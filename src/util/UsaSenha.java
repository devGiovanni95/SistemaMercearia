package util;

// TODO: Auto-generated Javadoc
/**
 * The Class UsaSenha.
 */
public class UsaSenha {

/**
 * The main method.
 *
 * @param args the arguments
 */
public static void main(String[] args) {
	GeradorDeCodigo x = new GeradorDeCodigo();
	
	String s = x.geraCodigo();
	System.out.println(s);
	}
}
