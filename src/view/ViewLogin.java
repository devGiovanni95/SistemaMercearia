package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		
		//JDesktopPane desktopPane = new JDesktopPane();
		
		//Creindo plano de fundo
		ImageIcon icon = new ImageIcon(getClass().getResource("/assets/fundo.png"));
		Image image = icon.getImage();
		JDesktopPane desktopPane = new JDesktopPane(){
			public void paintComponent(Graphics g) {
				g.drawImage(image,0,0,getWidth(),getHeight(),this);
			}
		};
		desktopPane.setForeground(new Color(41, 231, 205));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMercadoSilva = new JLabel("Mercado Silva");
		lblMercadoSilva.setForeground(new Color(3, 71, 72));
		lblMercadoSilva.setFont(new Font("Arial", Font.BOLD, 44));
		panel_1.add(lblMercadoSilva);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setForeground(new Color(3, 71, 72));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 20));
		textField.setColumns(25);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addGap(363))
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		panel_8.setLayout(gl_panel_8);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(273)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 318, Short.MAX_VALUE)
					.addGap(297))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(27))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(1.0f,1.0f,1.0f,0f));
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(new Color(3, 71, 72));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 26));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 20));
		//textField_1.setDropMode(DropMode.ON);
		textField_1.setColumns(25);
		GroupLayout gl_panel_8_1 = new GroupLayout(panel_8_1);
		gl_panel_8_1.setHorizontalGroup(
			gl_panel_8_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8_1.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(368))
				.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
		);
		gl_panel_8_1.setVerticalGroup(
			gl_panel_8_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8_1.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_8_1.setLayout(gl_panel_8_1);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(262)
					.addComponent(panel_8_1, GroupLayout.PREFERRED_SIZE, 318, Short.MAX_VALUE)
					.addGap(288))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(panel_8_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(22))
		);
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
					.addGap(3)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addGap(149))
		);
		desktopPane.setLayout(gl_desktopPane);
		contentPane.setLayout(gl_contentPane);
	}
}
