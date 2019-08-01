package com.lee.gmall.cart.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lee.gmall.annotation.LoginRequire;
import com.lee.gmall.bean.CartInfo;
import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.service.CartService;
import com.lee.gmall.service.SkuService;
import com.lee.gmall.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Reference
    SkuService skuService;

    @Reference
    CartService cartService;


    @LoginRequire(ifNeedSuccess = false)
    @RequestMapping("checkCart")
    public String checkCart(HttpServletRequest request, HttpServletResponse response, CartInfo cartInfo, ModelMap map) {
        String userId = (String) request.getAttribute("userId");
        List<CartInfo> cartInfos = new ArrayList<>();

        //修改购物车选中状态
        if (StringUtils.isNotBlank(userId)) {
            //更新数据库
            cartInfo.setUserId(userId);
            cartService.updateCartChecked(cartInfo);
        } else {
            //更新cookie
            String cartListCookie = CookieUtil.getCookieValue(request, "cartListCookie", true);
            if (StringUtils.isNotBlank(cartListCookie)) {
                cartInfos = JSON.parseArray(cartListCookie, CartInfo.class);
                for (CartInfo info : cartInfos) {
                    if (info.getSkuId().equals(cartInfo.getSkuId())) {
                        info.setIsChecked(cartInfo.getIsChecked());
                    }
                }
            }
            CookieUtil.setCookie(request, response, "cartListCookie", JSON.toJSONString(cartInfos), 60 * 60 * 24 * 7, true);
        }

        //更新数据后将最新数据查询出来
        if (StringUtils.isBlank(userId)) {
            //取cookie中的数据
            String cartListCookie = CookieUtil.getCookieValue(request, "cartListCookie", true);
            if (StringUtils.isNotBlank(cartListCookie)) {
                cartInfos = JSON.parseArray(cartListCookie, CartInfo.class);
            }
        } else {
            //取缓存中的数据
            cartInfos = cartService.getCartCache(userId);
        }

        map.put("cartList", cartInfos);

        return "cartListInner";
    }


    @LoginRequire(ifNeedSuccess = false)
    @RequestMapping("cartList")
    public String cartList(HttpServletRequest request, ModelMap map) {
        String userId = (String) request.getAttribute("userId");
        List<CartInfo> cartInfos = new ArrayList<>();

        if (StringUtils.isBlank(userId)) {
            //取cookie中的数据
            String cartListCookie = CookieUtil.getCookieValue(request, "cartListCookie", true);
            if (StringUtils.isNotBlank(cartListCookie)) {
                 cartInfos = JSON.parseArray(cartListCookie, CartInfo.class);
            }
        } else {
            //取缓存中的数据
            cartInfos = cartService.getCartCache(userId);
        }


        map.put("cartList", cartInfos);
        map.put("totalPrice", getTotalPrice(cartInfos));
        return "cartList";
    }

    private BigDecimal getTotalPrice(List<CartInfo> cartInfos) {
        BigDecimal totalPrice = new BigDecimal("0");
        for (CartInfo cartInfo : cartInfos) {
            totalPrice = totalPrice.add(cartInfo.getCartPrice());
        }

        return totalPrice;
    }

    @LoginRequire(ifNeedSuccess = false)
    @RequestMapping("addToCart")
    public String addToCart(HttpServletRequest request, HttpServletResponse response, CartInfo cartInfo) {
        //根据前台传入的skuId封装cartInfo
        SkuInfo sku = skuService.getSkuById(cartInfo.getSkuId());
        cartInfo.setSkuPrice(sku.getPrice());
        cartInfo.setSkuName(sku.getSkuName());
        cartInfo.setCartPrice(sku.getPrice().multiply(new BigDecimal(cartInfo.getSkuNum())));
        cartInfo.setImgUrl(sku.getSkuDefaultImg());
        cartInfo.setIsChecked("1");

        String userId = (String) request.getAttribute("userId");
        List<CartInfo> cartInfos = new ArrayList<>();

        if (StringUtils.isBlank(userId)) {
            //用户未登录,添加到cookie
            String cartListCookieStr = CookieUtil.getCookieValue(request, "cartListCookie", true);
            if (StringUtils.isBlank(cartListCookieStr)) {
                //存在购物车列表cookie
                cartInfos.add(cartInfo);
            } else {
                //不存在购物车列表cookie
                cartInfos = JSON.parseArray(cartListCookieStr, CartInfo.class);
                //判断是否为重复的sku
                boolean isNewCart = isNewCart(cartInfos, cartInfo);
                if (isNewCart) {
                    cartInfos.add(cartInfo);
                } else {
                    for (CartInfo info : cartInfos) {
                        String skuId = info.getSkuId();
                        String skuId1 = cartInfo.getSkuId();
                        if (skuId.equals(skuId1)) {
                            info.setSkuNum(info.getSkuNum() + cartInfo.getSkuNum());
                            info.setCartPrice(info.getSkuPrice().multiply(new BigDecimal(info.getSkuNum())));
                        }
                    }
                }
            }
            //操作完成后覆盖cookie
            CookieUtil.setCookie(request, response, "cartListCookie", JSON.toJSONString(cartInfos), 60 * 60 * 24 * 7, true);
        } else {
            //用户已登录,添加到数据库
            cartInfo.setUserId(userId);
            String skuId = cartInfo.getSkuId();
            //判断数据库中对应的cartInfo是否存在
            CartInfo cartInfoDb = cartService.ifCartExist(cartInfo);
            if (cartInfoDb != null) {
                //更新数据库
                cartInfoDb.setSkuNum(cartInfoDb.getSkuNum() + cartInfo.getSkuNum());
                cartInfoDb.setCartPrice(cartInfoDb.getSkuPrice().multiply(new BigDecimal(cartInfoDb.getSkuNum())));
                cartService.updateCart(cartInfoDb);
            } else {
                //插入数据库
                cartService.insertCart(cartInfo);

            }

            //同步缓存
            cartService.syncCache(userId);
        }
        return "redirect:/cartSuccess?skuId=" + sku.getId();
    }

    private boolean isNewCart(List<CartInfo> cartInfos, CartInfo cartInfo) {
        boolean isNewCart = true;
        String skuId = cartInfo.getSkuId();
        for (CartInfo info : cartInfos) {
            skuId.equals(info.getSkuId());
            isNewCart = false;
        }
        return isNewCart;
    }

    @LoginRequire(ifNeedSuccess = false)
    @RequestMapping("cartSuccess")
    public String cartSuccess(ModelMap map, String skuId) {
        SkuInfo sku = skuService.getSkuById(skuId);
        map.put("skuInfo", sku);
        return "success";
    }

}
