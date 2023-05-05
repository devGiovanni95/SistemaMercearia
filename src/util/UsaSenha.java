package util;

public class UsaSenha {
public static void main(String[] args) {
	GeradorDeCodigoAberturaCaixa x = new GeradorDeCodigoAberturaCaixa();
	
	String s = x.gerarCodigo();
	System.out.println(s);
	
}
}
