/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NISH
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaesarCipher1 extends JFrame implements ActionListener {
	
    private static JLabel        msgLabel        = new JLabel("Message: ");
    private static JLabel        keyLabel        = new JLabel("Key: ");
    private static JLabel        actionLabel     = new JLabel("Action: ");
    private static JLabel        resultLabel     = new JLabel("Result: ");
    private static JTextField    msgTextField    = new JTextField(20);
    private static JTextField    resultTextField = new JTextField(20);
    private static JSpinner      keySpinner      = new JSpinner( new SpinnerNumberModel(3, 1, 25, 1) );
    private static JRadioButton  encryptRadio    = new JRadioButton("Encrypt");
    private static JRadioButton  decryptRadio    = new JRadioButton("Decrypt");
    private static JButton       actionButton    = new JButton("Encrypt Message");
    private static JPanel        panel           = new JPanel();
    private static ButtonGroup   group           = new ButtonGroup();
    
    public static void main(String[] args) {
	new CaesarCipher();
    }
    
    public CaesarCipher1() {
    	this.setSize(310, 192);
    	this.setTitle("Caesar Cipher");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setResizable(false);
    	
    	panel.setLayout(new GridBagLayout());

    	addComponent(panel, msgLabel, 0, 0, 1, 1, GridBagConstraints.LINE_START);
    	addComponent(panel, msgTextField, 1, 0, 2, 1, GridBagConstraints.LINE_START);
    	
    	addComponent(panel, keyLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);
    	addComponent(panel, keySpinner, 1, 1, 1, 1, GridBagConstraints.LINE_START);
    	
    	addComponent(panel, actionLabel, 0, 2, 1, 1, GridBagConstraints.LINE_START);
    	group.add(encryptRadio);
    	group.add(decryptRadio);
    	addComponent(panel, encryptRadio, 1, 2, 1, 1, GridBagConstraints.LINE_START);
   	addComponent(panel, decryptRadio, 2, 2, 1, 1, GridBagConstraints.LINE_START);
    	encryptRadio.setSelected(true);
    	encryptRadio.addActionListener(this);
    	decryptRadio.addActionListener(this);
    	
    	addComponent(panel, resultLabel, 0, 3, 1, 1, GridBagConstraints.LINE_START);
    	addComponent(panel, resultTextField, 1, 3, 2, 1, GridBagConstraints.LINE_START);
    	resultTextField.setEditable(false);
    	
    	addComponent(panel, actionButton, 1, 4, 1, 1, GridBagConstraints.CENTER);
    	actionButton.addActionListener(this);
    	
    	this.add(panel);
    	this.setVisible(true);
    }
    
    private void addComponent(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
    	GridBagConstraints gc = new GridBagConstraints();
    	gc.gridx = x;
    	gc.gridy = y;
    	gc.gridwidth = width;
    	gc.gridheight = height;
    	gc.weightx = 100.0;
    	gc.weighty = 100.0;
    	gc.insets = new Insets(5, 5, 5, 5);
    	gc.anchor = align;
    	gc.fill = GridBagConstraints.NONE;
    	p.add(c, gc);
    }
    
    private void encryptMessage(String msg, int k) {
    	String result = "";
    	resultTextField.setText("");
    	for (int i = 0; i < msg.length(); i++)
    		result += encryptChar(msg.charAt(i), k);
    	resultTextField.setText(result);
    }
    
    private char encryptChar(char c, int k) {
    	if (Character.isLetter(c))
    		return (char) ('A' + (c - 'A' + k) % 26);
    	else
    		return c;
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == encryptRadio)
    		actionButton.setText("Encrypt Message");
    		
    	if (e.getSource() == decryptRadio)
    		actionButton.setText("Decrypt Message");
    		
    	if (e.getSource() == actionButton) {
    		String str = msgTextField.getText();
    		int k = (Integer) keySpinner.getValue();
    		int key = 0;
    		String message = "";

    		if (str.equals("")) {
    			JOptionPane.showMessageDialog(null, "Please enter a message!", "Error!", JOptionPane.ERROR_MESSAGE);
    			msgTextField.requestFocus();
    			return;
    		}
    		
    		message = str.toUpperCase();
    		if (encryptRadio.isSelected())
    			key = k;
    		else
    			key = 26 - k;
    			
    		encryptMessage(message, key);
    	}
    }
}