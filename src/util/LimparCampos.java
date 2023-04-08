package util;

import java.awt.Component;

import javax.swing.JComboBox;
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
		for(Component component : components) {
			if(component instanceof JComboBox) {
				((JComboBox) component).setSelectedIndex(0);
			}
		}
	}
}
