package br.com.alura.gerenciador.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_empresa")
	@SequenceGenerator(name="sequence_empresa", sequenceName="SEQ_EMPRESA", initialValue=1,allocationSize=1)
	private Integer cnpf;
	private String nome;
	
	public int getCnpf() {
		return cnpf;
	}
	public void setCnpf(int cnpf) {
		this.cnpf = cnpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
