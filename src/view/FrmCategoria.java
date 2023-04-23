package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.CategoriaController;
import controller.ClienteController;
import model.Categoria;
import model.Cliente;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import util.LimparCampos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class FrmCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfCategoria;
	private JTextField tfDescricao;
	private JTextField tfPesquisar;
	private JTable tabelaClientes;
	
	
	/**
	 * Metodo utilizado para listar todos os clientes e adiciona-los na tabela
	 */
	public void listar() {
		try {
		CategoriaController categoriaController = new CategoriaController();
		List<Categoria> lista = categoriaController.listarCategorias();
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
	 * Launch the application.
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
	public JTabbedPane abaPrincipal;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FrmCategoria() throws ParseException {
		setBackground(new Color(202, 240, 248));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				listar();
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
		
		JPanel abaDadosCategoria = new JPanel();
		abaDadosCategoria.setBackground(new Color(202, 240, 248));
		abaDadosCategoria.setMaximumSize(new Dimension(1360, 768));
		abaPrincipal.addTab("Dados de Categoria", null, abaDadosCategoria, null);
		
		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setColumns(10);
		
		JLabel lblNomeCategoria = new JLabel("Categoria:");
		lblNomeCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCategoria = new JTextField();
		tfCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		tfCategoria.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfDescricao = new JTextField();
		tfDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		tfDescricao.setColumns(10);
		GroupLayout gl_abaDadosCategoria = new GroupLayout(abaDadosCategoria);
		gl_abaDadosCategoria.setHorizontalGroup(
			gl_abaDadosCategoria.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_abaDadosCategoria.createSequentialGroup()
					.addContainerGap(380, Short.MAX_VALUE)
					.addGroup(gl_abaDadosCategoria.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescricao)
						.addGroup(gl_abaDadosCategoria.createParallelGroup(Alignment.TRAILING)
							.addComponent(lbCodigo)
							.addComponent(lblNomeCategoria)))
					.addGroup(gl_abaDadosCategoria.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosCategoria.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosCategoria.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_abaDadosCategoria.createParallelGroup(Alignment.LEADING)
								.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfCategoria, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))))
					.addGap(368))
		);
		gl_abaDadosCategoria.setVerticalGroup(
			gl_abaDadosCategoria.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosCategoria.createSequentialGroup()
					.addGap(126)
					.addGroup(gl_abaDadosCategoria.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCodigo)
						.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosCategoria.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeCategoria)
						.addComponent(tfCategoria, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosCategoria.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescricao)
						.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(248, Short.MAX_VALUE))
		);
		abaDadosCategoria.setLayout(gl_abaDadosCategoria);
		
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
				
				String nomePesquisado = "%" + tfPesquisar.getText() + "%";
				
					ClienteController clienteController = new ClienteController();
					List<Cliente> lista = clienteController.buscarClientePeloNome(nomePesquisado);
					DefaultTableModel dadosTabela = (DefaultTableModel) tabelaClientes.getModel();
					dadosTabela.setNumRows(0);
					dadosTabela.setColumnCount(15);
					dadosTabela.addRow(new Object[]{"Nome","E-mail","CPF","RG","Endereço","Telefone","Celular","Numero","CEP","Data Nascimento", "Bairro","Cidade","UF","Complemento","Limite"});
					

					for(Cliente cliente : lista) {
						dadosTabela.addRow(new Object[]{
								cliente.getNome(),
								cliente.getEmail(),
								cliente.getCpf(),
								cliente.getRg(),
								cliente.getEndereco(),
								cliente.getTelefone(),
								cliente.getCelular(),
								cliente.getNumero(),
								cliente.getCep(),
								cliente.getDataNascimento(),
								cliente.getBairro(),
								cliente.getCidade(),
								cliente.getUf(),
								cliente.getComplemento(),
								cliente.getLimite()		
							});
						}
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tabelaClientes = new JTable();
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pega os dados
				abaPrincipal.setSelectedIndex(0);
				
				tfCodigo.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),0).toString());
				tfCategoria.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),1).toString());
				tfDescricao.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),2).toString());
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
				
				Categoria categoria = new Categoria();
				
				categoria.setCodigo(Integer.parseInt(tfCodigo.getText()));
				categoria.setNomeCategoria(tfCategoria.getText());
				categoria.setDescricao(tfDescricao.getText());
						
				
				CategoriaController categoriaController = new CategoriaController();	
				
				categoriaController.alterarCategoria(categoria);
				
				new LimparCampos().Limpar(abaDadosCategoria);
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnAlterar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoria = new Categoria();
				
				categoria.setCodigo(Integer.parseInt(tfCodigo.getText()));
				categoria.setNomeCategoria(tfCategoria.getText());
				categoria.setDescricao(tfDescricao.getText());
				
				CategoriaController categoriaController = new CategoriaController();	
				
				categoriaController.cadastrarCategoria(categoria);
				
				new LimparCampos().Limpar(abaDadosCategoria);
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Categoria categoria = new Categoria();

				categoria.setCodigo(Integer.parseInt(tfCodigo.getText()));

				CategoriaController categoriaController = new CategoriaController();	
				
				categoriaController.cadastrarCategoria(categoria);
				
				new LimparCampos().Limpar(abaDadosCategoria);
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
