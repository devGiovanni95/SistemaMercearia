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
public class FrmEntradaEstoque extends JFrame {

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
	private JComboBox<SubCategoria> cbSubCategoria;

	/** The cb unidade de medida. */
	private JComboBox<String> cbUnidadeDeMedida;

	/** this layer is for the "Cadastrar Produto" tab. */
	private JLayeredPane abaCadastrarProduto;

	/** The aba dados produtos. */
	private JPanel abaDadosEstoque;

	/** The aba principal. */
	public JTabbedPane abaPrincipal ;

	/** The tf codigo. */
	private JTextField tfCodigo;

	/** Objeto da classe LimparCampos. */
	private LimparCampos limparCampos;
	private JTextField tfDataEntrada;
	private JTextField tfQuantidadeComprada;


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
	 * Método responsável por alterar os dados de um produto cadastrado.
	 * Os dados são obtidos dos campos de texto na interface gráfica e armazenados em um objeto do tipo Produto,
	Em seguida, os campos de texto na interface gráfica são limpos através do método Limpar() da classe LimparCampos.
	 * O objeto Produto é passado como parâmetro para o método alterarProduto() da classe ProdutosController.
	 */

	/**
	 * Alterar produto.
	 */
	private void alterarProduto(){
		Produto produto = new Produto();
		SubCategoria subCategoria = new SubCategoria();

		ProdutosController produtosController = new ProdutosController();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		produto.setDescricao(tfDescricao.getText());
		produto.setCodigoDeBarras(tfCodigoDeBarras.getText());
		produto.setMarca(tfMarca.getText());
		subCategoria = (SubCategoria)cbSubCategoria.getSelectedItem();
		produto.setSubCategoria(subCategoria);
		produto.setUnidadeDeMedida(cbUnidadeDeMedida.getSelectedItem().toString());
		produto.setQuantidade(Integer.parseInt(tfQtdEstoque.getText()));
		produto.setDataFabricacao(tfDataFabricacao.getText());
		produto.setDataValidade(tfValidade.getText());

		produto.setPrecoCusto(Double.parseDouble(tfPrecoUnitario.getText()));
		//produto.setCodigo(Integer.parseInt(tfCodigo.getText()));

		// Calcular o preço final com base na margem de lucro, IPI e ICMS
		//atualizarPrecoFinal();

		produto.setPrecoFinal(Double.parseDouble(tfSubTotal.getText().replaceAll(",",".")));

		produtosController.alterarProduto(produto);

		limparTela(abaDadosEstoque);
		JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}




