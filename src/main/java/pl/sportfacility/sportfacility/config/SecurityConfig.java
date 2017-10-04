package pl.sportfacility.sportfacility.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from account where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/unauthorized")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/success", true)
                .and()
                .authorizeRequests()
                .antMatchers("/#!/login").permitAll()
                .antMatchers("/#!/1").permitAll()
                .antMatchers("/users/register").permitAll()
                .antMatchers("/reservation/add").authenticated()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/bower_components/**").permitAll()
                .antMatchers("/components/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/", "/home", "/users/role").permitAll().antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/", "/index.html", "/views/login.html","/views/register.html", "/views/news.html", "/views/contact.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
    }
}