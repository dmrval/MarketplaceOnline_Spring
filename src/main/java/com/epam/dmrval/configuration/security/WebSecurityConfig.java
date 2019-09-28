package com.epam.dmrval.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

/** Author - Damir_Valeev Created on 9/28/2019 */
@Configuration
@ComponentScan("com.epam.dmrval")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/showItems")
        .permitAll()
        .antMatchers("/signUp")
        .permitAll()
        .antMatchers("/**")
        .hasAuthority("USER")
        .and()
        .formLogin()
        .loginPage("/login")
        .successHandler(
            (req, res, auth) -> {
              for (GrantedAuthority authority : auth.getAuthorities()) {
                if (authority.getAuthority().equals("USER")) {
                  res.sendRedirect("/showItems/");
                }
              }
            })
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .exceptionHandling()
        .accessDeniedPage("/accessDenied");
    http.csrf().disable();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }
}
