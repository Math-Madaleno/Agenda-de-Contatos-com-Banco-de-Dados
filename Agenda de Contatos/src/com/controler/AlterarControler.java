package com.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.classes.Contato;
import com.model.ContatoDAO;
import com.view.InterfaceAgenda;
import com.view.InterfaceAlterarContato;

public class AlterarControler implements ActionListener {
private InterfaceAlterarContato context;
	public AlterarControler (InterfaceAlterarContato context) {
		this.context = context;
	}
	public void actionPerformed(ActionEvent e) {
		String novoNome = this.context.getInputNomeContato();
		String novoApelido = this.context.getInputApelidoContato();
		String novoTelefone = this.context.getInputTelefoneContato();
		String novaConexao = this.context.getNovaConexao();
		Contato contatoAlterado = this.context.getContatoAlterado();
		JFrame frameAlterarContato = this.context.getFrameAlterarContato();
		
		if(!novoNome.isEmpty() && !novoApelido.isEmpty() && !novoTelefone.isEmpty() && novaConexao != null) {
			boolean confirmarNome = validarNome(novoNome);
			boolean confirmarApelido = validarApelido(novoApelido);
			boolean confirmarTelefone = validarTelefone(novoTelefone);
			boolean confirmarConexao = validarConexao(novaConexao);
			if(confirmarNome && confirmarApelido && confirmarTelefone && confirmarConexao ) {
				Contato novoContato = new Contato(contatoAlterado.getIdContato() , novoNome , novoApelido , novoTelefone , novaConexao , contatoAlterado.getDataDeConexao());
				ContatoDAO crudContatos = new ContatoDAO();
				boolean confirmacao = crudContatos.update(contatoAlterado.getIdContato(), novoContato);
				if(confirmacao) {
					crudContatos.desfazerConexao();
					frameAlterarContato.dispose();
					JOptionPane.showMessageDialog(null, "Contato Alterado com Sucesso !!!");
					InterfaceAgenda reiniciarAgenda = new InterfaceAgenda();
					reiniciarAgenda.inicializar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar Contato");
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Preencha Todos os Campos para Atualizar o Contato !!!");
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
