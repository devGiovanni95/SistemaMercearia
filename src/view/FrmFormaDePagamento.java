package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import controller.FormaPagamentoController;
import controller.ItemVendaController;
import controller.VendaController;
import controller.ProdutosController;
import model.Cliente;
import model.FormaPagamento;
import model.ItemVenda;
import model.Venda;
import model.Produto;
import util.GeradorDeCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFormaDePagamento.
 */
public class FrmFormaDePagamento extends JFrame {

	/** The cliente. */
	Cliente cliente;

	/** The content pane. */
	private JPanel contentPane;

	/** The tf dinheiro. */
	private JTextField tfDinheiro;

	/** The tf valor A receber. */
	private JTextField tfValorAReceber;

	/** The tf troco. */
	private JTextField tfTroco;

	/** The tf total compra. */
	private JTextField tfTotalCompra;

	/** The tf cartao credito. */
	private JTextField tfCartaoCredito;

	/** The tf cartao debito. */
	private JTextField tfCartaoDebito;

	/** The tf vale alimentacao. */
	private JTextField tfValeAlimentacao;

	/** The tf vale refeicao. */
	private JTextField tfValeRefeicao;

	/** The tf pix. */
	private JTextField tfPix;

	/** The tf pago. */
	private JTextField tfPago;

	/** The total compra. */
	private double totalCompra;

	/** The total faltante. */
	private double totalFaltante;

	/** The dinheiro. */
	private double dinheiro;

	/** The cartao credito. */
	private double cartaoCredito;

	/** The cartao debito. */
	private double cartaoDebito;

	/** The vale alimentacao. */
	private double valeAlimentacao;

	/** The vale refeicao. */
	private double valeRefeicao;

	/** The pix. */
	private double pix;

	/** The codigo de pagamento gerado automatico. */
	private String codigoDePagamentoGeradoAutomatico;

	/** The gerador de codigo. */
	GeradorDeCodigo geradorDeCodigo;

	/** The forma pagamento. */
	FormaPagamento formaPagamento;

	/** The forma pagamento controller. */
	FormaPagamentoController formaPagamentoController;
	
	/** The frente caixa. */
	FrmFrenteCaixa frenteCaixa = new FrmFrenteCaixa();
	
	/** The venda. */
	Venda venda = new Venda();
	
	/** The lista itens carinho. */
	DefaultTableModel listaItensCarinho;  
	

	/**
	 * Gets the lista itens carinho.
	 *
	 * @return the lista itens carinho
	 */
	public DefaultTableModel getListaItensCarinho() {
		return listaItensCarinho;
	}

	/**
	 * Sets the lista itens carinho.
	 *
	 * @param listaItensCarinho the new lista itens carinho
	 */
	public void setListaItensCarinho(DefaultTableModel listaItensCarinho) {
		this.listaItensCarinho = listaItensCarinho;
	}

	/**
	 * Gets the frente caixa.
	 *
	 * @return the frente caixa
	 */
	public FrmFrenteCaixa getFrenteCaixa() {
		return frenteCaixa;
	}

	/**
	 * Sets the frente caixa.
	 *
	 * @param frenteCaixa the new frente caixa
	 */
	public void setFrenteCaixa(FrmFrenteCaixa frenteCaixa) {
		this.frenteCaixa = frenteCaixa;
	}

	/**
	 * Gets the pedido.
	 *
	 * @return the pedido
	 */
	public Venda getPedido() {
		return venda;
	}

	/**
	 * Sets the pedido.
	 *
	 * @param venda the new pedido
	 */
	public void setPedido(Venda venda) {
		this.venda = venda;
	}


	/**
	 * Gets the total faltante.
	 *
	 * @return the total faltante
	 */
	public Double getTotalFaltante() {
		return totalFaltante;
	}

	/**
	 * Sets the total faltante.
	 *
	 * @param totalFaltante the new total faltante
	 */
	public void setTotalFaltante(Double totalFaltante) {
		this.totalFaltante = totalFaltante;
	}

	/**
	 * Gets the total compra.
	 *
	 * @return the total compra
	 */
	public Double getTotalCompra() {
		return totalCompra;
	}

