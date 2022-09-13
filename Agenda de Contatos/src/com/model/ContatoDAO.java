package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.classes.*;
public class ContatoDAO {
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	
	public ContatoDAO() {
		String servidor = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
		String usuario = "madaleno";
		String senha = "root12345";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor , usuario , senha);
			this.statement = this.connection.createStatement();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean create (Contato contato) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dataFormatada = format.format(contato.getDataDeConexao());
		String query = "INSERT INTO contatos VALUES (default , '" + contato.getNome() + "','" + contato.getApelido() + "','" + contato.getTelefoneDeContato() + "','" +contato.getTipoDeConexao() + "','" + dataFormatada+ "')";
		try {
			this.statement.executeUpdate(query);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Contato read (int idContato) {
		String query = "SELECT * FROM contatos WHERE idContato = '" + idContato + "'";
		Contato contatoLocalizado = null;
		try {
			this.result = this.statement.executeQuery(query);
			if(this.result.next()) {
				contatoLocalizado = new Contato(this.result.getInt("idContato") , this.result.getString("nome") , this.result.getString("apelido") , this.result.getString("telefone") , this.result.getString("tipoDeConexao") , this.result.getDate("dataDeConexao"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return contatoLocalizado;
	}
	
	public boolean update (int idContato , Contato novoContato) {
		String query = "UPDATE contatos SET nome = '" + novoContato.getNome() + "', apelido = '" + novoContato.getApelido() + "', telefone = '" + novoContato.getTelefoneDeContato() + "', tipoDeConexao = '" + novoContato.getTipoDeConexao() + "' , dataDeConexao = '" + novoContato.getDataDeConexao() +  "' WHERE idContato = '" + idContato +"'" ;
		try {
			this.statement.executeUpdate(query);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Contato excluir(int idContato) {
		Contato contatoExcluido = read(idContato);
		if(contatoExcluido != null) {
			String query = "DELETE FROM contatos WHERE idContato = '" + idContato + "'";
			try {
				this.statement.executeUpdate(query);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatoExcluido;
	}
	public ArrayList<Contato> readAll (){
		ArrayList<Contato> list = new ArrayList<>();
		String query = "SELECT * FROM contatos";
		try {
			this.result = this.statement.executeQuery(query);
			while(this.result.next()) {
				Contato newContato = new Contato(this.result.getInt("idContato") , this.result.getString("nome") , this.result.getString("apelido") , this.result.getString("telefone") , this.result.getString("tipoDeConexao"), this.result.getDate("dataDeConexao"));
				list.add(newContato);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void desfazerConexao () {
		try {
			
			if(this.connection != null) {
				this.connection.close();
			}
			if(this.statement!= null) {
				this.statement.close();
			}
			if(this.result != null) {
				this.result.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
