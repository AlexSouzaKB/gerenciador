package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
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

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JPAUtil.getEntityManager();
		EmpresaDAO dao = new EmpresaDAO(em);
		
		List<Empresa> empresas = dao.listar();
		
		request.setAttribute("empresas", empresas);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);

	}

}
