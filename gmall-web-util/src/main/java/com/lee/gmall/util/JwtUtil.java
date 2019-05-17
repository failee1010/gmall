package com.lee.gmall.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64UrlCodec;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @param
 * @return
 */
public class JwtUtil {

    public static void main(String[] args){

    }


    /***
     * jwt加密
     * @param key
     * @param map
     * @param salt
     * @return
     */
    public static String encode(String key,Map map,String salt){

        if(salt!=null){
            key+=salt;
        }
        JwtBuilder jwtBuilder = Jwts.builder().signWith(SignatureAlgorithm.HS256, key);
        jwtBuilder.addClaims(map);

        String token = jwtBuilder.compact();
        return token;
    }

    /***
     * jwt解密
     * @param key
     * @param token
     * @param salt
     * @return
     * @throws SignatureException
     */
    public static  Map decode(String key,String token,String salt)throws SignatureException{
        if(salt!=null){
            key+=salt;
        }
        Claims map = null;

        map = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

        System.out.println("map.toString() = " + map.toString());

        return map;

    }

}
