package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controller.ItemVendaController;
import controller.VendaController;
import model.ItemVenda;
import model.Venda;
import util.LimparCampos;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmProdutos.
 */
public class FrmConsultarVenda extends JFrame {

	/** The tf nome. */
	private JTextField tfPesquisar;

	/** The tb produtos. */
	private JTable tabelaVendas;

	/** this layer is for the "Cadastrar Produto" tab. */
	private JLayeredPane abaConsultarItens;

	/** The aba dados produtos. */
	private JPanel abaDadosItens;

	/** The aba principal. */
	public JTabbedPane abaPrincipal;

	/** Objeto da classe LimparCampos. */
	private LimparCampos limparCampos;
	private JTextField tfCodigo;
	private JTextField tfCliente;
	private JTextField tfFuncionario;
	private JTextField tfCodPagamento;
	private JTextField tfDataVenda;
	private JTextField tfValorVenda;
	private JTable tabelaItens;

	/**
	 * Limpar tela.
	 *
	 * @param tela the tela
	 */
	private void limparTela(JPanel tela) {
		LimparCampos limpar = new LimparCampos();
		limpar.Limpar(tela);
	}

	/**
	 * Limpar tela.
	 *
	 * @param tela the tela
	 */
	private void limparTabela(JTable table) {
		LimparCampos limpar = new LimparCampos();
		limpar.resetarTabela(table);
	}

	/**
	 * Consultar venda por nome.
	 *//*
		 * private void consultarProdutoPorNome(){ String nomePesquisado = "%" +
		 * tfPesquisar.getText() + "%"; ProdutosController produtosController = new
		 * ProdutosController(); SubCategoriaController categoriaController = new
		 * SubCategoriaController(); List<Produto> lista =
		 * produtosController.consultarProdutoPorNome(nomePesquisado); DefaultTableModel
		 * dadosTabela = (DefaultTableModel) tabelaVendas.getModel();
		 * dadosTabela.setNumRows(0); dadosTabela.setColumnCount(15);
		 * dadosTabela.addRow(new Object[]{"Codigo","Descrição", "Codigo de Barras",
		 * "Marca", "SubCategoria", "Unidade de Medida", "Quantidade",
		 * " Fabricação"," Validade","Lote", "IPI","ICMS","Margem Lucro","Preco Custo",
		 * "Preço Final"});
		 * 
		 * for(Produto produto : lista) { dadosTabela.addRow(new Object[]{
		 * produto.getCodigo(), produto.getDescricao(), produto.getCodigoDeBarras(),
		 * produto.getMarca(), produto.getSubCategoria().getNome(),
		 * produto.getUnidadeDeMedida(), produto.getQuantidade(),
		 * produto.getDataFabricacao(), produto.getDataValidade(), produto.getLote(),
		 * produto.getIpi(), produto.getIcms(), produto.getMargemLucro(),
		 * produto.getPrecoCusto(), produto.getPrecoFinal() }); } }
		 */

