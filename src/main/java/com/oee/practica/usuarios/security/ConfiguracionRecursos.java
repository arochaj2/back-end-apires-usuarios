package com.oee.practica.usuarios.security;

import java.util.Arrays;



import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;




@Configuration
@EnableResourceServer
public class ConfiguracionRecursos extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		// Aqui se quita o se da acceso a alguna pagina
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/usuario/lista").hasRole("ADMIN")
//		.antMatchers(HttpMethod.GET,"/usuario/{id}").hasRole("ADMIN")
//		.antMatchers(HttpMethod.GET,"/usuario/detail/{id}").hasRole("ADMIN")
//		.antMatchers(HttpMethod.GET,"/usuario/update/{id}").hasRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE,"/usuario/delete/{id}").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT,"/usuario/update/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/usuario/create").permitAll()
	    .anyRequest().authenticated()
	    .and().cors().configurationSource(corsConfigurationSource());
		

		
//		// Aqui se quita o se da acceso a alguna pagina
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/usuario/lista").permitAll()
//		.antMatchers(HttpMethod.GET,"/usuario/{id}").permitAll()
//		.antMatchers(HttpMethod.GET,"/usuario/detail/{id}").permitAll()
//		.antMatchers(HttpMethod.GET,"/usuario/update/{id}").permitAll()
//		.antMatchers(HttpMethod.DELETE,"/usuario/delete/{id}").permitAll()
//		.antMatchers(HttpMethod.PUT,"/usuario/update/{id}").permitAll()
//		.antMatchers(HttpMethod.POST,"/usuario/create").permitAll()
//		.anyRequest().authenticated()
//	    .and().cors().configurationSource(corsConfigurationSource());

	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		
		return source;
		
	}
	


		@Bean
		public FilterRegistrationBean<CorsFilter> corsFilter() {

			FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
			return bean;
		}
	
	

}
