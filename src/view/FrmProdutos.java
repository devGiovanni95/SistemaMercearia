package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

import controller.ProdutosController;
import controller.SubCategoriaController;
import model.Produtos;
import model.SubCategoria;



public class FrmProdutos extends JFrame {
	private JTextField tfLote;
	private JTextField tfCodigoDeBarras;
	private JTextField tfDescricao;
	private JTextField tfQtdEstoque;
	private JTextField tfIpi;
	private JTextField tfIcms;
	private JTextField tfMargem;
	private JTextField tfMarca;
	private JTextField tfDataFabricacao;
	private JTextField tfValidade;
	private JTextField tfPrecoCusto;
	private JTextField tfPrecoFinal;
	private JTextField tfNome;
	private JTable tbProdutos;
	// Declaração do JComboBox cbSubcategoria e cbUnidadeDeMedida como variáveis de instância.
	private JComboBox cbSubcategoria;
    private JComboBox<String> cbUnidadeDeMedida;

	/**
	 * Launch the application.
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
	 * Atualiza o campo Preço Final com base nos campos de Margem de Lucro, IPI e ICMS.
	 * Caso algum campo não possua um valor numérico válido, não atualiza o Preço Final.
	 */
	private void atualizarPrecoFinal() {
	    try {
	        double margem = Double.parseDouble(tfMargem.getText());
	        double ipi = Double.parseDouble(tfIpi.getText());
	        double icms = Double.parseDouble(tfIcms.getText());
	        double precoCusto = Double.parseDouble(tfPrecoCusto.getText());

	        double precoFinal = precoCusto * (1 + (margem + ipi + icms) / 100);
	        tfPrecoFinal.setText(String.format("%.2f", precoFinal));
	    } catch (NumberFormatException e) {
	        // Um dos campos não possui um número válido
	    }
	}

	   // Método privado popularSubcategorias() responsável por preencher o JComboBox cbSubcategoria com as subcategorias disponíveis.
	private void popularSubcategorias() {
        SubCategoriaController subCategoriaController = new SubCategoriaController();    // Criação de uma instância do SubCategoriaController para obter a lista de subcategorias.
        List<SubCategoria> listaSubcategoria = subCategoriaController.listarSubCategorias();     // Chamada ao método listarSubCategorias() do SubCategoriaController para obter a lista de subcategorias.

        // Remoção de todos os itens do JComboBox cbSubcategoria para garantir que ele esteja limpo.
        cbSubcategoria.removeAllItems();

        // Loop for-each para iterar sobre cada subcategoria na lista de subcategorias.
        for (SubCategoria subcategoria : listaSubcategoria) {
            cbSubcategoria.addItem(subcategoria);      // Adição de cada subcategoria ao JComboBox cbSubcategoria.
        }
    }
	
	  // Método privado popularUnidadesDeMedida() responsável por preencher o JComboBox cbUnidadeDeMedida.
    private void popularUnidadesDeMedida() {
        // Lista das unidades de medida disponíveis.
        List<String> unidadesDeMedida = Arrays.asList("kg", "g", "mg", "L", "ml", "unidades");

        // Loop for-each para iterar sobre cada unidade de medida na lista de unidades de medida.
        for (String unidadeDeMedida : unidadesDeMedida) {
            // Adição de cada unidade de medida ao JComboBox cbUnidadeDeMedida.
            cbUnidadeDeMedida.addItem(unidadeDeMedida);
        }
    }

	public JTabbedPane abaPrincipal ;
	/**
	 * Create the frame.
	 */
	
