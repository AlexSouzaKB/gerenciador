package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.DAO.EmpresaDAO;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.util.JPAUtil;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6805268814079099674L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando uma nova empresa");
		
		Empresa empresa = new Empresa();
		empresa.setNome(request.getParameter("nome"));
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		try {
			EmpresaDAO dao = new EmpresaDAO(em);			
			try {
				
				dao.inserir(empresa);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>Empresa " + empresa.getNome() + " cadastrada com sucesso!</body></html>");
		
	}

}
