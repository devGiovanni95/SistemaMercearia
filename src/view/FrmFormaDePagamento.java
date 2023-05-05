package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmFormaDePagamento extends JFrame {

	private JPanel contentPane;
	private JTextField tfValor;
	private JTextField tfFormaPagamento;
	private JTextField tfTotalCompra;
	private JTextField tfTroco;
	private JTextField tfValorRestante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFormaDePagamento frame = new FrmFormaDePagamento();
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
	public FrmFormaDePagamento() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tfValor.requestFocusInWindow();
			}
		});
		setBounds(100, 100, 759, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setForeground(new Color(24, 52, 70));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAutoRequestFocus(false);
		contentPane.setBackground(new Color(202, 240, 248));
		contentPane.setForeground(new Color(202, 240, 248));
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Forma de Pagamento");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		tfValor = new JTextField();
		tfValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
				}
			}
		});
		tfValor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblFormaPagamento = new JLabel("Forma de Pagamento:");
		lblFormaPagamento.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfFormaPagamento = new JTextField();
		tfFormaPagamento.setColumns(10);
		
		JTextPane txtpndinheiro = new JTextPane();
		txtpndinheiro.setFont(new Font("Arial", Font.BOLD, 16));
		txtpndinheiro.setText("1 - Dinheiro\r\n2 - Cartão de Crédito\r\n3 - Cartão de Débito\r\n4 - Vale Refeição \r\n6 - Vale Alimentação\r\n7 - Pix");
		txtpndinheiro.setBackground(new Color(202, 240, 248));
		txtpndinheiro.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		tfTotalCompra = new JTextField();
		tfTotalCompra.setEditable(false);
		tfTotalCompra.setColumns(10);
		
		JLabel lblTotalCompra = new JLabel("Total Compra:");
		lblTotalCompra.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfTroco = new JTextField();
		tfTroco.setEditable(false);
		tfTroco.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfValorRestante = new JTextField();
		tfValorRestante.setEditable(false);
		tfValorRestante.setColumns(10);
		
		JLabel lblFalta = new JLabel("Falta:");
		lblFalta.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.setBackground(new Color(4, 136, 47));
		btnFinalizarVenda.setFont(new Font("Arial", Font.BOLD, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFalta, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFormaPagamento)
								.addComponent(lblValor)
								.addComponent(lblTotalCompra))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(tfValor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
									.addComponent(lblNewLabel, Alignment.LEADING)
									.addComponent(tfFormaPagamento, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(txtpndinheiro, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfTotalCompra, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))))
								.addComponent(tfValorRestante, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(179)
							.addComponent(lblTroco)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfTroco, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(248)
							.addComponent(btnFinalizarVenda, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(240, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblValor))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(50)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFormaPagamento, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFormaPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(txtpndinheiro, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfTotalCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalCompra, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFalta, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfValorRestante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTroco, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfTroco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(btnFinalizarVenda, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