	/**
	 * Sets the total compra.
	 *
	 * @param totalCompra the new total compra
	 */
	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}
	
	

	/**
	 * Gets the codigo de pagamento gerado automatico.
	 *
	 * @return the codigo de pagamento gerado automatico
	 */
	public String getCodigoDePagamentoGeradoAutomatico() {
		return codigoDePagamentoGeradoAutomatico;
	}

	/**
	 * Sets the codigo de pagamento gerado automatico.
	 *
	 * @param codigoDePagamentoGeradoAutomatico the new codigo de pagamento gerado automatico
	 */
	public void setCodigoDePagamentoGeradoAutomatico(String codigoDePagamentoGeradoAutomatico) {
		this.codigoDePagamentoGeradoAutomatico = codigoDePagamentoGeradoAutomatico;
	}

	/**
	 * Setar valores.
	 */
	public void setarValores() {
		tfCartaoCredito.setText("0");
		tfCartaoDebito.setText("0");
		tfValeAlimentacao.setText("0");
		tfValeRefeicao.setText("0");
		tfPix.setText("0");
		tfTroco.setText("0");
	}

	/**
	 * Calcular saldo devedor.
	 *
	 * @return the double
	 */
	public double calcularSaldoDevedor() {

		dinheiro = Double.parseDouble(tfDinheiro.getText());
		cartaoCredito = Double.parseDouble(tfCartaoCredito.getText());
		cartaoDebito = Double.parseDouble(tfCartaoDebito.getText());
		valeAlimentacao = Double.parseDouble(tfValeAlimentacao.getText());
		valeRefeicao = Double.parseDouble(tfValeRefeicao.getText());
		pix = Double.parseDouble(tfPix.getText());

		double saldoFaltantante;
		saldoFaltantante = getTotalCompra() - dinheiro - cartaoCredito - cartaoDebito - valeAlimentacao - valeRefeicao
				- pix;

		if (saldoFaltantante < 0) {
			return 0;
		} else {
			return saldoFaltantante;
		}

	}

	/**
	 * Calcular total pago.
	 *
	 * @return the double
	 */
	public double calcularTotalPago() {
		dinheiro = Double.parseDouble(tfDinheiro.getText());
		cartaoCredito = Double.parseDouble(tfCartaoCredito.getText());
		cartaoDebito = Double.parseDouble(tfCartaoDebito.getText());
		valeAlimentacao = Double.parseDouble(tfValeAlimentacao.getText());
		valeRefeicao = Double.parseDouble(tfValeRefeicao.getText());
		pix = Double.parseDouble(tfPix.getText());

		double totalPago = dinheiro + cartaoCredito + cartaoDebito + valeAlimentacao + valeRefeicao + pix;

		return totalPago;

	}

	/**
	 * Calcular troco.
	 *
	 * @return the double
	 */
	public double calcularTroco() {
		double troco = 0;
		double pago = calcularTotalPago();
		double falta = getTotalFaltante();

		if (pago > falta) {
			// troco = getTotalCompra() - calcularTotalPago();
			troco = calcularTotalPago() - getTotalCompra();
			System.out.println("troco" + troco);
			return troco;
		} else {

			System.out.println("troco else" + troco);
			return troco;
		}
	}

	/**
	 * Atualizar componente.
	 */
	public void atualizarComponente() {
		tfPago.setText(String.valueOf(calcularTotalPago()));
		tfTroco.setText(String.valueOf(calcularTroco()).replace("-", ""));
		tfValorAReceber.setText(String.valueOf(calcularSaldoDevedor()));
	}

	/**
	 * Validar pagamento.
	 *
	 * @return true, if successful
	 */
	public boolean validarPagamento() {

		double faltante = Double.parseDouble(tfValorAReceber.getText());

		if (faltante > 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Cadastrar itens pedido.
	 */
	public void cadastrarItensPedido() {
		ItemVendaController itemVendaController = new ItemVendaController();
		ItemVenda itemVenda = new ItemVenda();
		List<ItemVenda> lista = new ArrayList<>();
		Produto produto = new Produto();
		ProdutosController produtosController = new ProdutosController();  
		
		
		lista.addAll(frenteCaixa.getItensPedido());
		
		for(int i = 1; i<= lista.size();i++) {
			produto = produtosController.consultarProdutosPorCodigoBarras(listaItensCarinho.getValueAt(i,0).toString());
			System.out.println("Conferir este0"+produto);
			itemVenda.setPedido(getPedido());
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(Double.parseDouble(listaItensCarinho.getValueAt(i,2).toString()));
			itemVenda.setPrecoUnitario(Double.parseDouble(listaItensCarinho.getValueAt(i,4).toString()));
			itemVenda.setSubtotal(Double.parseDouble(listaItensCarinho.getValueAt(i,5).toString()));
			
			itemVendaController.cadastrarItemVenda(itemVenda);
			System.out.println(itemVenda);
		}
		
	}
	
	
	/**
	 * Cadastrar pedido.
	 */
	public void cadastrarPedido() {
		
		VendaController vendaController = new VendaController();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataFormatada = dataAtual.format(formatter);		
		venda.setDataVenda(dataFormatada);		 
		vendaController.cadastrarVenda(venda);
	}
	

	/**
	 * Cadastrar pagamento.
	 */
	public void cadastrarPagamento() {
		formaPagamento = new FormaPagamento();
		formaPagamentoController = new FormaPagamentoController();
		geradorDeCodigo = new GeradorDeCodigo();

		setCodigoDePagamentoGeradoAutomatico(geradorDeCodigo.geraCodigo());
		//System.out.println(getCodigoDePagamentoGeradoAutomatico());

		formaPagamento.setCodigo(getCodigoDePagamentoGeradoAutomatico());
		formaPagamento.setDinheiro(Double.parseDouble(tfDinheiro.getText()));
		formaPagamento.setCartaoCredito(Double.parseDouble(tfCartaoCredito.getText()));
		formaPagamento.setCartaoDebito(Double.parseDouble(tfCartaoDebito.getText()));
		formaPagamento.setValeAlimentacao(Double.parseDouble(tfValeAlimentacao.getText()));
		formaPagamento.setValeRefeicao(Double.parseDouble(tfValeRefeicao.getText()));
		formaPagamento.setPix(Double.parseDouble(tfPix.getText()));
		formaPagamento.setTroco(Double.parseDouble(tfTroco.getText()));
		formaPagamento.setTotalCompra(Double.parseDouble(tfTotalCompra.getText()));

		formaPagamentoController.cadastrarFormaPagamento(formaPagamento);
		venda.setFormaPagamento(formaPagamento);
		
		
	}
	
	/**
	 * Nova venda.
	 */
	public void novaVenda() {
		FrmFrenteCaixa frmFrenteCaixa = new FrmFrenteCaixa();
		frmFrenteCaixa.setVisible(true);
		frmFrenteCaixa.setFuncionario(frenteCaixa.getFuncionario());
		this.dispose();
	}

	/**
	 * Launch the application.
	 *g
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFormaDePagamento frame = new FrmFormaDePagamento();

					frame.setVisible(true);
					frame.tfDinheiro.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmFormaDePagamento() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setFocusable(true);
				tfTotalCompra.setText(String.valueOf(getTotalCompra()));
				tfTroco.setText(String.valueOf(getTotalFaltante()));
				setarValores();

			}
		});
		setBounds(100, 100, 719, 665);
		contentPane = new JPanel();
		contentPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				tfTotalCompra.setText(String.valueOf(getTotalCompra()));
				tfDinheiro.requestFocusInWindow();
			}

			public void ancestorMoved(AncestorEvent event) {
				tfTotalCompra.setText(String.valueOf(getTotalCompra()));
				tfDinheiro.requestFocusInWindow();
			}

			public void ancestorRemoved(AncestorEvent event) {
				tfTotalCompra.setText(String.valueOf(getTotalCompra()));
				tfDinheiro.requestFocusInWindow();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setForeground(new Color(24, 52, 70));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setAutoRequestFocus(true);
		contentPane.setBackground(new Color(202, 240, 248));
		contentPane.setForeground(new Color(202, 240, 248));
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Forma de Pagamento");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));

		tfDinheiro = new JTextField();
		tfDinheiro.setFont(new Font("Arial", Font.BOLD, 17));
		tfDinheiro.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					atualizarComponente();
					tfCartaoCredito.requestFocusInWindow();
				}
			}
		});

		tfDinheiro.setColumns(10);

		JLabel lblValor = new JLabel("Dinheiro:");
		lblValor.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblCartaoCredito = new JLabel("Cartão de Crédito:");
		lblCartaoCredito.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblTotalCompra = new JLabel("Total Compra:");
		lblTotalCompra.setFont(new Font("Arial", Font.BOLD, 17));

		tfValorAReceber = new JTextField();
		tfValorAReceber.setFont(new Font("Arial", Font.BOLD, 17));
		tfValorAReceber.setEditable(false);
		tfValorAReceber.setColumns(10);

		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setFont(new Font("Arial", Font.BOLD, 17));

		tfTroco = new JTextField();
		tfTroco.setFont(new Font("Arial", Font.BOLD, 17));
		tfTroco.setEditable(false);
		tfTroco.setColumns(10);

		JLabel lblFalta = new JLabel("Falta:");
		lblFalta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarPedido();
						cadastrarItensPedido();
						novaVenda();
						//System.out.println(pedido);
					} else {
						JOptionPane.showMessageDialog(null,
								"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarPagamento()) {
					//System.out.println(validarPagamento());
					cadastrarPagamento();
					cadastrarPedido();
					cadastrarItensPedido();
					novaVenda();
					//System.out.println(pedido);
				} else {
					JOptionPane.showMessageDialog(null,
							"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
				}
			}
		});
		btnFinalizarVenda.setBackground(new Color(4, 136, 47));
		btnFinalizarVenda.setFont(new Font("Arial", Font.BOLD, 24));

		JLabel lblCartaoDeDbito = new JLabel("Cartão de Débito:");
		lblCartaoDeDbito.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblValeAlimentao = new JLabel("Vale Alimentação:");
		lblValeAlimentao.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblValeRefeicao = new JLabel("Vale Refeição:");
		lblValeRefeicao.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblPix = new JLabel("Pix:");
		lblPix.setFont(new Font("Arial", Font.BOLD, 17));

		tfTotalCompra = new JTextField();
		tfTotalCompra.setEditable(false);
		tfTotalCompra.setFont(new Font("Arial", Font.BOLD, 17));
		tfTotalCompra.setColumns(10);

		tfCartaoCredito = new JTextField();
		tfCartaoCredito.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					atualizarComponente();
					tfCartaoDebito.requestFocusInWindow();
				}
			}
		});
		tfCartaoCredito.setFont(new Font("Arial", Font.BOLD, 17));
		tfCartaoCredito.setColumns(10);

		tfCartaoDebito = new JTextField();
		tfCartaoDebito.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					atualizarComponente();
					tfValeAlimentacao.requestFocusInWindow();
				}
			}
		});
		tfCartaoDebito.setFont(new Font("Arial", Font.BOLD, 17));
		tfCartaoDebito.setColumns(10);

		tfValeAlimentacao = new JTextField();
		tfValeAlimentacao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					atualizarComponente();
					tfValeRefeicao.requestFocusInWindow();
				}
			}
		});
		tfValeAlimentacao.setFont(new Font("Arial", Font.BOLD, 17));
		tfValeAlimentacao.setColumns(10);

		tfValeRefeicao = new JTextField();
		tfValeRefeicao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					atualizarComponente();
					tfPix.requestFocusInWindow();
				}
			}
		});
		tfValeRefeicao.setFont(new Font("Arial", Font.BOLD, 17));
		tfValeRefeicao.setColumns(10);

		tfPix = new JTextField();
		tfPix.setFont(new Font("Arial", Font.BOLD, 17));
		tfPix.setColumns(10);
		tfPix.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					atualizarComponente();
					btnFinalizarVenda.requestFocusInWindow();
				}
			}
		});

		JLabel lblTotalPago = new JLabel("Pago:");
		lblTotalPago.setFont(new Font("Arial", Font.BOLD, 17));

		tfPago = new JTextField();
		tfPago.setFont(new Font("Arial", Font.BOLD, 17));
		tfPago.setEditable(false);
		tfPago.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(105)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblTotalCompra).addComponent(lblValor))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(tfTotalCompra, GroupLayout.PREFERRED_SIZE, 265,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel).addComponent(tfDinheiro,
														GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(73)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblCartaoCredito)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblCartaoDeDbito)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblValeRefeicao).addComponent(lblPix)
																.addComponent(lblValeAlimentao)))
												.addComponent(lblFalta).addComponent(lblTroco)
												.addComponent(lblTotalPago))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(tfTroco)
														.addComponent(tfCartaoCredito, GroupLayout.DEFAULT_SIZE, 265,
																Short.MAX_VALUE)
														.addComponent(tfCartaoDebito, GroupLayout.DEFAULT_SIZE, 265,
																Short.MAX_VALUE)
														.addComponent(tfValeAlimentacao, GroupLayout.DEFAULT_SIZE, 265,
																Short.MAX_VALUE)
														.addComponent(tfValeRefeicao, GroupLayout.DEFAULT_SIZE, 265,
																Short.MAX_VALUE)
														.addComponent(tfPix, GroupLayout.DEFAULT_SIZE, 265,
																Short.MAX_VALUE)
														.addComponent(tfValorAReceber))
												.addComponent(tfPago, GroupLayout.PREFERRED_SIZE, 265,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(219, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(266, Short.MAX_VALUE)
						.addComponent(btnFinalizarVenda, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addGap(229)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(25).addComponent(lblNewLabel).addGap(34)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblTotalCompra)
								.addComponent(tfTotalCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfDinheiro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblValor))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCartaoCredito)
								.addComponent(tfCartaoCredito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblCartaoDeDbito)
								.addComponent(tfCartaoDebito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblValeAlimentao)
								.addComponent(tfValeAlimentacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblValeRefeicao)
								.addComponent(tfValeRefeicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPix, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(13)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotalPago, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPago, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfValorAReceber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFalta))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblTroco)
								.addComponent(tfTroco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(btnFinalizarVenda, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addGap(21)));
		contentPane.setLayout(gl_contentPane);
	}
}
