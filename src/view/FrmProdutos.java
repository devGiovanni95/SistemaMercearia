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
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.CadastroProdutoFornecedorEstoqueController;
import controller.FornecedorController;
import controller.ProdutosController;
import controller.SubCategoriaController;
import model.CadastroProdutoFornecedorEstoque;
import model.Fornecedor;
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
	private JTextField tfDataEntrada;
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

	/*
	 * Método responsável por alterar os dados de um produto cadastrado.
	 * Os dados são obtidos dos campos de texto na interface gráfica e armazenados
	 * em um objeto do tipo Produto,
	 * Em seguida, os campos de texto na interface gráfica são limpos através do
	 * método Limpar() da classe LimparCampos.
	 * O objeto Produto é passado como parâmetro para o método alterarProduto() da
	 * classe ProdutosController.
	 */

	/**
	 * Alterar produto.
	 */
	private void alterarProduto() {
		Produto produto = new Produto();
		SubCategoria subCategoria = new SubCategoria();
		SubCategoriaController subCategoriaController = new SubCategoriaController();
		ProdutosController produtosController = new ProdutosController();

		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		produto.setDescricao(tfDescricao.getText());
		produto.setCodigoDeBarras(tfCodigoDeBarras.getText());
		produto.setMarca(tfMarca.getText());
		subCategoria = (SubCategoria) subCategoriaController.consultarSubCategoriaPorNome(tfSub.getText());

		produto.setSubCategoria(subCategoria);
		produto.setUnidadeDeMedida(cbUnidadeDeMedida.getSelectedItem().toString());
		produto.setQuantidade(Double.parseDouble(tfQtdEstoque.getText()));
		produto.setDataFabricacao(tfDataFabricacao.getText());
		produto.setDataValidade(tfValidade.getText());
		produto.setLote(tfLote.getText());
		produto.setIpi(Double.parseDouble(tfIpi.getText()));
		produto.setIcms(Double.parseDouble(tfIcms.getText()));
		produto.setMargemLucro(Double.parseDouble(tfMargem.getText()));
		produto.setPrecoCusto(Double.parseDouble(tfPrecoCusto.getText()));
		// produto.setCodigo(Integer.parseInt(tfCodigo.getText()));

		// Calcular o preço final com base na margem de lucro, IPI e ICMS
		// atualizarPrecoFinal();

		produto.setPrecoFinal(Double.parseDouble(tfPrecoFinal.getText().replaceAll(",", ".")));

		try {
			produtosController.alterarProduto(produto);
			JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		limparTela(abaDadosProdutos);
	}

	/**
	 * Cadastrar produto.
	 */
	private void cadastrarProduto() {
		Produto produto = new Produto();
		SubCategoria subCategoria = new SubCategoria();

		ProdutosController produtosController = new ProdutosController();

		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		produto.setDescricao(tfDescricao.getText());
		produto.setCodigoDeBarras(tfCodigoDeBarras.getText());
		produto.setMarca(tfMarca.getText());
		subCategoria = (SubCategoria) cbSubCategoria.getSelectedItem();
		produto.setSubCategoria(subCategoria);
		produto.setUnidadeDeMedida(cbUnidadeDeMedida.getSelectedItem().toString());
		// produto.setQuantidade(Integer.parseInt(tfQtdEstoque.getText()));
		produto.setQuantidade(0);
		produto.setDataFabricacao(tfDataFabricacao.getText());
		produto.setDataValidade(tfValidade.getText());
		produto.setLote(tfLote.getText());
		produto.setIpi(Double.parseDouble(tfIpi.getText()));
		produto.setIcms(Double.parseDouble(tfIcms.getText()));
		produto.setMargemLucro(Double.parseDouble(tfMargem.getText()));
		produto.setPrecoCusto(Double.parseDouble(tfPrecoCusto.getText()));

		produto.setPrecoFinal(Double.parseDouble(tfPrecoFinal.getText().replaceAll(",", ".")));
		// Calcular o preço final com base na margem de lucro, IPI e ICMS
		// atualizarPrecoFinal();

		// tentativa de debugar o erro com subcategoria
		// subCategoria = (SubCategoria)cbSubCategoria.getSelectedItem();
		// System.out.println(subCategoria.getCodigo());

		System.out.println("SubCategoria: " + produto.getSubCategoria().getNome());

		try {
			produtosController.cadastrarProduto(produto);
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		System.out.println(produto);
	}

	private void cadastrarProdutoFornecedorEstoque() {
		CadastroProdutoFornecedorEstoque cadastroProdutoFornecedorEstoque = new CadastroProdutoFornecedorEstoque();
		CadastroProdutoFornecedorEstoqueController cadastroProdutoFornecedorEstoqueController = new CadastroProdutoFornecedorEstoqueController();

		Produto produto = new Produto();
		ProdutosController produtosController = new ProdutosController();
		produto = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());

		Fornecedor fornecedor = new Fornecedor();
		FornecedorController fornecedorController = new FornecedorController();

		fornecedor = (Fornecedor) cbFornecedor.getSelectedItem();

		double precoUnitario = calcularPrecoCusto();
		double subtotal = calcularPrecoCusto();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		cadastroProdutoFornecedorEstoque.setProduto(produto);
		cadastroProdutoFornecedorEstoque.setFornecedor(fornecedor);
		cadastroProdutoFornecedorEstoque.setDataEntrada(tfDataEntrada.getText());
		cadastroProdutoFornecedorEstoque.setQuantidade(Double.parseDouble(tfQtdEstoque.getText()));
		cadastroProdutoFornecedorEstoque.setPrecoUnitario(Double.parseDouble(tfPrecoCusto.getText()));
		subtotal = (Double.parseDouble(tfQtdEstoque.getText())) * precoUnitario;
		cadastroProdutoFornecedorEstoque.setSubTotal(subtotal);

		cadastroProdutoFornecedorEstoqueController.cadastrarProdutoFornecedor(cadastroProdutoFornecedorEstoque);
		limparTela(abaDadosProdutos);
		JOptionPane.showMessageDialog(null, "Histórico cadastrado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		
		System.out.println(cadastroProdutoFornecedorEstoque);
		limparTela(abaDadosProdutos);
	}

	/**
	 * Método utilizado para efetuar a remoção.
	 */
	private void excluirProduto() {
		Produto produto = new Produto();
		ProdutosController produtosController = new ProdutosController();

		try {
			produto = produtosController.consultarProdutosPorCodigoBarras(tfCodigoDeBarras.getText());
			produtosController.excluirProduto(produto);
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		limparTela(abaDadosProdutos);
	}

	/**
	 * Preencher dados produto.
	 */
	/*
	 * Método utilizado para preencher os dados do produto na tela.
	 */
	private void preencherDadosProduto() {
		abaPrincipal.setSelectedIndex(0);

		tfCodigo.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),
				1).toString());
		tfDescricao.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString());
		tfCodigoDeBarras.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
		tfMarca.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString());

		// cbSubCategoria.setSelectedItem(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),
		// 3).toString());
		Produto produto = new Produto();
		ProdutosController controller = new ProdutosController();
		produto = controller
				.consultarProdutosPorCodigoBarrasCompleto(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(),
						1).toString());
		SubCategoria subCategoria = new SubCategoria();
		SubCategoriaController subCategoriaController = new SubCategoriaController();

		subCategoria = subCategoriaController.consultarSubCategoriasPorId(produto.getSubCategoria().getCodigo());

		String subCategoriaSelecionada = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString();

		cbSubCategoria.setSelectedItem(subCategoriaSelecionada);
		tfSub.setText(subCategoria.getNome());

		cbUnidadeDeMedida.setSelectedItem(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
		tfQtdEstoque.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 5).toString());
		tfDataFabricacao
				.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 6)
						.toString());
		tfValidade.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 7).toString());
		tfLote.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 8).toString());
		tfIpi.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 9).toString());
		tfIcms.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 10).toString());
		tfMargem.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 11).toString());
		tfPrecoCusto.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 12).toString());
		tfPrecoFinal.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 13).toString());

		cbFornecedor.setEnabled(false);
		tfDataEntrada.setEnabled(false);
		tfDataEntrada.setText("Não Aplicavel");
	}

	/**
	 * Consultar produto por nome.
	 * 
	 * @throws Exception
	 */

	private void consultarProdutoPorNome() throws Exception {
		String nomePesquisado = "%" + tfPesquisar.getText() + "%";
		ProdutosController produtosController = new ProdutosController();
		SubCategoriaController categoriaController = new SubCategoriaController();
		List<Produto> lista = produtosController.consultarProdutosPorNome(nomePesquisado);
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaProdutos.getModel();
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
	 */

	private void consultarProdutos() {
		try {
			ProdutosController produtosController = new ProdutosController();
			List<Produto> lista = produtosController.consultarProdutos();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaProdutos.getModel();
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}
	}

	/**
	 * Atualiza o campo Preço Final com base nos campos de Margem de Lucro, IPI e
	 * ICMS.
	 * Caso algum campo não possua um valor numérico válido, não atualiza o Preço
	 * Final.
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

	private double calcularPrecoCusto() {
		double ipi;
		double icms;
		double precoCusto = 0;
		double precoFinal = 0;

		try {

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

			if (tfPrecoCusto.getText().equals("")) {
				icms = 0;
			} else {
				icms = Double.parseDouble(tfIcms.getText());
			}

			precoFinal = precoCusto * (1 + (ipi + icms) / 100);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ops Verifique os campos preenchidos");

		}
		return precoFinal;
	}

	Vector<Fornecedor> fornecedor;

	public void consultarFornecedores() {
		try {
			FornecedorController fornecedorController = new FornecedorController();
			fornecedor = fornecedorController.consultarFornecedoresComboBox();

			cbFornecedor.setModel(new DefaultComboBoxModel<>(fornecedor));

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());

		}
	}

	Vector<SubCategoria> subCategoria;
	private JTextField tfSub;

	public void consultarSubcategorias() {
		try {
			SubCategoriaController subCategoriaController = new SubCategoriaController();
			subCategoria = subCategoriaController.consultarSubcategoriasComboBox();

			cbSubCategoria.setModel(new DefaultComboBoxModel<>(subCategoria));
			System.out.println(subCategoria);

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	public void verificarData(JFormattedTextField tfData) {
		if (tfData.getText() != null && tfData.getText().trim().length() == 10) { // Verifica se a data está inserida
																					// por completo
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				sdf.setLenient(false);
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(tfData.getText()));
				int year = cal.get(Calendar.YEAR);

				// Checa se o input do ano está dentro do intervalo permitido
				if (year > 2100 || year < 2020) {
					JOptionPane.showMessageDialog(null, "Insira uma data válida (antes do ano 2100 e depois de 2023).");
					tfData.setText("");
				}
			} catch (ParseException ex) {
				// Ignora, já que a data ainda não está completa
			}
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
	public FrmProdutos() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarProdutos();
				// consultarSubcategorias();
			}
		});

		setBackground(new Color(202, 240, 248));
		getContentPane().setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 799);
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
				// Fechar a janela atual
				SwingUtilities.getWindowAncestor(lblVoltar).dispose();

				// Abrir a janela principal
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
			}
		});
		lblVoltar.setIcon(new ImageIcon(FrmProdutos.class.getResource("/assets/sair.png")));
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(
				gl_panelSuperior.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSuperior.createSequentialGroup()
								.addComponent(lblProdutos)
								.addPreferredGap(ComponentPlacement.RELATED, 957, Short.MAX_VALUE)
								.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGap(46)));
		gl_panelSuperior.setVerticalGroup(
				gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelSuperior.createSequentialGroup()
								.addContainerGap(22, Short.MAX_VALUE)
								.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProdutos))));
		panelSuperior.setLayout(gl_panelSuperior);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelSuperior, GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
						.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 1344, Short.MAX_VALUE)
						.addComponent(panelInferior, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
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
		gl_panelInferior.setHorizontalGroup(
				gl_panelInferior.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelInferior_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1275,
								Short.MAX_VALUE));
		gl_panelInferior.setVerticalGroup(
				gl_panelInferior.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInferior.createSequentialGroup()
								.addContainerGap()
								.addComponent(panelInferior_2, GroupLayout.PREFERRED_SIZE, 49,
										GroupLayout.PREFERRED_SIZE)
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
		lblDescricao.setBounds(158, 121, 102, 17);
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblSubcategoria = new JLabel("Subcategoria: ");
		lblSubcategoria.setBounds(136, 205, 104, 19);
		lblSubcategoria.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(187, 248, 79, 17);
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblQtdEstoque = new JLabel("Quantidade em Estoque: ");
		lblQtdEstoque.setBounds(62, 160, 204, 23);
		lblQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblCodigoDeBarras = new JLabel("Código de Barras:");
		lblCodigoDeBarras.setBounds(104, 77, 162, 23);
		lblCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblDataFabricacao = new JLabel("Data de Fabricação: ");
		lblDataFabricacao.setBounds(92, 289, 170, 17);
		lblDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblLote = new JLabel("Lote: ");
		lblLote.setBounds(197, 333, 67, 17);
		lblLote.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblIcms = new JLabel("ICMS: ");
		lblIcms.setBounds(192, 376, 61, 17);
		lblIcms.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblIpi = new JLabel("IPI:");
		lblIpi.setBounds(211, 419, 42, 17);
		lblIpi.setFont(new Font("Arial", Font.BOLD, 14));

		tfLote = new JTextField();
		tfLote.setBounds(235, 327, 234, 23);
		tfLote.setBackground(Color.WHITE);
		tfLote.setFont(new Font("Arial", Font.BOLD, 14));
		tfLote.setColumns(10);

		tfCodigoDeBarras = new JTextField();
		tfCodigoDeBarras.setBounds(235, 77, 568, 23);
		tfCodigoDeBarras.setBackground(Color.WHITE);
		tfCodigoDeBarras.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigoDeBarras.setColumns(10);

		tfDescricao = new JTextField();
		tfDescricao.setBounds(235, 118, 568, 23);
		tfDescricao.setBackground(Color.WHITE);
		tfDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDescricao.setColumns(10);

		tfQtdEstoque = new JTextField();
		tfQtdEstoque.setToolTipText("Campo disponivel para editar produto");
		tfQtdEstoque.setBounds(235, 160, 162, 23);
		tfQtdEstoque.setBackground(Color.WHITE);
		tfQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));
		tfQtdEstoque.setColumns(10);

		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida: ");
		lblUnidadeDeMedida.setBounds(480, 163, 155, 17);
		lblUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));

		cbUnidadeDeMedida = new JComboBox<String>();
		cbUnidadeDeMedida.setBounds(639, 159, 164, 25);
		cbUnidadeDeMedida.setBackground(Color.WHITE);
		cbUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));
		cbUnidadeDeMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
				"KG", "UN", "CX"
		}));

		cbSubCategoria = new JComboBox<SubCategoria>();
		cbSubCategoria.setEditable(true);
		cbSubCategoria.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				consultarSubcategorias();
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
				cbFornecedor.setEnabled(true);
				tfDataEntrada.setEnabled(true);
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
				cadastrarProdutoFornecedorEstoque();
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
		tfIpi.setBounds(235, 413, 234, 23);
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
		tfIcms.setBounds(235, 370, 234, 23);
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
		lblMargemLucro.setBounds(486, 376, 155, 17);
		lblMargemLucro.setFont(new Font("Arial", Font.BOLD, 14));

		tfMargem = new JTextField();
		tfMargem.setBounds(634, 373, 169, 23);
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
		tfMarca.setBounds(235, 245, 568, 23);
		tfMarca.setBackground(Color.WHITE);
		tfMarca.setFont(new Font("Arial", Font.BOLD, 14));
		tfMarca.setColumns(10);

		tfDataFabricacao = new JTextField();
		tfDataFabricacao.setBounds(235, 286, 239, 23);
		tfDataFabricacao.setBackground(Color.WHITE);
		tfDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataFabricacao.setColumns(10);
		tfDataFabricacao = new JFormattedTextField(new MaskFormatter("##/##/####"));

		tfDataFabricacao.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				verificarData((JFormattedTextField) tfDataFabricacao);
			}

			public void removeUpdate(DocumentEvent e) {
				verificarData((JFormattedTextField) tfDataFabricacao);
			}

			public void insertUpdate(DocumentEvent e) {
				verificarData((JFormattedTextField) tfDataFabricacao);
			}
		});

		JLabel lblPrecoCusto = new JLabel("Preço de Custo: ");
		lblPrecoCusto.setBounds(514, 330, 127, 17);
		lblPrecoCusto.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblValidade = new JLabel("Data de Validade: ");
		lblValidade.setBounds(505, 289, 136, 17);
		lblValidade.setFont(new Font("Arial", Font.BOLD, 14));

		tfValidade = new JTextField();
		tfValidade = new JFormattedTextField(new MaskFormatter("##/##/####"));
		tfValidade.setBackground(Color.WHITE);
		tfValidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfValidade.setColumns(10);

		tfValidade.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				verificarData((JFormattedTextField) tfValidade);
			}

			public void removeUpdate(DocumentEvent e) {
				verificarData((JFormattedTextField) tfValidade);
			}

			public void insertUpdate(DocumentEvent e) {
				verificarData((JFormattedTextField) tfValidade);
			}
		});

		tfPrecoCusto = new JTextField();
		tfPrecoCusto.setBounds(634, 330, 169, 23);
		tfPrecoCusto.setBackground(Color.WHITE);
		tfPrecoCusto.setFont(new Font("Arial", Font.BOLD, 14));
		tfPrecoCusto.setColumns(10);
		tfPrecoCusto.getDocument().addDocumentListener(documentListener);
		tfPrecoCusto.addKeyListener(new KeyAdapter() {
			// Metodo confere se o valor digitado é numerico se não é impede de ser digitado
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == '.')) {
					e.consume();
				}
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(946, 409, 302, 25);
		btnRemover.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(946, 364, 302, 27);
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));

		JPanel painelFotoProduto = new JPanel();
		painelFotoProduto.setBounds(946, 67, 302, 279);
		painelFotoProduto.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JLabel lblPrecoFinal = new JLabel("Preço Final: ");
		lblPrecoFinal.setBounds(537, 419, 87, 17);
		lblPrecoFinal.setFont(new Font("Arial", Font.BOLD, 14));

		tfPrecoFinal = new JTextField();
		tfPrecoFinal.setBounds(634, 416, 169, 23);
		tfPrecoFinal.setBackground(Color.WHITE);
		tfPrecoFinal.setFont(new Font("Arial", Font.BOLD, 14));
		tfPrecoFinal.setColumns(10);
		tfPrecoFinal.setEditable(false);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(173, 30, 54, 17);
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setBounds(235, 29, 302, 20);
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		GroupLayout gl_abaCadastrarProduto = new GroupLayout(abaCadastrarProduto);
		gl_abaCadastrarProduto.setHorizontalGroup(
				gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
						.addComponent(abaDadosProdutos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE));
		gl_abaCadastrarProduto.setVerticalGroup(
				gl_abaCadastrarProduto.createParallelGroup(Alignment.LEADING)
						.addComponent(abaDadosProdutos, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE));
		abaDadosProdutos.setLayout(null);
		abaDadosProdutos.add(lblCodigoDeBarras);
		abaDadosProdutos.add(lblDescricao);
		abaDadosProdutos.add(lblQtdEstoque);
		abaDadosProdutos.add(lblSubcategoria);
		abaDadosProdutos.add(lblMarca);
		abaDadosProdutos.add(lblDataFabricacao);
		abaDadosProdutos.add(lblLote);
		abaDadosProdutos.add(tfCodigoDeBarras);
		abaDadosProdutos.add(tfDescricao);
		abaDadosProdutos.add(tfQtdEstoque);
		abaDadosProdutos.add(lblUnidadeDeMedida);
		abaDadosProdutos.add(cbUnidadeDeMedida);
		abaDadosProdutos.add(cbSubCategoria);
		abaDadosProdutos.add(tfMarca);
		abaDadosProdutos.add(tfDataFabricacao);
		abaDadosProdutos.add(lblValidade);
		abaDadosProdutos.add(tfValidade);
		abaDadosProdutos.add(tfLote);
		abaDadosProdutos.add(lblPrecoCusto);
		abaDadosProdutos.add(tfPrecoCusto);
		abaDadosProdutos.add(tfCodigo);
		abaDadosProdutos.add(lblIcms);
		abaDadosProdutos.add(lblPrecoFinal);
		abaDadosProdutos.add(lblIpi);
		abaDadosProdutos.add(tfIcms);
		abaDadosProdutos.add(lblMargemLucro);
		abaDadosProdutos.add(tfPrecoFinal);
		abaDadosProdutos.add(tfIpi);
		abaDadosProdutos.add(tfMargem);
		abaDadosProdutos.add(btnRemover);
		abaDadosProdutos.add(btnAdicionar);
		abaDadosProdutos.add(painelFotoProduto);
		abaDadosProdutos.add(lblCodigo);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Arial", Font.BOLD, 14));
		lblFornecedor.setBounds(144, 487, 96, 19);
		abaDadosProdutos.add(lblFornecedor);

		JLabel lblDataEntrada = new JLabel("Data de Entrada:");
		lblDataEntrada.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataEntrada.setBounds(116, 450, 115, 17);
		abaDadosProdutos.add(lblDataEntrada);

		tfDataEntrada = new JTextField();
		tfDataEntrada.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataEntrada.setColumns(10);
		tfDataEntrada.setBackground(Color.WHITE);
		tfDataEntrada.setBounds(235, 447, 232, 23);
		abaDadosProdutos.add(tfDataEntrada);

		cbFornecedor = new JComboBox<Fornecedor>();
		consultarFornecedores();

		cbFornecedor.setFont(new Font("Arial", Font.BOLD, 14));
		cbFornecedor.setBackground(Color.WHITE);
		cbFornecedor.setBounds(235, 486, 568, 25);
		abaDadosProdutos.add(cbFornecedor);

		cbSubCategoria = new JComboBox<SubCategoria>();
		cbSubCategoria.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				consultarSubcategorias();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbSubCategoria.setEditable(true);
		cbSubCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		cbSubCategoria.setBackground(Color.WHITE);
		cbSubCategoria.setBounds(235, 202, 177, 25);
		abaDadosProdutos.add(cbSubCategoria);

		tfValidade = new JTextField();
		tfValidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfValidade.setColumns(10);
		tfValidade.setBackground(Color.WHITE);
		tfValidade.setBounds(634, 283, 169, 23);
		abaDadosProdutos.add(tfValidade);

		tfDataFabricacao = new JTextField();
		tfDataFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDataFabricacao.setColumns(10);
		tfDataFabricacao.setBackground(Color.WHITE);
		tfDataFabricacao.setBounds(234, 283, 235, 23);
		abaDadosProdutos.add(tfDataFabricacao);

		tfSub = new JTextField();
		tfSub.setEditable(false);
		tfSub.setFont(new Font("Arial", Font.BOLD, 14));
		tfSub.setBounds(649, 202, 152, 23);
		abaDadosProdutos.add(tfSub);
		tfSub.setColumns(10);

		JLabel lblSubSelecionada = new JLabel("SubCategoria Selecionada: ");
		lblSubSelecionada.setFont(new Font("Arial", Font.BOLD, 14));
		lblSubSelecionada.setBounds(462, 206, 204, 17);
		abaDadosProdutos.add(lblSubSelecionada);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(FrmProdutos.class.getResource("/assets/confirme.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfSub.setText(cbSubCategoria.getSelectedItem().toString());
			}
		});
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfSub.setText(cbSubCategoria.getSelectedItem().toString());
				}
			}
		});
		btnNewButton.setBounds(422, 201, 30, 23);
		abaDadosProdutos.add(btnNewButton);
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
				try {
					consultarProdutoPorNome();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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