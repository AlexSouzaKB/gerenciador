package br.com.alura.gerenciador.interfaces;

import java.util.List;

import br.com.alura.gerenciador.modelo.Empresa;

public interface EmpresaI {
	
	public Empresa selecionar(Empresa empresa);
	public void inserir(Empresa empresa);
	public void alterar(Empresa empresa);
	public void apagar(Empresa empresa);
	public List<Empresa> listar();

}
