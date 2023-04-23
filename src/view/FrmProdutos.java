package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmProdutos extends JFrame {
	private JTextField tfLote;
	private JTextField tfCodigoDeBarras;
	private JTextField tfDescricao;
	private JTextField tfQuantidade;
	private JTextField tfIpi;
	private JTextField tfIcms;
	private JTextField tfDesconto;
	private JTextField tfMargem;
	private JTextField tfMarca;
	private JTextField tfFabricacao;
	private JTextField tfValidade;
	private JTextField tfPrecoCusto;
	private JTextField textField;
	private JTextField tfNome;
	private JTable tbProdutos;
	

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

	public JTabbedPane abaPrincipal ;
	/**
	 * Create the frame.
	 */
	public FrmProdutos() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(FrmProdutos.class.getResource("/assets/sair.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(lblProdutos)
					.addPreferredGap(ComponentPlacement.RELATED, 957, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
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
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_2.add(btnSalvar);
		
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
		
		JLabel lblCategoria = new JLabel("Categoria: ");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblQtdEstoque = new JLabel("Quantidade em Estoque: ");
		lblQtdEstoque.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCodigo = new JLabel("Código de Barras:");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Data de Fabricação: ");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		
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
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBackground(Color.WHITE);
		tfQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfQuantidade.setColumns(10);
		
		JLabel lblMedida = new JLabel("Unidade de Medida: ");
		lblMedida.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox cbUnidadeDeMedida = new JComboBox();
		cbUnidadeDeMedida.setBackground(Color.WHITE);
		cbUnidadeDeMedida.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBackground(Color.WHITE);
		cbCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfIpi = new JTextField();
		tfIpi.setBackground(Color.WHITE);
		tfIpi.setFont(new Font("Arial", Font.BOLD, 14));
		tfIpi.setColumns(10);
		
		tfIcms = new JTextField();
		tfIcms.setBackground(Color.WHITE);
		tfIcms.setFont(new Font("Arial", Font.BOLD, 14));
		tfIcms.setColumns(10);
		
		JLabel lblMargemLucro = new JLabel("Margem de Lucro %: ");
		lblMargemLucro.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblDesconto = new JLabel("Aplicar Desconto %: ");
		lblDesconto.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfDesconto = new JTextField();
		tfDesconto.setBackground(Color.WHITE);
		tfDesconto.setFont(new Font("Arial", Font.BOLD, 14));
		tfDesconto.setColumns(10);
		
		tfMargem = new JTextField();
		tfMargem.setBackground(Color.WHITE);
		tfMargem.setFont(new Font("Arial", Font.BOLD, 14));
		tfMargem.setColumns(10);
		
		tfMarca = new JTextField();
		tfMarca.setBackground(Color.WHITE);
		tfMarca.setFont(new Font("Arial", Font.BOLD, 14));
		tfMarca.setColumns(10);
		
		tfFabricacao = new JTextField();
		tfFabricacao.setBackground(Color.WHITE);
		tfFabricacao.setFont(new Font("Arial", Font.BOLD, 14));
		tfFabricacao.setColumns(10);
		
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
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblNewLabel = new JLabel("Preço Final: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Arial", Font.BOLD, 14));
		textField.setColumns(10);
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
											.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(102)
											.addComponent(lblDescricao, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblQtdEstoque, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(100)
											.addComponent(lblCategoria, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(125)
											.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
											.addGap(4))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(30)
											.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
											.addGap(8)))
									.addGap(4))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(135)
									.addComponent(lblLote, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addComponent(tfDescricao, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfQuantidade, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
									.addGap(46)
									.addComponent(lblMedida, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(cbUnidadeDeMedida, 0, 159, Short.MAX_VALUE))
								.addComponent(cbCategoria, 0, 510, Short.MAX_VALUE)
								.addComponent(tfMarca, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfFabricacao, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
									.addGap(31)
									.addComponent(lblValidade, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(tfValidade, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfLote, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
									.addGap(40)
									.addComponent(lblPrecoCusto, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
									.addGap(4)
									.addComponent(tfPrecoCusto, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(130)
									.addComponent(lblIcms, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
								.addComponent(lblNewLabel, Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(149)
									.addComponent(lblIpi, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(tfIcms, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMargemLucro, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
									.addGap(11))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
										.addComponent(tfIpi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(lblDesconto, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfDesconto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(tfMargem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))
					.addGap(143)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(btnAdicionar, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(painelPrincipal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
					.addGap(91))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(21)
							.addComponent(lblDescricao, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(lblQtdEstoque, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(lblMarca, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
							.addGap(24)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
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
									.addComponent(tfQuantidade, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblMedida, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
									.addGap(4))
								.addComponent(cbUnidadeDeMedida, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfMarca, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfFabricacao, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(painelPrincipal, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
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
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfIpi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(6)
											.addComponent(lblIpi, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(5)
									.addComponent(lblDesconto, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(tfDesconto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED, 43, GroupLayout.PREFERRED_SIZE)))))
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
