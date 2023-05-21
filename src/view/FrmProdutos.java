package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import controller.ProdutosController;
import controller.SubCategoriaController;
import model.Produto;
import model.SubCategoria;
import util.LimparCampos;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmProdutos.
 */
public class FrmProdutos extends JFrame {

	/** The tf lote. */
	private JTextField tfLote;

	/** The tf codigo de barras. */
	private JTextField tfCodigoDeBarras;

	/** The tf descricao. */
	private JTextField tfDescricao;

	/** The tf qtd estoque. */
	private JTextField tfQtdEstoque;

	/** The tf ipi. */
	private JTextField tfIpi;

	/** The tf icms. */
	private JTextField tfIcms;

	/** The tf margem. */
	private JTextField tfMargem;

	/** The tf marca. */
	private JTextField tfMarca;

	/** The tf data fabricacao. */
	private JTextField tfDataFabricacao;

	/** The tf validade. */
	private JTextField tfValidade;

	/** The tf preco custo. */
	private JTextField tfPrecoCusto;

	/** The tf preco final. */
	private JTextField tfPrecoFinal;

	/** The tf nome. */
	private JTextField tfPesquisar;

	/** The tb produtos. */
	private JTable tabelaProdutos;

	/** The cb sub categoria. */
	private JComboBox<SubCategoria> cbSubCategoria;

	/** The cb unidade de medida. */
	private JComboBox<String> cbUnidadeDeMedida;

	/** this layer is for the "Cadastrar Produto" tab. */
	private JLayeredPane abaCadastrarProduto;

	/** The aba dados produtos. */
	private JPanel abaDadosProdutos;

	/** The aba principal. */
	public JTabbedPane abaPrincipal;

	/** The tf codigo. */
	private JTextField tfCodigo;

	/** Objeto da classe LimparCampos. */
	private LimparCampos limparCampos;

	/**
	 * Limpar tela.
	 *
	 * @param tela the tela
	 */
	private void limparTela(JPanel tela) {
		LimparCampos limpar = new LimparCampos();
		limpar.Limpar(tela);
	}

	/*
	 * Método responsável por alterar os dados de um produto cadastrado. Os dados
	 * são obtidos dos campos de texto na interface gráfica e armazenados em um
	 * objeto do tipo Produto, Em seguida, os campos de texto na interface gráfica
	 * são limpos através do método Limpar() da classe LimparCampos. O objeto
	 * Produto é passado como parâmetro para o método alterarProduto() da classe
	 * ProdutosController.
	 */

