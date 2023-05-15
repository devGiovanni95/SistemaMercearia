package util;

// TODO: Auto-generated Javadoc
/**
 * The Class GeradorDeCodigoAberturaCaixa.
 */
public class GeradorDeCodigo {
	

	/**
	 * Gerar numero.
	 *
	 * @return the string
	 */
	public String gerarNumero() {
		String senha = "";	
		for(int i = 1; i<=3; i++) {
			 senha += (int)(Math.random()*10);
		}		
		return senha;		
		}
	
	/**
	 * Gerar letras.
	 *
	 * @return the string
	 */
	public String gerarLetras() {
	    String caracteresPermitidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    StringBuilder senha = new StringBuilder();
	    for (int i = 1; i <= 3; i++) {
	        int indiceAleatorio = (int) (Math.random() * caracteresPermitidos.length());
	        char caractereAleatorio = caracteresPermitidos.charAt(indiceAleatorio);
	        senha.append(caractereAleatorio);
	    }
	    return senha.toString();
	}
	
	/**
	 * Gera codigo.
	 *
	 * @return the string
	 */
	public String geraCodigo() {		
		String s = gerarNumero()+gerarLetras() + gerarNumero()+gerarNumero()+gerarLetras(); 
		return s;
	}

}
