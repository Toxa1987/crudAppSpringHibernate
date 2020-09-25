package by.toxa.config;

import by.toxa.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.security.AuthProvider;

@Configuration
@EnableWebSecurity
@ComponentScan("by.toxa.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   private AuthProviderImpl authProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login","/add","/send","/activation/**").anonymous()
                .antMatchers("/users").authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                .failureUrl("/login/true")
                .usernameParameter("email")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/users")
                .and()
                .logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}
