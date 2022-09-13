package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.controler.AdicionarControler;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class InterfaceAdicionarContato {

	private JFrame frameAdicionarContato;
	private JTextField inputNomeContato;
	private JTextField inputApelidoContato;
	private JTextField inputTelefoneContato;
	private String conexaoSelecionada;

	/**
	 * Launch the application.
	 */
	public void inicializar () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAdicionarContato window = new InterfaceAdicionarContato();
					window.create();
					window.frameAdicionarContato.setVisible(true);
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
		frameAdicionarContato = new JFrame();
		frameAdicionarContato.setTitle("Adicionar Contato");
		frameAdicionarContato.setResizable(false);
		frameAdicionarContato.setBounds(570, 150, 500, 550);
		frameAdicionarContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAdicionarContato.getContentPane().setLayout(null);
		frameAdicionarContato.getContentPane().setBackground(new Color(28,28,28));
		
		JLabel lblNomeContato = new JLabel("Nome do Contato :");
		lblNomeContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeContato.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNomeContato.setForeground(Color.WHITE);
		lblNomeContato.setBounds(150, 20, 200, 40);
		frameAdicionarContato.getContentPane().add(lblNomeContato);
		
		inputNomeContato = new JTextField();
		inputNomeContato.setBackground(Color.WHITE);
		inputNomeContato.setHorizontalAlignment(SwingConstants.CENTER);
		inputNomeContato.setForeground(Color.BLACK);
		inputNomeContato.setFont(new Font("Arial", Font.PLAIN, 14));
		inputNomeContato.setBounds(15, 70, 450, 30);
		frameAdicionarContato.getContentPane().add(inputNomeContato);
		inputNomeContato.setColumns(10);
		
		JLabel lblApelido = new JLabel("Apelido :");
		lblApelido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApelido.setForeground(Color.WHITE);
		lblApelido.setFont(new Font("Arial", Font.PLAIN, 18));
		lblApelido.setBounds(150, 130, 200, 40);
		frameAdicionarContato.getContentPane().add(lblApelido);
		
		inputApelidoContato = new JTextField();
		inputApelidoContato.setBackground(Color.WHITE);
		inputApelidoContato.setHorizontalAlignment(SwingConstants.CENTER);
		inputApelidoContato.setForeground(Color.BLACK);
		inputApelidoContato.setFont(new Font("Arial", Font.PLAIN, 14));
		inputApelidoContato.setColumns(10);
		inputApelidoContato.setBounds(15, 180, 450, 30);
		frameAdicionarContato.getContentPane().add(inputApelidoContato);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTelefone.setBounds(145, 240, 200, 40);
		frameAdicionarContato.getContentPane().add(lblTelefone);
		
		inputTelefoneContato = new JTextField();
		inputTelefoneContato.setBackground(Color.WHITE);
		inputTelefoneContato.setHorizontalAlignment(SwingConstants.CENTER);
		inputTelefoneContato.setForeground(Color.BLACK);
		inputTelefoneContato.setFont(new Font("Arial", Font.PLAIN, 14));
		inputTelefoneContato.setColumns(10);
		inputTelefoneContato.setBounds(15, 290, 450, 30);
		frameAdicionarContato.getContentPane().add(inputTelefoneContato);
		
		JComboBox comboBoxConexao = new JComboBox();
		comboBoxConexao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxConexao.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Tipo de Conexão", "Familares", "Melhores Amigos", "Amigos Proximos", "Colegas", "Colegas de Trabalho"}));
		comboBoxConexao.setBackground(Color.WHITE);
		comboBoxConexao.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxConexao.setForeground(Color.BLACK);
		comboBoxConexao.setBounds(15, 360, 450, 40);
		comboBoxConexao.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				String value = (String) comboBoxConexao.getSelectedItem();
				if(!value.equals("Selecione o Tipo de Conexão")) {
					conexaoSelecionada = value;
				}
				else {
					conexaoSelecionada = null;
				}
			}
		});
		
		frameAdicionarContato.getContentPane().add(comboBoxConexao);
		
		JButton btnAdicionarContato = new JButton("Adicionar Contato");
		btnAdicionarContato.setBackground(Color.WHITE);
		btnAdicionarContato.addActionListener(new AdicionarControler (this));
		btnAdicionarContato.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnAdicionarContato.setForeground(Color.WHITE);
		btnAdicionarContato.setBounds(120, 430, 250, 60);
		btnAdicionarContato.setBackground(new Color(0, 153, 51));

		btnAdicionarContato.addMouseListener((MouseListener) new MouseListener () {

			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				btnAdicionarContato.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnAdicionarContato.setBackground(new Color(0, 51, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnAdicionarContato.setBackground(new Color(0, 153, 51));
			}
			
		});
		
		frameAdicionarContato.getContentPane().add(btnAdicionarContato);
	
		frameAdicionarContato.addWindowListener(new WindowAdapter() {
			public void windowClosing (WindowEvent event) {
				InterfaceAgenda reiniciarAgenda = new InterfaceAgenda();
				reiniciarAgenda.inicializar();
			}
		});
	}

	public JFrame getFrameAdicionarContato() {
		return frameAdicionarContato;
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

	public String getConexaoSelecionada() {
		return conexaoSelecionada;
	}
	
	
}
