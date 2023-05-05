package util;

public class GeradorDeCodigoAberturaCaixa {
	

	public static String gerarCodigo() {
		String senha = "";	
		for(int i = 1; i<=10; i++) {
			 senha += (int)(Math.random()*10);
		}		
		return senha;		
		}
	
}
