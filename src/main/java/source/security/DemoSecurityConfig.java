package source.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/customer/**").hasRole("EMPLOYEE")
                .antMatchers("/customer/newCustomer","/customer/updateCustomer").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/customer/deleteCustomer").hasRole("ADMIN")
                .and()
                .formLogin()
                  .loginProcessingUrl("/authenticateTheUser")
                  //.successHandler(customAuthenticationSuccessHandler)
                  .permitAll()
        .and()
                .logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

}
