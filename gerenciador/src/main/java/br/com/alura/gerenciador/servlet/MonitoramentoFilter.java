package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


//@WebFilter("/entrada")
public class MonitoramentoFilter extends HttpFilter implements Filter {
	
	@Override
	public void init() throws ServletException {}
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		chain.doFilter(request, response); //chain faz o acao ter continuidade ou parar de executar
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execução: "+ acao + " -> " + (depois - antes));
	}


}
