package br.com.alura.gerenciador.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence_empresa")
	@SequenceGenerator(name="sequence_empresa", sequenceName="SEQ_EMPRESA", initialValue=1,allocationSize=1)
	private Integer cnpf;
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAbertura;
	
	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public void setCnpf(Integer cnpf) {
		this.cnpf = cnpf;
	}
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
