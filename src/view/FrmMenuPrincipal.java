package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controller.FuncionarioController;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.AberturaEFechamentoCaixa;
import model.Funcionario;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmMenuPrincipal.
 */
public class FrmMenuPrincipal extends JFrame {
	
	/** The usuario logado. */
	private String usuarioLogado;
	
	/** The situacao caixa. */
	private boolean situacaoCaixa;
	
	/** The lbl nome funcionario logado. */
	private JLabel lblNomeFuncionarioLogado;
	
	/** The id abertura. */
	private int idAbertura;
	
	/** The mn funcionarios. */
	public JMenu mnFuncionarios;
	
	/** The mn clientes. */
	public JMenu mnClientes;
	
	/** The mn fornecedores. */
	public JMenu mnFornecedores;
	
	/** The mn categoria. */
	public JMenu mnCategoria;
	
	/** The mn estoque. */
	public JMenu mnEstoque;
	
	/** The mn vendas. */
	public JMenu mnVendas;
	
	Funcionario funcionario ;
	
	private String cpfFuncionario;
	
	private AberturaEFechamentoCaixa aberturaEFechamentoCaixa = new AberturaEFechamentoCaixa();
	

	public AberturaEFechamentoCaixa getAberturaEFechamentoCaixa() {
		return aberturaEFechamentoCaixa;
	}

