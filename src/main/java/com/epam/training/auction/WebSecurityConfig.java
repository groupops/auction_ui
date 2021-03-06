package com.epam.training.auction;

import com.epam.training.auction.exception.AuctionConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableAutoConfiguration
@ImportResource("classpath:spring-context.xml")
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    // TODO: investigate this it can handle users with Spring API
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auctions/add").authenticated()
                .antMatchers("/", "/home", "/register", "/auctions/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .successHandler(getLoginSuccessHandler())
                .usernameParameter("login")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/home");
    }


    private AuthenticationSuccessHandler getLoginSuccessHandler() {
        return (request, response, authentication) -> {
            new DefaultRedirectStrategy().sendRedirect(request, response, "/home");
        };
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth, UserDetailsService
            userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        try {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        } catch (Exception e) {
            throw new AuctionConfigurationException("Couldn't setup AuthenticationManagerBuilder", e);
        }
    }
}
