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

public class FrmMenuPrincipal extends JFrame {

	/**
	 * Launch the application.
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
		setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		this.setLocationRelativeTo(null);
		
		 setExtendedState(NORMAL); 
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(202, 240, 248));
		setJMenuBar(menuBar);
		
		JMenu mnVendas = new JMenu("Ponto de Vendas");
		mnVendas.setFont(new Font("Arial", Font.BOLD, 15));
		mnVendas.setBackground(new Color(202, 240, 248));
		mnVendas.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/ponto-de-venda (1).png")));
		menuBar.add(mnVendas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ir Para PDV");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmFrenteCaixa frenteCaixa = new FrmFrenteCaixa();
				frenteCaixa.setVisible(true);
			}
		});

		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem.setIcon(new ImageIcon(getClass().getResource("/assets/venda.png")));
		mntmNewMenuItem.setSize(35,35);
		mnVendas.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Estoque");
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu_1.setBackground(new Color(202, 240, 248));
		mnNewMenu_1.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/lista-de-controle.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastrar Produto");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProdutos menu = new FrmProdutos();
				menu.setVisible(true);
			}
		});

		mntmNewMenuItem_2.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_2.setIcon(new ImageIcon(getClass().getResource("/assets/produto.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Pesquisar Produto");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProdutos menu = new FrmProdutos();
				menu.abaPrincipal.setSelectedIndex(1);
				menu.setVisible(true);
			}
		});
	
		mntmNewMenuItem_8.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/lista-de-controle.png")));
		mntmNewMenuItem_8.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Devolução");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_1.setIcon(new ImageIcon(getClass().getResource("/assets/fornecedor.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Fornecedores");
		mnNewMenu_3.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu_3.setBackground(new Color(202, 240, 248));
		mnNewMenu_3.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/fornecedor (3).png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cadastrar Fornecedor");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
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
		
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_3.setIcon(new ImageIcon(getClass().getResource("/assets/entregador.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Consultar Fornecedor");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
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

		mntmNewMenuItem_4.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_4.setIcon(new ImageIcon(getClass().getResource("/assets/lista-de-controle.png")));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Clientes");
		mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu_2.setBackground(new Color(202, 240, 248));
		mnNewMenu_2.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/cliente.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cadastrar Cliente");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_5.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_5.setIcon(new ImageIcon(getClass().getResource("/assets/cliente.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("Consultar Cliente");
		mntmNewMenuItem_5_1.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_5_1.setIcon(new ImageIcon(getClass().getResource("/assets/pesquisa.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5_1);
		
		JMenu mnNewMenu_4 = new JMenu("Funcionários");
		mnNewMenu_4.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu_4.setBackground(new Color(202, 240, 248));
		mnNewMenu_4.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/funcionarios.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_5_3 = new JMenuItem("Cadastrar Funcionário");
		mntmNewMenuItem_5_3.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_5_3.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_5_3.setIcon(new ImageIcon(getClass().getResource("/assets/funcionarios.png")));
		mnNewMenu_4.add(mntmNewMenuItem_5_3);
		
		JMenuItem mntmNewMenuItem_5_2 = new JMenuItem("Consultar Funcionário");
		mntmNewMenuItem_5_2.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_5_2.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_5_2.setIcon(new ImageIcon(getClass().getResource("/assets/consulta.png")));
		mnNewMenu_4.add(mntmNewMenuItem_5_2);
		
		JMenu mnNewMenu_5 = new JMenu("Acessos");
		mnNewMenu_5.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu_5.setBackground(new Color(202, 240, 248));
		mnNewMenu_5.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/acesso.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_5_4 = new JMenuItem("Alterar Acessos");
		mntmNewMenuItem_5_4.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_5_4.setIcon(new ImageIcon(getClass().getResource("/assets/acesso.png")));
		mnNewMenu_5.add(mntmNewMenuItem_5_4);
		
		JMenu mnNewMenu_6 = new JMenu("Configuração");
		mnNewMenu_6.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu_6.setBackground(new Color(202, 240, 248));
		mnNewMenu_6.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/configuracao2.png")));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_5_5 = new JMenuItem("Configurar");
		mntmNewMenuItem_5_5.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_5_5.setIcon(new ImageIcon(getClass().getResource("/assets/configuracao.png")));
		mnNewMenu_6.add(mntmNewMenuItem_5_5);
		
		JMenu mnNewMenu = new JMenu("Sair");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 15));
		mnNewMenu.setBackground(new Color(202, 240, 248));
		mnNewMenu.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/sair1.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Trocar Usuário");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					FrmLogin menu = new FrmLogin();
					menu.setVisible(true);

			}
		});
		mntmNewMenuItem_6.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_6.setIcon(new ImageIcon(getClass().getResource("/assets/sair.png")));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Sair do Sistema");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Arial", Font.BOLD, 15));
		mntmNewMenuItem_7.setIcon(new ImageIcon(getClass().getResource("/assets/do-utilizador.png")));
		mnNewMenu.add(mntmNewMenuItem_7);
		
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
		getContentPane().setLayout(groupLayout);
		JMenuBar barraMenu = new JMenuBar();
		JMenu pontoDeVenda = new JMenu("Arqui");
		barraMenu.add(pontoDeVenda);
	}
}
