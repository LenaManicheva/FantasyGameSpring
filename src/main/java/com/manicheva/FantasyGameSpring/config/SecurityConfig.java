package com.manicheva.FantasyGameSpring.config;


import com.manicheva.FantasyGameSpring.services.UserDetailsSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsSecurityService userDetailsSecurityService;

    @Autowired
    public SecurityConfig(UserDetailsSecurityService userDetailsSecurityService) {
        this.userDetailsSecurityService = userDetailsSecurityService;
    }
    //configure authorization + login page
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers( "/login", "/registration","/error", "/css/**", "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");


    }

    //configure authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsSecurityService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder (){
        return NoOpPasswordEncoder.getInstance();
    }
}

