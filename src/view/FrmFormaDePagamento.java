package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import controller.FormaPagamentoController;
import controller.ItemVendaController;
import controller.ProdutosController;
import controller.VendaController;
import model.Cliente;
import model.FormaPagamento;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import util.GeradorDeCodigo;
import util.Imprimir;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFormaDePagamento.
 */
public class FrmFormaDePagamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public Venda getVenda() {
		return venda;
	}

	/**
	 * Sets the pedido.
	 *
	 * @param venda the new pedido
	 */
	public void setVenda(Venda venda) {
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
	 * @param codigoDePagamentoGeradoAutomatico the new codigo de pagamento gerado
	 *                                          automatico
	 */
	public void setCodigoDePagamentoGeradoAutomatico(String codigoDePagamentoGeradoAutomatico) {
		this.codigoDePagamentoGeradoAutomatico = codigoDePagamentoGeradoAutomatico;
	}

	/**
	 * Método utilizado para efetuar um pré-preenchimento dos dados nos campos do
	 * formulario das formas de pagamento aceitas
	 * Caso de Uso (USC-010)
	 */
	public void setarValores() {
		tfDinheiro.setText("0");
		tfCartaoCredito.setText("0");
		tfCartaoDebito.setText("0");
		tfValeAlimentacao.setText("0");
		tfValeRefeicao.setText("0");
		tfPix.setText("0");
		tfTroco.setText("0");
	}

	/**
	 * Método utilizado para efetuar o calculo do saldo devedor.
	 * 
	 * @return saldoFaltante - Retorna o valor que falta para finalizar a venda.
	 *         Caso de Uso (USC-010);
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
	 * Método responsável por calcular o valor total pago. *
	 * 
	 * @return totalPago - Retorna o valor total que já foi pago.
	 *         Caso de Uso (USC-010)
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
	 * Método responsável por realizar o calculo do troco,
	 * quando necessário.
	 * 
	 * @return troco - Retorna o valor disponível de troco ao cliente.
	 *         Caso de Uso (USC-010);
	 */
	public double calcularTroco() {
		double troco = 0;
		double pago = calcularTotalPago();
		double falta = getTotalFaltante();

		if (pago > falta) {
			// troco = getTotalCompra() - calcularTotalPago();
			troco = calcularTotalPago() - getTotalCompra();

			return troco;
		} else {
			return troco;
		}
	}

	/**
	 * Método responsável por atualizar os textFields,
	 * dos campos com os valores recebidos depois dos calculos correspondentes.
	 * Caso de Uso (USC-010)
	 */
	public void atualizarComponente() {
		tfPago.setText(String.valueOf(calcularTotalPago()));
		// tfTroco.setText(String.valueOf(calcularTroco()).replace("-", ""));
		double troco = calcularTroco();
		DecimalFormat decimalFormat = new DecimalFormat("###0.00");
		String trocoFormatado = decimalFormat.format(troco);
		trocoFormatado = trocoFormatado.replace("-", "");
		tfTroco.setText(trocoFormatado.replace(",", "."));

		tfValorAReceber.setText(String.valueOf(calcularSaldoDevedor()));
	}

	/**
	 * Validar pagamento.
	 * 
	 * @return true or false - Retorna uma condição de verdadeiro ou falso
	 *         para validar se o pagamento foi efetuato na sua totalidade.
	 *         Caso de Uso (USC-010)
	 */
	public boolean validarPagamento() {

		double faltante = Double.parseDouble(tfValorAReceber.getText());

		if (faltante > 0) {
			return false;
		}
		return true;
	}

	/**
	 * Método responsável por cadastrar os itens contidos pedido.
	 * Caso de Uso (USC-005)
	 * Caso de Uso (USC-010)
	 */
	public void cadastrarItensPedido() {
		ItemVendaController itemVendaController = new ItemVendaController();
		ItemVenda itemVenda = new ItemVenda();
		List<ItemVenda> lista = new ArrayList<>();
		Produto produto = new Produto();
		ProdutosController produtosController = new ProdutosController();

		lista.addAll(frenteCaixa.getItensPedido());

		for (int i = 1; i <= lista.size(); i++) {
			produto = produtosController
					.consultarProdutosPorCodigoBarras(listaItensCarinho.getValueAt(i, 0).toString());
			System.out.println("Conferir este" + produto);
			itemVenda.setVenda(getVenda());
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(Double.parseDouble(listaItensCarinho.getValueAt(i, 2).toString()));
			itemVenda.setPrecoUnitario(Double.parseDouble(listaItensCarinho.getValueAt(i, 4).toString()));
			itemVenda.setSubtotal(Double.parseDouble(listaItensCarinho.getValueAt(i, 5).toString()));

			itemVendaController.cadastrarItemVenda(itemVenda);
			System.out.println(itemVenda);
		}
	}

	/**
	 * Método responsável por realizar a impressão do cupom não fiscal,
	 * com todas as informações da venda.
	 * Caso de Uso (USC-006) *
	 * 
	 * @return mensagem - Retorna um mensagem de confirmação se a geração da nota
	 *         foi efetivada ou não
	 */
	public String imprimir() {
		ItemVendaController itemVendaController = new ItemVendaController();
		List<ItemVenda> lista = itemVendaController.consultarItensVendaPorCodigo(getVenda().getCodigo());

		String operacao = " ";
		try {
			int a = 1;
			PrintWriter pw = new PrintWriter(
					"C:\\Users\\Public\\Documents\\CupomFiscal\\Cupom" + getVenda().getCodigo() + ".txt", "UTF-8");
			pw.write("                     MERCEARIA                    \n");
			pw.write("        RUA SEM NOME, 1254 - VILA SÃO JOSÉ        \n");
			pw.write("	    	 CEP: 13330-050 INDAIATUBA - SP         \n");
			pw.write("CNPJ:00.000.000/0000-00          					\n");
			pw.write("INCRIÇÃO ESTADUAL: 000.000000.0000				\n");
			pw.write("INCRIÇÃO MUNICIPAL: 0.000.000/000-0				\n");
			pw.write("--------------------------------------------------\n");
			pw.write("DATA: " + venda.getDataVenda() + "\n");
			pw.write("CODIGO DA VENDA:" + getVenda().getCodigo() + "\n");

			pw.write("----------------CUPOM NÃO FISCAL------------------\n");

			pw.write("ITEM  CÓDIGO       DESCRIÇÃO           \n");
			pw.write("QUANTIDADE      VALOR UNITARIO      	VALOR ITEM	\n");
			pw.write("--------------------------------------------------\n");

			for (ItemVenda item : lista) {
				pw.write(a + "     " + item.getProduto().getCodigoDeBarras());
				pw.write("    " + item.getProduto().getDescricao());
				pw.write("\n " + item.getQuantidade());
				pw.write("  " + item.getProduto().getUnidadeDeMedida());
				pw.write("             " + item.getPrecoUnitario());
				pw.write("            " + item.getSubtotal() + "\n");
				a++;
			}
			pw.write("--------------------------------------------------\n");
			pw.write("Total     R$                        " + getTotalCompra() + "\n");
			pw.write("                  \n");
			pw.write("                  \n");
			pw.write("Vendedor:" + getFrenteCaixa().getFuncionario().getNome() + "   \n");
			pw.write("                  \n");

			pw.close();

		} catch (Exception e) {
			operacao = "Falha de gravação" + e;
		}
		return "Cupom gerado com sucesso";
	}

	/**
	 * Método responsável por realizar o cadastrar da venda.
	 * Caso de Uso (USC-005)
	 */
	public void cadastrarVenda() {

		VendaController vendaController = new VendaController();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataFormatada = dataAtual.format(formatter);
		venda.setDataVenda(dataFormatada);
		vendaController.cadastrarVenda(venda);
	}

	/**
	 * Método responsável por cadastrar a forma do pagamento efetuado pelo cliente.
	 * Caso de Uso (USC-005) e (USC-010)
	 */
	public void cadastrarPagamento() {
		formaPagamento = new FormaPagamento();
		formaPagamentoController = new FormaPagamentoController();
		geradorDeCodigo = new GeradorDeCodigo();

		setCodigoDePagamentoGeradoAutomatico(geradorDeCodigo.geraCodigo());

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
	 * Método responsável efetuar a criação de uma nova venda.
	 * Caso de Uso (USC-005)
	 */
	public void novaVenda() {
		frenteCaixa.setFechar();
		FrmFrenteCaixa frmFrenteCaixa = new FrmFrenteCaixa();
		frmFrenteCaixa.setVisible(true);
		frmFrenteCaixa.setFuncionario(frenteCaixa.getFuncionario());
		dispose();

	}

	/**
	 * Launch the application.
	 * g
	 * 
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCategoria.class.getResource("/assets/produto.png")));
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
		lblNewLabel.setBounds(229, 27, 244, 28);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));

		tfDinheiro = new JTextField();
		tfDinheiro.setBounds(229, 134, 265, 27);
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
				if (e.getKeyCode() == KeyEvent.VK_F12) {
					atualizarComponente();
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarVenda();
						cadastrarItensPedido();
						JOptionPane.showMessageDialog(null, "" + imprimir());
						novaVenda();

					} else {
						JOptionPane.showMessageDialog(null,
								"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});

		tfDinheiro.setColumns(10);

		JLabel lblValor = new JLabel("Dinheiro:");
		lblValor.setBounds(147, 137, 72, 21);
		lblValor.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblCartaoCredito = new JLabel("Cartão de Crédito:");
		lblCartaoCredito.setBounds(75, 182, 146, 21);
		lblCartaoCredito.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblTotalCompra = new JLabel("Total Compra:");
		lblTotalCompra.setBounds(107, 95, 112, 21);
		lblTotalCompra.setFont(new Font("Arial", Font.BOLD, 17));

		tfValorAReceber = new JTextField();
		tfValorAReceber.setBounds(231, 444, 265, 27);
		tfValorAReceber.setFont(new Font("Arial", Font.BOLD, 17));
		tfValorAReceber.setEditable(false);
		tfValorAReceber.setColumns(10);

		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setBounds(169, 495, 52, 21);
		lblTroco.setFont(new Font("Arial", Font.BOLD, 17));

		tfTroco = new JTextField();
		tfTroco.setBounds(231, 489, 265, 27);
		tfTroco.setFont(new Font("Arial", Font.BOLD, 17));
		tfTroco.setEditable(false);
		tfTroco.setColumns(10);

		JLabel lblFalta = new JLabel("Falta:");
		lblFalta.setBounds(177, 447, 44, 21);
		lblFalta.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnFinalizarVenda = new JButton("F12 - Finalizar Venda");
		btnFinalizarVenda.setBounds(200, 549, 294, 54);
		btnFinalizarVenda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarVenda();
						cadastrarItensPedido();
						JOptionPane.showMessageDialog(null, "" + imprimir());
						Imprimir.imprimir(
								"C:\\Users\\Public\\Documents\\CupomFiscal\\Cupom" + getVenda().getCodigo() + ".txt");
						novaVenda();

					} else {
						JOptionPane.showMessageDialog(null,
								"Ainda alta receber R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarPagamento()) {
					cadastrarPagamento();
					cadastrarVenda();
					cadastrarItensPedido();
					JOptionPane.showMessageDialog(null, "" + imprimir());
					novaVenda();

				} else {
					JOptionPane.showMessageDialog(null,
							"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
				}
			}
		});
		btnFinalizarVenda.setBackground(new Color(4, 136, 47));
		btnFinalizarVenda.setFont(new Font("Arial", Font.BOLD, 24));

		JLabel lblCartaoDeDbito = new JLabel("Cartão de Débito:");
		lblCartaoDeDbito.setBounds(82, 230, 139, 21);
		lblCartaoDeDbito.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblValeAlimentao = new JLabel("Vale Alimentação:");
		lblValeAlimentao.setBounds(82, 272, 139, 21);
		lblValeAlimentao.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblValeRefeicao = new JLabel("Vale Refeição:");
		lblValeRefeicao.setBounds(110, 317, 111, 21);
		lblValeRefeicao.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblPix = new JLabel("Pix:");
		lblPix.setBounds(191, 364, 30, 17);
		lblPix.setFont(new Font("Arial", Font.BOLD, 17));

		tfTotalCompra = new JTextField();
		tfTotalCompra.setBounds(229, 89, 265, 27);
		tfTotalCompra.setEditable(false);
		tfTotalCompra.setFont(new Font("Arial", Font.BOLD, 17));
		tfTotalCompra.setColumns(10);

		tfCartaoCredito = new JTextField();
		tfCartaoCredito.setBounds(231, 179, 265, 27);
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
				if (e.getKeyCode() == KeyEvent.VK_F12) {
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarVenda();
						cadastrarItensPedido();
						JOptionPane.showMessageDialog(null, "" + imprimir());
						novaVenda();

					} else {
						JOptionPane.showMessageDialog(null,
								"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});
		tfCartaoCredito.setFont(new Font("Arial", Font.BOLD, 17));
		tfCartaoCredito.setColumns(10);

		tfCartaoDebito = new JTextField();
		tfCartaoDebito.setBounds(231, 224, 265, 27);
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
				if (e.getKeyCode() == KeyEvent.VK_F12) {
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarVenda();
						cadastrarItensPedido();
						JOptionPane.showMessageDialog(null, "" + imprimir());
						novaVenda();

					} else {
						JOptionPane.showMessageDialog(null,
								"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});
		tfCartaoDebito.setFont(new Font("Arial", Font.BOLD, 17));
		tfCartaoDebito.setColumns(10);

		tfValeAlimentacao = new JTextField();
		tfValeAlimentacao.setBounds(231, 269, 265, 27);
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
				if (e.getKeyCode() == KeyEvent.VK_F12) {
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarVenda();
						cadastrarItensPedido();
						JOptionPane.showMessageDialog(null, "" + imprimir());
						novaVenda();

					} else {
						JOptionPane.showMessageDialog(null,
								"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});
		tfValeAlimentacao.setFont(new Font("Arial", Font.BOLD, 17));
		tfValeAlimentacao.setColumns(10);

		tfValeRefeicao = new JTextField();
		tfValeRefeicao.setBounds(231, 314, 265, 27);
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
				if (e.getKeyCode() == KeyEvent.VK_F12) {
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarVenda();
						cadastrarItensPedido();
						JOptionPane.showMessageDialog(null, "" + imprimir());
						novaVenda();

					} else {
						JOptionPane.showMessageDialog(null,
								"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});
		tfValeRefeicao.setFont(new Font("Arial", Font.BOLD, 17));
		tfValeRefeicao.setColumns(10);

		tfPix = new JTextField();
		tfPix.setBounds(231, 359, 265, 27);
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
				if (e.getKeyCode() == KeyEvent.VK_F12) {
					if (validarPagamento()) {
						cadastrarPagamento();
						cadastrarVenda();
						cadastrarItensPedido();
						JOptionPane.showMessageDialog(null, "" + imprimir());
						novaVenda();

					} else {
						JOptionPane.showMessageDialog(null,
								"Falta receber ainda R$ " + tfValorAReceber.getText() + " Reais");
					}
				}
			}
		});

		JLabel lblTotalPago = new JLabel("Pago:");
		lblTotalPago.setBounds(175, 402, 46, 21);
		lblTotalPago.setFont(new Font("Arial", Font.BOLD, 17));

		tfPago = new JTextField();
		tfPago.setBounds(231, 399, 265, 27);
		tfPago.setFont(new Font("Arial", Font.BOLD, 17));
		tfPago.setEditable(false);
		tfPago.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblTotalCompra);
		contentPane.add(lblValor);
		contentPane.add(tfTotalCompra);
		contentPane.add(lblNewLabel);
		contentPane.add(tfDinheiro);
		contentPane.add(lblCartaoCredito);
		contentPane.add(lblCartaoDeDbito);
		contentPane.add(lblValeRefeicao);
		contentPane.add(lblPix);
		contentPane.add(lblValeAlimentao);
		contentPane.add(lblFalta);
		contentPane.add(lblTroco);
		contentPane.add(lblTotalPago);
		contentPane.add(tfTroco);
		contentPane.add(tfCartaoCredito);
		contentPane.add(tfCartaoDebito);
		contentPane.add(tfValeAlimentacao);
		contentPane.add(tfValeRefeicao);
		contentPane.add(tfPix);
		contentPane.add(tfValorAReceber);
		contentPane.add(tfPago);
		contentPane.add(btnFinalizarVenda);

		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblVoltar.setIcon(new ImageIcon(FrmFormaDePagamento.class.getResource("/assets/sair.png")));
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		lblVoltar.setBounds(605, 11, 88, 32);
		contentPane.add(lblVoltar);
	}
}
