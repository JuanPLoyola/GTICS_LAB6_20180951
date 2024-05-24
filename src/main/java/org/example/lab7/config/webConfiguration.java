package org.example.lab7.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;

@Configuration
public class webConfiguration {

    final DataSource dataSource;
    public webConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource){
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        String sql1 = "SELECT Nombre, Contrasena FROM usuarios where Nombre=?";
        String sql2 = "SELECT u.Nombre, r.Nombre FROM usuarios u"
                + "INNER JOIN roles r ON (u.Roles_idRoles = r.idRoles)"
                + "WHERE u.Nombre =?";

        users.setUsersByUsernameQuery(sql1);
        users.setAuthoritiesByUsernameQuery(sql2);
        return users;

    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.formLogin()
                        .loginPage("/login")
                                .loginProcessingUrl("/processLogin");

        http.authorizeHttpRequests()
                .requestMatchers("/Index","/Index/**").hasAnyAuthority("Cliente","Gerente","Admin")
                .anyRequest().permitAll();

        return http.build();
    }

}
