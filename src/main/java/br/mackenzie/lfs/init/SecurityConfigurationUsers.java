package br.mackenzie.lfs.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(2)
public class SecurityConfigurationUsers extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/user/**")
                .authorizeRequests()
                .anyRequest().hasAuthority("USER")


                .and()
                    .formLogin()
                        .permitAll()
                        .loginPage("/user_login")
                        .permitAll()
                        .defaultSuccessUrl("/user/home")
                        .failureUrl("/user_login?error=true")
                        .permitAll()

                .and()
                    .logout()
                        .logoutSuccessUrl("/user_login?logout=true")
                        .permitAll()

                .and()
                    .exceptionHandling()
                    .defaultAuthenticationEntryPointFor(
                            new LoginUrlAuthenticationEntryPoint("/user_login"),
                            new AntPathRequestMatcher("/user/**"))
                    .accessDeniedPage("/403")

                .and()
                .httpBasic();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint () {
        return new LoginUrlAuthenticationEntryPoint("/user_login");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
