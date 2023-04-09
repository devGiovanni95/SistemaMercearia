package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
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
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import model.Cliente;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import util.LimparCampos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JTextField tfCpf;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCelular;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCep;
	private JTextField tfLimite;
	private JTextField tfComplemento;
	private JTextField tfPesquisar;
	private JTable tabelaClientes;
	private JTextField tfRg;
	private JTextField tfDataNascimento;
	private JComboBox<String> cbUf;
	
	
	/**
	 * Metodo utilizado para listar todos os clientes e adiciona-los numa tabela
	 */
	public void listar() {
		try {
		ClienteController clienteController = new ClienteController();
		List<Cliente> lista = clienteController.listarCliente();
		DefaultTableModel dadosTabela = (DefaultTableModel) tabelaClientes.getModel();
		dadosTabela.setNumRows(0);
		dadosTabela.setColumnCount(15);
		dadosTabela.addRow(new Object[]{"Nome","E-mail","CPF","RG","Endereço","Telefone","Celular","Numero","CEP","Data Nascimento", "Bairro","Cidade","UF","Complemento","Limite"});
		

		for(Cliente cliente : lista) {
			dadosTabela.addRow(new Object[]{
					cliente.getNome(),
					cliente.getEmail(),
					cliente.getCpf(),
					cliente.getRg(),
					cliente.getEndereco(),
					cliente.getTelefone(),
					cliente.getCelular(),
					cliente.getNumero(),
					cliente.getCep(),
					cliente.getDataNascimento(),
					cliente.getBairro(),
					cliente.getCidade(),
					cliente.getUf(),
					cliente.getComplemento(),
					cliente.getLimite()		
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
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Ops aconteceu o erro: " );
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public FrmCliente() throws ParseException {
		setBackground(new Color(202, 240, 248));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//carregando a lista de clientes
				listar();
			}
		});
		setForeground(new Color(24, 52, 70));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAutoRequestFocus(false);
		setBounds(100, 100, 1265, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(202, 240, 248));
		contentPane.setForeground(new Color(202, 240, 248));
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(22, 138, 173));
		
		JTabbedPane abaPrincipal = new JTabbedPane(JTabbedPane.TOP);
		abaPrincipal.setBackground(new Color(202, 240, 248));
		
		JPanel abaDadosPessoais = new JPanel();
		abaDadosPessoais.setBackground(new Color(202, 240, 248));
		abaDadosPessoais.setMaximumSize(new Dimension(1920, 1080));
		abaPrincipal.addTab("Dados Pessoais", null, abaDadosPessoais, null);
		
		JLabel lbCodigo = new JLabel("Código: ");
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Arial", Font.BOLD, 14));
		tfCodigo.setEditable(false);
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
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		tfEndereco.setColumns(10);
		
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
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCelular = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
		tfCelular.setFont(new Font("Arial", Font.BOLD, 14));
		tfCelular.setColumns(10);
		
			
			JLabel lblTelefone = new JLabel("Telefone:");
			lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
			
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
			tfTelefone.setFont(new Font("Arial", Font.BOLD, 14));
			tfTelefone.setColumns(10);
			
					
					JLabel lblCep = new JLabel("CEP:");
					lblCep.setFont(new Font("Arial", Font.BOLD, 14));
					
					tfCep = new JFormattedTextField(new MaskFormatter("##.###-###"));
					tfCep.setFont(new Font("Arial", Font.BOLD, 14));
					tfCep.setColumns(10);
					
						
						cbUf = new JComboBox<String>();
						cbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
						cbUf.setBackground(Color.WHITE);
						cbUf.setForeground(Color.BLACK);
						cbUf.setFont(new Font("Arial", Font.BOLD, 14));
						JLabel lbUf = new JLabel("UF:");
						lbUf.setFont(new Font("Arial", Font.BOLD, 14));
						
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
						
						JLabel lblNascimento = new JLabel("Data Nascimento:");
						lblNascimento.setFont(new Font("Arial", Font.BOLD, 14));
						
						tfDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
						tfDataNascimento.setFont(new Font("Arial", Font.BOLD, 14));
						tfDataNascimento.setColumns(10);
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
											.addGap(38)
											.addComponent(lblCpf)
											.addGap(4)
											.addComponent(tfCpf, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
											.addGap(25)
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
											.addGap(7)
											.addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblCelular)
											.addGap(4)
											.addComponent(tfCelular, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(87)
											.addComponent(lblEndereco)
											.addGap(4)
											.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblNumero)
											.addGap(4)
											.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
											.addGap(25)
											.addComponent(lblCep)
											.addGap(4)
											.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblNascimento, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(tfDataNascimento, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(112)
											.addComponent(lblBairro)
											.addGap(6)
											.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
											.addGap(1)
											.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
											.addGap(41)
											.addComponent(lbUf)
											.addGap(4)
											.addComponent(cbUf, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(58)
											.addComponent(lblComplemento)
											.addGap(6)
											.addComponent(tfComplemento, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblLimite)
											.addGap(4)
											.addComponent(tfLimite, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(51, Short.MAX_VALUE))
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
											.addGap(2)
											.addComponent(lblEndereco))
										.addComponent(tfEndereco, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(2)
											.addComponent(lblNumero))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(1)
											.addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(2)
											.addComponent(lblCep))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(1)
											.addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(2)
											.addComponent(lblNascimento))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(2)
											.addComponent(tfDataNascimento, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(gl_abaDadosPessoais.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(2)
											.addComponent(lblBairro))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(1)
											.addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(2)
											.addComponent(lblCidade))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(1)
											.addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_abaDadosPessoais.createSequentialGroup()
											.addGap(2)
											.addComponent(lbUf))
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
									.addContainerGap(167, Short.MAX_VALUE))
						);
						abaDadosPessoais.setLayout(gl_abaDadosPessoais);
		
		JPanel abaConsultaCliente = new JPanel();
		abaConsultaCliente.setBackground(new Color(202, 240, 248));
		abaConsultaCliente.setForeground(new Color(202, 240, 248));
		abaPrincipal.addTab("Consulta Clientes", null, abaConsultaCliente, null);
		
		tfPesquisar = new JTextField();
		tfPesquisar.setColumns(10);
		
		JLabel lblNomePesquisa = new JLabel("Nome: ");
		lblNomePesquisa.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomePesquisado = "%" + tfPesquisar.getText() + "%";
				
					ClienteController clienteController = new ClienteController();
					List<Cliente> lista = clienteController.buscarClientePeloNome(nomePesquisado);
					DefaultTableModel dadosTabela = (DefaultTableModel) tabelaClientes.getModel();
					dadosTabela.setNumRows(0);
					dadosTabela.setColumnCount(15);
					dadosTabela.addRow(new Object[]{"Nome","E-mail","CPF","RG","Endereço","Telefone","Celular","Numero","CEP","Data Nascimento", "Bairro","Cidade","UF","Complemento","Limite"});
					

					for(Cliente cliente : lista) {
						dadosTabela.addRow(new Object[]{
								cliente.getNome(),
								cliente.getEmail(),
								cliente.getCpf(),
								cliente.getRg(),
								cliente.getEndereco(),
								cliente.getTelefone(),
								cliente.getCelular(),
								cliente.getNumero(),
								cliente.getCep(),
								cliente.getDataNascimento(),
								cliente.getBairro(),
								cliente.getCidade(),
								cliente.getUf(),
								cliente.getComplemento(),
								cliente.getLimite()		
							});
						}
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tabelaClientes = new JTable();
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pega os dados
				abaPrincipal.setSelectedIndex(0);
				
				tfNome.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),0).toString());
				tfEmail.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),1).toString());
				tfCpf.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),2).toString());
				tfRg.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),3).toString());
				tfEndereco.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),4).toString());
				tfTelefone.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),5).toString());
				tfCelular.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),6).toString());
				tfNumero.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),7).toString());
				tfCep.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),8).toString());
				tfDataNascimento.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),9).toString());
				tfBairro.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),10).toString());
				tfCidade.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),11).toString());
				cbUf.setSelectedItem(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),12).toString());
				tfComplemento.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),13).toString());
				tfLimite.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),14).toString());
				tfCodigo.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(),2).toString());
			}
		});
		
        tabelaClientes.setFont(new java.awt.Font("Arial", 0, 14)); 
		tabelaClientes.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					
			}
		));
		tabelaClientes.setFillsViewportHeight(true);
		tabelaClientes.setCellSelectionEnabled(true);
		tabelaClientes.setColumnSelectionAllowed(true);
		GroupLayout gl_abaConsultaCliente = new GroupLayout(abaConsultaCliente);
		gl_abaConsultaCliente.setHorizontalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNomePesquisa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(tfPesquisar, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(548))
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(7)
					.addComponent(tabelaClientes, GroupLayout.PREFERRED_SIZE, 1228, GroupLayout.PREFERRED_SIZE))
		);
		gl_abaConsultaCliente.setVerticalGroup(
			gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_abaConsultaCliente.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_abaConsultaCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNomePesquisa))
						.addGroup(gl_abaConsultaCliente.createSequentialGroup()
							.addGap(5)
							.addComponent(tfPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPesquisar))
					.addGap(4)
					.addComponent(tabelaClientes, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
		);
		abaConsultaCliente.setLayout(gl_abaConsultaCliente);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(1055, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addComponent(lblNewLabel))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 240, 248));
		panel_1.setForeground(new Color(202, 240, 248));
		
		JButton BntNovo = new JButton("Novo");
		BntNovo.setForeground(Color.WHITE);
		BntNovo.setBackground(new Color(106, 76, 147));
		BntNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		panel_1.setLayout(new GridLayout(0, 6, 20, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(202, 240, 248));
		panel_1.add(panel_3);
		BntNovo.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(BntNovo);
		
		JButton btnAlterar = new JButton("Editar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setBackground(new Color(255, 202, 58));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//editar
				Cliente cliente = new Cliente();
				
				cliente.setNome(tfNome.getText());
				cliente.setEmail(tfEmail.getText());
				cliente.setCpf(tfCpf.getText());
				cliente.setRg(tfRg.getText());
				cliente.setEndereco(tfEndereco.getText());
				cliente.setTelefone(tfTelefone.getText());
				cliente.setCelular(tfCelular.getText());
				cliente.setNumero(Integer.parseInt(tfNumero.getText()));
				cliente.setCep(tfCep.getText());
				cliente.setDataNascimento(tfDataNascimento.getText());
				cliente.setBairro(tfBairro.getText());
				cliente.setCidade(tfCidade.getText());
				cliente.setUf(cbUf.getSelectedItem().toString());
				cliente.setComplemento(tfComplemento.getText());
				cliente.setLimite(Double.parseDouble(tfLimite.getText()));				
				cliente.setCpf(tfCpf.getText());
				
				ClienteController clienteController = new ClienteController();	
				
				clienteController.alterarCliente(cliente);
				
				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnAlterar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(138, 201, 38));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				
				cliente.setNome(tfNome.getText());
				cliente.setEmail(tfEmail.getText());
				cliente.setCpf(tfCpf.getText());
				cliente.setRg(tfRg.getText());
				cliente.setEndereco(tfEndereco.getText());
				cliente.setTelefone(tfTelefone.getText());
				cliente.setCelular(tfCelular.getText());
				cliente.setNumero(Integer.parseInt(tfNumero.getText()));
				cliente.setCep(tfCep.getText());
				cliente.setDataNascimento(tfDataNascimento.getText());
				cliente.setBairro(tfBairro.getText());
				cliente.setCidade(tfCidade.getText());
				cliente.setUf(cbUf.getSelectedItem().toString());
				cliente.setComplemento(tfComplemento.getText());
				cliente.setLimite(Double.parseDouble(tfLimite.getText()));
				cliente.setCodigo(tfCodigo.getText());
				
				ClienteController clienteController = new ClienteController();	
				
				clienteController.cadastrarCliente(cliente);
				
				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(255, 89, 94));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//excluir
				Cliente cliente = new Cliente();

				cliente.setCpf(tfCpf.getText());

				ClienteController clienteController = new ClienteController();	
				
				clienteController.excluirCliente(cliente);
				
				new LimparCampos().Limpar(abaDadosPessoais);
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 24));
		panel_1.add(btnExcluir);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
				.addComponent(abaPrincipal, GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(abaPrincipal, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(202, 240, 248));
		panel_1.add(panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
