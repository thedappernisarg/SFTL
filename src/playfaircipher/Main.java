
package playfaircipher;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GUI gui = new GUI();
        gui.setSize(500, 350);
        gui.setLookAndFeel("MOTIF");
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setTitle("Playfair");
        gui.setVisible(true);
    }
}