	public void setAberturaEFechamentoCaixa(AberturaEFechamentoCaixa aberturaEFechamentoCaixa) {
		this.aberturaEFechamentoCaixa = aberturaEFechamentoCaixa;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Gets the id abertura.
	 *
	 * @return the id abertura
	 */
	public int getIdAbertura() {
		return idAbertura;
	}

	/**
	 * Sets the id abertura.
	 *
	 * @param idAbertura the new id abertura
	 */
	public void setIdAbertura(int idAbertura) {
		this.idAbertura = idAbertura;
	}

	/**
	 * Gets the usuario logado.
	 *
	 * @return the usuario logado
	 */
	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	/**
	 * Sets the usuario logado.
	 *
	 * @param usuarioLogado the new usuario logado
	 */
	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	/**
	 * Gets the situacao caixa.
	 *
	 * @return the situacao caixa
	 */
	public boolean getSituacaoCaixa() {
		return situacaoCaixa;
	}

	/**
	 * Sets the situacao caixa.
	 *
	 * @param situacaoCaixa the new situacao caixa
	 */
	public void setSituacaoCaixa(boolean situacaoCaixa) {
		this.situacaoCaixa = situacaoCaixa;
	}
	
	
	public Funcionario conferirUsuarioLogado() {
		funcionario = new Funcionario();
		FuncionarioController funcionarioController = new FuncionarioController();
		return funcionario = (Funcionario) funcionarioController.consultarFuncionariosPorCpf(cpfFuncionario);
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
				conferirUsuarioLogado();
				lblNomeFuncionarioLogado.setText(funcionario.getNome());
				System.out.println(funcionario);
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
				frenteCaixa.setFuncionario(funcionario);
				frenteCaixa.setVisible(true);
				dispose();
			}
		});

		mnIrPdv.setFont(new Font("Arial", Font.BOLD, 15));
		mnIrPdv.setIcon(new ImageIcon(getClass().getResource("/assets/venda.png")));
		mnIrPdv.setSize(35,35);
		mnVendas.add(mnIrPdv);
		
		JMenuItem mnRelatoriosVendas = new JMenuItem("Consultar Vendas");
		mnRelatoriosVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmConsultarVenda menu = null;
				dispose();
				menu = new FrmConsultarVenda();
				menu.setVisible(true);
			}
		});
		mnRelatoriosVendas.setFont(new Font("Arial", Font.BOLD, 15));
		mnRelatoriosVendas.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/crescimento.png")));
		mnVendas.add(mnRelatoriosVendas);
		
		mnEstoque = new JMenu("Estoque");
		mnEstoque.setFont(new Font("Arial", Font.BOLD, 15));
		mnEstoque.setBackground(new Color(202, 240, 248));
		mnEstoque.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/lista-de-controle.png")));
		menuBar.add(mnEstoque);
		
		JMenuItem mnCadastrarProduto = new JMenuItem("Cadastrar Produto");
		mnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProdutos menu = null;
				try {
					dispose();
					menu = new FrmProdutos();
				} catch (ParseException ex) {
					throw new RuntimeException(ex);
				}
				menu.setVisible(true);
			}
		});

		mnCadastrarProduto.setFont(new Font("Arial", Font.BOLD, 15));
		mnCadastrarProduto.setIcon(new ImageIcon(getClass().getResource("/assets/produto.png")));
		mnEstoque.add(mnCadastrarProduto);
		
		JMenuItem mnPesquisarProduto = new JMenuItem("Pesquisar Produto");
		mnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProdutos menu = null;
				try {
					menu = new FrmProdutos();
				} catch (ParseException ex) {
					throw new RuntimeException(ex);
				}
				menu.abaPrincipal.setSelectedIndex(1);
				menu.setVisible(true);
				dispose();
			}
		});
	
		mnPesquisarProduto.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/pesquisa-de-produto.png")));
		mnPesquisarProduto.setFont(new Font("Arial", Font.BOLD, 15));
		mnEstoque.add(mnPesquisarProduto);
		
		JMenuItem mnDevolucao = new JMenuItem("Entrada no Estoque");
		mnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmEntradaEstoque menu = null;
				menu = new FrmEntradaEstoque();
				menu.setVisible(true);
				dispose();
			}
		});
		mnDevolucao.setFont(new Font("Arial", Font.BOLD, 15));
		mnDevolucao.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/lista-de-controle.png")));
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
					dispose();
					FrmCategoria frmCategoria = new FrmCategoria();
					frmCategoria.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				}
		});
		mnCategoria.add(mnCadastrarCategoria);
		
		JMenuItem mnCadastrarSubcategoria = new JMenuItem("Cadastrar SubCategoria");
		mnCadastrarSubcategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					FrmSubCategoria frmSubCategoria = new FrmSubCategoria();
					frmSubCategoria.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		mnCadastrarSubcategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/categoria.png")));
		mnCategoria.add(mnCadastrarSubcategoria);
		
		JMenuItem mnConsultarCategoria = new JMenuItem("Consultar Categoria");
		mnConsultarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					FrmCategoria frmCategoria = new FrmCategoria();
					frmCategoria.setVisible(true);
					frmCategoria.abaPrincipal.setSelectedIndex(1);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnConsultarCategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/pesquisaCategoria.png")));
		mnCategoria.add(mnConsultarCategoria);
		
		JMenuItem mnConsultarSubcategoria = new JMenuItem("Consultar SubCategorias");
		mnConsultarSubcategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmSubCategoria frmSubCategoria;
				try {
					dispose();
					frmSubCategoria = new FrmSubCategoria();
					frmSubCategoria.setVisible(true);
					frmSubCategoria.abaPrincipal.setSelectedIndex(1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnConsultarSubcategoria.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/pesquisa-de-produto.png")));
		mnCategoria.add(mnConsultarSubcategoria);
		
		mnFornecedores = new JMenu("Fornecedores");
		mnFornecedores.setFont(new Font("Arial", Font.BOLD, 15));
		mnFornecedores.setBackground(new Color(202, 240, 248));
		mnFornecedores.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/fornecedor (3).png")));
		menuBar.add(mnFornecedores);

		JMenuItem mnCadastrarFornecedor = new JMenuItem("Cadastrar Fornecedor");

		// Para 'Cadastrar Fornecedor'
		mnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFornecedor menu;
				dispose(); // Fecha a janela atual (FrmMenuPrincipal)
				try {
					menu = new FrmFornecedor();
					menu.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mnCadastrarFornecedor.setFont(new Font("Arial", Font.BOLD, 15));
		mnCadastrarFornecedor.setIcon(new ImageIcon(getClass().getResource("/assets/entregador.png")));
		mnFornecedores.add(mnCadastrarFornecedor);

		JMenuItem mnConsultarFornecedor = new JMenuItem("Consultar Fornecedor");

		// Para 'Consultar Fornecedor'
		mnConsultarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFornecedor menu;
				try {
					dispose(); // Fecha a janela atual (FrmMenuPrincipal)
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
					dispose();
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
					dispose();
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
					dispose();
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
					dispose();
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

				dispose();
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
