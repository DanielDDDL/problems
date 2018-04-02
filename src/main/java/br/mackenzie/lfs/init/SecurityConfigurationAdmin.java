package br.mackenzie.lfs.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(1)
public class SecurityConfigurationAdmin extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/admin/**")
                    .authorizeRequests()
                        .anyRequest().hasAuthority("ADMIN")

                .and()
                    .formLogin()
                        .loginPage("/admin_login")
                        .defaultSuccessUrl("/admin/home")
                        .failureUrl("/admin_login?error=true")
                        .permitAll()

                .and()
                    .logout()
                        .logoutSuccessUrl("/admin_login?logout=true")
                        .permitAll()

                .and()
                    .exceptionHandling()
                    .defaultAuthenticationEntryPointFor(
                            new LoginUrlAuthenticationEntryPoint("/admin_login"),
                            new AntPathRequestMatcher("/admin/**"))
                    .accessDeniedPage("/403")

                .and()
                    .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
