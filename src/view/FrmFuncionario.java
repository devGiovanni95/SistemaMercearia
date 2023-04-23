package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.FuncionarioController;
import model.Cliente;
import model.Funcionario;
import util.LimparCampos;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmFuncionario extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfNumero;
	private JFormattedTextField tfCpf;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JFormattedTextField tfCelular;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCep;
	private JTextField tfLimite;
	private JTextField tfComplemento;
	private JTextField tfNomePesquisa;
	private JTable tabelaFuncionarios;
	private JFormattedTextField tfRg;
	private JTextField tfSenha;
	private JTextField tfCargo;
	private JTextField tfPisPasep;
	private JTextField tfSalario;
	private JTextField tfCarteiraTrabalho;
	private JComboBox cbEstadoCivil;
	private JTextField tfJornadaTrabalho;
	private JTextField tfAdmissao;
	private JTextField tfEndereco;
	private JTextField tfDemissao;
	private JComboBox<String> cbNivelAcesso_1;
	private JComboBox<String> cbAtivo_1;

	
	/**
	 * Metodo utilizado para listar todos os funcionários e adiciona-los na tabela
	 */
	public void listar() {
		try {
		FuncionarioController funcionarioController = new FuncionarioController();
		List<Funcionario> lista = funcionarioController.listarFuncionario();
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaFuncionarios.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(26);
		dadosTabela.addRow(new Object[]{"Nome","E-mail","CPF","RG","Endereço","Telefone","Celular","Numero","CEP","Data Nascimento", "Bairro","Cidade","UF","Complemento","Limite","Senha","Cargo","Nivel Acesso","Pis Pasep","Salário","Carteira de Trabalho","Estado Civil","Jornada Trabalho","Admissão","Demissão","Ativo"});
		

		for(Funcionario funcionario: lista) {
			dadosTabela.addRow(new Object[]{
					funcionario.getNome(),
					funcionario.getEmail(),
					funcionario.getCpf(),
					funcionario.getRg(),
					funcionario.getEndereco(),
					funcionario.getTelefone(),
					funcionario.getCelular(),
					funcionario.getNumero(),
					funcionario.getCep(),
					funcionario.getDataNascimento(),
					funcionario.getBairro(),
					funcionario.getCidade(),
					funcionario.getUf(),
					funcionario.getComplemento(),
					funcionario.getLimite(),
					funcionario.getSenha(),
					funcionario.getCargo(),
					funcionario.getNivelAcesso(),
					funcionario.getPisPasep(),
					funcionario.getSalario(),
					funcionario.getCarteiraTrabalho(),
					funcionario.getEstadoCivil(),
					funcionario.getJornadaTrabalho(),
					funcionario.getAdmissao(),
					funcionario.getDemissao(),
					funcionario.getAtivo()
					
				});
			}
		}catch (Exception erro) {
			JOptionPane.showMessageDialog(null,"Ops aconteceu o erro: " + erro);
		}	
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFuncionario frame = new FrmFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTabbedPane abaPrincipal;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FrmFuncionario() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				listar();
				
			}
		});
		setBackground(new Color(202, 240, 248));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 240, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(22, 138, 173));
		
		abaPrincipal = new JTabbedPane(JTabbedPane.TOP);
		abaPrincipal.setBackground(new Color(202, 240, 248));
		
		JPanel abaDadosPessoais = new JPanel();
		abaDadosPessoais.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Dados Pessoais", null, abaDadosPessoais, null);
	
		
		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.BOLD, 14));
		tfNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Arial", Font.BOLD, 14));
		tfEmail.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNumero = new JTextField();
		tfNumero.setFont(new Font("Arial", Font.BOLD, 14));
		tfNumero.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfBairro = new JTextField();
		tfBairro.setFont(new Font("Arial", Font.BOLD, 14));
		tfBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Arial", Font.BOLD, 14));
		tfCidade.setColumns(10);
		
		JLabel lblCnpj_1_3 = new JLabel("CNPJ: ");
		lblCnpj_1_3.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCelular = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		tfCelular.setFont(new Font("Arial", Font.BOLD, 14));
		tfCelular.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfTelefone = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
		tfTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		tfTelefone.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
		tfCep.setFont(new Font("Arial", Font.BOLD, 14));
		tfCep.setColumns(10);
		
		JComboBox<String> cbUf = new JComboBox<String>();
		cbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cbUf.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblLimite = new JLabel("Limite:");
		lblLimite.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfLimite = new JTextField();
		tfLimite.setFont(new Font("Arial", Font.BOLD, 14));
		tfLimite.setColumns(10);
		
		tfComplemento = new JTextField();
		tfComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		tfComplemento.setColumns(10);
		
		tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		tfCpf.setFont(new Font("Arial", Font.BOLD, 14));
		tfCpf.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfRg = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
		tfRg.setFont(new Font("Arial", Font.BOLD, 14));
		tfRg.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfSenha = new JTextField();
		tfSenha.setFont(new Font("Arial", Font.BOLD, 14));
		tfSenha.setColumns(10);
		
		JLabel lblNivelDeAcesso = new JLabel("Nível de Acesso:");
		lblNivelDeAcesso.setFont(new Font("Arial", Font.BOLD, 14));
		cbNivelAcesso_1 = new JComboBox<String>();
		cbNivelAcesso_1.setFont(new Font("Arial", Font.PLAIN, 14));
		cbNivelAcesso_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"","Gerente","Estoquista","Caixa"}));
		
				
				JLabel lblCargo = new JLabel("Cargo:");
				lblCargo.setFont(new Font("Arial", Font.BOLD, 14));
				
				tfCargo = new JTextField();
				tfCargo.setFont(new Font("Arial", Font.BOLD, 14));
				tfCargo.setColumns(10);
				
				JLabel lblPisPasep = new JLabel("PIS / PASEP:");
				lblPisPasep.setFont(new Font("Arial", Font.BOLD, 14));
				
				tfPisPasep = new JTextField();
				tfPisPasep.setFont(new Font("Arial", Font.BOLD, 14));
				tfPisPasep.setColumns(10);
				
				tfSalario = new JTextField();
				tfSalario.setFont(new Font("Arial", Font.BOLD, 14));
				tfSalario.setColumns(10);
				
				JLabel lblSalario = new JLabel("Salário:");
				lblSalario.setFont(new Font("Arial", Font.BOLD, 14));
				
				JLabel lblCtps = new JLabel("CTPS:");
				lblCtps.setFont(new Font("Arial", Font.BOLD, 14));
				
				tfCarteiraTrabalho = new JFormattedTextField(new MaskFormatter("#######-####"));
				tfCarteiraTrabalho.setFont(new Font("Arial", Font.BOLD, 14));
				tfCarteiraTrabalho.setColumns(10);
				
				JLabel lblCtps_1 = new JLabel("Estado Civil:");
				lblCtps_1.setFont(new Font("Arial", Font.BOLD, 14));
				
				JComboBox<String> cbEstadoCivil_1 = new JComboBox<String>();
				cbEstadoCivil_1.setFont(new Font("Arial", Font.BOLD, 14));
				cbEstadoCivil_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"","Solteiro(a)","Casado(a)","Divorciado(a)"}));
				
				JLabel lblJornada = new JLabel("Jornada:");
				lblJornada.setFont(new Font("Arial", Font.BOLD, 14));
				
				tfJornadaTrabalho = new JTextField();
				tfJornadaTrabalho.setFont(new Font("Arial", Font.BOLD, 14));
				tfJornadaTrabalho.setColumns(10);
				
				JLabel lblAdmissao = new JLabel("Admissão:");
				lblAdmissao.setFont(new Font("Arial", Font.BOLD, 14));
				
				tfAdmissao = new JFormattedTextField(new MaskFormatter("##/##/####"));
				tfAdmissao.setFont(new Font("Arial", Font.BOLD, 14));
				tfAdmissao.setColumns(10);
				
				JLabel lblAtivo = new JLabel("Ativo:");
				lblAtivo.setFont(new Font("Arial", Font.BOLD, 14));
				cbAtivo_1 = new JComboBox<String>();
				cbAtivo_1.setFont(new Font("Arial", Font.PLAIN, 14));
				cbAtivo_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"","Ativo","Inativo"}));
				
				
				tfEndereco = new JTextField();
				tfEndereco.setFont(new Font("Arial", Font.BOLD, 14));
				tfEndereco.setColumns(10);
				
				JLabel lblDemisso = new JLabel("Demissão:");
				lblDemisso.setFont(new Font("Arial", Font.BOLD, 14));
				
				tfDemissao = new JFormattedTextField(new MaskFormatter("##/##/####"));
				tfDemissao.setFont(new Font("Arial", Font.BOLD, 14));
				tfDemissao.setColumns(10);
				
				JLabel lblDataNascimento = new JLabel("Data Nascimento: ");
				lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 14));
				
				JFormattedTextField tfDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
				GroupLayout gl_abaDadosPessoais = new GroupLayout(abaDadosPessoais);
				gl_abaDadosPessoais.setHorizontalGroup(
					gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaDadosPessoais.createSequentialGroup()
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
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
									.addComponent(tfCpf, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
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
									.addComponent(cbNivelAcesso_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(lblCargo)
									.addGap(4)
									.addComponent(tfCargo, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblSalario)
									.addGap(13)
									.addComponent(tfSalario, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
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
									.addComponent(cbEstadoCivil_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblJornada)
									.addGap(4)
									.addComponent(tfJornadaTrabalho, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(88)
									.addComponent(lblAdmissao)
									.addGap(4)
									.addComponent(tfAdmissao, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(lblAtivo)
									.addGap(4)
									.addComponent(cbAtivo_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblDemisso)
									.addGap(4)
									.addComponent(tfDemissao, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(10)
									.addComponent(lblCnpj_1_3))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, gl_abaDadosPessoais.createSequentialGroup()
											.addGap(87)
											.addComponent(lblEndereo)
											.addGap(4)
											.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblNumero)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblCep)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfCep, 0, 0, Short.MAX_VALUE))
										.addGroup(Alignment.LEADING, gl_abaDadosPessoais.createSequentialGroup()
											.addGap(112)
											.addComponent(lblBairro)
											.addGap(4)
											.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
											.addGap(21)
											.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_abaDadosPessoais.createSequentialGroup()
													.addGap(63)
													.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))))
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(41)
											.addComponent(lblUf)
											.addGap(6)
											.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblDataNascimento)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfDataNascimento)))))
							.addGap(41))
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
									.addComponent(tfCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(3)
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNumero)
										.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCep)
										.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDataNascimento)
										.addComponent(tfDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
								.addComponent(cbNivelAcesso_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
									.addComponent(tfSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
								.addComponent(cbEstadoCivil_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(lblJornada))
								.addComponent(tfJornadaTrabalho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblAdmissao))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(tfAdmissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblAtivo))
								.addComponent(cbAtivo_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(2)
									.addComponent(lblDemisso))
								.addGroup(gl_abaDadosPessoais.createSequentialGroup()
									.addGap(1)
									.addComponent(tfDemissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(837)
							.addComponent(lblCnpj_1_3))
				);
				abaDadosPessoais.setLayout(gl_abaDadosPessoais);
		
		JPanel abaConsultaCliente = new JPanel();
		abaConsultaCliente.setBackground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta Funcionário", null, abaConsultaCliente, null);
		
		tfNomePesquisa = new JTextField();
		tfNomePesquisa.setColumns(10);
		
		JLabel lbCodigo_1 = new JLabel("Código: ");
		lbCodigo_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabelaFuncionarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelaFuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tabelaFuncionarios.setFillsViewportHeight(true);
		tabelaFuncionarios.setCellSelectionEnabled(true);
		tabelaFuncionarios.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultaCliente = new GroupLayout(abaConsultaCliente);
		gl_abaConsultaCliente.setHorizontalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(30)
					.addComponent(lbCodigo_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfNomePesquisa, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(625, Short.MAX_VALUE))
				.addComponent(tabelaFuncionarios, GroupLayout.DEFAULT_SIZE, 1337, Short.MAX_VALUE)
		);
		gl_abaConsultaCliente.setVerticalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfNomePesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCodigo_1)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addComponent(tabelaFuncionarios, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
		);
		abaConsultaCliente.setLayout(gl_abaConsultaCliente);
		
		JComboBox<String> cbNivelAcesso = new JComboBox<String>();
		cbNivelAcesso.setFont(new Font("Arial", Font.BOLD, 14));
		
		JComboBox<String> cbAtivo = new JComboBox<String>();
		cbAtivo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("Funcionários");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		
		JLabel lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmMenuPrincipal menu = new FrmMenuPrincipal();
				menu.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(FrmFuncionario.class.getResource("/assets/sair.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 821, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(new Color(202, 240, 248));
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBackground(new Color(106, 76, 147));
		btnNovo.setForeground(new Color(255, 255, 255));
		btnNovo.setFont(new Font("Arial", Font.BOLD, 24));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(255, 202, 58));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.setForeground(new Color(255, 255, 255));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setNome(tfNome.getText());
				funcionario.setEmail(tfEmail.getText());
				funcionario.setCpf(tfCpf.getText());
				funcionario.setRg(tfRg.getText());
				funcionario.setEndereco(tfEndereco.getText());
				funcionario.setTelefone(tfTelefone.getText());
				funcionario.setCelular(tfCelular.getText());
				funcionario.setNumero(Integer.parseInt(tfNumero.getText()));
				funcionario.setCep(tfCep.getText());
				funcionario.setDataNascimento(tfDataNascimento.getText());
				funcionario.setBairro(tfBairro.getText());
				funcionario.setCidade(tfCidade.getText());
				funcionario.setUf(cbUf.getSelectedItem().toString());
				funcionario.setComplemento(tfComplemento.getText());
				funcionario.setLimite(Double.parseDouble(tfLimite.getText()));
				funcionario.setCodigo(tfCodigo.getText());				
				funcionario.setSenha(tfSenha.getText());
				funcionario.setCargo(tfCargo.getText());
				funcionario.setNivelAcesso(cbNivelAcesso_1.getSelectedItem().toString());
				funcionario.setPisPasep(tfPisPasep.getText());
				funcionario.setSalario(Double.parseDouble(tfSalario.getText()));
				funcionario.setCarteiraTrabalho(tfCarteiraTrabalho.getText());
				funcionario.setEstadoCivil(cbEstadoCivil_1.getSelectedItem().toString());
				funcionario.setJornadaTrabalho(tfJornadaTrabalho.getText());
				funcionario.setAdmissao(tfAdmissao.getText());
				funcionario.setDemissao(tfDemissao.getText());
				funcionario.setAtivo(cbAtivo_1.getSelectedItem().toString());
				
				
				
				
			FuncionarioController funcionarioController = new FuncionarioController();	
				
			funcionarioController.cadastrarFuncionario(funcionario);
				
				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, 1342, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 1342, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelBotoes.setLayout(new GridLayout(0, 6, 20, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		panelBotoes.add(panel_2);
		panelBotoes.add(btnNovo);
		panelBotoes.add(btnEditar);
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnExcluir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 240, 248));
		panelBotoes.add(panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}