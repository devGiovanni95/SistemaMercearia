package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.CategoriaController;
import model.Categoria;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import util.LimparCampos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


// TODO: Auto-generated Javadoc
/**
 * The Class FrmCategoria.
 */
public class FrmCategoria extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The tf codigo. */
	private JTextField tfCodigo;
	
	/** The tf categoria. */
	private JTextField tfCategoria;
	
	/** The tf descricao. */
	private JTextField tfDescricao;
	
	/** The tf pesquisar. */
	private JTextField tfPesquisar;
	
	/** The tabela clientes. */
	private JTable tabelaClientes;
	
	/** The aba dados categoria. */
	private JPanel abaDadosCategoria;
	
	
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
	 * Método utilizado para cadastrar uma nova categoria com as informações preenchidas nos campos do formulário.
	 */
	private void cadastrarCategoria() {
		Categoria categoria = new Categoria();
		CategoriaController categoriaController = new CategoriaController();	
		try {
			categoria.setNomeCategoria(tfCategoria.getText());
			categoria.setDescricao(tfDescricao.getText());					
			categoriaController.cadastrarCategoria(categoria);			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		limparTela(abaDadosCategoria);
	}
	
	
	/**
	 * Metodo utilizado para listar todos as categorias e adiciona-las na tabela.
	 */
	public void consultarCategorias() {
		try {
		CategoriaController categoriaController = new CategoriaController();
		List<Categoria> lista = categoriaController.consultarCategorias();
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaClientes.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(3);
		dadosTabela.addRow(new Object[]{"Código","Nome Categoria","Descrição"});
		

		for(Categoria categoria : lista) {
			dadosTabela.addRow(new Object[]{
					categoria.getCodigo(),
					categoria.getNomeCategoria(),
					categoria.getDescricao()
			
				});
			}
		}catch (Exception erro) {
			JOptionPane.showMessageDialog(null,"Ops aconteceu o erro: " + erro);
		}
	}
	
	
	/**
	* Método utilizado para consultar categoria pelo nome ou parte do nome para exibir na tabela.
	* O texto pesquisado é obtido a partir do texto digitado pelo usuário.
	*/
	private void consultarCategoriasPorNome() {
		String nomePesquisado = "%" + tfPesquisar.getText() + "%";
		
		CategoriaController categoriaController = new CategoriaController();
		List<Categoria> lista = categoriaController.consultarCategoriaPeloNome(nomePesquisado);
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaClientes.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(15);
		dadosTabela.addRow(new Object[]{"Código","Nome Categoria","Descrição"});
		

		for(Categoria categoria: lista) {
			dadosTabela.addRow(new Object[]{
					categoria.getCodigo(),
					categoria.getNomeCategoria(),
					categoria.getDescricao()
				});
			}
	}
	
	/**
	 * Método responsável por preencher os campos da tela principal com os dados da categoria selecionado na tabela para que possam ser alterados.
	 * A partir da linha selecionada na tabela.
	 */
	private void preencherDadosCategoria() {
		
		abaPrincipal.setSelectedIndex(0);
		
		tfCodigo.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),0).toString());
		tfCategoria.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),1).toString());
		tfDescricao.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),2).toString());
	}
	
	
	/**
	Método responsável por alterar os dados de uma categoria cadastrada.
	Os dados são obtidos dos campos de texto na interface gráfica e armazenados em um objeto do tipo Categoria,
	Em seguida, os campos de texto na interface gráfica são limpos através do método Limpar() da classe LimparCampos.
	*/
	private void alterarCategoria() {
		
		Categoria categoria = new Categoria();
		CategoriaController categoriaController = new CategoriaController();	
		
		categoria.setCodigo(Integer.parseInt(tfCodigo.getText()));
		categoria.setNomeCategoria(tfCategoria.getText());
		categoria.setDescricao(tfDescricao.getText());						
		
		categoriaController.alterarCategoria(categoria);
		
		limparTela(abaDadosCategoria);
	}
	
	
	/**
	*Exclui a categoria selecionado na tabela de categoria.
	*Obtém o codigo do cliente a partir do campo de texto correspondente na tela.
	*Em seguida, os campos de texto na interface gráfica são limpos após a exclusão.
	*/
	private void excluirCategoria() {
		
		Categoria categoria = new Categoria();
		CategoriaController categoriaController = new CategoriaController();	

		categoria.setCodigo(Integer.parseInt(tfCodigo.getText()));	
		categoriaController.excluirCategoria(categoria);
		limparTela(abaDadosCategoria);
	
	}
	
	
	/**
	 * Launch the application.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCategoria frame = new FrmCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Ops aconteceu o erro: " );
				}
			}
		});
	}
	
	/** The aba principal. */
	public JTabbedPane abaPrincipal;

	/**
	 * Create the frame.
	 *
	 * @throws ParseException the parse exception
	 */
	public FrmCategoria() throws ParseException {
		setBackground(new Color(202, 240, 248));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				consultarCategorias();
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
		
		abaDadosCategoria = new JPanel();
		abaDadosCategoria.setBackground(new Color(202, 240, 248));
		abaDadosCategoria.setMaximumSize(new Dimension(1360, 768));
		abaPrincipal.addTab("Dados de Categoria", null, abaDadosCategoria, null);
		
		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setBounds(394, 129, 58, 17);
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(462, 126, 190, 22);
		tfCodigo.setEditable(false);
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setColumns(10);
		
		JLabel lblNomeCategoria = new JLabel("Categoria:");
		lblNomeCategoria.setBounds(380, 169, 72, 17);
		lblNomeCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCategoria = new JTextField();
		tfCategoria.setBounds(462, 166, 509, 22);
		tfCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		tfCategoria.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setBounds(380, 209, 78, 17);
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfDescricao = new JTextField();
		tfDescricao.setBounds(462, 206, 509, 22);
		tfDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDescricao.setColumns(10);
		abaDadosCategoria.setLayout(null);
		abaDadosCategoria.add(lblDescricao);
		abaDadosCategoria.add(lbCodigo);
		abaDadosCategoria.add(lblNomeCategoria);
		abaDadosCategoria.add(tfDescricao);
		abaDadosCategoria.add(tfCodigo);
		abaDadosCategoria.add(tfCategoria);
		
		JPanel abaConsultaCategoria = new JPanel();
		abaConsultaCategoria.setBackground(new Color(202, 240, 248));
		abaConsultaCategoria.setForeground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta Categorias", null, abaConsultaCategoria, null);
		
		
		tfPesquisar = new JTextField();
		tfPesquisar.setColumns(10);
		
		JLabel lblNomePesquisa = new JLabel("Nome: ");
		lblNomePesquisa.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				consultarCategoriasPorNome();
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tabelaClientes = new JTable();
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencherDadosCategoria();
			}
		});
		
        tabelaClientes.setFont(new java.awt.Font("Arial", 0, 14)); 
		tabelaClientes.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					
			}
		));
		tabelaClientes.setFillsViewportHeight(true);
		tabelaClientes.setCellSelectionEnabled(true);
		tabelaClientes.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultaCategoria = new GroupLayout(abaConsultaCategoria);
		gl_abaConsultaCategoria.setHorizontalGroup(
			gl_abaConsultaCategoria.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCategoria.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNomePesquisa, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(tfPesquisar, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(548))
				.addComponent(tabelaClientes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1339, Short.MAX_VALUE)
		);
		gl_abaConsultaCategoria.setVerticalGroup(
			gl_abaConsultaCategoria.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCategoria.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_abaConsultaCategoria.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaCategoria.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNomePesquisa))
						.addGroup(gl_abaConsultaCategoria.createSequentialGroup()
							.addGap(5)
							.addComponent(tfPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPesquisar))
					.addGap(4)
					.addComponent(tabelaClientes, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
		);
		abaConsultaCategoria.setLayout(gl_abaConsultaCategoria);
		
		JLabel lblNewLabel = new JLabel("Categorias");
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
		lblNewLabel_1.setIcon(new ImageIcon(FrmCategoria.class.getResource("/assets/sair.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 991, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(32))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addComponent(lblNewLabel))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(36))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 240, 248));
		panel_1.setForeground(new Color(202, 240, 248));
		
		JButton BntNovo = new JButton("Novo");
		BntNovo.setForeground(Color.WHITE);
		BntNovo.setBackground(new Color(106, 76, 147));
		BntNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				new LimparCampos().Limpar(abaDadosCategoria);
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
				alterarCategoria();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnAlterar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCategoria();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCategoria();
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnExcluir);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
				.addComponent(abaPrincipal, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		panel_1.add(panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
