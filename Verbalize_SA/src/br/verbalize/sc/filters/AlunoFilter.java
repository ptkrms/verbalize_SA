package br.verbalize.sc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.verbalize.sc.mb.SessaoMb;

@WebFilter(urlPatterns = "/aluno/*")
public class AlunoFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		SessaoMb sessaoMb = (SessaoMb) httpServletRequest.getSession()
				.getAttribute("sessaoMb");

		if (sessaoMb == null || !sessaoMb.ehAluno()) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect(httpServletRequest
					.getContextPath().concat(
							"/index.xhtml?msg=Acesso restrito."));
			return;
		}
		
		if (sessaoMb.ehAluno()) {
			filterChain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
