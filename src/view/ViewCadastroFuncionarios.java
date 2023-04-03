package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class ViewCadastroFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfNumero;
	private JTextField tfCpfCnpj;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCelular;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCep;
	private JTextField tfLimite;
	private JTextField tfComplemento;
	private JTextField textField;
	private JTable table;
	private JTextField tfRg;
	private JTextField tfSenha;
	private JTextField tfCargo;
	private JTextField tfPisPasep;
	private JTextField tfJornada;
	private JTextField tfCarteiraTrabalho;
	private JTextField tfEstadoCivil;
	private JTextField tfJornadaTrabalho;
	private JTextField lblAdmissão;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroFuncionarios frame = new ViewCadastroFuncionarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public ViewCadastroFuncionarios() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(18, 94, 137));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel abaConsultaCliente = new JPanel();
		tabbedPane.addTab("Consulta Funcionário", null, abaConsultaCliente, null);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lbCodigo_1 = new JLabel("Código: ");
		lbCodigo_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultaCliente = new GroupLayout(abaConsultaCliente);
		gl_abaConsultaCliente.setHorizontalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
							.addGap(30)
							.addComponent(lbCodigo_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1219, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_abaConsultaCliente.setVerticalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCodigo_1)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
		);
		abaConsultaCliente.setLayout(gl_abaConsultaCliente);
		
		JPanel abaDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, abaDadosPessoais, null);
		
		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCodigo = new JTextField();
		tfCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		
		JLabel lblCnpj_1_3 = new JLabel("CNPJ: ");
		lblCnpj_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCelular = new JTextField();
		tfCelular.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfTelefone = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
		tfTelefone.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCep = new JFormattedTextField();
		tfCep.setColumns(10);
		
		JComboBox cbUf = new JComboBox();
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfLimite = new JTextField();
		tfLimite.setColumns(10);
		
		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		
		tfCpfCnpj = new JTextField();
		tfCpfCnpj.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfRg = new JTextField();
		tfRg.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfSenha = new JTextField();
		tfSenha.setColumns(10);
		
		JLabel lblNivelDeAcesso = new JLabel("Nível de Acesso:");
		lblNivelDeAcesso.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox cbNivelAcesso = new JComboBox();
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCargo = new JTextField();
		tfCargo.setColumns(10);
		
		JLabel lblPisPasep = new JLabel("PIS / PASEP:");
		lblPisPasep.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfPisPasep = new JTextField();
		tfPisPasep.setColumns(10);
		
		tfJornada = new JTextField();
		tfJornada.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salário:");
		lblSalario.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCtps = new JLabel("CTPS:");
		lblCtps.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCarteiraTrabalho = new JTextField();
		tfCarteiraTrabalho.setColumns(10);
		
		JLabel lblCtps_1 = new JLabel("Estado Civil:");
		lblCtps_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEstadoCivil = new JTextField();
		tfEstadoCivil.setColumns(10);
		
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfJornadaTrabalho = new JTextField();
		tfJornadaTrabalho.setColumns(10);
		
		JLabel lblAdmisso = new JLabel("Admissão:");
		lblAdmisso.setFont(new Font("Arial", Font.BOLD, 14));
		
		lblAdmissão = new JTextField();
		lblAdmissão.setColumns(10);
		
		JLabel lblAtivo = new JLabel("Ativo:");
		lblAtivo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox cbNivelAcesso_1 = new JComboBox();
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblDemisso = new JLabel("Demissão:");
		lblDemisso.setFont(new Font("Arial", Font.BOLD, 14));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_abaDadosPessoais = new GroupLayout(abaDadosPessoais);
		gl_abaDadosPessoais.setHorizontalGroup(
			gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(91)
					.addComponent(lbCodigo)
					.addGap(14)
					.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(115)
					.addComponent(lblNome)
					.addGap(4)
					.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tfCpfCnpj, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblRg)
					.addGap(4)
					.addComponent(tfRg, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(113)
					.addComponent(lblEmail)
					.addGap(4)
					.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblTelefone)
					.addGap(14)
					.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblCelular)
					.addGap(6)
					.addComponent(tfCelular, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(87)
					.addComponent(lblEndereo)
					.addGap(4)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNumero)
					.addGap(11)
					.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblCep)
					.addGap(6)
					.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(112)
					.addComponent(lblBairro)
					.addGap(4)
					.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(63)
							.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(lblUf)
					.addGap(6)
					.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(58)
					.addComponent(lblComplemento)
					.addGap(4)
					.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblLimite)
					.addGap(13)
					.addComponent(tfLimite, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(111)
					.addComponent(lblSenha)
					.addGap(4)
					.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblNivelDeAcesso)
					.addGap(4)
					.addComponent(cbNivelAcesso, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(lblCargo)
					.addGap(4)
					.addComponent(tfCargo, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblSalario)
					.addGap(13)
					.addComponent(tfJornada, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(76)
					.addComponent(lblPisPasep)
					.addGap(4)
					.addComponent(tfPisPasep, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblCtps)
					.addGap(4)
					.addComponent(tfCarteiraTrabalho, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(lblCtps_1)
					.addGap(4)
					.addComponent(tfEstadoCivil, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblJornada)
					.addGap(4)
					.addComponent(tfJornadaTrabalho, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(88)
					.addComponent(lblAdmisso)
					.addGap(4)
					.addComponent(lblAdmissão, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblAtivo)
					.addGap(4)
					.addComponent(cbNivelAcesso_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblDemisso)
					.addGap(4)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCnpj_1_3))
		);
		gl_abaDadosPessoais.setVerticalGroup(
			gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaDadosPessoais.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lbCodigo))
						.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNome))
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCpf))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfCpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblRg))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblEmail))
						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblTelefone))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCelular))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEndereo))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumero))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCep))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblBairro))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(lblCidade))))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblUf))
						.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblComplemento))
						.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblLimite))
						.addComponent(tfLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblSenha))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNivelDeAcesso))
						.addComponent(cbNivelAcesso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCargo))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblSalario))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(tfJornada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblPisPasep))
						.addComponent(tfPisPasep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCtps))
						.addComponent(tfCarteiraTrabalho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCtps_1))
						.addComponent(tfEstadoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblJornada))
						.addComponent(tfJornadaTrabalho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblAdmisso))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(lblAdmissão, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblAtivo))
						.addComponent(cbNivelAcesso_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(2)
							.addComponent(lblDemisso))
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(837)
					.addComponent(lblCnpj_1_3))
		);
		abaDadosPessoais.setLayout(gl_abaDadosPessoais);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Funcionários");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(800, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Editar");
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		
		JButton btnNewButton_1_2 = new JButton("Salvar");
		btnNewButton_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		
		JButton btnNewButton_1_3 = new JButton("Excluir");
		btnNewButton_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(154)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(6))
				.addComponent(tabbedPane)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
