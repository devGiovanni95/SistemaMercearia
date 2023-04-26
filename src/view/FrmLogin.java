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
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import controller.FuncionarioController;
import util.LimparCampos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

// TODO: Auto-generated Javadoc
/**
 * The Class FrmLogin.
 */
public class FrmLogin extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The tf email. */
	private JTextField tfEmail;
	
	/** The tf senha. */
	private JPasswordField tfSenha;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 914, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setLocationRelativeTo(null);//tela centralizada
		setContentPane(contentPane);
		setTitle("TEla de Login");

		
		//Criando plano de fundo
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
		
		JLabel lblMercadoSilva = new JLabel("Mercado do Mineiro");
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
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Arial", Font.BOLD, 20));
		tfEmail.setColumns(25);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(363))
				.addComponent(tfEmail, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		panel_8.setLayout(gl_panel_8);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(261)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(289, Short.MAX_VALUE))
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
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(3, 71, 72));
		lblSenha.setFont(new Font("Arial", Font.BOLD, 26));
		
		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font("Arial", Font.BOLD, 20));
		//textField_1.setDropMode(DropMode.ON);
		tfSenha.setColumns(25);
		GroupLayout gl_panel_8_1 = new GroupLayout(panel_8_1);
		gl_panel_8_1.setHorizontalGroup(
			gl_panel_8_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8_1.createSequentialGroup()
					.addComponent(lblSenha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(368))
				.addComponent(tfSenha, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
		);
		gl_panel_8_1.setVerticalGroup(
			gl_panel_8_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8_1.createSequentialGroup()
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
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
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 24));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String email;
					String senha;
					
					email = tfEmail.getText();
					senha = tfSenha.getText();
					
					FuncionarioController funcionarioController = new FuncionarioController();
					
					funcionarioController.efetuarLogin(email, senha);
					tfEmail.setText("");
					tfSenha.setText("");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Erro: "+e2);
				}
				
			}
		});
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(339)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(361, Short.MAX_VALUE))
				.addComponent(panel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
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
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
		);
		
		JLabel lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/assets/sair.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(782, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		desktopPane.setLayout(gl_desktopPane);
		contentPane.setLayout(gl_contentPane);
	}
}