	/**
	 * Cadastrar produto.
	 */
	private void cadastrarProduto(){
		Produto produto = new Produto();
		SubCategoria subCategoria = new SubCategoria();

		ProdutosController produtosController = new ProdutosController();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		produto.setDescricao(tfDescricao.getText());
		produto.setCodigoDeBarras(tfCodigoDeBarras.getText());
		produto.setMarca(tfMarca.getText());
		subCategoria = (SubCategoria)cbSubCategoria.getSelectedItem();
		produto.setSubCategoria(subCategoria);
		produto.setUnidadeDeMedida(cbUnidadeDeMedida.getSelectedItem().toString());
		produto.setQuantidade(Integer.parseInt(tfQtdEstoque.getText()));
		produto.setDataFabricacao(tfDataFabricacao.getText());
		produto.setDataValidade(tfValidade.getText());

		produto.setPrecoCusto(Double.parseDouble(tfPrecoUnitario.getText()));

		produto.setPrecoFinal(Double.parseDouble(tfSubTotal.getText().replaceAll(",",".")));
		// Calcular o preço final com base na margem de lucro, IPI e ICMS
		//atualizarPrecoFinal();

		produtosController.cadastrarProduto(produto);

		limparTela(abaDadosEstoque);
		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método utilizado para efetuar a remoção.
	 */
	private void excluirProduto() {
		Produto produtos = new Produto();
		ProdutosController produtosController = new ProdutosController();
		
		produtos = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());

		produtosController.excluirProduto(produtos);

		limparTela(abaDadosEstoque);
		JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Preencher dados produto.
	 */
	/*
	 * Método utilizado para preencher os dados do produto na tela.
	 */
	private void preencherDadosProduto(){
		abaPrincipal.setSelectedIndex(0);

		//tfCodigo.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 0).toString());
		tfDescricao.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 0).toString());
		tfCodigoDeBarras.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 1).toString());
		tfMarca.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 2).toString());
		cbSubCategoria.setSelectedItem(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 3).toString());
		cbUnidadeDeMedida.setSelectedItem(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 4).toString());
		tfQtdEstoque.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 5).toString());
		tfDataFabricacao.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 6).toString());
		tfValidade.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 7).toString());

		tfPrecoUnitario.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 13).toString());
		tfSubTotal.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 14).toString());
	}

	/**
	 * Consultar produto por nome.
	 */
	private void consultarProdutoPorNome(){
		String nomePesquisado = "%" + tfPesquisar.getText() + "%";
		ProdutosController produtosController = new ProdutosController();
		SubCategoriaController categoriaController = new SubCategoriaController();
		List<Produto> lista = produtosController.consultarProdutosPorNome(nomePesquisado);
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaEstoque.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(15);
		dadosTabela.addRow(new Object[]{"Descrição", "Codigo de Barras", "Marca", "SubCategoria", "Unidade de Medida", "Quantidade",
				" Fabricação"," Validade","Lote", "IPI","ICMS","Margem Lucro","Preco Custo", "Preço Final"});

		for(Produto produto : lista) {
			dadosTabela.addRow(new Object[]{
				//	produto.getCodigo(),
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
	 */
	private void consultarProdutos() {
		try {
			ProdutosController produtosController = new ProdutosController();
			List<Produto> lista = produtosController.consultarProdutos();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaEstoque.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(15);
			dadosTabela.addRow(new Object[]{"Descrição", "Codigo de Barras", "Marca", "SubCategoria", "Unidade de Medida", "Quantidade",
					" Fabricação"," Validade","Lote", "IPI","ICMS","Margem Lucro","Preco Custo", "Preço Final"});

			for(Produto produto : lista) {
				dadosTabela.addRow(new Object[]{
						//produto.getCodigo(),
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
		}catch (Exception erro) {
			JOptionPane.showMessageDialog(null,"Ops aconteceu o erro: " + erro);
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
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
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
					.addGap(46))
		);
		gl_panelSuperior.setVerticalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSuperior.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProdutos)
						.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
		);
		panelSuperior.setLayout(gl_panelSuperior);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSuperior, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 1344, Short.MAX_VALUE)
				.addComponent(panelInferior, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelSuperior, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(panelInferior, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JPanel panelInferior_2 = new JPanel();
		panelInferior_2.setBackground(new Color(202, 240, 248));
		GroupLayout gl_panelInferior = new GroupLayout(panelInferior);
		gl_panelInferior.setHorizontalGroup(
				gl_panelInferior.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelInferior_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
		);
		gl_panelInferior.setVerticalGroup(
				gl_panelInferior.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInferior.createSequentialGroup()
								.addContainerGap()
								.addComponent(panelInferior_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
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
		lblSubcategoria.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblDataFabricacao = new JLabel("Data de Fabricação: ");
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigoDeBarras = new JTextField();
		tfCodigoDeBarras.setEnabled(false);
		tfCodigoDeBarras.setBackground(Color.WHITE);
		tfCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigoDeBarras.setColumns(10);

		tfDescricao = new JTextField();
		tfDescricao.setEnabled(false);
		tfDescricao.setBackground(Color.WHITE);
		tfDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDescricao.setColumns(10);

		tfQtdEstoque = new JTextField();
		tfQtdEstoque.setToolTipText("Campo disponivel para editar produto");
		tfQtdEstoque.setBackground(Color.WHITE);
		tfQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));
		tfQtdEstoque.setColumns(10);

		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida: ");
		lblUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));

		cbUnidadeDeMedida = new JComboBox<String>();
		cbUnidadeDeMedida.setEnabled(false);
		cbUnidadeDeMedida.setBackground(Color.WHITE);
		cbUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));
		cbUnidadeDeMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
				"KG","UN", "CX"
		}));

		cbSubCategoria = new JComboBox<SubCategoria>();
		cbSubCategoria.setEnabled(false);
		cbSubCategoria.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

				//listando  subcategorias dentro do combobox
				SubCategoriaController subCategoriaController = new SubCategoriaController();
				List<SubCategoria> listaDeSubCategoria = subCategoriaController.consultarSubCategorias();

				//removendo para limpar todos os campos
				cbSubCategoria.removeAll();

				//colocando dentro do combobox todos os dados
				for(SubCategoria subCategoria : listaDeSubCategoria) {
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
				//alterarProduto();
			}
		});

		panelInferior_2.add(btnAlterar);


		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cadastrarProduto();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior_2.add(btnSalvar);



		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//excluirProduto();
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
		tfMarca.setEnabled(false);
		tfMarca.setBackground(Color.WHITE);
		tfMarca.setFont(new Font("Arial", Font.BOLD, 14));
		tfMarca.setColumns(10);

		tfDataFabricacao = new JTextField();
		tfDataFabricacao.setBackground(Color.WHITE);
		tfDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataFabricacao.setColumns(10);

		JLabel lvlPrecoUnitario = new JLabel("Preço Unitario:");
		lvlPrecoUnitario.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblValidade = new JLabel("Data de Validade: ");
		lblValidade.setFont(new Font("Arial", Font.BOLD, 14));

		tfValidade = new JTextField();
		tfValidade.setBackground(Color.WHITE);
		tfValidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfValidade.setColumns(10);

		tfPrecoUnitario = new JTextField();
		tfPrecoUnitario.setBackground(Color.WHITE);
		tfPrecoUnitario.setFont(new Font("Arial", Font.BOLD, 14));
		tfPrecoUnitario.setColumns(10);
		//tfPrecoUnitario.getDocument().addDocumentListener(documentListener);
		tfPrecoUnitario.addKeyListener(new KeyAdapter() {
			//Metodo confere se o valor digitado é numerico se nçao é impede de ser digitado
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

		JLabel lblSubtotal = new JLabel("Preço Final: ");
		lblSubtotal.setFont(new Font("Arial", Font.BOLD, 14));

		tfSubTotal = new JTextField();
		tfSubTotal.setBackground(Color.WHITE);
		tfSubTotal.setFont(new Font("Arial", Font.BOLD, 14));
		tfSubTotal.setColumns(10);
		tfSubTotal.setEditable(false);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		
				JLabel lblQtdEstoque = new JLabel("Quantidade em Estoque:");
				lblQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));
		
				JLabel lblDescricao = new JLabel("Descrição:");
				lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		
				JLabel lblCodigoDeBarras = new JLabel("Código de Barras:");
				lblCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfDataEntrada = new JTextField();
		tfDataEntrada.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataEntrada.setColumns(10);
		tfDataEntrada.setBackground(Color.WHITE);
		
		JLabel lblDataEntrada = new JLabel("Data de Entrada:");
		lblDataEntrada.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblQuantidadeComprada = new JLabel("Quantidade Comprada:");
		lblQuantidadeComprada.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfQuantidadeComprada = new JTextField();
		tfQuantidadeComprada.setFont(new Font("Arial", Font.BOLD, 14));
		tfQuantidadeComprada.setColumns(10);
		tfQuantidadeComprada.setBackground(Color.WHITE);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox<SubCategoria> cbFornecedor = new JComboBox<SubCategoria>();
		cbFornecedor.setEditable(true);
		cbFornecedor.setFont(new Font("Arial", Font.BOLD, 14));
		cbFornecedor.setEnabled(false);
		cbFornecedor.setBackground(Color.WHITE);
		GroupLayout gl_abaCadastrarProduto = new GroupLayout(abaCadastrarProduto);
		gl_abaCadastrarProduto.setHorizontalGroup(
			gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
				.addComponent(abaDadosEstoque, GroupLayout.DEFAULT_SIZE, 1339, Short.MAX_VALUE)
		);
		gl_abaCadastrarProduto.setVerticalGroup(
			gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaCadastrarProduto.createSequentialGroup()
					.addComponent(abaDadosEstoque, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		GroupLayout gl_abaDadosEstoque = new GroupLayout(abaDadosEstoque);
		gl_abaDadosEstoque.setHorizontalGroup(
			gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosEstoque.createSequentialGroup()
					.addGap(179)
					.addComponent(lblCodigo)
					.addGap(38)
					.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosEstoque.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(46)
							.addComponent(lblCodigoDeBarras))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(98)
							.addComponent(lblDescricao))
						.addComponent(lblQtdEstoque)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(75)
							.addComponent(lblSubcategoria))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(129)
							.addComponent(lblMarca))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(38)
							.addComponent(lblDataFabricacao))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(76)
							.addComponent(lvlPrecoUnitario)))
					.addGap(10)
					.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
						.addComponent(tfCodigoDeBarras, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addComponent(tfQtdEstoque, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(lblUnidadeDeMedida, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(cbUnidadeDeMedida, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbSubCategoria, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfMarca, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addComponent(tfDataFabricacao, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(lblValidade)
							.addGap(4)
							.addComponent(tfValidade, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addComponent(tfPrecoUnitario, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(lblQuantidadeComprada)
							.addGap(10)
							.addComponent(tfQuantidadeComprada, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
					.addGap(143)
					.addComponent(painelFotoProduto, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosEstoque.createSequentialGroup()
					.addGap(144)
					.addComponent(lblDataEntrada)
					.addGap(12)
					.addComponent(tfDataEntrada, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblSubtotal)
					.addGap(4)
					.addComponent(tfSubTotal, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addGap(143)
					.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosEstoque.createSequentialGroup()
					.addGap(172)
					.addComponent(lblFornecedor)
					.addGap(10)
					.addComponent(cbFornecedor, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addGap(145)
					.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
		);
		gl_abaDadosEstoque.setVerticalGroup(
			gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosEstoque.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCodigo))
						.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(13)
							.addComponent(lblCodigoDeBarras)
							.addGap(24)
							.addComponent(lblDescricao)
							.addGap(22)
							.addComponent(lblQtdEstoque, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(lblSubcategoria, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(lblMarca)
							.addGap(24)
							.addComponent(lblDataFabricacao)
							.addGap(29)
							.addComponent(lvlPrecoUnitario))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(10)
							.addComponent(tfCodigoDeBarras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosEstoque.createSequentialGroup()
									.addGap(1)
									.addComponent(tfQtdEstoque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosEstoque.createSequentialGroup()
									.addGap(4)
									.addComponent(lblUnidadeDeMedida))
								.addComponent(cbUnidadeDeMedida, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(cbSubCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
								.addComponent(tfDataFabricacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosEstoque.createSequentialGroup()
									.addGap(3)
									.addComponent(lblValidade))
								.addComponent(tfValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
								.addComponent(tfPrecoUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosEstoque.createSequentialGroup()
									.addGap(3)
									.addComponent(lblQuantidadeComprada))
								.addComponent(tfQuantidadeComprada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(painelFotoProduto, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(7)
							.addComponent(lblDataEntrada))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(4)
							.addComponent(tfDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(7)
							.addComponent(lblSubtotal))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(4)
							.addComponent(tfSubTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAdicionar))
					.addGap(4)
					.addGroup(gl_abaDadosEstoque.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(14)
							.addComponent(lblFornecedor, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosEstoque.createSequentialGroup()
							.addGap(11)
							.addComponent(cbFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRemover)))
		);
		abaDadosEstoque.setLayout(gl_abaDadosEstoque);
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
