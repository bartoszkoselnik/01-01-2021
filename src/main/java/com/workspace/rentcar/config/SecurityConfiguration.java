package com.workspace.rentcar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/orders/**", "/api/cars/**")
                .hasRole("USER")
                .and()
                .formLogin().and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("vp_user1")
                .password("$2y$06$1BHyVRnSnuS0AGFTH38Xfek1dRParJ7gw5NJxIGz1UX3UduFGOPRa")
                .roles("USER")
                .and()
                .withUser("vp_user2")
                .password("$2y$06$Y975MVN7s3qHDRDT1zXUgeB2KfFvhPaKKEFT/c9psMTWMORqUR7L6")
                .roles("TEST");
    }


}
