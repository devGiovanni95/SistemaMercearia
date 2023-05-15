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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
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
import controller.FuncionarioController;
import controller.ProdutosController;
import model.AberturaEFechamentoCaixa;
import model.Cliente;
import model.Funcionario;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import util.GeradorDeCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFrenteCaixa.
 */
public class FrmFrenteCaixa extends JFrame{

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
	private String descricao,item, codigoBarras;
	
	/** The preco. */
	private double total=0, quantidade,preco;
	
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
	private Double totalCompra=0.0;
	
	/** The troco inicial. */
	private Double trocoInicial;
	
	/** The conferir situacao caixa. */
	private boolean conferirSituacaoCaixa;
	
	/** The quantidade produto. */
	private double quantidadeProduto;	
	
	/** The lbl total compra. */
	private JLabel lblTotalCompra ;
	
	/** The codigo abertura caixa. */
	private int codigoAberturaCaixa;
	
	private JLabel lblNomeFuncionario;
	
	private JLabel lblVenda ;
	
	private boolean vendaIniciada;
	
	DefaultTableModel dadosTabela;
	
	/** The cliente. */
	Cliente cliente = new Cliente();
	
	Funcionario funcionario = new Funcionario();
	
	GeradorDeCodigo x = new GeradorDeCodigo();
	
	Pedido pedido = new Pedido();
	
	ArrayList<ItemPedido> 	itensPedido = new ArrayList<>();


	public ArrayList<ItemPedido> getItensPedido() {
		return itensPedido;
	}


	public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public JLabel getLblNomeFuncionario() {
		return lblNomeFuncionario;
	}


