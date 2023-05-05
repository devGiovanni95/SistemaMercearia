package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.ProdutosController;
import model.Produto;
import java.awt.event.WindowStateListener;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFrenteCaixa.
 */
public class FrmFrenteCaixa extends JFrame{

	private JTextField tfCpf;
	private JTextField tfPrecoUnitario;
	private JTextField tfCodigoDeBarras;
	private JTextField tfQuantidadeDeItens;
	private Label lblSubTotal;
	private JTable listaProdutos;
	private String descricao,item, codigoBarras;
	private double total=0, quantidade,preco;
	private JLabel lblSituacaoCaixa;
	private JButton btnCancelarVenda;
	private JButton btnFecharCaixa;
	private JButton btnCancelarItem;
	private JButton btnFinalizarVenda;
	private JButton btnNotaPaulista;
	private JButton btnSangria;
	private Double subTotal;
	private Double totalCompra=0.0;
	private Double trocoInicial;
	private boolean conferirSituacaoCaixa;
	private double quantidadeProduto;	
	private JLabel lblTotalCompra ;
	
	
	public boolean isconferirSituacaoCaixa() {
		return conferirSituacaoCaixa;
	}


	public void setconferirSituacaoCaixa(boolean conferirSituacaoCaixa) {
		this.conferirSituacaoCaixa = conferirSituacaoCaixa;
	} 
	
	
	public void desabilitarBotoesCaixa() {
		this.btnCancelarItem.setEnabled(false);
		this.btnCancelarVenda.setEnabled(false);
		this.btnFecharCaixa.setEnabled(false);
		this.btnFinalizarVenda.setEnabled(false);
		this.btnSangria.setEnabled(false);
		this.btnNotaPaulista.setEnabled(false);	
		
	}
	
