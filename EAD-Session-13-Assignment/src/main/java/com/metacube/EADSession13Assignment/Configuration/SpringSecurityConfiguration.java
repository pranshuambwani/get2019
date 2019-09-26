package com.metacube.EADSession13Assignment.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/addstudent").hasRole("ADMIN")
          .antMatchers("/showStudent").hasAnyRole("USER","ADMIN")
          .antMatchers("/searchStudent").hasAnyRole("USER","ADMIN")
          .antMatchers("/login").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/perform_login")
          .defaultSuccessUrl("/home?logged=1", true)
          .failureUrl("/login?error=1")
          .and()
          .logout()
          .and()
          .exceptionHandling().accessDeniedPage("/home?denied=1");
    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
