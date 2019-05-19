package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.DAO.EmpresaDAO;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.util.JPAUtil;


@WebServlet("/listaEmpresa")
public class ListaEmpresaSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = new JPAUtil().getEntityManager();
		EmpresaDAO dao = new EmpresaDAO(em);
		
		List<Empresa> empresas = dao.listar();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<ul>");
		
		for (Empresa empresa : empresas) {
			out.println("<li>" + empresa.getNome() + "</li>");
		}
		
		out.println("</ul>");
		out.println("</body></html>");
	
	}

}