	// Construtor da classe frmProdutos.
	public FrmProdutos() {
		
		cbSubcategoria = new JComboBox();  // Criação do JComboBox cbSubcategoria.
        popularSubcategorias();  // Chamada ao método popularSubcategorias() para preencher o JComboBox cbSubcategoria com as subcategorias disponíveis.

     // Criação do JComboBox cbUnidadeDeMedida e popular com as unidades de medida disponíveis.
        cbUnidadeDeMedida = new JComboBox<>();
        popularUnidadesDeMedida();
		
		setBackground(new Color(202, 240, 248));
		getContentPane().setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		this.setLocationRelativeTo(null);
		
		
		abaPrincipal = new JTabbedPane(JTabbedPane.TOP);
		abaPrincipal.setBorder(null);
		abaPrincipal.setBackground(new Color(202, 240, 248));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(202, 240, 248));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(22, 138, 173));
		
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
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(lblProdutos)
					.addPreferredGap(ComponentPlacement.RELATED, 957, Short.MAX_VALUE)
					.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblVoltar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProdutos)))
		);
		panel_3.setLayout(gl_panel_3);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
				.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 1344, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(new GridLayout(0, 6, 10, 0));
		
		JPanel espacoEsquerdo = new JPanel();
		espacoEsquerdo.setBackground(new Color(202, 240, 248));
		panel_2.add(espacoEsquerdo);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(106, 76, 147));
		btnNovo.setForeground(new Color(255, 255, 255));
		btnNovo.setFont(new Font("Arial", Font.BOLD, 24));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(255, 202, 58));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_2.add(btnEditar);
		
		
		JButton btnSalvarProduto = new JButton("Salvar");
		btnSalvarProduto.setForeground(Color.WHITE);
		btnSalvarProduto.setBackground(new Color(138, 201, 38));
		btnSalvarProduto.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Produtos produto = new Produtos();
		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		        produto.setDescricao(tfDescricao.getText());
		        produto.setCodigoDeBarras(tfCodigoDeBarras.getText());
		        produto.setMarca(tfMarca.getText());
		        produto.setSubcategoria((SubCategoria) cbSubcategoria.getSelectedItem());
		        produto.setUnidadeDeMedida(cbUnidadeDeMedida.getSelectedItem().toString());
		        produto.setQuantidade(Integer.parseInt(tfQtdEstoque.getText()));
		        
		        try {
		            produto.setDataFabricacao(dateFormat.parse(tfDataFabricacao.getText()));
		            produto.setDataValidade(dateFormat.parse(tfValidade.getText()));
		        } catch (ParseException ex) {
		            JOptionPane.showMessageDialog(null, "Erro ao converter a data. Por favor, insira a data no formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        produto.setLote(tfLote.getText());
		        produto.setIpi(Double.parseDouble(tfIpi.getText()));
		        produto.setIcms(Double.parseDouble(tfIcms.getText()));
		        produto.setMargemLucro(Double.parseDouble(tfMargem.getText()));
		        produto.setPrecoCusto(Double.parseDouble(tfPrecoCusto.getText()));
		     
		        // Calcular o preço final com base na margem de lucro, IPI e ICMS
		        atualizarPrecoFinal();

		        ProdutosController produtosController = new ProdutosController(); 
		        
		        produtosController.cadastrarProduto(produto);
		        
		    }
		});
		btnSalvarProduto.setFont(new Font("Arial", Font.BOLD, 24));
		panel_2.add(btnSalvarProduto);

		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panel_2.add(btnExcluir);
		
		JPanel espacoDireito = new JPanel();
		espacoDireito.setBackground(new Color(202, 240, 248));
		panel_2.add(espacoDireito);
		panel_1.setLayout(gl_panel_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(202, 240, 248));
		layeredPane.setBorder(null);
		abaPrincipal.addTab("Cadastro Produtos", null, layeredPane, null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(null);
		panel.setBackground(new Color(202, 240, 248));
		
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
		
		JComboBox cbUnidadeDeMedida = new JComboBox();
		cbUnidadeDeMedida.setBackground(Color.WHITE);
		cbUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox cbSubcategoria = new JComboBox();
		cbSubcategoria.setBackground(Color.WHITE);
		cbSubcategoria.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		
		
		/*
		cbSubcategoria = new JComboBox();
		cbSubcategoria.addAncestorListener(new AncestorListener() {
		    public void ancestorAdded(AncestorEvent event) {
		        // Listando categorias dentro do combobox
		        SubCategoriaController subCategoriaController = new SubCategoriaController();
		        List<SubCategoria> listaSubcategoria = subCategoriaController.listarSubCategorias();

		        // Removendo para limpar todos os campos
		        cbSubcategoria.removeAllItems();

		        // Colocando dentro do combobox todos os dados
		        for (SubCategoria subcategoria : listaSubcategoria) {
		            cbSubcategoria.addItem(subcategoria);
		        }
		    }

		    @Override
		    public void ancestorMoved(AncestorEvent event) {
		    }

		    @Override
		    public void ancestorRemoved(AncestorEvent event) {
		    }
		}); */
		
		
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
		
		tfIcms = new JTextField();
		tfIcms.setBackground(Color.WHITE);
		tfIcms.setFont(new Font("Arial", Font.BOLD, 14));
		tfIcms.setColumns(10);
		tfIcms.getDocument().addDocumentListener(documentListener);
		
		JLabel lblMargemLucro = new JLabel("Margem de Lucro %: ");
		lblMargemLucro.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfMargem = new JTextField();
		tfMargem.setBackground(Color.WHITE);
		tfMargem.setFont(new Font("Arial", Font.BOLD, 14));
		tfMargem.setColumns(10);
		tfMargem.getDocument().addDocumentListener(documentListener);

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
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(42)
											.addComponent(lblCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(102)
											.addComponent(lblDescricao, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblQtdEstoque, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(100)
											.addComponent(lblSubcategoria, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(125)
											.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(30)
											.addComponent(lblDataFabricacao, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
											.addGap(8)))
									.addGap(4))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(135)
									.addComponent(lblLote, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addComponent(tfDescricao, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfQtdEstoque, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addGap(46)
									.addComponent(lblUnidadeDeMedida, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(cbUnidadeDeMedida, 0, 165, Short.MAX_VALUE))
								.addComponent(cbSubcategoria, 0, 530, Short.MAX_VALUE)
								.addComponent(tfMarca, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfDataFabricacao, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
									.addGap(31)
									.addComponent(lblValidade, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(tfValidade, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfLote, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
									.addGap(40)
									.addComponent(lblPrecoCusto, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(tfPrecoCusto, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(130)
									.addComponent(lblIcms, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
								.addComponent(lblPrecoFinal, Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(149)
									.addComponent(lblIpi, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfIcms, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMargemLucro, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
									.addGap(11))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(tfPrecoFinal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
										.addComponent(tfIpi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
									.addGap(174)))
							.addComponent(tfMargem, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
					.addGap(143)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
						.addComponent(btnAdicionar, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
						.addComponent(painelFotoProduto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
					.addGap(91))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(21)
							.addComponent(lblDescricao, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(lblQtdEstoque, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(lblSubcategoria, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
							.addGap(24)
							.addComponent(lblDataFabricacao, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(44))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(tfCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(tfDescricao, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(tfQtdEstoque, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblUnidadeDeMedida, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
									.addGap(4))
								.addComponent(cbUnidadeDeMedida, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(cbSubcategoria, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfMarca, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfDataFabricacao, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(lblValidade, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfValidade, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(tfLote, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(lblLote, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(lblPrecoCusto, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfPrecoCusto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(painelFotoProduto, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
							.addGap(4)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfIcms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblIcms, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)))
							.addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(14)
									.addComponent(btnAdicionar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfMargem, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMargemLucro, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfIpi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblIpi, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPrecoFinal)
								.addComponent(tfPrecoFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(99))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE)
		);
		layeredPane.setLayout(gl_layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta de Produtos", null, layeredPane_1, null);
		
		JLabel lblNomePesquisa = new JLabel("Nome: ");
		lblNomePesquisa.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomePesquisa.setBounds(10, 35, 48, 17);
		layeredPane_1.add(lblNomePesquisa);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(63, 34, 380, 20);
		layeredPane_1.add(tfNome);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPesquisar.setBounds(460, 30, 137, 25);
		layeredPane_1.add(btnPesquisar);
		
		tbProdutos = new JTable();
		tbProdutos.setFont(new Font("Arial", Font.PLAIN, 14));
		tbProdutos.setFillsViewportHeight(true);
		tbProdutos.setColumnSelectionAllowed(true);
		tbProdutos.setCellSelectionEnabled(true);
		tbProdutos.setBounds(0, 57, 1339, 469);
		layeredPane_1.add(tbProdutos);
		getContentPane().setLayout(groupLayout);
	}
}
