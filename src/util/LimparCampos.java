package util;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// TODO: Auto-generated Javadoc
/**
 * The Class LimparCampos.
 */
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
				((JComboBox) component).setSelectedIndex(1);
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
	
	public void resetarTabela(JTable tabela) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0); // Remove todas as linhas do modelo
    }
}
