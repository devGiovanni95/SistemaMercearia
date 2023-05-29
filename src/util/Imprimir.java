package util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Imprimir {
	
	/**
	 * Classe responsável por realizar a impressão do Cupom não Fiscal.
	 * @param caminho - caminho do arquivo para impressao.
	 */
	public static void imprimir(String caminho) {
		Desktop desktop = Desktop.getDesktop();
		try {
			File notaImpressao = new File(caminho);
			desktop.print(notaImpressao);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
