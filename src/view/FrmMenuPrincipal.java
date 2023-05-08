package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmMenuPrincipal.
 */
public class FrmMenuPrincipal extends JFrame {
	
	/** The usuario logado. */
	private String usuarioLogado;
	
	private boolean situacaoCaixa;
	
	/** The lbl nome funcionario logado. */
	private JLabel lblNomeFuncionarioLogado;
	
	private int idAbertura;
	public JMenu mnFuncionarios;
	public JMenu mnClientes;
	public JMenu mnFornecedores;
	public JMenu mnCategoria;
	public JMenu mnEstoque;
	public JMenu mnVendas;
	
	
	

	public int getIdAbertura() {
		return idAbertura;
	}

	public void setIdAbertura(int idAbertura) {
		this.idAbertura = idAbertura;
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public boolean getSituacaoCaixa() {
		return situacaoCaixa;
	}

	public void setSituacaoCaixa(boolean situacaoCaixa) {
		this.situacaoCaixa = situacaoCaixa;
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
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
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
	public FrmMenuPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				lblNomeFuncionarioLogado.setText(usuarioLogado);
			}
		});
		setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		this.setLocationRelativeTo(null);
		
		 setExtendedState(NORMAL); 
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(202, 240, 248));
		setJMenuBar(menuBar);
		
		mnVendas = new JMenu("Ponto de Vendas");
		mnVendas.setFont(new Font("Arial", Font.BOLD, 15));
		mnVendas.setBackground(new Color(202, 240, 248));
		mnVendas.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/ponto-de-venda (1).png")));
		menuBar.add(mnVendas);
		
		JMenuItem mnIrPdv = new JMenuItem("Ir Para PDV");
		mnIrPdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFrenteCaixa frenteCaixa = new FrmFrenteCaixa();
				frenteCaixa.setVisible(true);
			}
		});

		mnIrPdv.setFont(new Font("Arial", Font.BOLD, 15));
		mnIrPdv.setIcon(new ImageIcon(getClass().getResource("/assets/venda.png")));
		mnIrPdv.setSize(35,35);
		mnVendas.add(mnIrPdv);
		
		mnEstoque = new JMenu("Estoque");
		mnEstoque.setFont(new Font("Arial", Font.BOLD, 15));
		mnEstoque.setBackground(new Color(202, 240, 248));
		mnEstoque.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/lista-de-controle.png")));
		menuBar.add(mnEstoque);
		
		JMenuItem mnCadastrarProduto = new JMenuItem("Cadastrar Produto");
		mnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProdutos menu = new FrmProdutos();
				menu.setVisible(true);
			}
		});

		mnCadastrarProduto.setFont(new Font("Arial", Font.BOLD, 15));
		mnCadastrarProduto.setIcon(new ImageIcon(getClass().getResource("/assets/produto.png")));
		mnEstoque.add(mnCadastrarProduto);
		
		JMenuItem mnPesquisarProduto = new JMenuItem("Pesquisar Produto");
		mnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProdutos menu = new FrmProdutos();
				menu.abaPrincipal.setSelectedIndex(1);
				menu.setVisible(true);
			}
		});
	
		mnPesquisarProduto.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/lista-de-controle.png")));
		mnPesquisarProduto.setFont(new Font("Arial", Font.BOLD, 15));
		mnEstoque.add(mnPesquisarProduto);
		
		JMenuItem mnDevolucao = new JMenuItem("Devolução");
		mnDevolucao.setFont(new Font("Arial", Font.BOLD, 15));
		mnDevolucao.setIcon(new ImageIcon(getClass().getResource("/assets/fornecedor.png")));
		mnEstoque.add(mnDevolucao);
		
		mnCategoria = new JMenu("Categorias");
		mnCategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/categorias.png")));
		mnCategoria.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnCategoria);
		
		JMenuItem mnCadastrarCategoria = new JMenuItem("Cadastrar Categoria");
		mnCadastrarCategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/classificacao.png")));
		mnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FrmCategoria frmCategoria = new FrmCategoria();
					frmCategoria.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				}
		});
		mnCategoria.add(mnCadastrarCategoria);
		
		JMenuItem mnCadastrarSubcategoria = new JMenuItem("Cadastrar SubCategoria");
		mnCadastrarSubcategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/categoria.png")));
		mnCategoria.add(mnCadastrarSubcategoria);
		
		JMenuItem mnConsultarCategoria = new JMenuItem("Consultar Categoria");
		mnConsultarCategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/pesquisaCategoria.png")));
		mnCategoria.add(mnConsultarCategoria);
		
		JMenuItem mnConsultarSubcategoria = new JMenuItem("Consultar SubCategorias");
		mnConsultarSubcategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/pesquisa-de-produto.png")));
		mnCategoria.add(mnConsultarSubcategoria);
		
		mnFornecedores = new JMenu("Fornecedores");
		mnFornecedores.setFont(new Font("Arial", Font.BOLD, 15));
		mnFornecedores.setBackground(new Color(202, 240, 248));
		mnFornecedores.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/fornecedor (3).png")));
		menuBar.add(mnFornecedores);
		
		JMenuItem mnCadastrarFornecedor = new JMenuItem("Cadastrar Fornecedor");
		mnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFornecedor menu;
				try {
					menu = new FrmFornecedor();
					menu.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	

			}
		});
		
		mnCadastrarFornecedor.setFont(new Font("Arial", Font.BOLD, 15));
		mnCadastrarFornecedor.setIcon(new ImageIcon(getClass().getResource("/assets/entregador.png")));
		mnFornecedores.add(mnCadastrarFornecedor);
		
		JMenuItem mnConsultarFornecedor = new JMenuItem("Consultar Fornecedor");
		mnConsultarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFornecedor menu;
				try {
					menu = new FrmFornecedor();
					menu.abaPrincipal.setSelectedIndex(1);
					menu.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		mnConsultarFornecedor.setFont(new Font("Arial", Font.BOLD, 15));
		mnConsultarFornecedor.setIcon(new ImageIcon(getClass().getResource("/assets/lista-de-controle.png")));
		mnFornecedores.add(mnConsultarFornecedor);
		
		mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Arial", Font.BOLD, 15));
		mnClientes.setBackground(new Color(202, 240, 248));
		mnClientes.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/cliente.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mnCadastrarClientes = new JMenuItem("Cadastrar Cliente");
		mnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCliente menu;
				try {
					menu = new FrmCliente();
					menu.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnCadastrarClientes.setFont(new Font("Arial", Font.BOLD, 15));
		mnCadastrarClientes.setIcon(new ImageIcon(getClass().getResource("/assets/cliente.png")));
		mnClientes.add(mnCadastrarClientes);
		
		JMenuItem mnConsultarCliente = new JMenuItem("Consultar Cliente");
		mnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCliente menu;
				try {
					menu = new FrmCliente();
					menu.abaPrincipal.setSelectedIndex(1);
					menu.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConsultarCliente.setFont(new Font("Arial", Font.BOLD, 15));
		mnConsultarCliente.setIcon(new ImageIcon(getClass().getResource("/assets/pesquisa.png")));
		mnClientes.add(mnConsultarCliente);
		
		mnFuncionarios = new JMenu("Funcionários");
		mnFuncionarios.setFont(new Font("Arial", Font.BOLD, 15));
		mnFuncionarios.setBackground(new Color(202, 240, 248));
		mnFuncionarios.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/funcionarios.png")));
		menuBar.add(mnFuncionarios);
		
		JMenuItem mnCadastrarFuncionario = new JMenuItem("Cadastrar Funcionário");
		mnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFuncionario menu;
				try {
					menu = new FrmFuncionario();
					menu.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCadastrarFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		mnCadastrarFuncionario.setIcon(new ImageIcon(getClass().getResource("/assets/funcionarios.png")));
		mnFuncionarios.add(mnCadastrarFuncionario);
		
		JMenuItem mnConsultarFuncionario = new JMenuItem("Consultar Funcionário");
		mnConsultarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFuncionario menu;
				try {
					menu = new FrmFuncionario();
					menu.abaPrincipal.setSelectedIndex(1);
					menu.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConsultarFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		mnConsultarFuncionario.setIcon(new ImageIcon(getClass().getResource("/assets/consulta.png")));
		mnFuncionarios.add(mnConsultarFuncionario);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setFont(new Font("Arial", Font.BOLD, 15));
		mnSair.setBackground(new Color(202, 240, 248));
		mnSair.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/sair1.png")));
		menuBar.add(mnSair);
		
		JMenuItem mnSairSistema = new JMenuItem("Sair do Sistema");
		mnSairSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSairSistema.setFont(new Font("Arial", Font.BOLD, 15));
		mnSairSistema.setIcon(new ImageIcon(getClass().getResource("/assets/do-utilizador.png")));
		mnSair.add(mnSairSistema);
		
		JMenuItem mnTrocarUsuario = new JMenuItem("Trocar Usuário");
		mnSair.add(mnTrocarUsuario);
		mnTrocarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					FrmLogin menu = new FrmLogin();
					menu.setVisible(true);

			}
		});
		mnTrocarUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		mnTrocarUsuario.setIcon(new ImageIcon(getClass().getResource("/assets/sair.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(202, 240, 248));
		menuBar.add(panel);
		panel.setLayout(null);
		
		//Criando plano de fundo
		ImageIcon icon = new ImageIcon(getClass().getResource("/assets/fundo.png"));
		Image image = icon.getImage();
		JDesktopPane painelDesktop = new JDesktopPane(){
			public void paintComponent(Graphics g) {
				g.drawImage(image,0,0,getWidth(),getHeight(),this);
			}
		};
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(painelDesktop, GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(painelDesktop, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
		);
		
		JLabel lblUsuarioLogado = new JLabel("Usuário Logado:");
		lblUsuarioLogado.setBounds(0, 666, 137, 25);
		painelDesktop.add(lblUsuarioLogado);
		lblUsuarioLogado.setFont(new Font("Arial", Font.BOLD, 16));
		
		lblNomeFuncionarioLogado = new JLabel("");
		lblNomeFuncionarioLogado.setBounds(131, 666, 173, 25);
		painelDesktop.add(lblNomeFuncionarioLogado);
		lblNomeFuncionarioLogado.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().setLayout(groupLayout);
		JMenuBar barraMenu = new JMenuBar();
		JMenu pontoDeVenda = new JMenu("Arqui");
		barraMenu.add(pontoDeVenda);
	}
}
