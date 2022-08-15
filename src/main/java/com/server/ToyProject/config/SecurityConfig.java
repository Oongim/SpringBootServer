package com.server.ToyProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer.JwtConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.server.ToyProject.jwt.JwtAccessDeniedHandler;
import com.server.ToyProject.jwt.JwtAuthenticationEntryPoint;
import com.server.ToyProject.jwt.JwtSecurityConfig;
import com.server.ToyProject.jwt.TokenProvider;


@EnableWebSecurity //Web 보안을 활성화 하겠다
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{ //추가적인 설정을 위한 상속
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;


    public SecurityConfig(TokenProvider tokenProvider,JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler)
    {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception{
    //     http
    //     .authorizeRequests()    //HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정하겠다
    //     .antMatchers("/user/*").permitAll()  //요청에 대한 인증없이 접근을 허용하겠다는 의미
    //     .anyRequest().authenticated();  //나머지 요청들은 모두 인증되어야 한다.
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http    
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/user").permitAll()
                .antMatchers("/user/google/login").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .anyRequest().authenticated()

                .and()
                .apply(new JwtSecurityConfig(tokenProvider));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
