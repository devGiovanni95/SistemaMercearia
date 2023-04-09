package util;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LimparCampos {

	/**
	 * Metodo que efetua a limpeza de todos os componentes do tipo JTextField e do tipo JComboBox.
	 * @param tela - objeto do tipo JPanel que indica a classe pai da tela para efetuar a limpeza dos componentes. 
	 */
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
	
	/**
	 * Metodo que efetua a limpeza de todos os componentes do tipo JTextField e do tipo JComboBox.
	 * @param tela - objeto do tipo JDesktopPane que indica a classe pai da tela para efetuar a limpeza dos componentes. 
	 */
	public void Limpar(JDesktopPane tela) {
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
