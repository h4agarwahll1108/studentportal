package com.harsht.studentportal.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	public static final String SECRET = "5367566859703373367639792F423F4528482B4D6251655468576D5A71347437";

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
	}

	// private Key key
	// return
	// hmacShaKeyFor(Decoders.BASE64.decode(ApplicationConstants.SECRET_KEY));

	private Key key() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		Date now = new Date(System.currentTimeMillis());
		Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 30);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(now)
				.setExpiration(expirationDate)
				.signWith(key(), SignatureAlgorithm.HS256)
				.compact();
	}

	public boolean validateJwtToken(String authToken, UserDetails userDetails) {
		final String username = getUsernameFromToken(authToken);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(authToken));
	}
}