package edu.wsyu.filter;

import edu.wsyu.entity.vo.User;
import edu.wsyu.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 从请求头中获取JWT令牌
        String token = request.getHeader("Authorization");
        log.info("users token = {}", token);
        if (token == null || token.isBlank() || token.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }
        User verifiedUser = JwtUtil.verifyAndGetUser(token);
        if (verifiedUser != null) {
            UserDetails user = verifiedUser;
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            request.getSession().setAttribute("USER_ID", verifiedUser.getUid());
            request.getSession().setAttribute("USER_ROLES", user.getAuthorities());
        }
        // 继续过滤器链
        filterChain.doFilter(request, response);
    }
}
