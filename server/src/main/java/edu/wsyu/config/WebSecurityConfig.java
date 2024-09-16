package edu.wsyu.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.wsyu.entity.dto.Role;
import edu.wsyu.entity.vo.AuthorizerVO;
import edu.wsyu.service.UserService;
import edu.wsyu.util.Result;
import edu.wsyu.util.jwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class WebSecurityConfig {
    private final UserService userService;

    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

//    @Bean
//    public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {
//        //@format:pff
//        http
//
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/admin/**").hasRole("ADMIN")
//                            .requestMatchers("/student/**").hasRole("STUDENT")
//                            .requestMatchers("/teacher/**").hasRole("TEACHER")
//                            .requestMatchers("/**").permitAll()
//                            .requestMatchers("/static/**").permitAll()
//                            .requestMatchers("/public/**").permitAll()
//                            .requestMatchers("/login", "/register").permitAll()
//                            .anyRequest().authenticated();
//                })
//                .formLogin(login -> {
//                    login.loginProcessingUrl("/login")
//                            .usernameParameter("username")
//                            .passwordParameter("password")
//                            .successHandler(this::onAuthenticationSuccess)
//                            .failureHandler(this::onAuthenticationFailure);
//
//                })
//                .logout(logout -> {
//                    logout.logoutUrl("/logout").logoutSuccessHandler(this::onLogoutSuccess);
//                })
//                .rememberMe(remember -> {
//
//                })
//                .exceptionHandling(exception -> {
//                    exception.authenticationEntryPoint(this::commence)
//                            .accessDeniedHandler(this::handle);
//                })
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
////                    session 无状态
//                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
////                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        //@format:on
//        return http.build();
//    }

    /**
     * @desc onAuthenticationSuccess
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     */
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        User user = (User) authentication.getPrincipal();

        edu.wsyu.entity.vo.User one = userService.findUser(new QueryWrapper<edu.wsyu.entity.vo.User>().eq("username", user.getUsername()));

        String token = jwtUtil.createToken(one);
        List<String> roles = new ArrayList<>();
        for (Role role : one.getRoles()) {
            roles.add(role.getName());
        }
        HttpSession session = request.getSession();
        session.setAttribute("USER_ROLES", roles);

        log.info("用户 {} 登录成功", one.getUsername());
        AuthorizerVO authorizerVO = new AuthorizerVO(one, token);
        response.getWriter().write(Result.succeed(authorizerVO).toJSONStringify());
    }

    /**
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     * @desc onAuthenticationFailure
     */
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Result.failed("失败").toJSONStringify());
    }

    /**
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     * @desc onLogoutSuccess
     */
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String authorization = request.getHeader("Authorization");
        PrintWriter writer = response.getWriter();


        if (jwtUtil.validate(authorization)) {
            writer.write(Result.succeed("退出登录成功").toJSONStringify());
        } else {
            log.error("退出登录失败, userid = {}", request.getSession().getAttribute("USER_ID"));
            writer.write(Result.error("退出登录失败").toJSONStringify());
        }

    }

    /**
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     * @desc exception.authenticationEntryPoint
     */
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(Result.failed("认证失败").toJSONStringify());
    }

    /**
     * @param request
     * @param response
     * @param accessDeniedException
     * @throws IOException
     * @throws ServletException
     * @desc accessDeniedHandler
     */
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(Result.failed("权限不足").toJSONStringify());
    }


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
