package se.ashwini.myspringproject;

import org.springframework.context.annotation.Bean; // used to define bean methods
import org.springframework.context.annotation.Configuration; // marks the class as configuration class which contains bean method.
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // used to configure HTTP security settings.
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;// used to configure security in application.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // to securely hash password.
import org.springframework.security.crypto.password.PasswordEncoder; // used for password encoding.
import org.springframework.security.web.SecurityFilterChain; // used to configure security filter chain for HTTP request.
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").hasAnyRole("USER", "ADMIN", "MANAGER")
                        .requestMatchers("/user").hasAnyRole("USER", "MANAGER", "ADMIN")
                        .requestMatchers("/admin").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/manager").hasRole("MANAGER")
                        .requestMatchers("/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        return http.build();
    }

    /**
     * how HTTP request are configured and secured.HttpSecurity is passed as a parameter, which is used to configure HTTP security.
     * .authorizeHttpRequests() method is used to define authorization rules for different URLs (request paths) in the application.
     * The auth -> auth part use to apply authorization rules to various paths.
     * .formLogin enables form based login,used to apply default login configuration,default login page
     * @return this line builds and returns the configured security filter chain.
     */



    @Bean
    public PasswordEncoder passwordEncoder() { // to encrypt and decrypt password
        return new BCryptPasswordEncoder();
    }

}
