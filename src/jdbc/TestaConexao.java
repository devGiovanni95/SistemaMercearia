package jdbc;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class TestaConexao.
 */
public class TestaConexao {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		try {
			new ConnectionFactory().getConnection();
			JOptionPane.showMessageDialog(null,"Conectado com sucesso!");
		} catch (Exception  erro) {
			JOptionPane.showMessageDialog(null,"Ops aconteceu o erro: " + erro);
		}
	}

}
