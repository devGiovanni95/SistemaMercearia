package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.AberturaEFechamentoCaixaController;
import controller.ClienteController;
import controller.ProdutosController;
import model.AberturaEFechamentoCaixa;
import model.Cliente;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import util.GeradorDeCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFrenteCaixa.
 */
public class FrmFrenteCaixa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The tf cpf. */
	private JTextField tfCpf;

	/** The tf preco unitario. */
	private JTextField tfPrecoUnitario;

	/** The tf codigo de barras. */
	private JTextField tfCodigoDeBarras;

	/** The tf quantidade de itens. */
	private JTextField tfQuantidadeDeItens;

	/** The lbl sub total. */
	private Label lblSubTotal;

	/** The lista produtos. */
	private JTable listaProdutos;

	/** The codigo barras. */
	private String descricao, item, codigoBarras;

	/** The preco. */
	private double  quantidade;

	/** The lbl situacao caixa. */
	private JLabel lblSituacaoCaixa;

	/** The btn cancelar venda. */
	private JButton btnCancelarVenda;

	/** The btn fechar caixa. */
	private JButton btnFecharCaixa;

	/** The btn cancelar item. */
	private JButton btnCancelarItem;

	/** The btn finalizar venda. */
	private JButton btnFinalizarVenda;

	/** The btn nota paulista. */
	private JButton btnNotaPaulista;

	/** The btn sangria. */
	private JButton btnSangria;

	/** The sub total. */
	private Double subTotal;

	/** The total compra. */
	private Double totalCompra = 0.0;

	/** The troco inicial. */
	private Double trocoInicial;

	/** The conferir situacao caixa. */
	private boolean conferirSituacaoCaixa;

	/** The lbl total compra. */
	private JLabel lblTotalCompra;

	/** The codigo abertura caixa. */
	private int codigoAberturaCaixa;

	/** The lbl nome funcionario. */
	private JLabel lblNomeFuncionario;

	/** The lbl venda. */
	private JLabel lblVenda;

	/** The venda iniciada. */
	private boolean vendaIniciada;

	/** The dados tabela. */
	DefaultTableModel dadosTabela;

	/** The cliente. */
	Cliente cliente = new Cliente();

	/** The funcionario. */
	Funcionario funcionario = new Funcionario();

	/** The x. */
	GeradorDeCodigo x = new GeradorDeCodigo();

	/** The venda. */
	Venda venda = new Venda();

	/** The itens pedido. */
	ArrayList<ItemVenda> itensPedido = new ArrayList<>();

	/** The abertura E fechamento caixa. */
	AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa();

	/**
	 * Gets the itens pedido.
	 *
	 * @return the itens pedido
	 */
	public ArrayList<ItemVenda> getItensPedido() {
		return itensPedido;
	}

	/**
	 * Sets the itens pedido.
	 *
	 * @param itensPedido the new itens pedido
	 */
	public void setItensPedido(ArrayList<ItemVenda> itensPedido) {
		this.itensPedido = itensPedido;
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
	 * Gets the funcionario.
	 *
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * Sets the funcionario.
	 *
	 * @param funcionario the new funcionario
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Gets the lbl nome funcionario.
	 *
	 * @return the lbl nome funcionario
	 */
	public JLabel getLblNomeFuncionario() {
		return lblNomeFuncionario;
	}

	/**
	 * Sets the lbl nome funcionario.
	 *
	 * @param lblNomeFuncionario the new lbl nome funcionario
	 */
	public void setLblNomeFuncionario(JLabel lblNomeFuncionario) {
		this.lblNomeFuncionario = lblNomeFuncionario;
	}

	/**
	 * Gets the abertura E fechamento caixa.
	 *
	 * @return the abertura E fechamento caixa
	 */
	public AberturaEFechamentoCaixa getAberturaEFechamentoCaixa() {
		return aberturaEFechamentoCaixa;
	}

	/**
	 * Sets the abertura E fechamento caixa.
	 *
	 * @param aberturaEFechamentoCaixa the new abertura E fechamento caixa
	 */
	public void setAberturaEFechamentoCaixa(AberturaEFechamentoCaixa aberturaEFechamentoCaixa) {
		this.aberturaEFechamentoCaixa = aberturaEFechamentoCaixa;
	}

	/**
	 * Gets the codigo abertura caixa.
	 *
	 * @return the codigo abertura caixa
	 */
	public int getCodigoAberturaCaixa() {
		return codigoAberturaCaixa;
	}

	/**
	 * Sets the codigo abertura caixa.
	 *
	 * @param codigoAberturaCaixa the new codigo abertura caixa
	 */
	public void setCodigoAberturaCaixa(int codigoAberturaCaixa) {
		this.codigoAberturaCaixa = codigoAberturaCaixa;
	}

	/**
	 * Checks if is conferir situacao caixa.
	 *
	 * @return true, if is conferir situacao caixa
	 */
	public boolean isConferirSituacaoCaixa() {
		return conferirSituacaoCaixa;
	}

	/**
	 * Sets the conferir situacao caixa.
	 *
	 * @param conferirSituacaoCaixa the new conferir situacao caixa
	 */
	public void setConferirSituacaoCaixa(boolean conferirSituacaoCaixa) {
		this.conferirSituacaoCaixa = conferirSituacaoCaixa;
	}

	/**
	 * Checks if is venda iniciada.
	 *
	 * @return true, if is venda iniciada
	 */
	public boolean isVendaIniciada() {
		return vendaIniciada;
	}

	/**
	 * Sets the venda iniciada.
	 *
	 * @param vendaIniciada the new venda iniciada
	 */
	public void setVendaIniciada(boolean vendaIniciada) {
		this.vendaIniciada = vendaIniciada;
	}

	/**
	 * Método responsável por consultar cpf informado.
	 * 
	 * @return cliente - Retorna o cliente retornado na consulta
	 *         Caso de Uso (USC-004)
	 */
	public Cliente consultarCpf() {
		ClienteController clienteController = new ClienteController();
		cliente = clienteController.consultarClientesPorCpf(tfCpf.getText());
		venda.setCliente(cliente);
		return cliente;
	}

	/**
	 * Método utilizado para alterar texto do label e sua cor.
	 * Caso de Uso (USC-005)
	 */
	public void textoCaixaFechado() {
		lblSituacaoCaixa.setText("Caixa Fechado");
		lblSituacaoCaixa.setForeground(Color.RED);

	}

	/**
	 * Método utilizado para alterar texto do label e sua cor.
	 * Caso de Uso (USC-005)
	 */
	public void textoCaixaAberto() {
		lblSituacaoCaixa.setText("Caixa Aberto");
		lblSituacaoCaixa.setForeground(Color.GREEN);

	}

	/**
	 * Método confere no Banco de Dados se há alguma venda em aberta.
	 *
	 * @return - retorna se a condição é verdadeira ou falsa
	 *         Caso de Uso (USC-005)
	 */
	public boolean conferirSeHaCaixaAberto() {
		AberturaEFechamentoCaixaController aberturaEFechamentoCaixaController = new AberturaEFechamentoCaixaController();
		boolean confere;
		if (aberturaEFechamentoCaixaController.consultarAberturaEmExecucao(retornaUltimoCodigoDeAberto()) == null) {
			textoCaixaFechado();
			confere = false;
		} else if (aberturaEFechamentoCaixaController.consultarAberturaEmExecucao(retornaUltimoCodigoDeAberto())
				.isSituacaoCaixa()) {
			textoCaixaAberto();
			confere = true;
			setAberturaEFechamentoCaixa(
					aberturaEFechamentoCaixaController.consultarAberturaEmExecucao(retornaUltimoCodigoDeAberto()));
		} else {
			textoCaixaFechado();
			confere = false;
		}
		return confere;
	}
	
	public void setFechar(){
		dispose();
	}

	/**
	 * Método responsável por efetuar a abertura caixa.
	 * Caso de Uso (USC-005)
	 */
	public void efetuarAberturaCaixa() {
		AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa();
		AberturaEFechamentoCaixaController aberturaEFechamentoCaixaController = new AberturaEFechamentoCaixaController();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataFormatada = dataAtual.format(formatter);
		aberturaEFechamentoCaixa.setDataAbertura(dataFormatada);
		aberturaEFechamentoCaixa.setTrocoInicial(trocoInicial);
		aberturaEFechamentoCaixa.setFuncionario(getFuncionario());
		aberturaEFechamentoCaixa.setSituacaoCaixa(true);
		aberturaEFechamentoCaixaController.cadastrarAbertura(aberturaEFechamentoCaixa);
		dispose();

		FrmFrenteCaixa frmFrenteCaixa = new FrmFrenteCaixa();
		frmFrenteCaixa.setVisible(true);
		frmFrenteCaixa.setFuncionario(funcionario);

	}

	/**
	 * Método responsável por Efetuar o fechamento do caixa no sistema.
	 * Caso de Uso (USC-005)
	 */
	public void efetuarFechamento() {
		FrmMenuPrincipal forma = new FrmMenuPrincipal();
		AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa();
		AberturaEFechamentoCaixaController aberturaEFechamentoCaixaController = new AberturaEFechamentoCaixaController();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataFormatada = dataAtual.format(formatter);

		aberturaEFechamentoCaixa.setCodigo(retornaUltimoCodigoDeAberto());
		aberturaEFechamentoCaixa.setDataFechamento(dataFormatada);
		aberturaEFechamentoCaixa.setSituacaoCaixa(false);
		aberturaEFechamentoCaixaController.cadastrarFechamento(aberturaEFechamentoCaixa);
		forma.setVisible(true);
		this.dispose();
		textoCaixaFechado();

	}

	/**
	 * Método responsavel por retornar o ultimo código de abertura.
	 * 
	 * @return a numeração da abertura.
	 *         Caso de Uso (USC-005)
	 */
	public int retornaUltimoCodigoDeAberto() {

		AberturaEFechamentoCaixaController aberturaEFechamentoCaixaController = new AberturaEFechamentoCaixaController();
		int codigo = aberturaEFechamentoCaixaController.retornarUltimaAberturaCaixa().getCodigo();
		System.out.println(codigo + "retorna");
		return codigo;
	}

	/**
	 * Método responsável por definir o troco inicial.
	 * Verificar se o caixa já está aberto ou não
	 * E fazer a validação do troco informado.
	 * Caso de Uso (USC-005) (USC-010)
	 */
	public void conferirTroco() {

		if (getAberturaEFechamentoCaixa().isSituacaoCaixa() == false) {
			//FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
			try {
				trocoInicial = Double.parseDouble(JOptionPane.showInputDialog("Digite no Troco Inicial"));
				if (trocoInicial >= 0) {
					JOptionPane.showMessageDialog(null, "Caixa Aberto");// criar uma tela personalizada

					setConferirSituacaoCaixa(true);
					tfCodigoDeBarras.requestFocusInWindow();
					tfCodigoDeBarras.setFocusable(true);
					efetuarAberturaCaixa();
					setCodigoAberturaCaixa(retornaUltimoCodigoDeAberto());

				} else {
					JOptionPane.showMessageDialog(null, "Valor tem que ser maior ou igual a zero");
					conferirTroco();
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor inválido " + e);
				conferirTroco();
			}
		} else {

		}
	}

	/**
	 * Método responsável por por fazer a conferência se foi informado o cpf ou não.
	 * Caso de Uso (USC-005) (USC-004)
	 */
	public void conferirCpfNaNota() {
		if (consultarCpf().equals(null)) {
			tfCpf.setText("Não informado");
		}
	}

	/**
	 * Método responsável por mover o foco para o TextField Quantidade.
	 * Caso de Uso (USC-005)
	 */
	public void preencherQuantidade() {
		tfQuantidadeDeItens.setText("");
		tfQuantidadeDeItens.setEditable(true);
		tfQuantidadeDeItens.requestFocus();
	}

	/**
	 * Método responsável por fazer a chamada da tela Forma de Pagamento.
	 * Caso de Uso (USC-005) (USC-010)
	 */
	public void formaPagamento() {
		double totalCompra = Double.parseDouble(lblTotalCompra.getText().replace(",", "."));

		if (totalCompra > 0) {
			dispose();
			FrmFormaDePagamento formaDePagamento = new FrmFormaDePagamento();
			formaDePagamento.cliente = cliente;
			formaDePagamento.setTotalCompra(totalCompra);
			formaDePagamento.setTotalFaltante(totalCompra);

			formaDePagamento.setVisible(true);
			venda.setValorVenda(totalCompra);
			formaDePagamento.setVenda(venda);
			formaDePagamento.setFrenteCaixa(this);
			formaDePagamento.setListaItensCarinho(dadosTabela);
			//formaDePagamento.setListaItensCarinho(dadosTabela);
			
		} else {
			JOptionPane.showMessageDialog(null, "Venda não pode ser finalizada pois não há nenhum lançamento");
		}
	}

	/**
	 * Método define o titulo de informação da Tabela.
	 * Caso de Uso (USC-005)
	 */
	public void itensTabela() {
		// linha tabela titulo
		dadosTabela = (DefaultTableModel) listaProdutos.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(6);
		dadosTabela.addRow(new Object[] { "Código", "Descrição", "Quantidade", "Item", "Preço", "Total" });
	}

	/**
	 * Méto responsável por fazer o sistema esperar um determinado tempo antes de
	 * executar outrea ação.
	 * Caso de Uso (USC-005)
	 */
	public void esperar() {
		try {
			Thread.sleep(1200);
		} catch (InterruptedException ex) {

		}
		tfCodigoDeBarras.setText("");
		tfPrecoUnitario.setText("");
	}

	/**
	 * Método adiciona os itens na tabela de listagem dos produtos na venda.
	 * Caso de Uso (USC-005)
	 */
	private void adicionarItens() {
		Produto produto = new Produto();
		//Venda venda = new Venda();
		ProdutosController produtosController = new ProdutosController();

		produto = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());
		if (produto.equals(null)) {

			adicionarItens();

		} else {
			tfPrecoUnitario.setText(String.valueOf(produto.getPrecoFinal()));

			DefaultTableModel dadosTabela = (DefaultTableModel) listaProdutos.getModel();

			quantidade = Double.parseDouble(tfQuantidadeDeItens.getText());
			subTotal = Double.parseDouble(tfQuantidadeDeItens.getText())
					* Double.parseDouble(tfPrecoUnitario.getText());

			// alimenta a tela com somatoria da compra
			totalCompra += subTotal;
			
			DecimalFormat decimalFormat = new DecimalFormat("###0.00");
			String totalCompraFormatado = decimalFormat.format(totalCompra);
			
			lblTotalCompra.setText(totalCompraFormatado);
			

			ItemVenda itemVenda = new ItemVenda(produto, getPedido(), quantidade, produto.getPrecoFinal(), subTotal);

			itensPedido.add(itemVenda);

			dadosTabela.addRow(new Object[] {
					produto.getCodigoDeBarras(),
					produto.getDescricao(),
					quantidade,
					produto.getUnidadeDeMedida(),
					produto.getPrecoFinal(),
					subTotal

			});
		}
		esperar();
		tfQuantidadeDeItens.setText("1");
	}

	/**
	 * Método responsável por realizar a verificação se o caixa está fechado e
	 * inicializar uma venda.
	 * Caso de Uso (USC-005)
	 */
	public void iniciarVenda() {
		if (isConferirSituacaoCaixa() == false) {
			JOptionPane.showMessageDialog(null, "Caixa Fechado");
		} else if (isVendaIniciada() == false) {
			setVendaIniciada(true);
			venda.setCodigo(x.geraCodigo());
			lblVenda.setForeground(Color.GREEN);
			lblVenda.setText("Venda Iniciada");
			tfCodigoDeBarras.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "Venda não Inicializada");
		}
	}

	/**
	 * Método responsével por abrir a tela de menu principal.
	 * Caso de Uso (USC-005)
	 */
	public void voltarParaMenu() {
		// FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
		// frmMenuPrincipal.setVisible(true);

		this.dispose();
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
			}
		});
		setFocusable(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCategoria.class.getResource("/assets/produto.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				itensTabela();
				lblTotalCompra.setText("0.0");
				tfCodigoDeBarras.requestFocus();
				setConferirSituacaoCaixa(conferirSeHaCaixaAberto());

				lblNomeFuncionario.setText(funcionario.getNome());
				setVendaIniciada(false);
				venda.setFuncionario(funcionario);

				lblSituacaoCaixa = new JLabel("Caixa Fechado");
				lblSituacaoCaixa.setForeground(Color.RED);

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
		lblSituacaoCaixa.setFont(new Font("Arial", Font.BOLD, 45));
		lblSituacaoCaixa.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel painelListaProdutos = new JPanel();
		painelListaProdutos.setBackground(new Color(255, 255, 255));
		painelListaProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JPanel painelSubTotal = new JPanel();
		painelSubTotal.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));
		painelSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelSubTotal.setBackground(Color.WHITE);

		JPanel painelBotoesComandos = new JPanel();
		painelBotoesComandos.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));

		JPanel painelImagemProduto = new JPanel();
		painelImagemProduto.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JLabel lblOperador = new JLabel("Operador(a): ");
		lblOperador.setFont(new Font("Arial", Font.BOLD, 15));

		lblNomeFuncionario = new JLabel("");
		lblNomeFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblOperador)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNomeFuncionario, GroupLayout.PREFERRED_SIZE, 94,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(1140, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(39)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(painelCabecalho, GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(2)
																				.addComponent(painelImagemProduto,
																						GroupLayout.PREFERRED_SIZE, 304,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(painelCpf,
																								GroupLayout.DEFAULT_SIZE,
																								311, Short.MAX_VALUE)
																						.addComponent(
																								painelPrecoUnitario,
																								GroupLayout.DEFAULT_SIZE,
																								311, Short.MAX_VALUE)
																						.addComponent(
																								painelCodigoDeBarras,
																								GroupLayout.DEFAULT_SIZE,
																								311, Short.MAX_VALUE)
																						.addComponent(
																								painelQuantidadeDeItens,
																								GroupLayout.DEFAULT_SIZE,
																								311, Short.MAX_VALUE)))
																		.addComponent(painelComandos,
																				GroupLayout.DEFAULT_SIZE, 623,
																				Short.MAX_VALUE))
																.addGap(19))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(painelBotoesComandos,
																		GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
																.addGap(18)))
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(painelListaProdutos, GroupLayout.DEFAULT_SIZE,
																613, Short.MAX_VALUE)
														.addComponent(painelSubTotal, GroupLayout.DEFAULT_SIZE, 613,
																Short.MAX_VALUE))))
								.addGap(50)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(30)
								.addComponent(painelCabecalho, GroupLayout.PREFERRED_SIZE, 70,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(painelListaProdutos, GroupLayout.DEFAULT_SIZE, 416,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(painelSubTotal, GroupLayout.DEFAULT_SIZE, 142,
														Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(painelQuantidadeDeItens,
																		GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(painelCodigoDeBarras,
																		GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(painelPrecoUnitario,
																		GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
																.addGap(15)
																.addComponent(painelCpf, GroupLayout.DEFAULT_SIZE, 65,
																		Short.MAX_VALUE)
																.addGap(6))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(painelImagemProduto,
																		GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addComponent(painelComandos, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(painelBotoesComandos, GroupLayout.PREFERRED_SIZE, 199,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblOperador)
										.addComponent(lblNomeFuncionario, GroupLayout.PREFERRED_SIZE, 18,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		listaProdutos = new JTable();
		listaProdutos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"New column", "New column", "New column", "New column", "New column"
				}));

		GroupLayout gl_painelListaProdutos = new GroupLayout(painelListaProdutos);
		gl_painelListaProdutos.setHorizontalGroup(
				gl_painelListaProdutos.createParallelGroup(Alignment.LEADING)
						.addComponent(listaProdutos, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE));
		gl_painelListaProdutos.setVerticalGroup(
				gl_painelListaProdutos.createParallelGroup(Alignment.TRAILING)
						.addComponent(listaProdutos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416,
								Short.MAX_VALUE));
		painelListaProdutos.setLayout(gl_painelListaProdutos);

		JLabel lblNewLabel = new JLabel("F7 - Menu Principal");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltarParaMenu();
			}
		});
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setIcon(new ImageIcon(FrmFrenteCaixa.class.getResource("/assets/sair.png")));

		lblVenda = new JLabel("Venda Não Iniciada");
		lblVenda.setForeground(new Color(221, 77, 77));
		lblVenda.setFont(new Font("Arial", Font.BOLD, 18));
		lblVenda.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVenda.setVerticalAlignment(SwingConstants.CENTER);
		GroupLayout gl_painelCabecalho = new GroupLayout(painelCabecalho);
		gl_painelCabecalho.setHorizontalGroup(
				gl_painelCabecalho.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_painelCabecalho.createSequentialGroup()
								.addComponent(lblVenda, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
								.addGap(235)
								.addComponent(lblSituacaoCaixa, GroupLayout.PREFERRED_SIZE, 469,
										GroupLayout.PREFERRED_SIZE)
								.addGap(175)
								.addComponent(lblNewLabel)
								.addContainerGap()));
		gl_painelCabecalho.setVerticalGroup(
				gl_painelCabecalho.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelCabecalho.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_painelCabecalho.createSequentialGroup()
								.addGap(23)
								.addComponent(lblVenda)
								.addContainerGap(22, Short.MAX_VALUE))
						.addComponent(lblSituacaoCaixa, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE));
		painelCabecalho.setLayout(gl_painelCabecalho);

		JButton btnConsultar = new JButton("F1 - Modo Consulta");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto();
				ProdutosController produtosController = new ProdutosController();

				String consulta = JOptionPane.showInputDialog("Digite o Código de Barras");

				try {
					produto = produtosController.consultarProdutosPorCodigoBarrasCompleto(consulta);
					if (produto.getCodigoDeBarras() == null) {

					} else {
						JOptionPane.showMessageDialog(null,
								produto.getDescricao() + " - R$: " + produto.getPrecoFinal());
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Código de Barras inválido ou não cadastrado");
				}
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 22));

		btnNotaPaulista = new JButton("F2 - Nota Fiscal Paulista");
		btnNotaPaulista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evento) {
				if (evento.getKeyCode() == KeyEvent.VK_F2) {
					if (conferirSituacaoCaixa == true) {
						tfCpf.setEditable(true);
						tfCpf.requestFocusInWindow();
					}
				}
			}
		});
		btnNotaPaulista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conferirSituacaoCaixa == true) {
					tfCpf.setEditable(true);
					tfCpf.requestFocusInWindow();
				}
			}
		});
		btnNotaPaulista.setFont(new Font("Arial", Font.BOLD, 22));

		btnFinalizarVenda = new JButton("F10 - Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conferirSituacaoCaixa == true) {
					dispose();
					conferirCpfNaNota();
					formaPagamento();
				} else {
					JOptionPane.showMessageDialog(null, "Caixa Fechado");
				}
			}
		});
		btnFinalizarVenda.setFont(new Font("Arial", Font.BOLD, 22));

		btnCancelarItem = new JButton("F11 - Cancelar Item");
		btnCancelarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String valor = (listaProdutos.getValueAt(listaProdutos.getSelectedRow(), 5).toString());
				double removido = Double.parseDouble(valor);
			

				listaProdutos.setValueAt("0", listaProdutos.getSelectedRow(), 5);
				listaProdutos.setValueAt("0", listaProdutos.getSelectedRow(), 2);
				

				double aux = Double.parseDouble(lblTotalCompra.getText());
				lblTotalCompra.setText("" + (aux - removido));

				dadosTabela.fireTableDataChanged();

			}
		});
		btnCancelarItem.setFont(new Font("Arial", Font.BOLD, 22));

		JButton btnAbrirCaixa = new JButton("F3 - Abrir Caixa");
		btnAbrirCaixa.setFocusable(true);

		btnAbrirCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isConferirSituacaoCaixa() == true) {
					JOptionPane.showMessageDialog(null, "Caixa já está aberto");
				} else {
					conferirTroco();
					textoCaixaAberto();
				}

			}
		});
		btnAbrirCaixa.setFont(new Font("Arial", Font.BOLD, 22));

		btnFecharCaixa = new JButton("F4 - Fechar Caixa");
		btnFecharCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isConferirSituacaoCaixa()) {
					efetuarFechamento();
					textoCaixaFechado();
				}
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
				if (isConferirSituacaoCaixa() == true) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						// fazer validacao de codigo inexistente
						if (isVendaIniciada() == true) {
							adicionarItens();
						} else {
							JOptionPane.showMessageDialog(null, "Venda não inicializada");
						}
					} else {
					}
				} else if (e.getKeyCode() == KeyEvent.VK_F3) {
					conferirTroco();
					textoCaixaAberto();
				} else if (e.getKeyCode() == KeyEvent.VK_F6) {
					preencherQuantidade();
				} else {
					JOptionPane.showMessageDialog(null, "Caixa Fechado");
					tfCodigoDeBarras.setText("");
				}
				if (e.getKeyCode() == KeyEvent.VK_F6) {
					preencherQuantidade();
				}
				if (e.getKeyCode() == KeyEvent.VK_F4) {
					if (isConferirSituacaoCaixa()) {
						efetuarFechamento();
						textoCaixaFechado();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_F7) {
					voltarParaMenu();
				}
				if (e.getKeyCode() == KeyEvent.VK_F8) {
					iniciarVenda();

				}
				if (e.getKeyCode() == KeyEvent.VK_F10) {
					if (conferirSituacaoCaixa == true) {
						conferirCpfNaNota();
						formaPagamento();
					} else {
						JOptionPane.showMessageDialog(null, "Caixa Fechado");
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_F1) {

					Produto produto = new Produto();
					ProdutosController produtosController = new ProdutosController();
					String consulta = JOptionPane.showInputDialog("Digite o Código de Barras");

					try {
						produto = produtosController.consultarProdutosPorCodigoBarrasCompleto(consulta);
						if (produto.getCodigoDeBarras() == null) {

						} else {
							JOptionPane.showMessageDialog(null,
									produto.getDescricao() + " - R$: " + produto.getPrecoFinal());
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Código de Barras inválido ou não cadastrado");
					}
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
				preencherQuantidade();
			}
		});
		btnQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfCodigoDeBarras.setFocusable(true);
				}
			}
		});

		btnCancelarVenda = new JButton("F12 - Cancelar Venda");
		btnCancelarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Venda Cancelada com sucesso!");
				FrmFrenteCaixa caixa = new FrmFrenteCaixa();
				caixa.setFuncionario(funcionario);
				dispose();
				caixa.setVisible(true);
			}
		});
		btnCancelarVenda.setFont(new Font("Arial", Font.BOLD, 22));

		JButton btnMenuPrincipal = new JButton("F8 - Iniciar Venda");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarVenda();
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
								.addComponent(btnMenuPrincipal, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)));
		gl_painelBotoesComandos.setVerticalGroup(
				gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelBotoesComandos.createSequentialGroup()
								.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
										.addComponent(btnConsultar)
										.addComponent(btnAbrirCaixa, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNotaPaulista, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnFecharCaixa, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
										.addComponent(btnFinalizarVenda, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSangria, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
										.addComponent(btnQuantidade, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCancelarItem, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnCancelarVenda, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnMenuPrincipal, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))));
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
		tfCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (consultarCpf().equals(null)) {
						JOptionPane.showMessageDialog(null, "CPF Inválido");
					} else {

						tfCodigoDeBarras.requestFocusInWindow();
					}
				}
			}
		});
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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfCodigoDeBarras.requestFocus();
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
		painelSubtotal.setBackground(new Color(175, 205, 253));
		painelSubTotal.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));

		GroupLayout gl_painelSubTotal = new GroupLayout(painelSubTotal);
		gl_painelSubTotal.setHorizontalGroup(
				gl_painelSubTotal.createParallelGroup(Alignment.LEADING)
						.addComponent(tituloSubtotal, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
						.addComponent(painelSubtotal, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE));
		gl_painelSubTotal.setVerticalGroup(
				gl_painelSubTotal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelSubTotal.createSequentialGroup()
								.addComponent(tituloSubtotal, GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
								.addComponent(painelSubtotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(25)));
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

	/**
	 * Action perfomed.
	 *
	 * @param evento the evento
	 */
	public void actionPerfomed(ActionEvent evento) {
		if (evento.getSource() == tfQuantidadeDeItens) {
			tfCodigoDeBarras.requestFocusInWindow();
			tfCodigoDeBarras.setFocusable(true);
		}
	}
}
