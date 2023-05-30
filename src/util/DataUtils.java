package util;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtils {

    public void verificarData(JFormattedTextField tfData, int minYear, int maxYear) {
        if (tfData.getText() != null && tfData.getText().trim().length() == 10) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf.parse(tfData.getText()));
                int year = cal.get(Calendar.YEAR);

                if (year > maxYear || year < minYear) {
                    JOptionPane.showMessageDialog(null, "Insira uma data válida (antes do ano " + maxYear + " e depois de " + minYear + ").");
                    tfData.setText("");
                }
            } catch (ParseException ex) {
                // Ignora, já que a data ainda não está completa
            }
        }
    }

    public void addDateVerifier(JFormattedTextField tfData, int minYear, int maxYear) {
        DocumentListener dl = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarData(tfData, minYear, maxYear);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarData(tfData, minYear, maxYear);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarData(tfData, minYear, maxYear);
            }
        };

        tfData.getDocument().addDocumentListener(dl);
    }

    // Método para verificar se a data inserida é válida
    public static boolean isDateValid(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("##/##/####");
        sdf.setLenient(false); // Isso fará com que o SimpleDateFormat não aceite datas inválidas

        try {
            sdf.parse(date); // Tente converter a string em uma data
        } catch (ParseException e) {
            return false; // Se a conversão falhar, retorne false
        }

        return true; // Se a conversão for bem-sucedida, retorne true
    }
}
