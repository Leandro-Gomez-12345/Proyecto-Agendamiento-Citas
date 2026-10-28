package co.com.proyectoagendamientocitas.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfiguracion {

	@Bean
	public SecurityFilterChain filtrosDeSeguridad(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(reglas -> reglas.anyRequest().authenticated())
			.oauth2Login(Customizer.withDefaults())
			.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));
		return http.build();
	}
}
