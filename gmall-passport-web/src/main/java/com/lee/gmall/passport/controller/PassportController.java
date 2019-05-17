package com.lee.gmall.passport.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lee.gmall.bean.CartInfo;
import com.lee.gmall.bean.UserInfo;
import com.lee.gmall.service.CartService;
import com.lee.gmall.util.CookieUtil;
import com.lee.gmall.util.PassportUtil;
import com.lee.gmall.service.UserService;
import com.lee.gmall.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PassportController {

    @Reference
    UserService userService;
    @Reference
    CartService cartService;


    /***
     * 登录页
     * @return
     */
    @RequestMapping("index")
    public String index(String returnURL, ModelMap map) {
        map.put("returnURL", returnURL);
        return "index";
    }

    /***
     * 颁发token
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo) {
        //调用用户服务验证用户名和密码
        UserInfo user = userService.login(userInfo);

        if (user == null) {
            //用户名或密码错误
            return "username or password err";
        } else {
            //使用jwt，颁发token
            Map<String, String> map = new HashMap<>();
            map.put("userId", user.getId());
            map.put("nickName", user.getNickName());

            String token = JwtUtil.encode("superlee1010", map, PassportUtil.getRequestAddr(request));

            //合并购物车数据
            String cartListCookie = CookieUtil.getCookieValue(request, "cartListCookie", true);
            List<CartInfo> cartInfos = null;
            if (StringUtils.isNotBlank(cartListCookie)) {
                cartInfos = JSON.parseArray(cartListCookie, CartInfo.class);
            }
            cartService.combineCart(cartInfos, user.getId());
            //删除cookie中的购物车数据
            CookieUtil.setCookie(request, response, "cartListCookie", "", 0, true);

            return token;
        }

    }

    /***
     * 认证token
     * @return
     */
    @RequestMapping("verify")
    @ResponseBody
    public String verify(String token, String salt) {
        Map userMap = null;
        try {
            userMap = JwtUtil.decode("superlee1010", token, salt);
        } catch (Exception e) {
            return "fail";
        }
        if (userMap != null) {
            return "success";
        } else {
            return "fail";
        }
    }

}
