package net.alphastar.microservicea.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//The @EnableWebSecurity is a marker annotation. It allows Spring to find (it's a @Configuration and, therefore, @Component) and automatically apply the class to the global WebSecurity.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder encodedPass;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService);
        //auth.inMemoryAuthentication().withUser("rohan").password("{noop}password").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("rohan").password("$2a$10$a89v06ied5ZWvnL5raVilOymiLGOrWs1LeDC/vVoYaz4tlj7Bmd16").roles("ADMIN");
        //.passwordEncoder(encodedPass);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable().authorizeRequests().antMatchers("/api/**").authenticated().and().httpBasic();
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/api/**").hasRole("ADMIN")
                .and().csrf().disable();
    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception
//    {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}password")
//                .roles("USER");
//    }

}
/*
{ no httpBasic
    "timestamp": "2022-03-08T11:45:52.886+00:00",
    "status": 403,
    "error": "Forbidden",
    "path": "/api/hello"
}

httpBasic
{
    "timestamp": "2022-03-08T11:46:35.492+00:00",
    "status": 401,
    "error": "Unauthorized",
    "path": "/api/hello"
}
 */