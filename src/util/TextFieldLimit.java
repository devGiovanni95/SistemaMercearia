package util;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Classe TextFieldLimit.
 * É uma extensão da classe JTextField.
 * Define um campo de texto que limita o número de caracteres que o usuário pode
 * inserir.
 * E também pode limitar o tipo de caracteres inseridos baseado no Validador
 * fornecido.
 */
public class TextFieldLimit extends JTextField {

    /**
     * Construtor da classe TextFieldLimit.
     * Cria um novo TextFieldLimit com o número máximo de caracteres definido.
     * 
     * @param limit     O número máximo de caracteres permitidos.
     * @param validador O validador a ser usado para verificar a entrada.
     */
    public TextFieldLimit(int limit, Validador validador) {
        super();
        // Define o documento do campo de texto para um novo LimitDocument com o limite
        // fornecido e o validador.
        this.setDocument(new LimitDocument(limit, validador));
    }

    /**
     * Classe interna LimitDocument.
     * Ela limita o número de caracteres que podem ser inseridos no documento.
     * E também pode limitar o tipo de caracteres inseridos baseado no Validador
     * fornecido.
     */
    private class LimitDocument extends PlainDocument {
        private int limit;
        private Validador validador;

        /**
         * Construtor da classe LimitDocument.
         * Cria um novo LimitDocument com o número máximo de caracteres definido e o
         * validador.
         * 
         * @param limit     O número máximo de caracteres permitidos.
         * @param validador O validador a ser usado para verificar a entrada.
         */
        LimitDocument(int limit, Validador validador) {
            super();
            this.limit = limit;
            this.validador = validador;
        }

        /**
         * Insere uma string no documento.
         * Se a inserção da string exceder o limite ou não passar pelo validador, a
         * string não será inserida.
         * 
         * @param offset A posição no documento para inserir a string.
         * @param str    A string para inserir.
         * @param attr   O conjunto de atributos para a string.
         * @throws BadLocationException Se o offset for inválido.
         */
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            String newText = getText(0, getLength()) + str;
            // Se a inserção da string não exceder o limite e passar pelo validador...
            if ((getLength() + str.length()) <= limit && validador.isValido(newText)) {
                // ... insira a string.
                super.insertString(offset, str, attr);
            }
            // Se a inserção da string exceder o limite ou não passar pelo validador, a
            // string não será inserida.
        }
    }

    /**
     * Interface Validador.
     * Define um método para verificar a validade de uma string.
     */
    public interface Validador {
        /**
         * Verifica se uma string é válida.
         * 
         * @param str A string a verificar.
         * @return true se a string é válida, false caso contrário.
         */
        boolean isValido(String str);
    }

    /**
     * Classe ValidadorInteiro.
     * Implementa a interface Validador.
     * Verifica se uma string é um número inteiro válido.
     */
    public static class ValidadorInteiro implements Validador {
        @Override
        public boolean isValido(String str) {
            return str.matches("[0-9]*");
        }
    }

    /**
     * Classe ValidadorDecimal.
     * Implementa a interface Validador.
     * Verifica se uma string é um número decimal válido.
     */
    public static class ValidadorDecimal implements Validador {
        @Override
        public boolean isValido(String str) {
            return str.matches("^[0-9]*\\.?[0-9]{0,2}$");
        }
    }

    /**
     * Classe ValidadorString.
     * Implementa a interface Validador.
     * Aceita todas as strings.
     */
    public static class ValidadorString implements Validador {
        @Override
        public boolean isValido(String str) {
            return true;
        }
    }

    /**
     * Classe ValidadorMoney.
     * Implementa a interface Validador.
     * Verifica se uma string é um valor monetário válido.
     */
    public static class ValidadorMoney implements Validador {
        @Override
        public boolean isValido(String str) {
            return str.matches("^[0-9]+(\\.[0-9]{1,2})?$");
        }
    }

    /**
     * Classe ValidadorPorcentagem.
     * Implementa a interface Validador.
     * Verifica se uma string é um número decimal válido sem o símbolo de
     * porcentagem.
     */
    public static class ValidadorPorcentagem implements Validador {
        @Override
        public boolean isValido(String str) {
            return str.matches("^[0-9]*\\.?[0-9]{0,2}$");
        }
    }

}
