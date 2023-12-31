package com.scg.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

public class SecurityConfig {


@Bean
  SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
	  http
      .authorizeExchange(exchanges -> exchanges
          .pathMatchers("/resource").hasAuthority("SCOPE_resource.read")
          .anyExchange().authenticated()
      )
          
      . oauth2ResourceServer((oauth2ResourceServer) ->
      oauth2ResourceServer
      .jwt( )
);
return http.build();
  }
}