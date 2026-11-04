package co.com.proyectoagendamientocitas.configuracion;

import java.io.IOException;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class CsrfCookieFiltro extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		var tokenCsrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		if (tokenCsrf != null) {
			tokenCsrf.getToken();
		}
		filterChain.doFilter(request, response);
	}
}
