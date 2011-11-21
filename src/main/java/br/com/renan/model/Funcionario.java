package br.com.renan.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Funcionario {

	private Integer id;
	
	private String nome;
	
	private String caminhoFoto;

	public Funcionario(Integer id, String nome, String caminhoFoto) {
		this.id = id;
		this.nome = nome;
		this.caminhoFoto = caminhoFoto;
	}

	public Funcionario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}
}