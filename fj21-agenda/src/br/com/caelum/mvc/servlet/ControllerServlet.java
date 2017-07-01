package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.mvc.logica."+parametro;
		
		try{
			Class classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(req, res);
			
			req.getRequestDispatcher(pagina).forward(req, res);
		}catch(Exception e){
			throw new ServletException("A logica de negócios causou uma exceção", e);
		}
	}
}
