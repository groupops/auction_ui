package com.epam.training.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.epam.training.auction.exception.AuctionConfigurationException;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/register").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        try {
            auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
        } catch (Exception e) {
            throw new AuctionConfigurationException("Couldn't setup AuthenticationManagerBuilder", e);
        }
    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
//        try {
//            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//        } catch (Exception e) {
//            throw new AuctionConfigurationException("Couldn't setup AuthenticationManagerBuilder", e);
//        }
//    }
}
