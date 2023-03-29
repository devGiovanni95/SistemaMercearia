package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ViewFrenteCaixa extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrenteCaixa frame = new ViewFrenteCaixa();
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
	public ViewFrenteCaixa() {
		getContentPane().setBackground(new Color(175, 205, 253));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setExtendedState(MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1_1_1_3 = new JPanel();
		panel_1_1_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelComandos = new JPanel();
		panelComandos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelComandos.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_1 = new JLabel("Comandos");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 30));
		panelComandos.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel = new JLabel("Caixa Fechado");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 48));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panelComandos_1 = new JPanel();
		panelComandos_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelComandos_1.setBackground(Color.WHITE);
		
		JButton btnNewButton_1_1 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_1 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_1.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_2 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_2.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_3 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_3.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_4 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_4.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_5 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_5.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_6 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_6.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_7 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_7.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnNewButton_1_3_8 = new JButton("F1 - Modo Consulta");
		btnNewButton_1_3_8.setFont(new Font("Arial", Font.BOLD, 22));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1175, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_1_1_1_3, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
										.addComponent(panel_1_1_1_2, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
										.addComponent(panel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
										.addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
									.addGap(2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panelComandos, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1_3_5, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_1_3_3, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_1_3_4, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
											.addGap(18))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_1_3_6, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
											.addGap(18)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1_3_2, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_3_1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton_1_3_8, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1_3_7, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
										.addComponent(btnNewButton_1_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
								.addComponent(panelComandos_1, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))))
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelComandos_1, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(panel_1_1_1_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(panelComandos, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1_1)
								.addComponent(btnNewButton_1_3_8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_3_7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1_3_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_3_6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1_3_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_3_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1_3_5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_3_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addGap(36))
		);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Analise e Desenvolvimento de Software Fatec\\3Semestre\\Poo\\SistemaMercearia\\src\\assets\\carrinho.png"));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(10, 87, 194));
		GroupLayout gl_panel_1_1_1_1 = new GroupLayout(panel_1_1_1_1);
		gl_panel_1_1_1_1.setHorizontalGroup(
			gl_panel_1_1_1_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
		);
		gl_panel_1_1_1_1.setVerticalGroup(
			gl_panel_1_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1_1.createSequentialGroup()
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2_1 = new JLabel("Código de Barras");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel_6.add(lblNewLabel_2_1);
		panel_1_1_1_1.setLayout(gl_panel_1_1_1_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(10, 87, 194));
		GroupLayout gl_panel_1_1_1_3 = new GroupLayout(panel_1_1_1_3);
		gl_panel_1_1_1_3.setHorizontalGroup(
			gl_panel_1_1_1_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1_1_1_3.createSequentialGroup()
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panel_1_1_1_3.setVerticalGroup(
			gl_panel_1_1_1_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1_3.createSequentialGroup()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2_3 = new JLabel("CPF");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel_8.add(lblNewLabel_2_3);
		panel_1_1_1_3.setLayout(gl_panel_1_1_1_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(10, 87, 194));
		GroupLayout gl_panel_1_1_1_2 = new GroupLayout(panel_1_1_1_2);
		gl_panel_1_1_1_2.setHorizontalGroup(
			gl_panel_1_1_1_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1_1_1_2.createSequentialGroup()
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panel_1_1_1_2.setVerticalGroup(
			gl_panel_1_1_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1_2.createSequentialGroup()
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2_2 = new JLabel("Preço Unitário");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_7.add(lblNewLabel_2_2);
		panel_1_1_1_2.setLayout(gl_panel_1_1_1_2);
		GroupLayout gl_panel_1_1_1 = new GroupLayout(panel_1_1_1);
		gl_panel_1_1_1.setHorizontalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
		);
		gl_panel_1_1_1.setVerticalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade De Itens");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_5.add(lblNewLabel_2);
		panel_1_1_1.setLayout(gl_panel_1_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(10, 87, 194));
		GroupLayout gl_panelComandos_1 = new GroupLayout(panelComandos_1);
		gl_panelComandos_1.setHorizontalGroup(
			gl_panelComandos_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
		);
		gl_panelComandos_1.setVerticalGroup(
			gl_panelComandos_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelComandos_1.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1_1 = new JLabel("SubTotal");
		panel_4.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		panelComandos_1.setLayout(gl_panelComandos_1);
		getContentPane().setLayout(groupLayout);
	}
}
