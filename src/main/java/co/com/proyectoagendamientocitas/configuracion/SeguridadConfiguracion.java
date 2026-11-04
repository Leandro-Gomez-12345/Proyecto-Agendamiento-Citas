package co.com.proyectoagendamientocitas.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class SeguridadConfiguracion {

	@Bean
	SecurityFilterChain filtrosDeSeguridad(HttpSecurity http) {
		http
			.authorizeHttpRequests(reglas -> reglas.anyRequest().authenticated())
			.oauth2Login(Customizer.withDefaults())
			.csrf(CsrfConfigurer::spa)
			.addFilterAfter(new CsrfCookieFiltro(), CsrfFilter.class);
		return http.build();
	}
}