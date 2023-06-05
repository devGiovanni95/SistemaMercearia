package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.CadastroProdutoFornecedorEstoqueController;
import controller.FornecedorController;
import controller.ProdutosController;
import model.CadastroProdutoFornecedorEstoque;
import model.Fornecedor;
import model.Produto;
import util.LimparCampos;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmProdutos.
 */
public class FrmEntradaEstoque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The tf codigo de barras. */
	private JTextField tfCodigoDeBarras;

	/** The tf descricao. */
	private JTextField tfDescricao;

	/** The tf qtd estoque. */
	private JTextField tfQtdEstoque;

	/** The tf marca. */
	private JTextField tfMarca;

	/** The tf data fabricacao. */
	private JTextField tfDataFabricacao;

	/** The tf validade. */
	private JTextField tfValidade;

	/** The tf preco custo. */
	private JTextField tfPrecoUnitario;

	/** The tf preco final. */
	private JTextField tfSubTotal;

	/** The tf nome. */
	private JTextField tfPesquisar;

	/** The tb produtos. */
	private JTable tabelaEstoque;

	/** The cb sub categoria. */
	private JTextField tfSubCategoria;

	/** The cb unidade de medida. */
	private JComboBox<String> cbUnidadeDeMedida;

	/** this layer is for the "Cadastrar Produto" tab. */
	private JLayeredPane abaCadastrarProduto;

	/** The aba dados produtos. */
	private JPanel abaDadosEstoque;

	/** The aba principal. */
	public JTabbedPane abaPrincipal;

	/** The tf codigo. */
	private JTextField tfCodigo;

	private JTextField tfDataEntrada;
	private JTextField tfQuantidadeComprada;
	private JComboBox<Fornecedor> cbFornecedor;

	/**
	 * Limpar tela.
	 *
	 * @param tela the tela
	 */
	private void limparTela(JPanel tela) {
		LimparCampos limpar = new LimparCampos();
		limpar.Limpar(tela);
	}

	private void cadastrarProdutoEstoque() {
		CadastroProdutoFornecedorEstoque cadastroProdutoFornecedorEstoque = new CadastroProdutoFornecedorEstoque();
		CadastroProdutoFornecedorEstoqueController cadastroProdutoFornecedorEstoqueController = new CadastroProdutoFornecedorEstoqueController();

		Produto produto = new Produto();
		ProdutosController produtosController = new ProdutosController();
		produto = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());

		Fornecedor fornecedor = new Fornecedor();
		//FornecedorController fornecedorController = new FornecedorController();

		fornecedor = (Fornecedor) cbFornecedor.getSelectedItem();

		//conferir aki
		//double precoUnitario = 0;
		double subtotal = 0;

		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		cadastroProdutoFornecedorEstoque.setProduto(produto);
		cadastroProdutoFornecedorEstoque.setFornecedor(fornecedor);
		cadastroProdutoFornecedorEstoque.setDataEntrada(tfDataEntrada.getText());
		cadastroProdutoFornecedorEstoque.setQuantidade(Double.parseDouble(tfQuantidadeComprada.getText()));
		cadastroProdutoFornecedorEstoque.setPrecoUnitario(Double.parseDouble(tfPrecoUnitario.getText()));
		subtotal = (Double.parseDouble(tfQuantidadeComprada.getText()))
				* (Double.parseDouble(tfPrecoUnitario.getText()));
		cadastroProdutoFornecedorEstoque.setSubTotal(subtotal);

		cadastroProdutoFornecedorEstoqueController.cadastrarProdutoFornecedor(cadastroProdutoFornecedorEstoque);
		limparTela(abaDadosEstoque);
		JOptionPane.showMessageDialog(null, "Histórico cadastrado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println(cadastroProdutoFornecedorEstoque);
		limparTela(abaDadosEstoque);

	}

	private void preencherHora() {
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataHoraFormatada = dataHoraAtual.format(formatada);
		tfDataEntrada.setText(dataHoraFormatada);
	}

	/*
	 * Método utilizado para preencher os dados do produto na tela.
	 * Caso de Uso (USC-002)
	 */
	private void preencherDadosProduto() {
		abaPrincipal.setSelectedIndex(0);

		tfCodigo.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 1).toString());
		tfDescricao.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 0).toString());
		tfCodigoDeBarras.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 1).toString());
		tfMarca.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 2).toString());
		tfSubCategoria.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 3).toString());
		cbUnidadeDeMedida.setSelectedItem(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 4).toString());
		tfQtdEstoque.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 5).toString());
		tfDataFabricacao.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 6).toString());
		tfValidade.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 7).toString());

	}

	/**
	 * Consultar produto por nome.
	 * Caso de Uso (USC-002)
	 */
	private void consultarProdutoPorNome() {
		String nomePesquisado = "%" + tfPesquisar.getText() + "%";
		ProdutosController produtosController = new ProdutosController();
		List<Produto> lista = null;
		try {
			lista = produtosController.consultarProdutosPorNome(nomePesquisado);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar produtos: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaEstoque.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(15);
		dadosTabela.addRow(new Object[] { "Descrição", "Codigo de Barras", "Marca", "SubCategoria", "Unidade de Medida",
				"Quantidade",
				" Fabricação", " Validade", "Lote", "IPI", "ICMS", "Margem Lucro", "Preco Custo", "Preço Final" });

		for (Produto produto : lista) {
			dadosTabela.addRow(new Object[] {
					produto.getDescricao(),
					produto.getCodigoDeBarras(),
					produto.getMarca(),
					produto.getSubCategoria().getNome(),
					produto.getUnidadeDeMedida(),
					produto.getQuantidade(),
					produto.getDataFabricacao(),
					produto.getDataValidade(),
					produto.getLote(),
					produto.getIpi(),
					produto.getIcms(),
					produto.getMargemLucro(),
					produto.getPrecoCusto(),
					produto.getPrecoFinal()
			});
		}
	}

	/**
	 * Metodo utilizado para listar todos os produtos e adiciona-los na tabela.
	 * Caso de Uso (USC-002)
	 */
	private void consultarProdutos() {
		try {
			ProdutosController produtosController = new ProdutosController();
			List<Produto> lista = produtosController.consultarProdutos();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaEstoque.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(15);
			dadosTabela.addRow(new Object[] { "Descrição", "Codigo de Barras", "Marca", "SubCategoria",
					"Unidade de Medida", "Quantidade",
					" Fabricação", " Validade", "Lote", "IPI", "ICMS", "Margem Lucro", "Preco Custo", "Preço Final" });

			for (Produto produto : lista) {
				dadosTabela.addRow(new Object[] {
						produto.getDescricao(),
						produto.getCodigoDeBarras(),
						produto.getMarca(),
						produto.getSubCategoria().getNome(),
						produto.getUnidadeDeMedida(),
						produto.getQuantidade(),
						produto.getDataFabricacao(),
						produto.getDataValidade(),
						produto.getLote(),
						produto.getIpi(),
						produto.getIcms(),
						produto.getMargemLucro(),
						produto.getPrecoCusto(),
						produto.getPrecoFinal()
				});
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar produtos: " + erro.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método responsável por realizar o cálculo do preço final do produto,
	 * com base na quantidade de produtos comprado e o valor final
	 * 
	 * @return subTotal - retorna o valor total da compra efetuada,
	 *         depois da multiplicação da quantidade e do preço.
	 */
	public double calcularPrecoFinal() {
		double quantidade = Double.parseDouble(tfQuantidadeComprada.getText());
		double precoUnitario = Double.parseDouble(tfPrecoUnitario.getText());
		double subtotal = 0;

		if (quantidade > 0 && precoUnitario > 0) {
			subtotal = quantidade * precoUnitario;
			tfSubTotal.setText(subtotal + "");
		}
		return subtotal;
	}

	Vector<Fornecedor> fornecedor;

	/**
	 * Método responsável por efetuar a consulta e listar todos os fornecedores na
	 * tabela.
	 * Caso de Uso (USC-002) e (USC-003)
	 */
	public void consultarFornecedores() {
		try {
			FornecedorController fornecedorController = new FornecedorController();
			fornecedor = fornecedorController.consultarFornecedoresComboBox();

			cbFornecedor.setModel(new DefaultComboBoxModel<>(fornecedor));

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());

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
					FrmEntradaEstoque frame = new FrmEntradaEstoque();
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
	public FrmEntradaEstoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarProdutos();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCategoria.class.getResource("/assets/produto.png")));
		setBackground(new Color(202, 240, 248));
		getContentPane().setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		this.setLocationRelativeTo(null);

		abaPrincipal = new JTabbedPane(JTabbedPane.TOP);
		abaPrincipal.setBorder(null);
		abaPrincipal.setBackground(new Color(202, 240, 248));

		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(null);
		panelInferior.setBackground(new Color(202, 240, 248));

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(null);
		panelSuperior.setBackground(new Color(22, 138, 173));

		JLabel lblProdutos = new JLabel("Estoque");
		lblProdutos.setForeground(Color.WHITE);
		lblProdutos.setFont(new Font("Arial Black", Font.BOLD, 40));

		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Fechar a janela atual
				// SwingUtilities.getWindowAncestor(lblVoltar).dispose();

				// Abrir a janela principal
				/*
				 * FrmMenuPrincipal menu = new FrmMenuPrincipal();
				 * menu.setVisible(true);
				 */
				dispose();
			}
		});

		lblVoltar.setIcon(new ImageIcon(FrmEntradaEstoque.class.getResource("/assets/sair.png")));
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(
				gl_panelSuperior.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSuperior.createSequentialGroup()
								.addComponent(lblProdutos)
								.addPreferredGap(ComponentPlacement.RELATED, 1003, Short.MAX_VALUE)
								.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGap(46)));
		gl_panelSuperior.setVerticalGroup(
				gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelSuperior.createSequentialGroup()
								.addContainerGap(22, Short.MAX_VALUE)
								.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
										.addComponent(lblProdutos)
										.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE))));
		panelSuperior.setLayout(gl_panelSuperior);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelSuperior, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
						.addComponent(panelInferior, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
						.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 1344, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelSuperior, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
								.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, 109,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		JPanel panelInferior_2 = new JPanel();
		panelInferior_2.setBackground(new Color(202, 240, 248));
		GroupLayout gl_panelInferior = new GroupLayout(panelInferior);
		gl_panelInferior.setHorizontalGroup(
				gl_panelInferior.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelInferior.createSequentialGroup()
								.addComponent(panelInferior_2, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
								.addGap(20)));
		gl_panelInferior.setVerticalGroup(
				gl_panelInferior.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInferior.createSequentialGroup()
								.addGap(26)
								.addComponent(panelInferior_2, GroupLayout.PREFERRED_SIZE, 49,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(34, Short.MAX_VALUE)));
		panelInferior_2.setLayout(new GridLayout(0, 6, 10, 0));

		JPanel espacoEsquerdo = new JPanel();
		espacoEsquerdo.setBackground(new Color(202, 240, 248));
		panelInferior_2.add(espacoEsquerdo);
		panelInferior.setLayout(gl_panelInferior);

		abaCadastrarProduto = new JLayeredPane();
		abaCadastrarProduto.setBackground(new Color(202, 240, 248));
		abaCadastrarProduto.setBorder(null);
		abaPrincipal.addTab("Cadastrar Estoque", null, abaCadastrarProduto, null);

		abaDadosEstoque = new JPanel();
		abaDadosEstoque.setForeground(new Color(0, 0, 0));
		abaDadosEstoque.setBorder(null);
		abaDadosEstoque.setBackground(new Color(202, 240, 248));

		JLabel lblSubcategoria = new JLabel("Subcategoria:");
		lblSubcategoria.setBounds(156, 205, 97, 19);
		lblSubcategoria.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(210, 248, 51, 17);
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblDataFabricacao = new JLabel("Data de Fabricação: ");
		lblDataFabricacao.setBounds(119, 290, 142, 17);
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigoDeBarras = new JTextField();
		tfCodigoDeBarras.setBounds(271, 77, 551, 23);
		tfCodigoDeBarras.setEnabled(false);
		tfCodigoDeBarras.setBackground(Color.WHITE);
		tfCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigoDeBarras.setColumns(10);

		tfDescricao = new JTextField();
		tfDescricao.setBounds(271, 118, 551, 23);
		tfDescricao.setEnabled(false);
		tfDescricao.setBackground(Color.WHITE);
		tfDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDescricao.setColumns(10);

		tfQtdEstoque = new JTextField();
		tfQtdEstoque.setEditable(false);
		tfQtdEstoque.setBounds(271, 160, 166, 23);
		tfQtdEstoque.setToolTipText("Campo disponivel para editar produto");
		tfQtdEstoque.setBackground(Color.WHITE);
		tfQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));
		tfQtdEstoque.setColumns(10);

		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida: ");
		lblUnidadeDeMedida.setBounds(483, 163, 165, 17);
		lblUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));

		cbUnidadeDeMedida = new JComboBox<String>();
		cbUnidadeDeMedida.setBounds(652, 159, 170, 25);
		cbUnidadeDeMedida.setEnabled(false);
		cbUnidadeDeMedida.setBackground(Color.WHITE);
		cbUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));
		cbUnidadeDeMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
				"KG", "UN", "CX"
		}));

		tfSubCategoria = new JTextField();
		tfSubCategoria.setBounds(271, 202, 551, 23);
		tfSubCategoria.setEditable(false);
		tfSubCategoria.setEnabled(false);
		tfSubCategoria.setBackground(Color.WHITE);
		tfSubCategoria.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(106, 76, 147));
		btnNovo.setForeground(new Color(255, 255, 255));
		btnNovo.setFont(new Font("Arial", Font.BOLD, 24));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela(abaDadosEstoque);
			}
		});
		panelInferior_2.add(btnNovo);

		JButton btnAlterar = new JButton("Editar");
		btnAlterar.setBackground(new Color(255, 202, 58));
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 24));

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// alterarProduto();
			}
		});

		panelInferior_2.add(btnAlterar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProdutoEstoque();
			}

		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior_2.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior_2.add(btnExcluir);

		JPanel espacoDireito = new JPanel();
		espacoDireito.setBackground(new Color(202, 240, 248));
		panelInferior_2.add(espacoDireito);

		tfMarca = new JTextField();
		tfMarca.setBounds(271, 243, 551, 23);
		tfMarca.setEnabled(false);
		tfMarca.setBackground(Color.WHITE);
		tfMarca.setFont(new Font("Arial", Font.BOLD, 14));
		tfMarca.setColumns(10);

		tfDataFabricacao = new JTextField();
		tfDataFabricacao.setEditable(false);
		tfDataFabricacao.setBounds(271, 287, 236, 23);
		tfDataFabricacao.setBackground(Color.WHITE);
		tfDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataFabricacao.setColumns(10);

		JLabel lvlPrecoUnitario = new JLabel("Preço Unitario:");
		lvlPrecoUnitario.setBounds(157, 328, 104, 17);
		lvlPrecoUnitario.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblValidade = new JLabel("Data de Validade: ");
		lblValidade.setBounds(536, 290, 125, 17);
		lblValidade.setFont(new Font("Arial", Font.BOLD, 14));

		tfValidade = new JTextField();
		tfValidade.setEditable(false);
		tfValidade.setBounds(662, 287, 160, 23);
		tfValidade.setBackground(Color.WHITE);
		tfValidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfValidade.setColumns(10);

		tfPrecoUnitario = new JTextField();
		tfPrecoUnitario.setEditable(false);
		tfPrecoUnitario.setBounds(271, 325, 151, 23);
		tfPrecoUnitario.setBackground(Color.WHITE);
		tfPrecoUnitario.setFont(new Font("Arial", Font.BOLD, 14));
		tfPrecoUnitario.setColumns(10);
		tfPrecoUnitario.addKeyListener(new KeyAdapter() {
			// Metodo confere se o valor digitado é numerico se nçao é impede de ser
			// digitado
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(965, 401, 283, 25);
		btnRemover.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(965, 370, 283, 25);
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));

		JPanel painelFotoProduto = new JPanel();
		painelFotoProduto.setBounds(965, 67, 283, 279);
		painelFotoProduto.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JLabel lblSubtotal = new JLabel("Preço Final: ");
		lblSubtotal.setBounds(517, 367, 87, 17);
		lblSubtotal.setFont(new Font("Arial", Font.BOLD, 14));

		tfSubTotal = new JTextField();
		tfSubTotal.setBounds(608, 364, 214, 23);
		tfSubTotal.setBackground(Color.WHITE);
		tfSubTotal.setFont(new Font("Arial", Font.BOLD, 14));
		tfSubTotal.setColumns(10);
		tfSubTotal.setEditable(false);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(179, 30, 54, 17);
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setBounds(271, 29, 214, 20);
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);

		JLabel lblQtdEstoque = new JLabel("Quantidade em Estoque:");
		lblQtdEstoque.setBounds(81, 160, 172, 23);
		lblQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(179, 121, 74, 17);
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblCodigoDeBarras = new JLabel("Código de Barras:");
		lblCodigoDeBarras.setBounds(127, 80, 126, 17);
		lblCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));

		tfDataEntrada = new JTextField();
		tfDataEntrada.setEditable(false);
		tfDataEntrada.setBounds(271, 364, 236, 23);
		tfDataEntrada.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataEntrada.setColumns(10);
		tfDataEntrada.setBackground(Color.WHITE);

		JLabel lblDataEntrada = new JLabel("Data de Entrada:");
		lblDataEntrada.setBounds(144, 367, 115, 17);
		lblDataEntrada.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblQuantidadeComprada = new JLabel("Quantidade Comprada:");
		lblQuantidadeComprada.setBounds(460, 328, 160, 17);
		lblQuantidadeComprada.setFont(new Font("Arial", Font.BOLD, 14));

		tfQuantidadeComprada = new JTextField();
		tfQuantidadeComprada.setEditable(false);
		tfQuantidadeComprada.setBounds(627, 325, 195, 23);
		tfQuantidadeComprada.setFont(new Font("Arial", Font.BOLD, 14));
		tfQuantidadeComprada.setColumns(10);
		tfQuantidadeComprada.setBackground(Color.WHITE);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(172, 405, 87, 19);
		lblFornecedor.setFont(new Font("Arial", Font.BOLD, 14));

		cbFornecedor = new JComboBox<Fornecedor>();
		cbFornecedor.setBounds(271, 403, 551, 23);
		cbFornecedor.setEditable(true);
		cbFornecedor.setFont(new Font("Arial", Font.BOLD, 14));
		cbFornecedor.setEnabled(true);
		cbFornecedor.setBackground(Color.WHITE);
		consultarFornecedores();

		GroupLayout gl_abaCadastrarProduto = new GroupLayout(abaCadastrarProduto);
		gl_abaCadastrarProduto.setHorizontalGroup(
				gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
						.addComponent(abaDadosEstoque, GroupLayout.DEFAULT_SIZE, 1339, Short.MAX_VALUE));
		gl_abaCadastrarProduto.setVerticalGroup(
				gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaCadastrarProduto.createSequentialGroup()
								.addComponent(abaDadosEstoque, GroupLayout.PREFERRED_SIZE, 505,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(37, Short.MAX_VALUE)));
		abaDadosEstoque.setLayout(null);
		abaDadosEstoque.add(lblCodigo);
		abaDadosEstoque.add(tfCodigo);
		abaDadosEstoque.add(lblCodigoDeBarras);
		abaDadosEstoque.add(lblDescricao);
		abaDadosEstoque.add(lblQtdEstoque);
		abaDadosEstoque.add(lblSubcategoria);
		abaDadosEstoque.add(lblMarca);
		abaDadosEstoque.add(lblDataFabricacao);
		abaDadosEstoque.add(lvlPrecoUnitario);
		abaDadosEstoque.add(tfCodigoDeBarras);
		abaDadosEstoque.add(tfDescricao);
		abaDadosEstoque.add(tfQtdEstoque);
		abaDadosEstoque.add(lblUnidadeDeMedida);
		abaDadosEstoque.add(cbUnidadeDeMedida);
		abaDadosEstoque.add(tfSubCategoria);
		abaDadosEstoque.add(tfMarca);
		abaDadosEstoque.add(tfDataFabricacao);
		abaDadosEstoque.add(lblValidade);
		abaDadosEstoque.add(tfValidade);
		abaDadosEstoque.add(tfPrecoUnitario);
		abaDadosEstoque.add(lblQuantidadeComprada);
		abaDadosEstoque.add(tfQuantidadeComprada);
		abaDadosEstoque.add(painelFotoProduto);
		abaDadosEstoque.add(lblDataEntrada);
		abaDadosEstoque.add(tfDataEntrada);
		abaDadosEstoque.add(lblSubtotal);
		abaDadosEstoque.add(tfSubTotal);
		abaDadosEstoque.add(btnAdicionar);
		abaDadosEstoque.add(lblFornecedor);
		abaDadosEstoque.add(cbFornecedor);
		abaDadosEstoque.add(btnRemover);
		abaCadastrarProduto.setLayout(gl_abaCadastrarProduto);

		JLayeredPane abaConsultarEstoque = new JLayeredPane();
		abaConsultarEstoque.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta de Estoque", null, abaConsultarEstoque, null);

		JLabel lblNomePesquisa = new JLabel("Nome: ");
		lblNomePesquisa.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomePesquisa.setBounds(10, 35, 48, 17);
		abaConsultarEstoque.add(lblNomePesquisa);

		tfPesquisar = new JTextField();
		tfPesquisar.setColumns(10);
		tfPesquisar.setBounds(63, 34, 380, 20);
		abaConsultarEstoque.add(tfPesquisar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPesquisar.setBounds(460, 30, 137, 25);
		abaConsultarEstoque.add(btnPesquisar);

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarProdutoPorNome();
			}
		});

		tabelaEstoque = new JTable();
		tabelaEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherDadosProduto();
				tfQuantidadeComprada.setEditable(true);
				tfPrecoUnitario.setEditable(true);
				// tfDataEntrada.setEditable(true);
				preencherHora();
			}

		});

		tabelaEstoque.setFont(new Font("Arial", Font.PLAIN, 14));
		tabelaEstoque.setFillsViewportHeight(true);
		tabelaEstoque.setColumnSelectionAllowed(true);
		tabelaEstoque.setCellSelectionEnabled(true);
		tabelaEstoque.setBounds(0, 63, 1339, 409);
		abaConsultarEstoque.add(tabelaEstoque);
		getContentPane().setLayout(groupLayout);
	}

}
