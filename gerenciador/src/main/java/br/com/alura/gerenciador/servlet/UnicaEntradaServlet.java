package br.com.alura.gerenciador.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresas;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao"); //pega o parâmetro que vem dps da "acao"
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		//aqui foi feito uma restrição de acesso às paginas, exceto "Login" e "LoginForm"
//		if (usuarioNaoEstaLogado && ehUmaAcaoProtegida) {
//			System.out.println("Faça o Login");
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
		
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao; //para pegar o nome da classe
		
		String nome;
		try {
			//aqui foi usado um metodo de programação chamado reflection
			Class classe = Class.forName(nomeDaClasse); //carrega o nome da classe 
			Acao acao = (Acao) classe.newInstance(); //criando a instancia da ação já fazendo um "Casat" para interface
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
				throw new ServletException(e);
		}
		
		String[] tipoEndereco = nome.split(":");
		
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
//		String nome = null;
//		
//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//			
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//			
//		} else if (paramAcao.equals("MostraEmpresas")) {
//			MostraEmpresas acao = new MostraEmpresas();
//			nome = acao.executa(request, response);
//			
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//			
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//			
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
		
		
		
	}

}
