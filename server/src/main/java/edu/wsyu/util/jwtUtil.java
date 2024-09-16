package edu.wsyu.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import edu.wsyu.entity.vo.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Data
public class jwtUtil {
    //
    private static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMn0EyXzUtDWLiwWOZ1jyFn8pCqa80042hXtuuDxQC6nanNQG0fS7nnnLILo1/I/Jb5Ogb3X3ucgYrgzaC3rxK3eUSIsemGKTIEFgBxeNg3H/H9v9ix+Of/k1Z1CP4N5O0hwblyHTjYZJfOjmiJyEfXR5WF9cBRs3/DRCIY0WgYTAgMBAAECgYAV+F6TlLAKwMePIO/YUSr9AdYePciAOydxQUaWWB3iYBuIO0vBzuRbZgHapVgbe4aF+JEhb7hJLqXEDPD60JkPG4FMaLQhbLLayqjII10za1/GYoXm4LtjjqgIw8gRWxKuOjJePo/4sTNGXUORhjx46nGdYBCLJ9Kjd2e9KvgpeQJBAPsesFrEXudckAXw4EY+YX7wB++/g964IJoXI3rEWm6Q9aisqWm7ZaXmNgp7uVwQQfu8glAe46qKwT1WrUFClR0CQQDN4MjnZBdojjkFFJkZAjB4wt4WH79/H0l9PjQIJ4SDj4CmJqDgqyxsjDNmOuE8SGuk2mxJ0VUJBxdZvxy6KxDvAkA30Rdz5WgO1vUwTN0c3+q9006ATLpb++NLPM9nD1PmdZQU/OPfG4c5e9UROXT28Kop8Tmp42PJWXQgVS7HbaxFAkBVVt4wfF7vqjSclIM5yJyLEku45AQfD7sIvWYYEzlsx2lOdiituIa7oAoWUEXZFTP5q8jDeJBFI7lcLEoeKYflAkEAz/Q8tBgQWAymL4o/Xo14/IfXX2zhqRrXGYLIxcrQtzj4bAq6AXCTby1PKlcmOJW+IX9DHQ31wc1df3VTsnXw5A==";
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJ9BMl81LQ1i4sFjmdY8hZ/KQqmvNNONoV7brg8UAup2pzUBtH0u555yyC6NfyPyW+ToG9197nIGK4M2gt68St3lEiLHphikyBBYAcXjYNx/x/b/Ysfjn/5NWdQj+DeTtIcG5ch042GSXzo5oichH10eVhfXAUbN/w0QiGNFoGEwIDAQAB";

    private static final String myAlgorithm = "RSA";
    //    private static KeyFactory keyFactory = null;
    private static final String ISSUER = "edu.wsyu";//发行者
    private static final String AUDIENCE = "*";//受众

    @Value(value = "${spring.security.jwt.expire}")
    public static int expireTime;

    private static final RSA rsa = SecureUtil.rsa(PRIVATE_KEY, PUBLIC_KEY);

    private static final JWTSigner signer = JWTSignerUtil.rs256(rsa.getPrivateKey());

    private static final JWTSigner verifier = JWTSignerUtil.rs256(rsa.getPublicKey());



//    private RSAPrivateKey getPrivateKey() throws InvalidKeySpecException {
//        byte[] privateKeyBytes = Base64.getDecoder().decode(PRIVATE_KEY);
//        PKCS8EncodedKeySpec encodedPrivateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
//        PrivateKey privateKey = keyFactory.generatePrivate(encodedPrivateKeySpec);
//        return (RSAPrivateKey) privateKey;
//    }
//
//    private static RSAPublicKey getPublicKey() throws InvalidKeySpecException {
//        byte[] publicKeyBytes = Base64.getDecoder().decode(PUBLIC_KEY);
//        X509EncodedKeySpec encodedPublicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
//        PublicKey publicKey = keyFactory.generatePublic(encodedPublicKeySpec);
//        return (RSAPublicKey) publicKey;
//    }

    public static String createToken(User user) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expire = now.plusSeconds(expireTime);
        Map<String, Object> payload = new HashMap<>();

        payload.put(JWTPayload.ISSUED_AT, now);     // 签发时间

        payload.put(JWTPayload.EXPIRES_AT, expire); // 过期时间

        payload.put(JWTPayload.NOT_BEFORE, now);        // 生效时间

        payload.put(JWTPayload.ISSUER, ISSUER);  // 发行者

        payload.put(JWTPayload.AUDIENCE, AUDIENCE);      // 受众

        payload.put("uid", user.getUid());
        String token = JWTUtil.createToken(payload, signer);
        log.info("user:{}{} token:{}\n", user.getUid(), user.getUsername(), token);
        return token;
    }

    /**
     * 校验token
     */
    public static Boolean validate(String token) {
        Boolean verified = JWTUtil.verify(token, verifier);
        // validate包含了verify
        log.info("JWT token校验结果：{}", verified);
        return verified;
    }

    public static JSONObject getJSONObject(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        JSONObject payloads = jwt.getPayloads();
        payloads.remove(JWTPayload.ISSUED_AT);
//        payloads.remove(JWTPayload.EXPIRES_AT);
        payloads.remove(JWTPayload.NOT_BEFORE);
        log.info("根据token获取原始内容：{}", payloads);
        return payloads;
    }

}
