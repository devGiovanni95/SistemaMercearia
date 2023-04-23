package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class FrmFrenteCaixa extends JFrame {
	private JTextField tfCpf;
	private JTextField tfPrecoUnitario;
	private JTextField tfCodigoDeBarras;
	private JTextField tfQuantidadeDeItens;
	private JTable listaProdutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFrenteCaixa frame = new FrmFrenteCaixa();
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
	public FrmFrenteCaixa() {
		getContentPane().setBackground(new Color(175, 205, 253));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		this.setLocationRelativeTo(null);
		
		JPanel painelCabecalho = new JPanel();
		painelCabecalho.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelCabecalho.setBackground(Color.WHITE);
		
		JPanel painelQuantidadeDeItens = new JPanel();
		painelQuantidadeDeItens.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel painelCodigoDeBarras = new JPanel();
		painelCodigoDeBarras.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel painelPrecoUnitario = new JPanel();
		painelPrecoUnitario.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel painelCpf = new JPanel();
		painelCpf.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel painelComandos = new JPanel();
		painelComandos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelComandos.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_1 = new JLabel("Comandos");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		painelComandos.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(1, 1, 309, 31);
		panel_5.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel = new JLabel("Caixa Fechado");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 48));
		
		JPanel painelListaProdutos = new JPanel();
		painelListaProdutos.setBackground(new Color(255, 255, 255));
		painelListaProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel painelSubTotal = new JPanel();
		painelSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		painelSubTotal.setBackground(Color.WHITE);
		
		JPanel painelBotoesComandos = new JPanel();
		painelBotoesComandos.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JPanel painelImagemProduto = new JPanel();
		painelImagemProduto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(painelCabecalho, GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(2)
											.addComponent(painelImagemProduto, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(painelCpf, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(painelPrecoUnitario, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(painelCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(painelQuantidadeDeItens, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
										.addComponent(painelComandos, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
									.addGap(19))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelBotoesComandos, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(painelListaProdutos, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
								.addComponent(painelSubTotal, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))))
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(painelCabecalho, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(painelListaProdutos, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelSubTotal, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelQuantidadeDeItens, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(painelCodigoDeBarras, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(painelPrecoUnitario, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addGap(15)
									.addComponent(painelCpf, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelImagemProduto, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(painelComandos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelBotoesComandos, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		
		listaProdutos = new JTable();
		painelListaProdutos.add(listaProdutos);
		GroupLayout gl_painelCabecalho = new GroupLayout(painelCabecalho);
		gl_painelCabecalho.setHorizontalGroup(
			gl_painelCabecalho.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCabecalho.createSequentialGroup()
					.addGap(416)
					.addComponent(lblNewLabel)
					.addContainerGap(496, Short.MAX_VALUE))
		);
		gl_painelCabecalho.setVerticalGroup(
			gl_painelCabecalho.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_painelCabecalho.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(lblNewLabel))
		);
		painelCabecalho.setLayout(gl_painelCabecalho);
		
		JButton btnNewButton_1_1 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_1 = new JButton("F2 - Nota Fiscal Paulista");
		btnNewButton_1_1_1.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_2 = new JButton("F10 - Finalizar Venda");
		btnNewButton_1_1_2.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_3 = new JButton("F11 - Cancelar Item");
		btnNewButton_1_1_3.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_4 = new JButton("F3 - Abrir Caixa");
		btnNewButton_1_1_4.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_5 = new JButton("F4 - Fechar Caixa");
		btnNewButton_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_5.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_6 = new JButton("F5 - Sangria");
		btnNewButton_1_1_6.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_7 = new JButton("F6 - Trocar Usuário");
		btnNewButton_1_1_7.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_8 = new JButton("F12 - Cancelar Venda");
		btnNewButton_1_1_8.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_1_9 = new JButton("F7 - Sair");
		btnNewButton_1_1_9.setFont(new Font("Arial", Font.BOLD, 22));
		GroupLayout gl_painelBotoesComandos = new GroupLayout(painelBotoesComandos);
		gl_painelBotoesComandos.setHorizontalGroup(
			gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_4, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_5, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_2, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_6, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_3, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_7, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_8, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_9, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
		);
		gl_painelBotoesComandos.setVerticalGroup(
			gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelBotoesComandos.createSequentialGroup()
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1)
						.addComponent(btnNewButton_1_1_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelBotoesComandos.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_1_1_8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		painelBotoesComandos.setLayout(gl_painelBotoesComandos);
		painelCodigoDeBarras.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(1, 1, 309, 31);
		panel_6.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_1 = new JLabel("Código de Barras");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel_6.add(lblNewLabel_2_1);
		painelCodigoDeBarras.add(panel_6);
		
		tfCodigoDeBarras = new JTextField();
		tfCodigoDeBarras.setBounds(1, 31, 310, 38);
		painelCodigoDeBarras.add(tfCodigoDeBarras);
		tfCodigoDeBarras.setColumns(10);
		painelCpf.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(1, 1, 309, 31);
		panel_8.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_3 = new JLabel("CPF");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel_8.add(lblNewLabel_2_3);
		painelCpf.add(panel_8);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(0, 31, 310, 39);
		painelCpf.add(tfCpf);
		tfCpf.setColumns(10);
		painelPrecoUnitario.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(1, 1, 309, 31);
		panel_7.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_2 = new JLabel("Preço Unitário");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_7.add(lblNewLabel_2_2);
		painelPrecoUnitario.add(panel_7);
		
		tfPrecoUnitario = new JTextField();
		tfPrecoUnitario.setBounds(0, 30, 310, 39);
		painelPrecoUnitario.add(tfPrecoUnitario);
		tfPrecoUnitario.setColumns(10);
		painelQuantidadeDeItens.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade De Itens");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_5.add(lblNewLabel_2);
		painelQuantidadeDeItens.add(panel_5);
		
		tfQuantidadeDeItens = new JTextField();
		tfQuantidadeDeItens.setBounds(1, 29, 310, 40);
		painelQuantidadeDeItens.add(tfQuantidadeDeItens);
		tfQuantidadeDeItens.setColumns(10);
		
		JPanel tituloSubtotal = new JPanel();
		tituloSubtotal.setBackground(new Color(10, 87, 194));
		
		JLabel lblSubTotal = new JLabel("");
		GroupLayout gl_painelSubTotal = new GroupLayout(painelSubTotal);
		gl_painelSubTotal.setHorizontalGroup(
			gl_painelSubTotal.createParallelGroup(Alignment.LEADING)
				.addComponent(tituloSubtotal, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
				.addComponent(lblSubTotal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
		);
		gl_painelSubTotal.setVerticalGroup(
			gl_painelSubTotal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelSubTotal.createSequentialGroup()
					.addComponent(tituloSubtotal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblSubTotal, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblNewLabel_1_1 = new JLabel("SubTotal");
		tituloSubtotal.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		painelSubTotal.setLayout(gl_painelSubTotal);
		getContentPane().setLayout(groupLayout);
	}
}
