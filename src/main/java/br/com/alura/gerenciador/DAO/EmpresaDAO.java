package br.com.alura.gerenciador.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.gerenciador.interfaces.EmpresaI;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.util.JPAUtil;

public class EmpresaDAO implements EmpresaI{
	
	private EntityManager em;

	public EmpresaDAO(EntityManager em) {
		this.em = em;
	}

	public Empresa selecionar(Empresa empresa) {
		em.getTransaction().begin();
		empresa = em.find(Empresa.class, empresa.getCnpf());
		em.getTransaction().commit();
		return empresa;
	}

	public void inserir(Empresa empresa) {
		em.getTransaction().begin();
		em.persist(empresa);
		em.getTransaction().commit();
	}

	public void alterar(Empresa empresa) {
		em.getTransaction().begin();
		em.merge(empresa);
		em.getTransaction().commit();

	}

	public void apagar(Empresa empresa) {
		em.getTransaction().begin();
		em.remove(empresa);
		em.getTransaction().commit();
	}

	public List<Empresa> listar() {

		String sql = "select e from Empresa e";

		Query query = (Query) em.createQuery(sql);
		List<Empresa> empresas = query.getResultList();
		return empresas;
	}


}
