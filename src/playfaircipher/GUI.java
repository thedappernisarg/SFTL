/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class GUI extends GBFrame {

    private JTextArea decryptedArea;
    private JTextArea square;
    private JTextArea encryptedArea;
    private JRootpane rootPane;
    private JButton encryptBtn;
    private JButton decryptBtn;
    private final Font STD_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    private final Font BOLD_FONT = new Font(Font.MONOSPACED, Font.BOLD, 12);
    //creates a square with a key. feel free to remove... FOR TESTING
    //PURPOSES
    private PolybusSq theSquare = new PolybusSq(/*"you goddamn motherfucking fuckng cunt?!"*/);

    public GUI() {
        //this will hold *decrypted* text.
        decryptedArea = addTextArea("", 1, 1, 1, 3);
        //formatting
        decryptedArea.setFont(STD_FONT);
        decryptedArea.setColumns(16);
        decryptedArea.setLineWrap(true);
        //displays the polybus square created
        square = addTextArea(PolybusSq.print(), 1, 2, 1, 3);
        //more formatting...
        square.setFont(STD_FONT);
        square.setColumns(7);
        square.setLineWrap(true);
        //can't change the square
        square.setFocusable(false);
        //holds *encrypted* text
        encryptedArea = addTextArea("", 1, 3, 1, 3);
        //even more formatting
        encryptedArea.setFont(STD_FONT);
        encryptedArea.setColumns(16);
        encryptedArea.setLineWrap(true);
        //gets text from decryptedArea and encrypts it.
        //displays encrypted text in encryptedArea.
        encryptBtn = addButton("ENCRYPT", 4, 1, 1, 1);
        encryptBtn.setFont(BOLD_FONT);
        //gets text from encryptedArea and decrypts it.
        //displays plaintext in decryptedArea.
        decryptBtn = addButton("DECRYPT", 4, 3, 1, 1);
        decryptBtn.setFont(BOLD_FONT);
    }


    public void buttonClicked(JButton jb) {
        if (jb == encryptBtn) {
            theSquare.reset();
            theSquare.setKey(getKey());
            square.setText(theSquare.print());
            //TODO: encrypt the message
            //TODO: display ciphertext
        } else if (jb == decryptBtn) {

        }
    }

    private String getKey() {
        return JOptionPane.showInputDialog(rootPane, "Input the message key:");
    }

    private JTextArea addTextArea(String string, int i, int i0, int i1, int i2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private JButton addButton(String string, int i, int i0, int i1, int i2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setLookAndFeel(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
   

    void setResizable(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void setTitle(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}



