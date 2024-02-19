//package com.ChienNguyen.InteriorContructionQuotaionV2.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration {
//
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        try {
//            http
//                    // ...
//                    .httpBasic(httpBasic -> httpBasic.disable())
//                    .authorizeHttpRequests((authorizeExchange) -> authorizeExchange
//                            .requestMatchers("/mylogin").permitAll()
//                            .anyRequest().permitAll())
//                    .csrf((csrf) -> csrf.disable())
//                    .formLogin(form -> form.loginPage("/login").permitAll());
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return http.build();
//    }
//}
