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

// TODO: Auto-generated Javadoc
/**
 * The Class FrmFrenteCaixa.
 */
public class FrmFrenteCaixa extends JFrame {
	
	/** The text field. */
	private JTextField textField;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The text field 3. */
	private JTextField textField_3;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(Color.WHITE);
		
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
		panel_5.setBounds(1, 1, 309, 31);
		panel_5.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel = new JLabel("Caixa Fechado");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 48));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panelComandos_1 = new JPanel();
		panelComandos_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelComandos_1.setBackground(Color.WHITE);
		
		JPanel painelComandos = new JPanel();
		painelComandos.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(2)
											.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(panel_1_1_1_3, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(panel_1_1_1_2, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(panel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
										.addComponent(panelComandos, GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
									.addGap(19))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(painelComandos, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
								.addComponent(panelComandos_1, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))))
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
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelComandos_1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_1_1_1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_1_1_1_2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addGap(15)
									.addComponent(panel_1_1_1_3, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(panelComandos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(painelComandos, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(416)
					.addComponent(lblNewLabel)
					.addContainerGap(496, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(lblNewLabel))
		);
		panel.setLayout(gl_panel);
		
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
		GroupLayout gl_painelComandos = new GroupLayout(painelComandos);
		gl_painelComandos.setHorizontalGroup(
			gl_painelComandos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_4, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_5, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_2, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_6, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_3, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_7, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
				.addGroup(gl_painelComandos.createSequentialGroup()
					.addComponent(btnNewButton_1_1_8, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnNewButton_1_1_9, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
		);
		gl_painelComandos.setVerticalGroup(
			gl_painelComandos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelComandos.createSequentialGroup()
					.addGroup(gl_painelComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1)
						.addComponent(btnNewButton_1_1_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelComandos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1_7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelComandos.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_1_1_8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		painelComandos.setLayout(gl_painelComandos);
		panel_1_1_1_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(1, 1, 309, 31);
		panel_6.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_1 = new JLabel("Código de Barras");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel_6.add(lblNewLabel_2_1);
		panel_1_1_1_1.add(panel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1, 31, 310, 38);
		panel_1_1_1_1.add(textField_2);
		textField_2.setColumns(10);
		panel_1_1_1_3.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(1, 1, 309, 31);
		panel_8.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_3 = new JLabel("CPF");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel_8.add(lblNewLabel_2_3);
		panel_1_1_1_3.add(panel_8);
		
		textField = new JTextField();
		textField.setBounds(0, 31, 310, 39);
		panel_1_1_1_3.add(textField);
		textField.setColumns(10);
		panel_1_1_1_2.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(1, 1, 309, 31);
		panel_7.setBackground(new Color(10, 87, 194));
		
		JLabel lblNewLabel_2_2 = new JLabel("Preço Unitário");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_7.add(lblNewLabel_2_2);
		panel_1_1_1_2.add(panel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 30, 310, 39);
		panel_1_1_1_2.add(textField_1);
		textField_1.setColumns(10);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade De Itens");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_5.add(lblNewLabel_2);
		panel_1_1_1.add(panel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(1, 29, 310, 40);
		panel_1_1_1.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(10, 87, 194));
		GroupLayout gl_panelComandos_1 = new GroupLayout(panelComandos_1);
		gl_panelComandos_1.setHorizontalGroup(
			gl_panelComandos_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
		);
		gl_panelComandos_1.setVerticalGroup(
			gl_panelComandos_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelComandos_1.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1_1 = new JLabel("SubTotal");
		panel_4.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		panelComandos_1.setLayout(gl_panelComandos_1);
		getContentPane().setLayout(groupLayout);
	}
}