	/**
	 * Alterar produto.
	 */
	private void alterarProduto() {
		Produto produto = new Produto();
		SubCategoria subCategoria = new SubCategoria();

		ProdutosController produtosController = new ProdutosController();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		produto.setDescricao(tfDescricao.getText());
		produto.setCodigoDeBarras(tfCodigoDeBarras.getText());
		produto.setMarca(tfMarca.getText());
		subCategoria = (SubCategoria) cbSubCategoria.getSelectedItem();
		produto.setSubCategoria(subCategoria);
		produto.setUnidadeDeMedida(cbUnidadeDeMedida.getSelectedItem().toString());
		produto.setQuantidade(Integer.parseInt(tfQtdEstoque.getText()));
		try {
			produto.setDataFabricacao(dateFormat.parse(tfDataFabricacao.getText()));
			produto.setDataValidade(dateFormat.parse(tfValidade.getText()));
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(null,
					"Erro ao converter a data. Por favor, insira a data no formato dd/MM/yyyy.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		produto.setLote(tfLote.getText());
		produto.setIpi(Double.parseDouble(tfIpi.getText()));
		produto.setIcms(Double.parseDouble(tfIcms.getText()));
		produto.setMargemLucro(Double.parseDouble(tfMargem.getText()));
		produto.setPrecoCusto(Double.parseDouble(tfPrecoCusto.getText()));
		// produto.setCodigo(Integer.parseInt(tfCodigo.getText()));

		// Calcular o preço final com base na margem de lucro, IPI e ICMS
		// atualizarPrecoFinal();

		produto.setPrecoFinal(Double.parseDouble(tfPrecoFinal.getText().replaceAll(",", ".")));

		produtosController.alterarProduto(produto);

		limparTela(abaDadosProdutos);
		JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Cadastrar produto.
	 */
	private void cadastrarProduto() {
		Produto produto = new Produto();
		SubCategoria subCategoria = new SubCategoria();

		ProdutosController produtosController = new ProdutosController();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		produto.setDescricao(tfDescricao.getText());
		produto.setCodigoDeBarras(tfCodigoDeBarras.getText());
		produto.setMarca(tfMarca.getText());
		subCategoria = (SubCategoria) cbSubCategoria.getSelectedItem();
		produto.setSubCategoria(subCategoria);
		produto.setUnidadeDeMedida(cbUnidadeDeMedida.getSelectedItem().toString());
		produto.setQuantidade(Integer.parseInt(tfQtdEstoque.getText()));
		try {
			produto.setDataFabricacao(dateFormat.parse(tfDataFabricacao.getText()));
			produto.setDataValidade(dateFormat.parse(tfValidade.getText()));
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(null,
					"Erro ao converter a data. Por favor, insira a data no formato dd/MM/yyyy.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		produto.setLote(tfLote.getText());
		produto.setIpi(Double.parseDouble(tfIpi.getText()));
		produto.setIcms(Double.parseDouble(tfIcms.getText()));
		produto.setMargemLucro(Double.parseDouble(tfMargem.getText()));
		produto.setPrecoCusto(Double.parseDouble(tfPrecoCusto.getText()));

		produto.setPrecoFinal(Double.parseDouble(tfPrecoFinal.getText().replaceAll(",", ".")));
		// Calcular o preço final com base na margem de lucro, IPI e ICMS
		// atualizarPrecoFinal();

		produtosController.cadastrarProduto(produto);

		limparTela(abaDadosProdutos);
		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método utilizado para efetuar a remoção.
	 */
	private void excluirProduto() {
		Produto produtos = new Produto();
		ProdutosController produtosController = new ProdutosController();

		produtos = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());
		produtosController.excluirProduto(produtos);

		limparTela(abaDadosProdutos);
		JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Preencher dados produto.
	 */
	/*
	 * Método utilizado para preencher os dados do produto na tela.
	 */
	private void preencherDadosProduto() {
		abaPrincipal.setSelectedIndex(0);

		tfCodigo.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
		tfDescricao.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString());
		tfCodigoDeBarras.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
		tfMarca.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString());
		cbSubCategoria.setSelectedItem(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString());
		cbUnidadeDeMedida.setSelectedItem(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
		tfQtdEstoque.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 5).toString());
		tfDataFabricacao.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 6).toString());
		tfValidade.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 7).toString());
		tfLote.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 8).toString());
		tfIpi.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 9).toString());
		tfIcms.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 10).toString());
		tfMargem.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 11).toString());
		tfPrecoCusto.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 12).toString());
		tfPrecoFinal.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 13).toString());
	}

	/**
	 * Consultar produto por nome.
	 */
	private void consultarProdutoPorNome() {
		String nomePesquisado = "%" + tfPesquisar.getText() + "%";
		ProdutosController produtosController = new ProdutosController();
		SubCategoriaController categoriaController = new SubCategoriaController();
		List<Produto> lista = produtosController.consultarProdutosPorNome(nomePesquisado);
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaProdutos.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(15);
		dadosTabela.addRow(new Object[] { "Codigo", "Descrição", "Codigo de Barras", "Marca", "SubCategoria",
				"Unidade de Medida", "Quantidade", " Fabricação", " Validade", "Lote", "IPI", "ICMS", "Margem Lucro",
				"Preco Custo", "Preço Final" });

		for (Produto produto : lista) {
			dadosTabela.addRow(new Object[] { /* produto.getCodigo(), */ produto.getDescricao(),
					produto.getCodigoDeBarras(), produto.getMarca(), produto.getSubCategoria().getNome(),
					produto.getUnidadeDeMedida(), produto.getQuantidade(), produto.getDataFabricacao(),
					produto.getDataValidade(), produto.getLote(), produto.getIpi(), produto.getIcms(),
					produto.getMargemLucro(), produto.getPrecoCusto(), produto.getPrecoFinal() });
		}
	}

	/**
	 * Metodo utilizado para listar todos os produtos e adiciona-los na tabela.
	 */
	private void consultarProdutos() {
		try {
			ProdutosController produtosController = new ProdutosController();
			List<Produto> lista = produtosController.consultarProdutos();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaProdutos.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(14);
			dadosTabela.addRow(new Object[] { "Descrição", "Codigo de Barras", "Marca", "SubCategoria",
					"Unidade de Medida", "Quantidade", " Fabricação", " Validade", "Lote", "IPI", "ICMS",
					"Margem Lucro", "Preco Custo", "Preço Final" });

			for (Produto produto : lista) {
				dadosTabela.addRow(new Object[] { /* produto.getCodigo(), */ produto.getDescricao(),
						produto.getCodigoDeBarras(), produto.getMarca(), produto.getSubCategoria().getNome(),
						produto.getUnidadeDeMedida(), produto.getQuantidade(), produto.getDataFabricacao(),
						produto.getDataValidade(), produto.getLote(), produto.getIpi(), produto.getIcms(),
						produto.getMargemLucro(), produto.getPrecoCusto(), produto.getPrecoFinal() });
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: " + erro);
		}
	}

	/**
	 * Atualiza o campo Preço Final com base nos campos de Margem de Lucro, IPI e
	 * ICMS. Caso algum campo não possua um valor numérico válido, não atualiza o
	 * Preço Final.
	 */
	private void atualizarPrecoFinal() {
		try {

			double ipi;
			double icms;
			double margem = Double.parseDouble(tfMargem.getText());

			if (tfIpi.getText().equals("")) {
				ipi = 0;
			} else {
				ipi = Double.parseDouble(tfIpi.getText());
			}

			if (tfIcms.getText().equals("")) {
				icms = 0;
			} else {
				icms = Double.parseDouble(tfIcms.getText());
			}

			double precoCusto = Double.parseDouble(tfPrecoCusto.getText());

			double precoFinal = precoCusto * (1 + (margem + ipi + icms) / 100);
			tfPrecoFinal.setText(String.format("%.2f", precoFinal));
		} catch (NumberFormatException e) {
			// Um dos campos não possui um número válido, não atualiza o Preço Final
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
					FrmProdutos frame = new FrmProdutos();
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
	public FrmProdutos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarProdutos();
			}
		});

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

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setForeground(Color.WHITE);
		lblProdutos.setFont(new Font("Arial Black", Font.BOLD, 40));

		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
			}
		});
		lblVoltar.setIcon(new ImageIcon(FrmProdutos.class.getResource("/assets/sair.png")));
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addComponent(lblProdutos)
						.addPreferredGap(ComponentPlacement.RELATED, 957, Short.MAX_VALUE)
						.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addGap(46)));
		gl_panelSuperior.setVerticalGroup(gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addContainerGap(22, Short.MAX_VALUE)
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProdutos))));
		panelSuperior.setLayout(gl_panelSuperior);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSuperior, GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
				.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 1344, Short.MAX_VALUE)
				.addComponent(panelInferior, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelSuperior, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
						.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JPanel panelInferior_2 = new JPanel();
		panelInferior_2.setBackground(new Color(202, 240, 248));
		GroupLayout gl_panelInferior = new GroupLayout(panelInferior);
		gl_panelInferior.setHorizontalGroup(gl_panelInferior.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelInferior_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE));
		gl_panelInferior.setVerticalGroup(gl_panelInferior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInferior.createSequentialGroup().addContainerGap()
						.addComponent(panelInferior_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelInferior_2.setLayout(new GridLayout(0, 6, 10, 0));

		JPanel espacoEsquerdo = new JPanel();
		espacoEsquerdo.setBackground(new Color(202, 240, 248));
		panelInferior_2.add(espacoEsquerdo);
		panelInferior.setLayout(gl_panelInferior);

		abaCadastrarProduto = new JLayeredPane();
		abaCadastrarProduto.setBackground(new Color(202, 240, 248));
		abaCadastrarProduto.setBorder(null);
		abaPrincipal.addTab("Cadastrar Produto", null, abaCadastrarProduto, null);

		abaDadosProdutos = new JPanel();
		abaDadosProdutos.setForeground(new Color(0, 0, 0));
		abaDadosProdutos.setBorder(null);
		abaDadosProdutos.setBackground(new Color(202, 240, 248));

		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSubcategoria = new JLabel("Subcategoria: ");
		lblSubcategoria.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblQtdEstoque = new JLabel("Quantidade em Estoque: ");
		lblQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblCodigoDeBarras = new JLabel("Código de Barras:");
		lblCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblDataFabricacao = new JLabel("Data de Fabricação: ");
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblLote = new JLabel("Lote: ");
		lblLote.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblIcms = new JLabel("ICMS: ");
		lblIcms.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblIpi = new JLabel("IPI:");
		lblIpi.setFont(new Font("Arial", Font.BOLD, 14));

		tfLote = new JTextField();
		tfLote.setBackground(Color.WHITE);
		tfLote.setFont(new Font("Arial", Font.BOLD, 14));
		tfLote.setColumns(10);

		tfCodigoDeBarras = new JTextField();
		tfCodigoDeBarras.setBackground(Color.WHITE);
		tfCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigoDeBarras.setColumns(10);

		tfDescricao = new JTextField();
		tfDescricao.setBackground(Color.WHITE);
		tfDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDescricao.setColumns(10);

		tfQtdEstoque = new JTextField();
		tfQtdEstoque.setBackground(Color.WHITE);
		tfQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));
		tfQtdEstoque.setColumns(10);

		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida: ");
		lblUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));

		cbUnidadeDeMedida = new JComboBox<String>();
		cbUnidadeDeMedida.setBackground(Color.WHITE);
		cbUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));
		cbUnidadeDeMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "UN", "CX" }));

		cbSubCategoria = new JComboBox<SubCategoria>();
		cbSubCategoria.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

				// listando subcategorias dentro do combobox
				SubCategoriaController subCategoriaController = new SubCategoriaController();
				List<SubCategoria> listaDeSubCategoria = subCategoriaController.consultarSubCategorias();

				// removendo para limpar todos os campos
				cbSubCategoria.removeAll();

				// colocando dentro do combobox todos os dados
				for (SubCategoria subCategoria : listaDeSubCategoria) {
					cbSubCategoria.addItem(subCategoria);
				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbSubCategoria.setBackground(Color.WHITE);
		cbSubCategoria.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(106, 76, 147));
		btnNovo.setForeground(new Color(255, 255, 255));
		btnNovo.setFont(new Font("Arial", Font.BOLD, 24));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela(abaDadosProdutos);
			}
		});
		panelInferior_2.add(btnNovo);

		JButton btnAlterar = new JButton("Editar");
		btnAlterar.setBackground(new Color(255, 202, 58));
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 24));

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProduto();
			}
		});

		panelInferior_2.add(btnAlterar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProduto();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior_2.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
			}
		});
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior_2.add(btnExcluir);

		JPanel espacoDireito = new JPanel();
		espacoDireito.setBackground(new Color(202, 240, 248));
		panelInferior_2.add(espacoDireito);

		DocumentListener documentListener = new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				atualizarPrecoFinal();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				atualizarPrecoFinal();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				atualizarPrecoFinal();
			}
		};

		tfIpi = new JTextField();
		tfIpi.setBackground(Color.WHITE);
		tfIpi.setFont(new Font("Arial", Font.BOLD, 14));
		tfIpi.setColumns(10);
		tfIpi.getDocument().addDocumentListener(documentListener);
		tfIpi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}
		});

		tfIcms = new JTextField();
		tfIcms.setBackground(Color.WHITE);
		tfIcms.setFont(new Font("Arial", Font.BOLD, 14));
		tfIcms.setColumns(10);
		tfIcms.getDocument().addDocumentListener(documentListener);
		tfIcms.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}
		});

		JLabel lblMargemLucro = new JLabel("Margem de Lucro %: ");
		lblMargemLucro.setFont(new Font("Arial", Font.BOLD, 14));

		tfMargem = new JTextField();
		tfMargem.setBackground(Color.WHITE);
		tfMargem.setFont(new Font("Arial", Font.BOLD, 14));
		tfMargem.setColumns(10);
		tfMargem.getDocument().addDocumentListener(documentListener);
		tfMargem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}
		});

		tfMarca = new JTextField();
		tfMarca.setBackground(Color.WHITE);
		tfMarca.setFont(new Font("Arial", Font.BOLD, 14));
		tfMarca.setColumns(10);

		tfDataFabricacao = new JTextField();
		tfDataFabricacao.setBackground(Color.WHITE);
		tfDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataFabricacao.setColumns(10);

		JLabel lblPrecoCusto = new JLabel("Preço de Custo: ");
		lblPrecoCusto.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblValidade = new JLabel("Data de Validade: ");
		lblValidade.setFont(new Font("Arial", Font.BOLD, 14));

		tfValidade = new JTextField();
		tfValidade.setBackground(Color.WHITE);
		tfValidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfValidade.setColumns(10);

		tfPrecoCusto = new JTextField();
		tfPrecoCusto.setBackground(Color.WHITE);
		tfPrecoCusto.setFont(new Font("Arial", Font.BOLD, 14));
		tfPrecoCusto.setColumns(10);
		tfPrecoCusto.getDocument().addDocumentListener(documentListener);
		tfPrecoCusto.addKeyListener(new KeyAdapter() {
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
		btnRemover.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));

		JPanel painelFotoProduto = new JPanel();
		painelFotoProduto.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JLabel lblPrecoFinal = new JLabel("Preço Final: ");
		lblPrecoFinal.setFont(new Font("Arial", Font.BOLD, 14));

		tfPrecoFinal = new JTextField();
		tfPrecoFinal.setBackground(Color.WHITE);
		tfPrecoFinal.setFont(new Font("Arial", Font.BOLD, 14));
		tfPrecoFinal.setColumns(10);
		tfPrecoFinal.setEditable(false);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);

		GroupLayout gl_abaDadosProdutos = new GroupLayout(abaDadosProdutos);
		gl_abaDadosProdutos.setHorizontalGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(62).addGroup(
						gl_abaDadosProdutos.createParallelGroup(Alignment.TRAILING).addGroup(gl_abaDadosProdutos
								.createSequentialGroup()
								.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.TRAILING).addGroup(
										gl_abaDadosProdutos.createSequentialGroup().addGroup(gl_abaDadosProdutos
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(42)
														.addComponent(lblCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 162,
																Short.MAX_VALUE)
														.addGap(4))
												.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(102)
														.addComponent(lblDescricao, GroupLayout.DEFAULT_SIZE, 102,
																Short.MAX_VALUE)
														.addGap(4))
												.addGroup(gl_abaDadosProdutos.createSequentialGroup()
														.addComponent(lblQtdEstoque, GroupLayout.DEFAULT_SIZE, 204,
																Short.MAX_VALUE)
														.addGap(4))
												.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(100)
														.addComponent(lblSubcategoria, GroupLayout.DEFAULT_SIZE, 104,
																Short.MAX_VALUE)
														.addGap(4))
												.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(125)
														.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, 79,
																Short.MAX_VALUE)
														.addGap(4))
												.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(30)
														.addComponent(lblDataFabricacao, GroupLayout.DEFAULT_SIZE, 170,
																Short.MAX_VALUE)
														.addGap(8)))
												.addGap(4))
										.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(135).addComponent(
												lblLote, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)))
								.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
										.addComponent(tfCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
										.addComponent(tfDescricao, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
										.addGroup(gl_abaDadosProdutos.createSequentialGroup()
												.addComponent(tfQtdEstoque, GroupLayout.DEFAULT_SIZE, 160,
														Short.MAX_VALUE)
												.addGap(46)
												.addComponent(lblUnidadeDeMedida, GroupLayout.DEFAULT_SIZE, 155,
														Short.MAX_VALUE)
												.addGap(4).addComponent(cbUnidadeDeMedida, 0, 164, Short.MAX_VALUE))
										.addComponent(cbSubCategoria, 0, 529, Short.MAX_VALUE)
										.addComponent(tfMarca, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
										.addGroup(gl_abaDadosProdutos.createSequentialGroup()
												.addComponent(tfDataFabricacao, GroupLayout.DEFAULT_SIZE, 200,
														Short.MAX_VALUE)
												.addGap(31)
												.addComponent(lblValidade, GroupLayout.DEFAULT_SIZE, 136,
														Short.MAX_VALUE)
												.addGap(4).addComponent(tfValidade, GroupLayout.DEFAULT_SIZE, 158,
														Short.MAX_VALUE))
										.addGroup(gl_abaDadosProdutos.createSequentialGroup()
												.addComponent(tfLote, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
												.addGap(40)
												.addComponent(lblPrecoCusto, GroupLayout.DEFAULT_SIZE, 127,
														Short.MAX_VALUE)
												.addGap(4).addComponent(tfPrecoCusto, GroupLayout.DEFAULT_SIZE, 158,
														Short.MAX_VALUE))
										.addComponent(
												tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGroup(gl_abaDadosProdutos
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(130)
												.addComponent(lblIcms, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
										.addComponent(lblPrecoFinal, Alignment.TRAILING)
										.addGroup(gl_abaDadosProdutos
												.createSequentialGroup().addGap(149)
												.addComponent(lblIpi, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_abaDadosProdutos.createSequentialGroup()
														.addComponent(tfIcms, GroupLayout.DEFAULT_SIZE, 206,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblMargemLucro, GroupLayout.DEFAULT_SIZE, 155,
																Short.MAX_VALUE)
														.addGap(11))
												.addGroup(gl_abaDadosProdutos.createSequentialGroup()
														.addGroup(gl_abaDadosProdutos
																.createParallelGroup(Alignment.TRAILING)
																.addComponent(tfPrecoFinal, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
																.addComponent(tfIpi, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
														.addGap(174)))
										.addComponent(tfMargem, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
						.addGap(143)
						.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
								.addComponent(btnAdicionar, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
								.addComponent(painelFotoProduto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 302,
										Short.MAX_VALUE))
						.addGap(91))
				.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(179).addComponent(lblCodigo)
						.addContainerGap(1106, Short.MAX_VALUE)));
		gl_abaDadosProdutos
				.setVerticalGroup(
						gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING).addGroup(gl_abaDadosProdutos
								.createSequentialGroup().addGap(29).addGroup(gl_abaDadosProdutos
										.createParallelGroup(Alignment.BASELINE).addComponent(lblCodigo).addComponent(
												tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(10)
												.addComponent(lblCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 23,
														Short.MAX_VALUE)
												.addGap(21)
												.addComponent(lblDescricao, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE)
												.addGap(22)
												.addComponent(lblQtdEstoque, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addGap(22)
												.addComponent(lblSubcategoria, GroupLayout.PREFERRED_SIZE, 19,
														GroupLayout.PREFERRED_SIZE)
												.addGap(24)
												.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
												.addGap(24)
												.addComponent(lblDataFabricacao, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE)
												.addGap(44))
										.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(10)
												.addComponent(tfCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 23,
														Short.MAX_VALUE)
												.addGap(18)
												.addComponent(
														tfDescricao, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
												.addGap(18)
												.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(1)
																.addComponent(tfQtdEstoque, GroupLayout.PREFERRED_SIZE,
																		23, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(4)
																.addComponent(lblUnidadeDeMedida,
																		GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
																.addGap(4))
														.addComponent(cbUnidadeDeMedida, GroupLayout.PREFERRED_SIZE, 25,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addComponent(cbSubCategoria, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(tfMarca, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addGroup(gl_abaDadosProdutos
														.createParallelGroup(Alignment.LEADING)
														.addComponent(tfDataFabricacao, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(3)
																.addComponent(lblValidade, GroupLayout.PREFERRED_SIZE,
																		17, GroupLayout.PREFERRED_SIZE))
														.addComponent(
																tfValidade, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_abaDadosProdutos
																.createParallelGroup(Alignment.BASELINE)
																.addComponent(tfLote, GroupLayout.PREFERRED_SIZE, 23,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_abaDadosProdutos.createSequentialGroup()
																		.addGap(6).addComponent(lblLote,
																				GroupLayout.DEFAULT_SIZE, 17,
																				Short.MAX_VALUE)))
														.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(3)
																.addComponent(lblPrecoCusto, GroupLayout.PREFERRED_SIZE,
																		17, GroupLayout.PREFERRED_SIZE))
														.addComponent(tfPrecoCusto, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_abaDadosProdutos
												.createSequentialGroup()
												.addComponent(
														painelFotoProduto, GroupLayout.DEFAULT_SIZE, 279,
														Short.MAX_VALUE)
												.addGap(4)))
								.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(20)
												.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.BASELINE)
														.addComponent(tfIcms, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(6)
																.addComponent(lblIcms, GroupLayout.DEFAULT_SIZE, 17,
																		Short.MAX_VALUE)))
												.addGap(16))
										.addGroup(gl_abaDadosProdutos.createSequentialGroup()
												.addGroup(gl_abaDadosProdutos
														.createParallelGroup(Alignment.LEADING, false)
														.addGroup(gl_abaDadosProdutos
																.createSequentialGroup().addGap(14)
																.addComponent(
																		btnAdicionar, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(18)
																.addGroup(gl_abaDadosProdutos
																		.createParallelGroup(Alignment.BASELINE)
																		.addComponent(tfMargem,
																				GroupLayout.PREFERRED_SIZE, 23,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblMargemLucro,
																				GroupLayout.PREFERRED_SIZE, 17,
																				GroupLayout.PREFERRED_SIZE))))
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosProdutos.createSequentialGroup().addGap(4)
												.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.BASELINE)
														.addComponent(tfIpi, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_abaDadosProdutos
																.createSequentialGroup().addGap(6).addComponent(lblIpi,
																		GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)))
												.addGap(18)
												.addGroup(gl_abaDadosProdutos.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblPrecoFinal)
														.addComponent(tfPrecoFinal, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_abaDadosProdutos.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED, 43,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(99)));
		abaDadosProdutos.setLayout(gl_abaDadosProdutos);
		GroupLayout gl_abaCadastrarProduto = new GroupLayout(abaCadastrarProduto);
		gl_abaCadastrarProduto.setHorizontalGroup(gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
				.addComponent(abaDadosProdutos, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE));
		gl_abaCadastrarProduto.setVerticalGroup(gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
				.addComponent(abaDadosProdutos, GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE));
		abaCadastrarProduto.setLayout(gl_abaCadastrarProduto);

		JLayeredPane abaConsultarProdutos = new JLayeredPane();
		abaConsultarProdutos.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta de Produtos", null, abaConsultarProdutos, null);

		JLabel lblNomePesquisa = new JLabel("Nome: ");
		lblNomePesquisa.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomePesquisa.setBounds(10, 35, 48, 17);
		abaConsultarProdutos.add(lblNomePesquisa);

		tfPesquisar = new JTextField();
		tfPesquisar.setColumns(10);
		tfPesquisar.setBounds(63, 34, 380, 20);
		abaConsultarProdutos.add(tfPesquisar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPesquisar.setBounds(460, 30, 137, 25);
		abaConsultarProdutos.add(btnPesquisar);

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarProdutoPorNome();
			}
		});

		tabelaProdutos = new JTable();
		tabelaProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherDadosProduto();
			}

		});

		tabelaProdutos.setFont(new Font("Arial", Font.PLAIN, 14));
		tabelaProdutos.setFillsViewportHeight(true);
		tabelaProdutos.setColumnSelectionAllowed(true);
		tabelaProdutos.setCellSelectionEnabled(true);
		tabelaProdutos.setBounds(10, 63, 1339, 469);
		abaConsultarProdutos.add(tabelaProdutos);
		getContentPane().setLayout(groupLayout);
	}
}
