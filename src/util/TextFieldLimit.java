package util;

import javax.swing.*;
import javax.swing.text.*;

/**
 * Esta classe, TextFieldLimit, é uma extensão da classe JTextField.
 * Ela define um campo de texto que limita o número de caracteres que o usuário pode inserir.
 */
public class TextFieldLimit extends JTextField {

    /**
     * Construtor da classe TextFieldLimit. Cria um novo TextFieldLimit com o número máximo de caracteres definido.
     * @param limit O número máximo de caracteres permitidos.
     */
    public TextFieldLimit(int limit) {
        super();
        // Define o documento do campo de texto para um novo LimitDocument com o limite fornecido.
        this.setDocument(new LimitDocument(limit));
    }

    /**
     * Esta é uma classe interna que estende PlainDocument.
     * Ela limita o número de caracteres que podem ser inseridos no documento.
     */
    private class LimitDocument extends PlainDocument {
        // Armazena o número máximo de caracteres permitidos.
        private int limit;

        /**
         * Construtor da classe LimitDocument. Cria um novo LimitDocument com o número máximo de caracteres definido.
         * @param limit O número máximo de caracteres permitidos.
         */
        LimitDocument(int limit) {
            super();
            this.limit = limit;
        }

        /**
         * Insere uma string no documento. Se a inserção da string exceder o limite, a string não será inserida.
         * @param offset A posição no documento para inserir a string.
         * @param str A string para inserir.
         * @param attr O conjunto de atributos para a string.
         * @throws BadLocationException Se o offset for inválido.
         */
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }

            // Se a inserção da string não exceder o limite...
            if ((getLength() + str.length()) <= limit) {
                // ... insira a string.
                super.insertString(offset, str, attr);
            }
            // Se a inserção da string exceder o limite, a string não será inserida.
        }
    }
}
