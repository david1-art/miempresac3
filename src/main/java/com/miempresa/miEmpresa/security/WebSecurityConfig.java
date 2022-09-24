package com.miempresa.miEmpresa.security;

import com.miempresa.miEmpresa.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements UserDetailsService {

    @Autowired
    private EmpleadoService service;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/", "/home", "/**/*.js", "/**/*.css",  "/**/*.svg", "/error/404", "/login/registro", "/login/postregistro").permitAll()
                        //.antMatchers("/", "home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login/login")
                        .permitAll()
                        .defaultSuccessUrl("/index", true)
                )
                .logout((logout) -> logout
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Traer usuario de la BD por correo elecctronico
        com.miempresa.miEmpresa.entities.Empleado userObject = this.service.selectByUserName(username);
        System.out.println(username);
        if (userObject != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            // authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(
                    userObject.getCorreoElectronico(),
                    userObject.getContraseña(),
                    authorities
            );
        }
        System.out.println("usuario no encontrado");
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    /*@Bean
    public UserDetailsService userDetailsService(){
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }*/
}