	public void habilitarBotoesCaixa() {
		btnCancelarItem.setEnabled(true);
		btnCancelarVenda.setEnabled(true);
		btnFecharCaixa.setEnabled(true);
		btnFinalizarVenda.setEnabled(true);
		btnSangria.setEnabled(true);
		btnNotaPaulista.setEnabled(true);	
		
	}
	
	
	private void situacaoCaixa() {		
		if(conferirSituacaoCaixa == true) {
			lblSituacaoCaixa = new JLabel("Caixa Aberto");
			lblSituacaoCaixa.setForeground(Color.GREEN);
			lblSituacaoCaixa.setFont(new Font("Arial", Font.BOLD, 48));	
			//habilitarBotoesCaixa();
		}else {
			lblSituacaoCaixa = new JLabel("Caixa Fechado");
			lblSituacaoCaixa.setForeground(Color.RED);
			lblSituacaoCaixa.setFont(new Font("Arial", Font.BOLD, 48));	
			//desabilitarBotoesCaixa();
		}
	}
	
	
	private void conferirTroco() {
		FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
	try {
		trocoInicial =  Double.parseDouble(JOptionPane.showInputDialog("Digite no Troco Inicial"));
		if(trocoInicial >= 0) {
			JOptionPane.showMessageDialog(null, "Caixa Aberto");//criar uma tela personalizada
			frmMenuPrincipal.setSituacaoCaixa(true);	
			lblSituacaoCaixa.setText("Caixa Aberto");
			lblSituacaoCaixa.setForeground(Color.GREEN);
			setconferirSituacaoCaixa(true);
			habilitarBotoesCaixa();
			tfCodigoDeBarras.requestFocusInWindow();
			//tfCodigoDeBarras.setFocusable(true);
			System.out.println(conferirSituacaoCaixa);
			repaint();
					
				
			}else {
				JOptionPane.showMessageDialog(null, "Valor tem ser maior ou igual a zero");
				conferirTroco();
			}
		
		} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor inválido " + e);
				conferirTroco();
		}
			//setconferirSituacaoCaixa(true);
	
	}

	
	private void conferirQuantidade() {
		try {
				quantidadeProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite a Quantidade de Itens"));
				tfQuantidadeDeItens.setText(quantidadeProduto + "");
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Valor não permitido" + e2);
				conferirQuantidade();
		}
	}
	
	private void formaPagamento() {
		double totalCompra = Double.parseDouble(lblTotalCompra.getText());
		
		if(totalCompra > 0) {
			FrmFormaDePagamento formaDePagamento = new FrmFormaDePagamento();
			formaDePagamento.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Ops venda não pode ser finalizada pois não há nenhum lançamento");
		}
	}

	
	
	private void itensTabela() { 
		//linha tabela titulo
		DefaultTableModel dadosTabela = (DefaultTableModel) listaProdutos.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(6);
		dadosTabela.addRow(new Object[]{"Código","Descrição","Quantidade","Item","Preço" ,"Total"});
	}
	
	
	private void esperar() {
		try {
		    Thread.sleep(1200);		
		} catch (InterruptedException ex) {
		    
		}
		tfCodigoDeBarras.setText("");
		tfPrecoUnitario.setText("");
	}
	
	private void adicionarItens() {
		Produto produtos = new Produto();
		ProdutosController produtosController = new ProdutosController();
		
		produtos = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());
		tfPrecoUnitario.setText(String.valueOf(produtos.getPrecoFinal()));				
		DefaultTableModel dadosTabela = (DefaultTableModel) listaProdutos.getModel();		
		quantidade = Double.parseDouble(tfQuantidadeDeItens.getText());
		subTotal = Double.parseDouble(tfQuantidadeDeItens.getText()) * Double.parseDouble(tfPrecoUnitario.getText());
		totalCompra += subTotal;
		lblTotalCompra.setText(String.valueOf(totalCompra));
		
		dadosTabela.addRow(new Object[] {
				tfCodigoDeBarras.getText(),	
				produtos.getDescricao(),
				tfQuantidadeDeItens.getText(),
				produtos.getUnidadeDeMedida(),
				tfPrecoUnitario.getText(),
				subTotal
		});
		
		
		//tentar aguardar o1 segundo antes  de apagar informações
		esperar();
		tfQuantidadeDeItens.setText("1");
	
	}
	
	private void conferirEstadoCaixa() {
		
		FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
		conferirSituacaoCaixa = frmMenuPrincipal.getSituacaoCaixa();		
		if (isconferirSituacaoCaixa() == true) {
			habilitarBotoesCaixa();
		}else {
			desabilitarBotoesCaixa();
		}
		}

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFrenteCaixa frame = new FrmFrenteCaixa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmFrenteCaixa() {
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				itensTabela();
				setFocusable(true);
				//conferirEstadoCaixa();
			}
		});
			setFocusable(true);
			
			addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				itensTabela();
				setFocusable(true);
				//conferirEstadoCaixa();
				lblTotalCompra.setText("0.0");
				
			}

		});
		getContentPane().setBackground(new Color(175, 205, 253));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		this.setLocationRelativeTo(null);
		
		JPanel painelCabecalho = new JPanel();
		painelCabecalho.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelCabecalho.setBackground(Color.WHITE);
		
		JPanel painelQuantidadeDeItens = new JPanel();
		painelQuantidadeDeItens.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel painelCodigoDeBarras = new JPanel();
		painelCodigoDeBarras.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel painelPrecoUnitario = new JPanel();
		painelPrecoUnitario.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel painelCpf = new JPanel();
		painelCpf.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel painelComandos = new JPanel();
		painelComandos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelComandos.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_1 = new JLabel("Comandos");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		painelComandos.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(1, 1, 309, 31);
		panel_5.setBackground(new Color(10, 87, 194));
		
		
		lblSituacaoCaixa = new JLabel();
		situacaoCaixa();
		
		JPanel painelListaProdutos = new JPanel();
		painelListaProdutos.setBackground(new Color(255, 255, 255));
		painelListaProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel painelSubTotal = new JPanel();
		painelSubTotal.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		painelSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelSubTotal.setBackground(Color.WHITE);
		
		JPanel painelBotoesComandos = new JPanel();
		painelBotoesComandos.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JPanel painelImagemProduto = new JPanel();
		painelImagemProduto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(painelCabecalho, GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(2)
											.addComponent(painelImagemProduto, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(painelCpf, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(painelPrecoUnitario, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(painelCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(painelQuantidadeDeItens, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
										.addComponent(painelComandos, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
									.addGap(19))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelBotoesComandos, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(painelListaProdutos, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
								.addComponent(painelSubTotal, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))))
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(painelCabecalho, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(painelListaProdutos, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelSubTotal, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelQuantidadeDeItens, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(painelCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(painelPrecoUnitario, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addGap(15)
									.addComponent(painelCpf, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelImagemProduto, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(painelComandos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelBotoesComandos, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		
		listaProdutos = new JTable();
		GroupLayout gl_painelListaProdutos = new GroupLayout(painelListaProdutos);
		gl_painelListaProdutos.setHorizontalGroup(
			gl_painelListaProdutos.createParallelGroup(Alignment.LEADING)
				.addComponent(listaProdutos, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
		);
		gl_painelListaProdutos.setVerticalGroup(
			gl_painelListaProdutos.createParallelGroup(Alignment.TRAILING)
				.addComponent(listaProdutos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		painelListaProdutos.setLayout(gl_painelListaProdutos);
		GroupLayout gl_painelCabecalho = new GroupLayout(painelCabecalho);
		gl_painelCabecalho.setHorizontalGroup(
			gl_painelCabecalho.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCabecalho.createSequentialGroup()
					.addGap(416)
					.addComponent(lblSituacaoCaixa)
					.addContainerGap(496, Short.MAX_VALUE))
		);
		gl_painelCabecalho.setVerticalGroup(
			gl_painelCabecalho.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painelCabecalho.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(lblSituacaoCaixa))
		);
		painelCabecalho.setLayout(gl_painelCabecalho);
		
		JButton btnConsultar = new JButton("F1 - Modo Consulta");
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnNotaPaulista = new JButton("F2 - Nota Fiscal Paulista");
		btnNotaPaulista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evento) {
				if(evento.getKeyCode() == KeyEvent.VK_ENTER) {
					tfCodigoDeBarras.requestFocusInWindow();
					repaint();
				}
			}
		});
		btnNotaPaulista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCpf.requestFocusInWindow();
				tfCodigoDeBarras.requestFocusInWindow();
			}
		});
		btnNotaPaulista.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnFinalizarVenda = new JButton("F10 - Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//double totalCompra = Double.parseDouble(lblTotalCompra.getText());
				if(conferirSituacaoCaixa == true) {
					formaPagamento();
				}else {
					JOptionPane.showMessageDialog(null, "Ops Caixa Fechado");
				}
			}
		});
		btnFinalizarVenda.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnCancelarItem = new JButton("F11 - Cancelar Item");
		btnCancelarItem.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnAbrirCaixa = new JButton("F3 - Abrir Caixa");
		btnAbrirCaixa.setFocusable(true);
		btnAbrirCaixa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evento) {
				if(evento.getKeyCode() == KeyEvent.VK_F3) {
					conferirTroco();
				}
			}
			
			@Override
			public void keyTyped(KeyEvent evento) {
				if(evento.getKeyCode() == KeyEvent.VK_F3) {
					conferirTroco();
				}
			}
		});
		btnAbrirCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conferirTroco();
				
			}
		});
		btnAbrirCaixa.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnFecharCaixa = new JButton("F4 - Fechar Caixa");
		btnFecharCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFecharCaixa.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnSangria = new JButton("F5 - Sangria");
		btnSangria.setFont(new Font("Arial", Font.BOLD, 22));
		
		tfCodigoDeBarras = new JTextField();
		tfCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 15));
		tfCodigoDeBarras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//buscar produto por codigo
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					adicionarItens();	 
				}
			}		
		});
	tfCodigoDeBarras.setBounds(1, 31, 310, 38);
	painelCodigoDeBarras.add(tfCodigoDeBarras);
	tfCodigoDeBarras.setColumns(10);
	painelCpf.setLayout(null);

		
		JButton btnQuantidade = new JButton("F6 - Quantidade Itens");
		btnQuantidade.setFont(new Font("Arial", Font.BOLD, 22));
		btnQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfQuantidadeDeItens.setText("");
				tfQuantidadeDeItens.setEditable(true);
				tfQuantidadeDeItens.requestFocusInWindow();
			}
		});
		btnQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//buscar produto por codigo
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {					
					tfCodigoDeBarras.setFocusable(true);
				}
			}

		});
		
		btnCancelarVenda = new JButton("F12 - Cancelar Venda");
		btnCancelarVenda.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnMenuPrincipal = new JButton("F7 - Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
				//frmMenuPrincipal.setVisible(true);
				
			}
		});
		btnMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 22));
		
		
		GroupLayout gl_painelBotoesComandos = new GroupLayout(painelBotoesComandos);
		gl_painelBotoesComandos.setHorizontalGroup(
			gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnAbrirCaixa, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnNotaPaulista, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnFecharCaixa, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnFinalizarVenda, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnSangria, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnCancelarItem, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnQuantidade, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnCancelarVenda, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnMenuPrincipal, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
		);
		gl_painelBotoesComandos.setVerticalGroup(
			gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnConsultar)
						.addComponent(btnAbrirCaixa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNotaPaulista, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFecharCaixa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFinalizarVenda, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSangria, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnQuantidade, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelarItem, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnCancelarVenda, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		painelBotoesComandos.setLayout(gl_painelBotoesComandos);
		painelCodigoDeBarras.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(1, 1, 309, 31);
		panel_6.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_1 = new JLabel("Código de Barras");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel_6.add(lblNewLabel_2_1);
		painelCodigoDeBarras.add(panel_6);
		
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(1, 1, 309, 31);
		panel_8.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_3 = new JLabel("CPF");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel_8.add(lblNewLabel_2_3);
		painelCpf.add(panel_8);
		
		tfCpf = new JTextField();
		tfCpf.setFont(new Font("Arial", Font.BOLD, 15));
		tfCpf.setEditable(false);
		tfCpf.setBounds(0, 31, 310, 39);
		painelCpf.add(tfCpf);
		tfCpf.setColumns(10);
		painelPrecoUnitario.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(1, 1, 309, 31);
		panel_7.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_2 = new JLabel("Preço Unitário");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_7.add(lblNewLabel_2_2);
		painelPrecoUnitario.add(panel_7);
		
		tfPrecoUnitario = new JTextField();
		tfPrecoUnitario.setFont(new Font("Arial", Font.BOLD, 15));
		tfPrecoUnitario.setEditable(false);
		tfPrecoUnitario.setBounds(0, 30, 310, 39);
		painelPrecoUnitario.add(tfPrecoUnitario);
		tfPrecoUnitario.setColumns(10);
		painelQuantidadeDeItens.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade De Itens");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_5.add(lblNewLabel_2);
		painelQuantidadeDeItens.add(panel_5);
		
		tfQuantidadeDeItens = new JTextField();
		tfQuantidadeDeItens.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F6) {
					tfCodigoDeBarras.setRequestFocusEnabled(true);
				}
			}
		});
		
		
		
		
		tfQuantidadeDeItens.setFont(new Font("Arial", Font.BOLD, 15));
		tfQuantidadeDeItens.setEditable(false);
		tfQuantidadeDeItens.setBounds(1, 29, 310, 40);
		painelQuantidadeDeItens.add(tfQuantidadeDeItens);
		tfQuantidadeDeItens.setColumns(10);
		tfQuantidadeDeItens.setText("1");
		
		JPanel tituloSubtotal = new JPanel();
		tituloSubtotal.setBackground(new Color(10, 87, 194));
		
		JPanel painelSubtotal = new JPanel();
		painelSubTotal.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		GroupLayout gl_painelSubTotal = new GroupLayout(painelSubTotal);
		gl_painelSubTotal.setHorizontalGroup(
			gl_painelSubTotal.createParallelGroup(Alignment.LEADING)
				.addComponent(tituloSubtotal, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
				.addComponent(painelSubtotal, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
		);
		gl_painelSubTotal.setVerticalGroup(
			gl_painelSubTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelSubTotal.createSequentialGroup()
					.addComponent(tituloSubtotal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(painelSubtotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(25))
		);
		FlowLayout fl_painelSubtotal = new FlowLayout(FlowLayout.CENTER, 5, 5);
		painelSubtotal.setLayout(fl_painelSubtotal);
		
		lblTotalCompra = new JLabel(" ");
		lblTotalCompra.setFont(new Font("Arial", Font.BOLD, 34));
		painelSubtotal.add(lblTotalCompra);
		
		JLabel lblNewLabel_1_1 = new JLabel("SubTotal");
		tituloSubtotal.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		painelSubTotal.setLayout(gl_painelSubTotal);
		getContentPane().setLayout(groupLayout);
		
	
		
	}
	public void actionPerfomed(ActionEvent evento) {
		if(evento.getSource() == tfQuantidadeDeItens) {
			tfCodigoDeBarras.requestFocusInWindow();
			tfCodigoDeBarras.setFocusable(true);
		}
	}


}
