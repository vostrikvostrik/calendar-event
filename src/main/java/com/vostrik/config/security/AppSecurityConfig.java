package com.vostrik.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Аннотация @EnableWebSecurity в связке с WebSecurityConfigurerAdapter классом работает над обеспечением
 * аутентификации. По умолчанию в Spring Security встроены и активны HTTP аутентификация и аутентификация
 * на базе веб форм.
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("superadmin").password("superadmin").roles("SUPERADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/user_events").access("hasRole('ROLE_ADMIN')")
                //.antMatchers("/user_events").access("hasRole('ROLE_SUPERADMIN')")
                .and().formLogin()//.loginPage("/login")
                .defaultSuccessUrl("/user_events", false)
                //.failureUrl("/login?login_error=true")
                .and().logout().permitAll()
               // .logoutSuccessUrl("/user_events") //or whatever page you want
               // .logoutUrl("/logout") //thinking this is what you need
         ;
    }
}
