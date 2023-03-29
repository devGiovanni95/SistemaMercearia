package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class ViewMenuPrincipal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenuPrincipal frame = new ViewMenuPrincipal();
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
	public ViewMenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 663);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVendas = new JMenu("Ponto de Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ir Para PDV");
		mntmNewMenuItem.setSelectedIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\de-dinheiro.png"));
		mntmNewMenuItem.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\venda.png"));
		mntmNewMenuItem.setSize(35,35);
		mnVendas.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Estoque");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastrar Produto");
		mntmNewMenuItem_2.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\produto.png"));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Devolução");
		mntmNewMenuItem_1.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\fornecedor.png"));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("Fornecedores");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cadastrar Fornecedor");
		mntmNewMenuItem_3.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\entregador.png"));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Consultar Fornecedor");
		mntmNewMenuItem_4.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\lista-de-controle.png"));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cadastrar Cliente");
		mntmNewMenuItem_5.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\cliente.png"));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_5_1 = new JMenuItem("Consultar Cliente");
		mntmNewMenuItem_5_1.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\pesquisa.png"));
		mnNewMenu_2.add(mntmNewMenuItem_5_1);
		
		JMenu mnNewMenu_4 = new JMenu("Funcionários");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_5_3 = new JMenuItem("Cadastrar Funcionário");
		mntmNewMenuItem_5_3.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\funcionarios.png"));
		mnNewMenu_4.add(mntmNewMenuItem_5_3);
		
		JMenuItem mntmNewMenuItem_5_2 = new JMenuItem("Consultar Funcionário");
		mntmNewMenuItem_5_2.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\consulta.png"));
		mnNewMenu_4.add(mntmNewMenuItem_5_2);
		
		JMenu mnNewMenu_5 = new JMenu("Acessos");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_5_4 = new JMenuItem("Alterar Acessos");
		mntmNewMenuItem_5_4.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\acesso.png"));
		mnNewMenu_5.add(mntmNewMenuItem_5_4);
		
		JMenu mnNewMenu_6 = new JMenu("Configuração");
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_5_5 = new JMenuItem("Configurar");
		mntmNewMenuItem_5_5.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\configuracao.png"));
		mnNewMenu_6.add(mntmNewMenuItem_5_5);
		
		JMenu mnNewMenu = new JMenu("Sair");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Trocar Usuário");
		mntmNewMenuItem_6.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\sair.png"));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Sair do Sistema");
		mntmNewMenuItem_7.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\do-utilizador.png"));
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		JMenuBar barraMenu = new JMenuBar();
		JMenu pontoDeVenda = new JMenu("Arqui");
		barraMenu.add(pontoDeVenda);
	}

}
