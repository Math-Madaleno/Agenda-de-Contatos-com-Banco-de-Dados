package com.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.classes.Contato;
import com.model.ContatoDAO;
import com.view.InterfaceAdicionarContato;
import com.view.InterfaceAgenda;

public class AdicionarControler implements ActionListener{
	private InterfaceAdicionarContato context;
	public AdicionarControler (InterfaceAdicionarContato context) {
		this.context = context;
	}
	
	public void actionPerformed(ActionEvent e) {
		String nome = this.context.getInputNomeContato();
		String apelido = this.context.getInputApelidoContato();
		String telefone = this.context.getInputTelefoneContato();
		String conexaoSelecionada = this.context.getConexaoSelecionada();
		JFrame frameAdicionarContato = this.context.getFrameAdicionarContato();
		if(!nome.isEmpty() && !apelido.isEmpty() && !telefone.isEmpty() && conexaoSelecionada!= null) {
			boolean condicaoNome = validarNome(nome);
			boolean condicaoApelido = validarApelido(apelido);
			boolean condicaoTelefone = validarTelefone(telefone);
			boolean condicaoConexao = validarConexao(conexaoSelecionada);
			if(condicaoNome &&  condicaoApelido && condicaoTelefone && condicaoConexao) {
				ContatoDAO crudContatos = new ContatoDAO();
				Date dataAtual = new Date();
				Contato newContato = new Contato(-1 , nome, apelido , telefone ,conexaoSelecionada , dataAtual);
				boolean confirmacao = crudContatos.create(newContato);
				if(confirmacao) {
					crudContatos.desfazerConexao();
					frameAdicionarContato.dispose();
					JOptionPane.showMessageDialog(null, "Contato Adicionado com Sucesso !!!");
					InterfaceAgenda reiniciarAgenda = new InterfaceAgenda();
					reiniciarAgenda.inicializar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Erro ao Adicionar Contato");
				}
				
				
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Todas as Condições Devem ser Cumpridas !!!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Preencha Todos os Campos !!!");
		}
		
	}
	private boolean validarNome (String nome) {
		if(nome.length() <=60) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "O Nome do Contato deve possuir no máximo 60 caracteres \n" + "Nome Atual possui " + nome.length() + " caracteres");
			return false;
		}
	}
	private boolean validarApelido (String apelido) {
		if(apelido.length() <=30) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "O Apelido do Contato deve possuir no máximo 30 caracteres \n" + "Apelido Atual possui " + apelido.length() + " caracteres");
			return false;
		}
	}
	private boolean validarTelefone (String telefone) {
		if(telefone.length() <=17) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "O Telefone do Contato deve possuir no máximo 17 caracteres \n" + "Telefone Atual possui " + telefone.length() + " caracteres");
			return false;
		}
	}
	
	private boolean validarConexao (String conexao) {
		if(conexao.equals("Familares") || conexao.equals("Melhores Amigos") | conexao.equals("Amigos Proximos") | conexao.equals("Colegas") | conexao.equals("Colegas de Trabalho") ) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Selecione uma Conexão Válida");
			return false;
		}
		
	}
	
}
