package com.workspace.rentcar.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@Order(1)
public class ModSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/api/orders/**", "/api/customer/**")
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .hasRole("MOD")
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT login, password, enabled FROM rc_employee WHERE login = ?")
                .authoritiesByUsernameQuery("SELECT rc_employee.login, auth.name" +
                        "FROM rc_authority auth" +
                        "INNER JOIN rc_employee_rc_authority emp_auth ON emp_auth.id_rc_authority = auth.id_rc_authority" +
                        "INNER JOIN rc_employee ON rc_employee.id_rc_employee = emp_auth.id_rc_employee" +
                        "WHERE rc_employee.login = ?");
    }
}
