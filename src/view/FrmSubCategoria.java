package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import controller.CategoriaController;
import controller.SubCategoriaController;
import model.Categoria;
import model.SubCategoria;
import util.LimparCampos;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmSubCategoria.
 */
public class FrmSubCategoria extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The tf codigo. */
	private JTextField tfCodigo;

	/** The tf nome sub categoria. */
	private JTextField tfNomeSubCategoria;

	/** The tf descricao. */
	private JTextField tfDescricao;

	/** The tf pesquisar. */
	private JTextField tfPesquisar;

	/** The tabela sub categorias. */
	private JTable tabelaSubCategorias;

	/** The aba dados sub categorias. */
	private JPanel abaDadosSubCategorias;

	/** The aba principal. */
	public JTabbedPane abaPrincipal;

	/** The cb categoria. */
	private JComboBox<Categoria> cbCategoria;

	/**
	 * Método responsavel por limpar a tela referenciada.
	 *
	 * @param tela the tela
	 */
	private void limparTela(JPanel tela) {
		LimparCampos limpar = new LimparCampos();
		limpar.Limpar(tela);
	}

	/**
	 * Metodo utilizado para listar todos os clientes e adiciona-los na tabela.
	 */
	public void consultarSubCategorias() {
		try {
			SubCategoriaController subCategoriaController = new SubCategoriaController();
			CategoriaController categoriaController = new CategoriaController();
			List<SubCategoria> lista = subCategoriaController.consultarSubCategorias();
			DefaultTableModel dadosTabela = (DefaultTableModel) tabelaSubCategorias.getModel();
			dadosTabela.setNumRows(0);
			dadosTabela.setColumnCount(4);
			dadosTabela.addRow(new Object[] { "Código", "SubCategoria", "Categoria", "Descrição" });

			for (SubCategoria subCategoria : lista) {
				dadosTabela.addRow(new Object[] {
						subCategoria.getCodigo(),
						subCategoria.getNome(),
						categoriaController.consultarCategoriasPorId(subCategoria.getCategoria().getCodigo()),
						subCategoria.getDescricao()
				});
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: " + erro);
		}

	}

	/**
	 * Método utilizado para consultar subCategoria pelo nome ou parte do nome para
	 * exibir na tabela.
	 * O texto pesquisado é obtido a partir do texto digitado pelo usuario.
	 */
	private void consultarSubCategoriaPorNome() {
		String nomePesquisado = "%" + tfPesquisar.getText() + "%";

		SubCategoriaController subCategoriaController = new SubCategoriaController();
		List<SubCategoria> lista = (List<SubCategoria>) subCategoriaController
				.consultarSubCategoriaPorNome(nomePesquisado);
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaSubCategorias.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(4);
		dadosTabela.addRow(new Object[] { "Código", "SubCategoria", "Categoria", "Descrição" });

		for (SubCategoria subCategoria : lista) {
			dadosTabela.addRow(new Object[] {
					subCategoria.getCodigo(),
					subCategoria.getNome(),
					subCategoria.getCategoria().getNomeCategoria(),
					subCategoria.getDescricao()

			});
		}
	}

	/**
	 * Método responsável por preencher os campos da tela principal com os dados da
	 * subCategoria selecionado na tabela para que possam ser alterados.
	 * A partir da linha selecionada na tabela.
	 */
	private void preencherDadosSubCategoria() {
		abaPrincipal.setSelectedIndex(0);

		tfCodigo.setText(tabelaSubCategorias.getValueAt(tabelaSubCategorias.getSelectedRow(), 0).toString());
		cbCategoria.setSelectedItem(tabelaSubCategorias.getValueAt(tabelaSubCategorias.getSelectedRow(), 1).toString());
		tfNomeSubCategoria.setText(tabelaSubCategorias.getValueAt(tabelaSubCategorias.getSelectedRow(), 2).toString());
		// Nao esta atualizando no combobox
		try {
			tfDescricao.setText(tabelaSubCategorias.getValueAt(tabelaSubCategorias.getSelectedRow(), 3).toString());
		} catch (Exception e) {
			tfDescricao.setText("Não informado");
		}
	}

	/**
	 * Método responsável por alterar os dados de uma subCategoria cadastrada.
	 * Os dados são obtidos dos campos de texto na interface gráfica e armazenados
	 * em um objeto do tipo SubCategoria,
	 * Em seguida, os campos de texto na interface gráfica são limpos através do
	 * método limparTela da classe LimparCampos.
	 */
	private void alterarSubCategoria() {
		SubCategoria subCategoria = new SubCategoria();
		SubCategoriaController subCategoriaController = new SubCategoriaController();
		Categoria categoria = new Categoria();

		subCategoria.setCodigo(Integer.parseInt(tfCodigo.getText()));
		subCategoria.setNome(tfNomeSubCategoria.getText());
		subCategoria.setDescricao(tfDescricao.getText());

		// transformando o item do combo box em objeto de categoria
		categoria = (Categoria) cbCategoria.getSelectedItem();
		// salvando o objeto fornecedor
		subCategoria.setCategoria(categoria);

		subCategoriaController.alterarSubCategoria(subCategoria);
 
		limparTela(abaDadosSubCategorias);
	}

	/**
	 * Exclui a subCategoria selecionado na tabela de subCategorias.
	 * Obtém o código da subCategoria a partir do campo de texto correspondente na
	 * tela.
	 * Em seguida, os campos de texto na interface gráfica são limpos após a
	 * exclusão.
	 */
	private void excluirSubCategoria() {

		SubCategoria subCategoria = new SubCategoria();
		SubCategoriaController subCategoriaController = new SubCategoriaController();

		subCategoria.setCodigo(Integer.parseInt(tfCodigo.getText()));
		subCategoriaController.excluirSubCategoria(subCategoria);
		limparTela(abaDadosSubCategorias);
	}

	Vector<Categoria> idCategoria;

	public void consultarCategorias() {
		try {
			CategoriaController categoriaController = new CategoriaController();
			idCategoria = categoriaController.consultarCategoriasComboBox();

			cbCategoria.setModel(new DefaultComboBoxModel<>(idCategoria));

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
					FrmSubCategoria frame = new FrmSubCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: ");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @throws ParseException the parse exception
	 */
	public FrmSubCategoria() throws ParseException {
		setBackground(new Color(202, 240, 248));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarSubCategorias();
			}
		});
		setForeground(new Color(24, 52, 70));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAutoRequestFocus(false);
		setBounds(100, 100, 1364, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 240, 248));
		contentPane.setForeground(new Color(202, 240, 248));
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(22, 138, 173));

		abaPrincipal = new JTabbedPane(JTabbedPane.TOP);
		abaPrincipal.setBackground(new Color(202, 240, 248));

		abaDadosSubCategorias = new JPanel();
		abaDadosSubCategorias.setBackground(new Color(202, 240, 248));
		abaDadosSubCategorias.setMaximumSize(new Dimension(1360, 768));
		abaPrincipal.addTab("Dados de SubCategoria", null, abaDadosSubCategorias, null);

		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));

		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setColumns(10);

		JLabel lblNomeSubCategoria = new JLabel("SubCategoria:");
		lblNomeSubCategoria.setFont(new Font("Arial", Font.BOLD, 14));

		tfNomeSubCategoria = new JTextField();
		tfNomeSubCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		tfNomeSubCategoria.setColumns(10);

		JLabel lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));

		tfDescricao = new JTextField();
		tfDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDescricao.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");

		lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));

		// Verificar

		// categoria
		cbCategoria = new JComboBox<Categoria>();
		cbCategoria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

			}
		});
		cbCategoria.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				consultarCategorias();
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		cbCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout gl_abaDadosSubCategorias = new GroupLayout(abaDadosSubCategorias);
		gl_abaDadosSubCategorias.setHorizontalGroup(
				gl_abaDadosSubCategorias.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_abaDadosSubCategorias.createSequentialGroup()
								.addContainerGap(364, Short.MAX_VALUE)
								.addGroup(gl_abaDadosSubCategorias.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_abaDadosSubCategorias.createSequentialGroup()
												.addGroup(
														gl_abaDadosSubCategorias.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblDescricao)
																.addComponent(lblNomeSubCategoria))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_abaDadosSubCategorias
														.createParallelGroup(Alignment.LEADING)
														.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, 509,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(tfNomeSubCategoria, GroupLayout.PREFERRED_SIZE,
																509, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_abaDadosSubCategorias.createSequentialGroup()
												.addGroup(
														gl_abaDadosSubCategorias.createParallelGroup(Alignment.TRAILING)
																.addComponent(lbCodigo)
																.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE,
																		72, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(
														gl_abaDadosSubCategorias.createParallelGroup(Alignment.LEADING)
																.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 190,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE,
																		509, GroupLayout.PREFERRED_SIZE))))
								.addGap(357)));
		gl_abaDadosSubCategorias.setVerticalGroup(
				gl_abaDadosSubCategorias.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosSubCategorias.createSequentialGroup()
								.addGap(131)
								.addGroup(gl_abaDadosSubCategorias.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbCodigo))
								.addGap(18)
								.addGroup(gl_abaDadosSubCategorias.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_abaDadosSubCategorias.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfNomeSubCategoria, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNomeSubCategoria))
								.addGap(18)
								.addGroup(gl_abaDadosSubCategorias.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDescricao)
										.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(203, Short.MAX_VALUE)));
		abaDadosSubCategorias.setLayout(gl_abaDadosSubCategorias);

		JPanel abaConsultaSubCategorias = new JPanel();
		abaConsultaSubCategorias.setBackground(new Color(202, 240, 248));
		abaConsultaSubCategorias.setForeground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta SubCategorias", null, abaConsultaSubCategorias, null);

		tfPesquisar = new JTextField();
		tfPesquisar.setColumns(10);

		JLabel lblNomePesquisa = new JLabel("Nome: ");
		lblNomePesquisa.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarSubCategoriaPorNome();
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));

		tabelaSubCategorias = new JTable();
		tabelaSubCategorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherDadosSubCategoria();
			}

		});

		tabelaSubCategorias.setFont(new java.awt.Font("Arial", 0, 14));
		tabelaSubCategorias.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {

				}));
		tabelaSubCategorias.setFillsViewportHeight(true);
		tabelaSubCategorias.setCellSelectionEnabled(true);
		tabelaSubCategorias.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultaSubCategorias = new GroupLayout(abaConsultaSubCategorias);
		gl_abaConsultaSubCategorias.setHorizontalGroup(
				gl_abaConsultaSubCategorias.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaSubCategorias.createSequentialGroup()
								.addGap(31)
								.addComponent(lblNomePesquisa, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
								.addGap(8)
								.addComponent(tfPesquisar, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
								.addGap(20)
								.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
								.addGap(548))
						.addComponent(tabelaSubCategorias, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1339,
								Short.MAX_VALUE));
		gl_abaConsultaSubCategorias.setVerticalGroup(
				gl_abaConsultaSubCategorias.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaSubCategorias.createSequentialGroup()
								.addGap(7)
								.addGroup(gl_abaConsultaSubCategorias.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaConsultaSubCategorias.createSequentialGroup()
												.addGap(4)
												.addComponent(lblNomePesquisa))
										.addGroup(gl_abaConsultaSubCategorias.createSequentialGroup()
												.addGap(5)
												.addComponent(tfPesquisar, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnPesquisar))
								.addGap(4)
								.addComponent(tabelaSubCategorias, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)));
		abaConsultaSubCategorias.setLayout(gl_abaConsultaSubCategorias);

		JLabel lblNewLabel = new JLabel("SubCategorias");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));

		JLabel lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Fechar a janela atual
				SwingUtilities.getWindowAncestor(lblNewLabel_1).dispose();

				// Abrir a janela principal
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
			}
		});

		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setIcon(new ImageIcon(FrmSubCategoria.class.getResource("/assets/sair.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED, 991, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1)
								.addGap(32)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addContainerGap(49, Short.MAX_VALUE)
								.addComponent(lblNewLabel))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addContainerGap(38, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1)
								.addGap(36)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 240, 248));
		panel_1.setForeground(new Color(202, 240, 248));

		JButton BntNovo = new JButton("Novo");
		BntNovo.setForeground(Color.WHITE);
		BntNovo.setBackground(new Color(106, 76, 147));
		BntNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LimparCampos().Limpar(abaDadosSubCategorias);
			}
		});
		panel_1.setLayout(new GridLayout(0, 6, 20, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(202, 240, 248));
		panel_1.add(panel_3);
		BntNovo.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(BntNovo);

		JButton btnAlterar = new JButton("Editar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setBackground(new Color(255, 202, 58));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarSubCategoria();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnAlterar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SubCategoria subCategoria = new SubCategoria();
				Categoria categoria = new Categoria();

				subCategoria.setCodigo(Integer.parseInt(tfCodigo.getText()));
				subCategoria.setNome(tfNomeSubCategoria.getText());
				subCategoria.setDescricao(tfDescricao.getText());

				// transformando o item do combo box em objeto de categoria
				categoria = (Categoria) cbCategoria.getSelectedItem();
				// salvando o objeto fornecedor
				subCategoria.setCategoria(categoria);

				SubCategoriaController subCategoriaController = new SubCategoriaController();

				subCategoriaController.cadastrarSubCategoria(subCategoria);

				new LimparCampos().Limpar(abaDadosSubCategorias);
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirSubCategoria();
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnExcluir);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
						.addComponent(abaPrincipal, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(36, Short.MAX_VALUE)));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		panel_1.add(panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