	public void setLblNomeFuncionario(JLabel lblNomeFuncionario) {
		this.lblNomeFuncionario = lblNomeFuncionario;
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
	public boolean isconferirSituacaoCaixa() {
		return conferirSituacaoCaixa;
	}


	/**
	 * Sets the conferir situacao caixa.
	 *
	 * @param conferirSituacaoCaixa the new conferir situacao caixa
	 */
	public void setconferirSituacaoCaixa(boolean conferirSituacaoCaixa) {
		this.conferirSituacaoCaixa = conferirSituacaoCaixa;
	} 
	
	
	
	public boolean isVendaIniciada() {
		return vendaIniciada;
	}


	public void setVendaIniciada(boolean vendaIniciada) {
		this.vendaIniciada = vendaIniciada;
	}


	/**
	 * Consultar cpf.
	 *
	 * @return the cliente
	 */
	public Cliente consultarCpf() {
		ClienteController clienteController = new ClienteController();
		cliente = clienteController.consultarClientesPorCpf(tfCpf.getText());
		pedido.setCliente(cliente);
		return cliente;
	}

	/**
	 * Desabilitar botoes caixa.
	 */
	public void desabilitarBotoesCaixa() {
		this.btnCancelarItem.setEnabled(false);
		this.btnCancelarVenda.setEnabled(false);
		this.btnFecharCaixa.setEnabled(false);
		this.btnFinalizarVenda.setEnabled(false);
		this.btnSangria.setEnabled(false);
		this.btnNotaPaulista.setEnabled(false);	
		
	}
	
	/**
	 * Habilitar botoes caixa.
	 */
	public void habilitarBotoesCaixa() {
		btnCancelarItem.setEnabled(true);
		btnCancelarVenda.setEnabled(true);
		btnFecharCaixa.setEnabled(true);
		btnFinalizarVenda.setEnabled(true);
		btnSangria.setEnabled(true);
		btnNotaPaulista.setEnabled(true);			
	}
	
	/**
	 * Método responsavel por verificar se o caixa está aberto;.
	 */
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
	
	/**
	 * Efetuar abertura caixa.
	 */
	public void efetuarAberturaCaixa() {
		AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa();
		AberturaEFechamentoCaixaController aberturaEFechamentoCaixaController = new AberturaEFechamentoCaixaController();
		FuncionarioController funcionarioController = new FuncionarioController();
		Funcionario funcionario = new Funcionario();
		funcionario = funcionarioController.consultarFuncionariosPorCpf("123.456.789-01");
		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dataAtual = LocalDateTime.now();
		String dataFormatada = dataAtual.format(formatter);
		System.out.println(dataFormatada);		
		aberturaEFechamentoCaixa.setDataAbertura(dataFormatada);
		aberturaEFechamentoCaixa.setTrocoInicial(trocoInicial);
		aberturaEFechamentoCaixa.setFuncionario(funcionario);
		aberturaEFechamentoCaixa.setSituacaoCaixa(false);
		
		//System.out.println(funcionario);
		
		aberturaEFechamentoCaixaController.cadastrarAbertura(aberturaEFechamentoCaixa);	
		
	}
	
	/**
	 * Efetuar fechamento.
	 */
	public void efetuarFechamento(){
		AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa();
		AberturaEFechamentoCaixaController aberturaEFechamentoCaixaController = new AberturaEFechamentoCaixaController();
		
		aberturaEFechamentoCaixaController.cadastrarFechamento(aberturaEFechamentoCaixa);
		
	}
	
	/**
	 * Retorna codigo de aberto.
	 *
	 * @return the int
	 */
	public int retornaCodigoDeAberto() {
		AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa();
		AberturaEFechamentoCaixaController aberturaEFechamentoCaixaController = new AberturaEFechamentoCaixaController();
		int codigo = aberturaEFechamentoCaixaController.retornarUltimaAberturaCaixa();
		System.out.println(codigo + "retorna");
		return codigo;
	}	
	
	/**
	 * Método responsável por definir o troco inicial. 
	 * E fazer a validação do troco informado.  
	 */
	public void conferirTroco() {
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
			tfCodigoDeBarras.setFocusable(true);
			efetuarAberturaCaixa();
			setCodigoAberturaCaixa(retornaCodigoDeAberto());
			//retornaCodigoDeAberto();
			//System.out.println(getCodigoAberturaCaixa());
						
			}else {
				JOptionPane.showMessageDialog(null, "Valor tem ser maior ou igual a zero");
				conferirTroco();
			}
		
		} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor inválido " + e);
				conferirTroco();
		}	
	}
	
	
	/**
	 * Método responsável por por fazer a conferência se foi informado o cpf ou não. 
	 */
	public void conferirCpfNaNota() {
		if(consultarCpf().equals(null)) {
			tfCpf.setText("Não informado");
		}
	}
	
	/**
	 * Método responsável por mover o foco para o TextField Quantidade.
	 */
	public void preencherQuantidade() {
		tfQuantidadeDeItens.setText("");
		tfQuantidadeDeItens.setEditable(true);
		tfQuantidadeDeItens.requestFocus();
		}

	
	/**
	 * Método responsável por fazer a chamada da tela Forma de Pagamento.
	 */
	public void formaPagamento() {
		double totalCompra = Double.parseDouble(lblTotalCompra.getText());
		
		if(totalCompra > 0) {			
			FrmFormaDePagamento formaDePagamento = new FrmFormaDePagamento();
			//passando o objeto inteiro para a proxima tela
			formaDePagamento.cliente = cliente;
			//passando o valor da compra  //convertendo em string
			formaDePagamento.setTotalCompra(totalCompra);
			formaDePagamento.setTotalFaltante(totalCompra);
			
			
			formaDePagamento.setVisible(true);
			pedido.setValorVenda(totalCompra);			
			formaDePagamento.setPedido(pedido);
			formaDePagamento.setFrenteCaixa(this);
			formaDePagamento.setListaItensCarinho(dadosTabela);
			
			//Para minimizar/esconder a tela
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Ops venda não pode ser finalizada pois não há nenhum lançamento");
		}
	}

	
	
	/**
	 * Itens tabela.
	 */
	public void itensTabela() { 
		//linha tabela titulo
		dadosTabela = (DefaultTableModel) listaProdutos.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(6);
		dadosTabela.addRow(new Object[]{"Código","Descrição","Quantidade","Item","Preço","Total"});
	}
	
	
	/**
	 * Esperar.
	 */
		public void esperar() {
			try {
			    Thread.sleep(1200);		
			} catch (InterruptedException ex) {
			    
			}
			tfCodigoDeBarras.setText("");
			tfPrecoUnitario.setText("");
		}

		
		private void adicionarItens() {
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		ProdutosController produtosController = new ProdutosController();		
		
		produto = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());
		if(produto.equals(null)) {
		
		adicionarItens();
			
			
		}else {
		tfPrecoUnitario.setText(String.valueOf(produto.getPrecoFinal()));
		
		DefaultTableModel dadosTabela = (DefaultTableModel) listaProdutos.getModel();	
		
		quantidade = Double.parseDouble(tfQuantidadeDeItens.getText());
		subTotal = Double.parseDouble(tfQuantidadeDeItens.getText()) * Double.parseDouble(tfPrecoUnitario.getText());
		
		//alimenta a tela com somatoria da compra
		totalCompra += subTotal;
		lblTotalCompra.setText(totalCompra.toString());

		ItemPedido itemPedido = new ItemPedido(produto, getPedido(), quantidade, produto.getPrecoFinal(), subTotal);		
		
			
		
			itensPedido.add(itemPedido);
			
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
	 * Método responsável por conferir se o caixa está aberto ou fechada.
	 */
		public void conferirEstadoCaixa() {
		
		FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
		conferirSituacaoCaixa = frmMenuPrincipal.getSituacaoCaixa();		
		if (isconferirSituacaoCaixa() == true) {
			habilitarBotoesCaixa();
		}else {
			desabilitarBotoesCaixa();
		}
	}
		
		
		public void iniciarVenda() {
			if(isVendaIniciada() == false) {
				setVendaIniciada(true);
				pedido.setCodigo(x.geraCodigo());
				lblVenda.setForeground(Color.GREEN);
				lblVenda.setText("Venda Iniciada");
				tfCodigoDeBarras.requestFocus();
			}else{
				JOptionPane.showMessageDialog(null, "Inicialize a venda");
			}
		}
	
	public void voltarParaMenu() {
		FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
		frmMenuPrincipal.setVisible(true);
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
			
			addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				itensTabela();
				lblTotalCompra.setText("0.0");
				tfCodigoDeBarras.requestFocus();
				
				//checagem dos atributos
				//System.out.println(funcionario);
				lblNomeFuncionario.setText(funcionario.getNome());
				setVendaIniciada(false);
				pedido.setFuncionario(funcionario);
				
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
		lblSituacaoCaixa.setHorizontalAlignment(SwingConstants.CENTER);
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
					.addComponent(lblNomeFuncionario, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1140, Short.MAX_VALUE))
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
					.addGap(30)
					.addComponent(painelCabecalho, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(painelListaProdutos, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelSubTotal, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelQuantidadeDeItens, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(painelCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(painelPrecoUnitario, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
									.addGap(15)
									.addComponent(painelCpf, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelImagemProduto, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(painelComandos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelBotoesComandos, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOperador)
						.addComponent(lblNomeFuncionario, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		listaProdutos = new JTable();
		listaProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		listaProdutos.setTableHeader(null);
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
					.addComponent(lblSituacaoCaixa, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
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
				.addComponent(lblSituacaoCaixa, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
		);
		painelCabecalho.setLayout(gl_painelCabecalho);
		
		JButton btnConsultar = new JButton("F1 - Modo Consulta");
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnNotaPaulista = new JButton("F2 - Nota Fiscal Paulista");
		btnNotaPaulista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evento) {
				if(evento.getKeyCode() == KeyEvent.VK_F2) {
					if(conferirSituacaoCaixa == true) {
						tfCpf.setEditable(true);
						tfCpf.requestFocusInWindow();					
					}
				}
			}
		});
		btnNotaPaulista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(conferirSituacaoCaixa == true) {
					tfCpf.setEditable(true);
					tfCpf.requestFocusInWindow();					
				}
			}
		});
		btnNotaPaulista.setFont(new Font("Arial", Font.BOLD, 22));
		
		btnFinalizarVenda = new JButton("F10 - Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(conferirSituacaoCaixa == true) {					
					conferirCpfNaNota();
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
			if(conferirSituacaoCaixa == true) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					//fazer validacao de codigo inezistente
					if( isVendaIniciada() == true) {
						adicionarItens();	 						
					}else {
						JOptionPane.showMessageDialog(null, "Venda não inicializada");								
					}
				}else {
					//JOptionPane.showMessageDialog(null, "Caixa Fechado");								
				}
			}else if(e.getKeyCode() == KeyEvent.VK_F3) {
				conferirTroco();
			}else if(e.getKeyCode() == KeyEvent.VK_F6) {
				preencherQuantidade();
			}else{
				JOptionPane.showMessageDialog(null, "Caixa Fechado");		
				tfCodigoDeBarras.setText("");
			}
			
			if(e.getKeyCode() == KeyEvent.VK_F6) {
				preencherQuantidade();
			}
			if(e.getKeyCode() == KeyEvent.VK_F7) {
				voltarParaMenu();
			}
			if(e.getKeyCode() == KeyEvent.VK_F8) {
				iniciarVenda();
			}
			if(e.getKeyCode() == KeyEvent.VK_F10) {
				if(conferirSituacaoCaixa == true) {					
					conferirCpfNaNota();
					formaPagamento();
				}else {
					JOptionPane.showMessageDialog(null, "Ops Caixa Fechado");
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
		tfCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(consultarCpf().equals(null)) {
						JOptionPane.showMessageDialog(null, "CPF Inválido");
					}else {
						
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
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
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
	
	/**
	 * Action perfomed.
	 *
	 * @param evento the evento
	 */
	public void actionPerfomed(ActionEvent evento) {
		if(evento.getSource() == tfQuantidadeDeItens) {
			tfCodigoDeBarras.requestFocusInWindow();
			tfCodigoDeBarras.setFocusable(true);
		}
	}
}
