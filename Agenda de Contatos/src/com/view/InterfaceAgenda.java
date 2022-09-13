package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.classes.Contato;
import com.model.ContatoDAO;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class InterfaceAgenda {

	private JFrame frameAgenda;
	private JTable tableContatos;

	/**
	 * Launch the application.
	 */
	
	public InterfaceAgenda () {
		
	}
	public void inicializar () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAgenda window = new InterfaceAgenda();
					window.create();
					window.frameAgenda.setVisible(true);
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
		frameAgenda = new JFrame();
		frameAgenda.setTitle("Agenda de Contatos");
		frameAgenda.setResizable(false);
		frameAgenda.setBounds(200, 200, 1250, 400);
		frameAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAgenda.getContentPane().setLayout(null);
		frameAgenda.getContentPane().setBackground(new Color(28 ,28 ,28));
		
		JScrollPane painelDeContatos = new JScrollPane();
		painelDeContatos.setBounds(15, 60, 1200, 200);
		frameAgenda.getContentPane().add(painelDeContatos);
		
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		cellRender.setBackground(new Color(28 ,28 ,28));
		cellRender.setForeground(Color.WHITE);
		tableContatos = new JTable();
		tableContatos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id. Contato :", "Nome :", "Apelido :", "Conexão :", "Contato :", "Data de Conexão :"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableContatos.getColumnModel().getColumn(0).setResizable(false);
		tableContatos.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableContatos.getColumnModel().getColumn(0).setMinWidth(80);
		tableContatos.getColumnModel().getColumn(0).setMaxWidth(80);
		tableContatos.getColumnModel().getColumn(1).setResizable(false);
		tableContatos.getColumnModel().getColumn(1).setPreferredWidth(450);
		tableContatos.getColumnModel().getColumn(1).setMinWidth(450);
		tableContatos.getColumnModel().getColumn(1).setMaxWidth(450);
		tableContatos.getColumnModel().getColumn(2).setResizable(false);
		tableContatos.getColumnModel().getColumn(2).setPreferredWidth(250);
		tableContatos.getColumnModel().getColumn(2).setMinWidth(250);
		tableContatos.getColumnModel().getColumn(2).setMaxWidth(250);
		tableContatos.getColumnModel().getColumn(3).setResizable(false);
		tableContatos.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableContatos.getColumnModel().getColumn(3).setMinWidth(150);
		tableContatos.getColumnModel().getColumn(3).setMaxWidth(150);
		tableContatos.getColumnModel().getColumn(4).setResizable(false);
		tableContatos.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableContatos.getColumnModel().getColumn(4).setMinWidth(150);
		tableContatos.getColumnModel().getColumn(4).setMaxWidth(150);
		tableContatos.getColumnModel().getColumn(5).setResizable(false);
		tableContatos.getColumnModel().getColumn(5).setPreferredWidth(120);
		tableContatos.getColumnModel().getColumn(5).setMinWidth(120);
		tableContatos.getColumnModel().getColumn(5).setMaxWidth(120);
		
		for(int i =0; i < 6; ++i) {
			tableContatos.getColumnModel().getColumn(i).setCellRenderer(cellRender);
			tableContatos.getColumnModel().getColumn(i).setHeaderRenderer(cellRender);
		}
		ContatoDAO crudContatos = new ContatoDAO();
		Object contatos [] = crudContatos.readAll().toArray();
		DefaultTableModel model = (DefaultTableModel)tableContatos.getModel();
		for(int i =0; i < contatos.length; ++i) {
			Contato contato = (Contato) contatos[i];
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String dataFormatada = format.format(contato.getDataDeConexao());
			model.addRow(new Object [] {contato.getIdContato() , contato.getNome()  , contato.getApelido() , contato.getTipoDeConexao()  , contato.getTelefoneDeContato()  , dataFormatada});
		}
		
		painelDeContatos.setViewportView(tableContatos);
		
		JButton btnExcluirContato = new JButton("Excluir Contato");
		btnExcluirContato.setForeground(Color.WHITE);
		btnExcluirContato.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnExcluirContato.setBounds(60, 280, 350, 60);
		btnExcluirContato.setBackground(new Color(255, 0, 0));
		btnExcluirContato.addMouseListener((MouseListener) new MouseListener () {
			public void mouseClicked(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {
				btnExcluirContato.setCursor(new Cursor (Cursor.HAND_CURSOR));
				btnExcluirContato.setBackground(new Color(102, 0, 0));
			}

			public void mouseExited(MouseEvent e) {
				btnExcluirContato.setBackground(new Color(255, 0, 0));
			}
			
		});

		btnExcluirContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableContatos.getSelectedRow();
				if(row >=0) {
					int idContatoSelecionado = (int)model.getValueAt(row, 0);
					ContatoDAO crudClientes = new ContatoDAO();
					Contato contatoExcluido = crudClientes.excluir(idContatoSelecionado);
					if(contatoExcluido != null) {
						frameAgenda.dispose();
						InterfaceContatoExcluido visualizarContato = new InterfaceContatoExcluido (contatoExcluido);
						visualizarContato.inicializar();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um Contato para deletar");
				}
			}
		});
		
		frameAgenda.getContentPane().add(btnExcluirContato);
		
		JLabel lblListaDeContatos = new JLabel("Lista de Contatos :");
		lblListaDeContatos.setForeground(Color.WHITE);
		lblListaDeContatos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblListaDeContatos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeContatos.setBounds(15, 10, 250, 40);
		frameAgenda.getContentPane().add(lblListaDeContatos);
		
		JButton btnAlterarContato = new JButton("Alterar Contato");
		btnAlterarContato.setForeground(Color.WHITE);
		btnAlterarContato.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnAlterarContato.setBounds(440, 280, 350, 60);
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
		
		btnAlterarContato.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int row = tableContatos.getSelectedRow();
				if(row>=0) {
					int idContatoSelecionado = (int)model.getValueAt(row, 0);
					ContatoDAO crudContatos = new ContatoDAO();
					Contato contatoLocalizado = crudContatos.read(idContatoSelecionado);
					crudContatos.desfazerConexao();
					if(contatoLocalizado != null) {
						frameAgenda.dispose();
						InterfaceAlterarContato alterarContato = new InterfaceAlterarContato(contatoLocalizado);
						alterarContato.inicializar();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Escolha um Contato para ser Alterado !!!");
				}
	
				
			}
		});
		
		frameAgenda.getContentPane().add(btnAlterarContato);
		
		JButton btnAdicionarContato = new JButton("Adicionar Contato");
		btnAdicionarContato.setForeground(Color.WHITE);
		btnAdicionarContato.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnAdicionarContato.setBounds(820, 280, 350, 60);
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
		
		btnAdicionarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAgenda.dispose();
				InterfaceAdicionarContato adicionarContato = new InterfaceAdicionarContato ();
				adicionarContato.inicializar();
			}
		});

		frameAgenda.getContentPane().add(btnAdicionarContato);
	}
}
