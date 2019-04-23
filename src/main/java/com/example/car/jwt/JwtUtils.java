package com.example.car.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @author liwei
 * @date 2019/3/6 10:09 AM
 */
public class JwtUtils {

   /* public static String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getCardId()));
        return token;
    }*/
    public static String getToken(String userId){
        String token="";
        token= JWT.create().withAudience(userId)
                .sign(Algorithm.HMAC256(userId));
        return token;
    }

    public static String getUserIdByToken(String token){
        return JWT.decode(token).getAudience().get(0);
    }

    public static void main(String[] args) {
        System.out.println(JwtUtils.getToken("689b94319954a09d8cb6c0f3ac2692f7"));
    }

}
