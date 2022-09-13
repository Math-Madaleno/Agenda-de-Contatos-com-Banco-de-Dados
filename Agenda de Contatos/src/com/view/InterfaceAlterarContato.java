package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.classes.Contato;
import com.controler.AlterarControler;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class InterfaceAlterarContato {

	private JFrame frameAlterarContato;
	private Contato contatoAlterado;
	private JTextField textNomeContato;
	private JTextField textApelidoContato;
	private JTextField textTelefoneContato;
	private JTextField textTipoDeConexao;
	private JLabel lblNovoNomeContato;
	private JTextField inputNomeContato;
	private JLabel lblNovoApelidoContato;
	private JTextField inputApelidoContato;
	private JLabel lblNovoTelefone;
	private JTextField inputTelefoneContato;
	private JLabel lblNovoTipoConexao;
	private JComboBox comboBoxNovaConexao;
	private String novaConexao;
	/**
	 * Launch the application.
	 */
	public InterfaceAlterarContato (Contato contatoAlterado) {
		this.contatoAlterado = contatoAlterado;
	}
	
	public void inicializar () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAlterarContato window = new InterfaceAlterarContato(contatoAlterado);
					window.create();
					window.frameAlterarContato.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	/**
	 * @wbp.parser.entryPoint
	 */

	private void create () {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAlterarContato = new JFrame();
		frameAlterarContato.setTitle("Alterar Contato : "+ contatoAlterado.getApelido());
		frameAlterarContato.setResizable(false);
		frameAlterarContato.setBounds(320, 150, 1000, 550);
		frameAlterarContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAlterarContato.getContentPane().setLayout(null);
		frameAlterarContato.getContentPane().setBackground(new Color(28 , 28 , 28));
		
		JLabel lblNomeContatoAtual = new JLabel("Nome do Contato Atual :");
		lblNomeContatoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeContatoAtual.setForeground(Color.WHITE);
		lblNomeContatoAtual.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNomeContatoAtual.setBounds(115, 20, 250, 40);
		frameAlterarContato.getContentPane().add(lblNomeContatoAtual);
		
		textNomeContato = new JTextField();
		textNomeContato.setEditable(false);
		textNomeContato.setText(contatoAlterado.getNome());
		textNomeContato.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeContato.setForeground(Color.BLACK);
		textNomeContato.setFont(new Font("Arial", Font.PLAIN, 15));
		textNomeContato.setColumns(10);
		textNomeContato.setBackground(Color.WHITE);
		textNomeContato.setBounds(10, 70, 450, 30);
		frameAlterarContato.getContentPane().add(textNomeContato);
		
		JLabel lblApelidoContatoAtual = new JLabel("Apelido do Contato Atual :");
		lblApelidoContatoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblApelidoContatoAtual.setForeground(Color.WHITE);
		lblApelidoContatoAtual.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApelidoContatoAtual.setBounds(115, 120, 250, 40);
		frameAlterarContato.getContentPane().add(lblApelidoContatoAtual);
		
		textApelidoContato = new JTextField();
		textApelidoContato.setEditable(false);
		textApelidoContato.setText(contatoAlterado.getApelido());
		textApelidoContato.setHorizontalAlignment(SwingConstants.CENTER);
		textApelidoContato.setForeground(Color.BLACK);
		textApelidoContato.setFont(new Font("Arial", Font.PLAIN, 15));
		textApelidoContato.setColumns(10);
		textApelidoContato.setBackground(Color.WHITE);
		textApelidoContato.setBounds(10, 170, 450, 30);
		frameAlterarContato.getContentPane().add(textApelidoContato);
		
		JLabel lblTelefoneContatoAtual = new JLabel("Telefone Atual :");
		lblTelefoneContatoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefoneContatoAtual.setForeground(Color.WHITE);
		lblTelefoneContatoAtual.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTelefoneContatoAtual.setBounds(115, 220, 250, 40);
		frameAlterarContato.getContentPane().add(lblTelefoneContatoAtual);
		
		textTelefoneContato = new JTextField();
		textTelefoneContato.setEditable(false);
		textTelefoneContato.setText(contatoAlterado.getTelefoneDeContato());
		textTelefoneContato.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefoneContato.setForeground(Color.BLACK);
		textTelefoneContato.setFont(new Font("Arial", Font.PLAIN, 15));
		textTelefoneContato.setColumns(10);
		textTelefoneContato.setBackground(Color.WHITE);
		textTelefoneContato.setBounds(10, 270, 450, 30);
		frameAlterarContato.getContentPane().add(textTelefoneContato);
		
		JLabel lblTipoDeConexaoAtual = new JLabel("Tipo de Conexão Atual :");
		lblTipoDeConexaoAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeConexaoAtual.setForeground(Color.WHITE);
		lblTipoDeConexaoAtual.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipoDeConexaoAtual.setBounds(115, 320, 250, 40);
		frameAlterarContato.getContentPane().add(lblTipoDeConexaoAtual);
		
		textTipoDeConexao = new JTextField();
		textTipoDeConexao.setEditable(false);
		textTipoDeConexao.setText(contatoAlterado.getTipoDeConexao());
		textTipoDeConexao.setHorizontalAlignment(SwingConstants.CENTER);
		textTipoDeConexao.setForeground(Color.BLACK);
		textTipoDeConexao.setFont(new Font("Arial", Font.PLAIN, 15));
		textTipoDeConexao.setColumns(10);
		textTipoDeConexao.setBackground(Color.WHITE);
		textTipoDeConexao.setBounds(10, 370, 450, 30);
		frameAlterarContato.getContentPane().add(textTipoDeConexao);
		
		lblNovoNomeContato = new JLabel("Novo Nome do Contato :");
		lblNovoNomeContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoNomeContato.setForeground(Color.WHITE);
		lblNovoNomeContato.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNovoNomeContato.setBounds(630, 20, 250, 40);
		frameAlterarContato.getContentPane().add(lblNovoNomeContato);
		
		inputNomeContato = new JTextField();
		inputNomeContato.setHorizontalAlignment(SwingConstants.CENTER);
		inputNomeContato.setForeground(Color.BLACK);
		inputNomeContato.setFont(new Font("Arial", Font.PLAIN, 15));
		inputNomeContato.setColumns(10);
		inputNomeContato.setBackground(Color.WHITE);
		inputNomeContato.setBounds(525, 70, 450, 30);
		frameAlterarContato.getContentPane().add(inputNomeContato);
		
		lblNovoApelidoContato = new JLabel("Novo Apelido do Contato :");
		lblNovoApelidoContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoApelidoContato.setForeground(Color.WHITE);
		lblNovoApelidoContato.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNovoApelidoContato.setBounds(630, 120, 250, 40);
		frameAlterarContato.getContentPane().add(lblNovoApelidoContato);
		
		inputApelidoContato = new JTextField();
		inputApelidoContato.setHorizontalAlignment(SwingConstants.CENTER);
		inputApelidoContato.setForeground(Color.BLACK);
		inputApelidoContato.setFont(new Font("Arial", Font.PLAIN, 15));
		inputApelidoContato.setColumns(10);
		inputApelidoContato.setBackground(Color.WHITE);
		inputApelidoContato.setBounds(525, 170, 450, 30);
		frameAlterarContato.getContentPane().add(inputApelidoContato);
		
		lblNovoTelefone = new JLabel("Novo Telefone :");
		lblNovoTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoTelefone.setForeground(Color.WHITE);
		lblNovoTelefone.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNovoTelefone.setBounds(630, 220, 250, 40);
		frameAlterarContato.getContentPane().add(lblNovoTelefone);
		
		inputTelefoneContato = new JTextField();
		inputTelefoneContato.setHorizontalAlignment(SwingConstants.CENTER);
		inputTelefoneContato.setForeground(Color.BLACK);
		inputTelefoneContato.setFont(new Font("Arial", Font.PLAIN, 15));
		inputTelefoneContato.setColumns(10);
		inputTelefoneContato.setBackground(Color.WHITE);
		inputTelefoneContato.setBounds(525, 270, 450, 30);
		frameAlterarContato.getContentPane().add(inputTelefoneContato);
		
		lblNovoTipoConexao = new JLabel("Novo Tipo de Conexão :");
		lblNovoTipoConexao.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoTipoConexao.setForeground(Color.WHITE);
		lblNovoTipoConexao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNovoTipoConexao.setBounds(630, 320, 250, 40);
		frameAlterarContato.getContentPane().add(lblNovoTipoConexao);
		
		
		comboBoxNovaConexao = new JComboBox();
		comboBoxNovaConexao.setBackground(Color.WHITE);
		comboBoxNovaConexao.setForeground(Color.BLACK);
		comboBoxNovaConexao.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxNovaConexao.setBounds(525, 370, 450, 30);
		comboBoxNovaConexao.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Tipo de Conexão", "Familares", "Melhores Amigos", "Amigos Proximos", "Colegas", "Colegas de Trabalho"}));
		comboBoxNovaConexao.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				String value = (String)comboBoxNovaConexao.getSelectedItem();
				if(!value.equals("Selecione o Tipo de Conexão")) {
					novaConexao = value;
				}
				else {
					novaConexao = null;
				}
			}
			
		});
		frameAlterarContato.getContentPane().add(comboBoxNovaConexao);
		
		
		JButton btnAlterarContato = new JButton("Alterar Contato");
		btnAlterarContato.setBackground(Color.WHITE);
		btnAlterarContato.addActionListener(new AlterarControler(this));
		btnAlterarContato.setForeground(Color.WHITE);
		btnAlterarContato.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnAlterarContato.setBounds(350, 430, 250, 60);
		btnAlterarContato.setBackground(new Color(0, 102, 204));
		
		btnAlterarContato.addMouseListener((MouseListener) new MouseListener () {

			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				btnAlterarContato.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnAlterarContato.setBackground(new Color(0, 51, 204));
			}

			public void mouseExited(MouseEvent e) {
				btnAlterarContato.setBackground(new Color(0, 102, 204));
			}
			
		});
		
		frameAlterarContato.getContentPane().add(btnAlterarContato);
		
		frameAlterarContato.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent event) {
				InterfaceAgenda reiniciarAgenda = new InterfaceAgenda();
				reiniciarAgenda.inicializar();
			}
		});
	}

	public JFrame getFrameAlterarContato() {
		return frameAlterarContato;
	}

	public Contato getContatoAlterado() {
		return contatoAlterado;
	}

	public String getInputNomeContato() {
		return inputNomeContato.getText();
	}

	public String getInputApelidoContato() {
		return inputApelidoContato.getText();
	}

	public String getInputTelefoneContato() {
		return inputTelefoneContato.getText();
	}

	public String getNovaConexao() {
		return this.novaConexao;
	}
	
	
}
