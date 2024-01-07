package com.ahalshaba.springangularoauth2jwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration /** the bean security is a configuration**/
@EnableWebSecurity /** we enbale security for this microservice **/
@EnableMethodSecurity(prePostEnabled = true) /** protection with roles (preauthorize)**/
public class SecurityConfig {

    private JwtAuthConverter jwtAuthConverter;

    public SecurityConfig(JwtAuthConverter jwtAuthConverter){
        this.jwtAuthConverter = jwtAuthConverter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       
        return http
                    .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                    /* whene you have jwt, use jwtAuthConverter for getting roles*/
                    .oauth2ResourceServer(o2->o2.jwt(jwt-> jwt.jwtAuthenticationConverter(jwtAuthConverter)))
                    .build();
    }

}
