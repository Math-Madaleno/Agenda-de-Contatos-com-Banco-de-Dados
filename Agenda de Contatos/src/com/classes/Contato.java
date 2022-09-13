package com.classes;

import java.util.Date;

public class Contato {
	private int idContato;
	private String nome;
	private String apelido;
	private String telefone;
	private String tipoDeConexao;
	private Date dataDeConexao;
	
	public Contato (int idContato , String nome , String apelido , String telefone , String tipoDeConexao , Date dataDeConexao) {
		this.idContato = idContato;
		this.nome = nome;
		this.apelido=apelido;
		this.telefone=telefone;
		this.tipoDeConexao=tipoDeConexao;
		this.dataDeConexao=dataDeConexao;	
	}

	public int getIdContato() {
		return idContato;
	}

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public String getTelefoneDeContato() {
		return this.telefone;
	}

	public String getTipoDeConexao() {
		return this.tipoDeConexao;
	}

	public Date getDataDeConexao() {
		return dataDeConexao;
	}
	
}
