package view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 663);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVendas = new JMenu("Ponto de Vendas");
		mnVendas.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/ponto-de-venda (1).png")));
		menuBar.add(mnVendas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ir Para PDV");
		mntmNewMenuItem.setIcon(new ImageIcon(getClass().getResource("/assets/venda.png")));
		mntmNewMenuItem.setSize(35,35);
		mnVendas.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Estoque");
		mnNewMenu_1.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/lista-de-controle.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastrar Produto");
		mntmNewMenuItem_2.setIcon(new ImageIcon(getClass().getResource("/assets/produto.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Devolução");
		mntmNewMenuItem_1.setIcon(new ImageIcon(getClass().getResource("/assets/fornecedor.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Fornecedores");
		mnNewMenu_3.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/fornecedor (3).png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cadastrar Fornecedor");
		mntmNewMenuItem_3.setIcon(new ImageIcon(getClass().getResource("/assets/entregador.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Consultar Fornecedor");
		mntmNewMenuItem_4.setIcon(new ImageIcon(getClass().getResource("/assets/lista-de-controle.png")));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Clientes");
		mnNewMenu_2.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/cliente.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cadastrar Cliente");
		mntmNewMenuItem_5.setIcon(new ImageIcon(getClass().getResource("/assets/cliente.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("Consultar Cliente");
		mntmNewMenuItem_5_1.setIcon(new ImageIcon(getClass().getResource("/assets/pesquisa.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5_1);
		
		JMenu mnNewMenu_4 = new JMenu("Funcionários");
		mnNewMenu_4.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/funcionarios.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_5_3 = new JMenuItem("Cadastrar Funcionário");
		mntmNewMenuItem_5_3.setIcon(new ImageIcon(getClass().getResource("/assets/funcionarios.png")));
		mnNewMenu_4.add(mntmNewMenuItem_5_3);
		
		JMenuItem mntmNewMenuItem_5_2 = new JMenuItem("Consultar Funcionário");
		mntmNewMenuItem_5_2.setIcon(new ImageIcon(getClass().getResource("/assets/consulta.png")));
		mnNewMenu_4.add(mntmNewMenuItem_5_2);
		
		JMenu mnNewMenu_5 = new JMenu("Acessos");
		mnNewMenu_5.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/acesso.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_5_4 = new JMenuItem("Alterar Acessos");
		mntmNewMenuItem_5_4.setIcon(new ImageIcon(getClass().getResource("/assets/acesso.png")));
		mnNewMenu_5.add(mntmNewMenuItem_5_4);
		
		JMenu mnNewMenu_6 = new JMenu("Configuração");
		mnNewMenu_6.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/configuracao2.png")));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_5_5 = new JMenuItem("Configurar");
		mntmNewMenuItem_5_5.setIcon(new ImageIcon(getClass().getResource("/assets/configuracao.png")));
		mnNewMenu_6.add(mntmNewMenuItem_5_5);
		
		JMenu mnNewMenu = new JMenu("Sair");
		mnNewMenu.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/assets/sair1.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Trocar Usuário");
		mntmNewMenuItem_6.setIcon(new ImageIcon(getClass().getResource("/assets/sair.png")));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Sair do Sistema");
		mntmNewMenuItem_7.setIcon(new ImageIcon(getClass().getResource("/assets/do-utilizador.png")));
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		
		//Creindo plano de fundo
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
