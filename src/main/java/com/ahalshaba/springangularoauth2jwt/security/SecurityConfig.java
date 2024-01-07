package com.ahalshaba.springangularoauth2jwt.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/** 
* the bean security is a configuration
* we enbale security for this microservice 
* protection with roles (preauthorize)
*/

@Configuration 
@EnableWebSecurity 
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private JwtAuthConverter jwtAuthConverter;

    public SecurityConfig(JwtAuthConverter jwtAuthConverter){
        this.jwtAuthConverter = jwtAuthConverter;
    }

    /**
     * 
     * @param http
     * enable cors and use default configuration
     * all requests must be authenticated
     * when we receive a jwt we convert it to recover the roles 
     * @return
     * @throws Exception
     *
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       
        return http
                    .cors(Customizer.withDefaults())
                    .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
                    .oauth2ResourceServer(o2->o2.jwt(jwt-> jwt.jwtAuthenticationConverter(jwtAuthConverter)))
                    .build();
    }
    /**
     * configure cors for authoriation urls and methods
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200/*","https://example.com"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
