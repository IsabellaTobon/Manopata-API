package com.manopata.api.utlis.auth;

import com.manopata.api.auth.dto.TokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private final String key = "dEq234gggREWT22344AASQWERGERGERTGasafasdfqewwrWETQWRghhlwertwer9798";
    private final String issuer = "Main";
    private final int ttl = 3600000; // milliseconds token will live (1 hour)

    public TokenResponse generateToken(String username, String role)
    {
        TokenResponse token = new TokenResponse();
        token.setToken(this.createToken(username, role));

        return token;
    }

    public boolean isTokenStillValid(String token)
    {
        Claims claims  = this.getClaims(token);
        return claims.getExpiration().before(new Date());
    }

    private String createToken(String id, String subject)
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long currentTimeMilliseconds = System.currentTimeMillis();
        Date now = new Date(currentTimeMilliseconds);

        byte[] secretBytes = DatatypeConverter.parseBase64Binary(this.key);
        Key signedKey = new SecretKeySpec(secretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signedKey);

        Date expirationDate = new Date(currentTimeMilliseconds + this.ttl);

        return builder.compact();
    }

    private Claims getClaims(String token)
    {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build().parseSignedClaims(token).getPayload();
    }
}
