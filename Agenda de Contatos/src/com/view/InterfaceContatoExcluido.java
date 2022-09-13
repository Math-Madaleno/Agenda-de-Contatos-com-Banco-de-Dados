package com.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.classes.Contato;

public class InterfaceContatoExcluido {
	private JFrame frameContatoExcluido;
	private JTextField textIdContato;
	private JTextField textNomeContato;
	private JTextField textApelidoContato;
	private JTextField textTelefoneContato;
	private JTextField textTipoDeConexao;
	private JLabel lblDataDeConexao;
	private JTextField textDataDeConexao;
	private JButton btnFinalizar;
	private Contato contatoExcluido;

	/**
	 * Launch the application.
	 */
	public InterfaceContatoExcluido (Contato contatoExcluido) {
		this.contatoExcluido = contatoExcluido;
	}
	
	public void inicializar () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceContatoExcluido window = new InterfaceContatoExcluido(contatoExcluido);
					window.create();
					window.frameContatoExcluido.setVisible(true);
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

	private void create (){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameContatoExcluido = new JFrame();
		frameContatoExcluido.setResizable(false);
		frameContatoExcluido.setTitle("Contato Excluido : " + contatoExcluido.getApelido());
		frameContatoExcluido.setBounds(550, 80, 500, 750);
		frameContatoExcluido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameContatoExcluido.getContentPane().setLayout(null);
		frameContatoExcluido.getContentPane().setBackground(new Color(28,28,28));
		
		JLabel lblIdContato = new JLabel("Id . Contato :");
		lblIdContato.setForeground(Color.WHITE);
		lblIdContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdContato.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIdContato.setBounds(120, 10, 250, 40);
		frameContatoExcluido.getContentPane().add(lblIdContato);
		
		textIdContato = new JTextField();
		textIdContato.setText(""+contatoExcluido.getIdContato());
		textIdContato.setBackground(Color.WHITE);
		textIdContato.setHorizontalAlignment(SwingConstants.CENTER);
		textIdContato.setForeground(Color.BLACK);
		textIdContato.setEditable(false);
		textIdContato.setFont(new Font("Arial", Font.PLAIN, 15));
		textIdContato.setBounds(15, 60, 450, 30);
		frameContatoExcluido.getContentPane().add(textIdContato);
		textIdContato.setColumns(10);
		
		JLabel lblNomeContato = new JLabel("Nome do Contato :");
		lblNomeContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeContato.setForeground(Color.WHITE);
		lblNomeContato.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNomeContato.setBounds(120, 110, 250, 40);
		frameContatoExcluido.getContentPane().add(lblNomeContato);
		
		textNomeContato = new JTextField();
		textNomeContato.setText(contatoExcluido.getNome());
		textNomeContato.setBackground(Color.WHITE);
		textNomeContato.setEditable(false);
		textNomeContato.setForeground(Color.BLACK);
		textNomeContato.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeContato.setFont(new Font("Arial", Font.PLAIN, 15));
		textNomeContato.setColumns(10);
		textNomeContato.setBounds(15, 160, 450, 30);
		frameContatoExcluido.getContentPane().add(textNomeContato);
		
		JLabel lblApelidoContato = new JLabel("Apelido do Contato :");
		lblApelidoContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblApelidoContato.setForeground(Color.WHITE);
		lblApelidoContato.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApelidoContato.setBounds(120, 210, 250, 40);
		frameContatoExcluido.getContentPane().add(lblApelidoContato);
		
		textApelidoContato = new JTextField();
		textApelidoContato.setText(contatoExcluido.getApelido());
		textApelidoContato.setBackground(Color.WHITE);
		textApelidoContato.setEditable(false);
		textApelidoContato.setFont(new Font("Arial", Font.PLAIN, 15));
		textApelidoContato.setHorizontalAlignment(SwingConstants.CENTER);
		textApelidoContato.setForeground(Color.BLACK);
		textApelidoContato.setColumns(10);
		textApelidoContato.setBounds(15, 260, 450, 30);
		frameContatoExcluido.getContentPane().add(textApelidoContato);
		
		JLabel lblTelefoneContato = new JLabel("Telefone :");
		lblTelefoneContato.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefoneContato.setForeground(Color.WHITE);
		lblTelefoneContato.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTelefoneContato.setBounds(120, 310, 250, 40);
		frameContatoExcluido.getContentPane().add(lblTelefoneContato);
		
		textTelefoneContato = new JTextField();
		textTelefoneContato.setText(contatoExcluido.getTelefoneDeContato());
		textTelefoneContato.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefoneContato.setForeground(Color.BLACK);
		textTelefoneContato.setFont(new Font("Arial", Font.PLAIN, 15));
		textTelefoneContato.setEditable(false);
		textTelefoneContato.setBackground(Color.WHITE);
		textTelefoneContato.setColumns(10);
		textTelefoneContato.setBounds(15, 360, 450, 30);
		frameContatoExcluido.getContentPane().add(textTelefoneContato);
		
		JLabel lblTipoDeConexao = new JLabel("Tipo de Conexão :");
		lblTipoDeConexao.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeConexao.setForeground(Color.WHITE);
		lblTipoDeConexao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipoDeConexao.setBounds(120, 410, 250, 40);
		frameContatoExcluido.getContentPane().add(lblTipoDeConexao);
		
		textTipoDeConexao = new JTextField();
		textTipoDeConexao.setText(contatoExcluido.getTipoDeConexao());
		textTipoDeConexao.setEditable(false);
		textTipoDeConexao.setHorizontalAlignment(SwingConstants.CENTER);
		textTipoDeConexao.setForeground(Color.BLACK);
		textTipoDeConexao.setFont(new Font("Arial", Font.PLAIN, 15));
		textTipoDeConexao.setBackground(Color.WHITE);
		textTipoDeConexao.setColumns(10);
		textTipoDeConexao.setBounds(15, 460, 450, 30);
		frameContatoExcluido.getContentPane().add(textTipoDeConexao);
		
		lblDataDeConexao = new JLabel("Data de Conexão :");
		lblDataDeConexao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDeConexao.setForeground(Color.WHITE);
		lblDataDeConexao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDataDeConexao.setBounds(120, 510, 250, 40);
		frameContatoExcluido.getContentPane().add(lblDataDeConexao);
		
		SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy");
		String dataFormatada = format.format(contatoExcluido.getDataDeConexao());
		textDataDeConexao = new JTextField();
		textDataDeConexao.setText(dataFormatada);
		textDataDeConexao.setHorizontalAlignment(SwingConstants.CENTER);
		textDataDeConexao.setForeground(Color.BLACK);
		textDataDeConexao.setFont(new Font("Arial", Font.PLAIN, 15));
		textDataDeConexao.setEditable(false);
		textDataDeConexao.setBackground(Color.WHITE);
		textDataDeConexao.setColumns(10);
		textDataDeConexao.setBounds(15, 560, 450, 30);
		frameContatoExcluido.getContentPane().add(textDataDeConexao);
		
		btnFinalizar = new JButton("OK");
		btnFinalizar.setBackground(new Color(0, 102, 255));
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFinalizar.setBackground(new Color(0, 102, 204));
		btnFinalizar.addMouseListener((MouseListener) new MouseListener () {

			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				btnFinalizar.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnFinalizar.setBackground(new Color(0, 51, 204));
			}

			public void mouseExited(MouseEvent e) {
				btnFinalizar.setBackground(new Color(0, 102, 204));
			}
			
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameContatoExcluido.dispose();
				JOptionPane.showMessageDialog(null, "Contato Excluido Com Sucesso !!!");
				InterfaceAgenda reiniciarAgenda = new InterfaceAgenda();
				reiniciarAgenda.inicializar();
			}
		});
		btnFinalizar.setBounds(120, 615, 250, 50);
		frameContatoExcluido.getContentPane().add(btnFinalizar);
		frameContatoExcluido.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				JOptionPane.showMessageDialog(null, "Contato Excluido Com Sucesso !!!");
				InterfaceAgenda reiniciarAgenda = new InterfaceAgenda();
				reiniciarAgenda.inicializar();
			}
		});
		
		
	}
}