	/**
	 * Metodo utilizado para listar todas as vendas e adiciona-los na tabela.
	 */
	public void consultarVendas() {
		try {
			VendaController vendaController = new VendaController();
			List<Venda> lista = vendaController.consultarVendas();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaVendas.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(6);
			dadosTabela.addRow(new Object[] { "Código", "Cliente", "Funcionario", "Forma de Pagamento", "Data da Venda",
					"Valor venda" });
			String aux;

			for (Venda venda : lista) {

				if (venda.getCliente().getNome() == null) {
					aux = "Cliente não informado";
				} else {
					aux = venda.getCliente().getNome();
				}
				
				dadosTabela.addRow(new Object[] { venda.getCodigo(), aux, venda.getFuncionario().getNome(),
						venda.getFormaPagamento().getCodigo(), venda.getDataVenda().replace("-", "/"), venda.getValorVenda()});
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: " + erro);
		}
	}

	/**
	 * Metodo utilizado para listar todas as vendas e adiciona-los na tabela.
	 */
	public void consultarItens() {
		try {
			ItemVendaController itemVendaController = new ItemVendaController();
			List<ItemVenda> lista = itemVendaController.consultarItensVendaPorCodigo(tfCodigo.getText());
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaItens.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(6);
			dadosTabela.addRow(new Object[] { "Código de Barras", "Descrição", "Quantidade Produtos", "Tipo",
					"Preço Unit.", "Subtotal" });

			for (ItemVenda item : lista) {
				dadosTabela.addRow(new Object[] {

						item.getProduto().getCodigoDeBarras(), item.getProduto().getDescricao(), item.getQuantidade(),
						item.getProduto().getUnidadeDeMedida(), item.getPrecoUnitario(), item.getSubtotal() });
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: " + erro);
			System.out.println(erro);
		}
	}

	/*
	 * Metodo para preencher os campos da tela com os dados da venda selecionada na
	 * tabela.
	 */
	private void preencherDadosVendas() {
		abaPrincipal.setSelectedIndex(1);

		tfCodigo.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 0).toString());

		try {
			tfCliente.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 1).toString());
		} catch (NullPointerException e) {
			tfCliente.setText("Não Informado");
		}

		tfFuncionario.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 2).toString());
		tfCodPagamento.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 3).toString());
		tfDataVenda.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 4).toString());
		tfValorVenda.setText(tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 5).toString());

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
					FrmConsultarVenda frame = new FrmConsultarVenda();
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
	public FrmConsultarVenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarVendas();
			}
		});

		setBackground(new Color(202, 240, 248));
		getContentPane().setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1399, 768);
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

		JLabel lblProdutos = new JLabel("Vendas");
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

		lblVoltar.setIcon(new ImageIcon(FrmConsultarVenda.class.getResource("/assets/sair.png")));
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addComponent(lblProdutos)
						.addPreferredGap(ComponentPlacement.RELATED, 1003, Short.MAX_VALUE)
						.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addGap(46)));
		gl_panelSuperior.setVerticalGroup(gl_panelSuperior.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSuperior.createSequentialGroup().addContainerGap(22, Short.MAX_VALUE)
						.addGroup(gl_panelSuperior.createParallelGroup(Alignment.LEADING).addComponent(lblProdutos)
								.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))));
		panelSuperior.setLayout(gl_panelSuperior);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelSuperior, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

		JLayeredPane abaConsultarVenda = new JLayeredPane();
		abaConsultarVenda.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta de Vendas", null, abaConsultarVenda, null);

		JLabel lblNomePesquisa = new JLabel("Data:");
		lblNomePesquisa.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomePesquisa.setBounds(10, 35, 48, 17);
		abaConsultarVenda.add(lblNomePesquisa);

		tfPesquisar = new JTextField();
		tfPesquisar.setColumns(10);
		tfPesquisar.setBounds(63, 34, 380, 20);
		abaConsultarVenda.add(tfPesquisar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPesquisar.setBounds(460, 30, 137, 25);
		abaConsultarVenda.add(btnPesquisar);

		tfCodigo = new JTextField();

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		tabelaVendas = new JTable();
		tabelaVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherDadosVendas();
				// limparCampos.resetarTabela(tabelaItens);
				limparTabela(tabelaItens);
			}

		});

		tabelaVendas.setFont(new Font("Arial", Font.PLAIN, 14));
		tabelaVendas.setFillsViewportHeight(true);
		tabelaVendas.setColumnSelectionAllowed(true);
		tabelaVendas.setCellSelectionEnabled(true);
		tabelaVendas.setBounds(0, 63, 1378, 478);
		abaConsultarVenda.add(tabelaVendas);

		abaConsultarItens = new JLayeredPane();
		abaConsultarItens.setBackground(new Color(202, 240, 248));
		abaConsultarItens.setBorder(null);
		abaPrincipal.addTab("Consultar Itens de Venda", null, abaConsultarItens, null);

		abaDadosItens = new JPanel();
		abaDadosItens.setForeground(new Color(0, 0, 0));
		abaDadosItens.setBorder(null);
		abaDadosItens.setBackground(new Color(202, 240, 248));

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(106, 76, 147));
		btnNovo.setForeground(new Color(255, 255, 255));
		btnNovo.setFont(new Font("Arial", Font.BOLD, 24));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTela(abaDadosItens);
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
				// cadastrarProduto();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior_2.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// excluirProduto();
			}
		});
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panelInferior_2.add(btnExcluir);

		JPanel espacoDireito = new JPanel();
		espacoDireito.setBackground(new Color(202, 240, 248));
		panelInferior_2.add(espacoDireito);
		GroupLayout gl_abaConsultarItens = new GroupLayout(abaConsultarItens);
		gl_abaConsultarItens.setHorizontalGroup(gl_abaConsultarItens.createParallelGroup(Alignment.LEADING)
				.addComponent(abaDadosItens, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		gl_abaConsultarItens.setVerticalGroup(gl_abaConsultarItens.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultarItens.createSequentialGroup()
						.addComponent(abaDadosItens, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblFuncionrio = new JLabel("Funcionário:");
		lblFuncionrio.setFont(new Font("Arial", Font.BOLD, 15));

		tfCodigo.setFont(new Font("Arial", Font.BOLD, 15));
		tfCodigo.setColumns(10);

		tfCliente = new JTextField();
		tfCliente.setFont(new Font("Arial", Font.BOLD, 15));
		tfCliente.setColumns(10);

		tfFuncionario = new JTextField();
		tfFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		tfFuncionario.setColumns(10);

		JLabel lblFormaPagamento = new JLabel("Código Pagamento:");
		lblFormaPagamento.setFont(new Font("Arial", Font.BOLD, 15));

		tfCodPagamento = new JTextField();
		tfCodPagamento.setFont(new Font("Arial", Font.BOLD, 15));
		tfCodPagamento.setColumns(10);

		JLabel lblDataVenda = new JLabel("Data Venda:");
		lblDataVenda.setFont(new Font("Arial", Font.BOLD, 15));

		tfDataVenda = new JTextField();
		tfDataVenda.setFont(new Font("Arial", Font.BOLD, 15));
		tfDataVenda.setColumns(10);

		JLabel lblValorVenda = new JLabel("Valor Venda:");
		lblValorVenda.setFont(new Font("Arial", Font.BOLD, 15));

		tfValorVenda = new JTextField();
		tfValorVenda.setFont(new Font("Arial", Font.BOLD, 15));
		tfValorVenda.setColumns(10);

		tabelaItens = new JTable();

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consultarItens();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 15));
		GroupLayout gl_abaDadosItens = new GroupLayout(abaDadosItens);
		gl_abaDadosItens.setHorizontalGroup(gl_abaDadosItens.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosItens.createSequentialGroup().addContainerGap().addGroup(gl_abaDadosItens
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosItens.createSequentialGroup()
								.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfCliente, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblFuncionrio)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfFuncionario,
										GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosItens.createSequentialGroup().addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnConsultar,
										GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblFormaPagamento)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfCodPagamento, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDataVenda)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfDataVenda, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblValorVenda).addGap(4)
						.addComponent(tfValorVenda, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addGap(27))
				.addComponent(tabelaItens, GroupLayout.DEFAULT_SIZE, 1378, Short.MAX_VALUE));
		gl_abaDadosItens.setVerticalGroup(gl_abaDadosItens.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosItens.createSequentialGroup().addGap(19)
						.addGroup(gl_abaDadosItens.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar))
						.addGap(36)
						.addGroup(gl_abaDadosItens.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfCliente, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFuncionrio, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfFuncionario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfDataVenda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblValorVenda, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfValorVenda, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFormaPagamento, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfCodPagamento, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataVenda, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tabelaItens, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE).addGap(0)));
		abaDadosItens.setLayout(gl_abaDadosItens);
		abaConsultarItens.setLayout(gl_abaConsultarItens);
		getContentPane().setLayout(groupLayout);
	}
}
