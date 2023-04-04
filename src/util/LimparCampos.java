package util;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class LimparCampos {

	public void Limpar(JPanel tela) {
		Component components[] = tela.getComponents();
		for(Component component : components) {
			if(component instanceof JTextField) {
				((JTextField) component).setText(null);
			}
		}
	}
}
