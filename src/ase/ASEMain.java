package ase;
import AddRoundKey.KeyExpansion;
import ase.AES;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


/**
 *
 * @author DEEP
 */
public class ASEMain   {
    
    /** Creates a new instance of DesMain */
    public ASEMain() {
    }
    
    public static void main(String [] rr){
        AESPanel  mm = new AESPanel();
        mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mm.setVisible(true);
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
class AESPanel extends JFrame{
    public static   JTextArea StepsText = new JTextArea(17,70);
    private    AES mm;
    private    KeyExpansion ee =new KeyExpansion();
    private    Container c=this.getContentPane();
    private    JButton btnCihper = new JButton("Cipher");
    private    JButton btnDeCihper = new JButton("Decipher");
    
    private   JTextArea CipherText = new JTextArea(4,70);
    private   JTextArea OriginalText = new JTextArea(4,70);
    private   JTextArea DeCipherText = new JTextArea(4,70);
    
    
    private    JScrollPane OriginalScorl=new JScrollPane(OriginalText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private    JScrollPane CipherScorl=new JScrollPane(CipherText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private  JScrollPane DecipherScorl=new JScrollPane(DeCipherText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private   JScrollPane StepScorl=new JScrollPane(StepsText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private  JTextField KeyWord = new JTextField(16);
    private  JPanel PanelCipher = new JPanel();
    private  JPanel PanelDecipher = new JPanel();
    private  JPanel PanelKeyWord = new JPanel();
    private  JPanel PanelOriginaltxt = new JPanel();
    private JPanel jpstep=new JPanel();
    private  JLabel lblKeyWord= new JLabel("KeyWord : ");
    public AESPanel(){
        this.setTitle("AES");
        this.setSize(600,700);
        this.setVisible(true);
        setState(JFrame.MAXIMIZED_BOTH);
        setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        GenerateGUI();
    }
    
    
    private void GenerateGUI(){
        
        c.setLayout(new FlowLayout());
        
        
        PanelKeyWord.setLayout(new FlowLayout());
        PanelKeyWord.add(lblKeyWord);
        PanelKeyWord.add(KeyWord);
        
        PanelOriginaltxt.setBorder(BorderFactory.createTitledBorder("Original Text"));
        PanelOriginaltxt.setLayout(new FlowLayout());
        PanelOriginaltxt.add(OriginalScorl);
        
        PanelCipher.setBorder(BorderFactory.createTitledBorder("Cipher Text"));
        PanelCipher.setLayout(new FlowLayout());
        PanelCipher.add(CipherScorl);
        PanelCipher.add(btnCihper);
        
        PanelDecipher.setBorder(BorderFactory.createTitledBorder("Decipher Text"));
        PanelDecipher.setLayout(new FlowLayout());
        PanelDecipher.add(DecipherScorl);
        PanelDecipher.add(btnDeCihper);
        jpstep.setBorder(BorderFactory.createTitledBorder("Mointor"));
        jpstep.setLayout(new FlowLayout());
        jpstep.add(StepScorl);
        
        
        c.add(PanelKeyWord);
        c.add(PanelOriginaltxt);
        c.add(PanelCipher);
        c.add(PanelDecipher);
        c.add(jpstep);
        
        
        
        
        DoActions();
        
        
        
        
        
    }
    private void DoActions(){
        ActionHandler action = new ActionHandler();
        
        btnCihper.addActionListener(action);
        btnDeCihper.addActionListener(action);
        
    }
    
    private class ActionHandler implements ActionListener{
        
        
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnCihper){
                String plaintext=OriginalText.getText();
                String keyworD=KeyWord.getText();
                
                if(keyworD.length()<16) {
                    String Massg="Keyword must be 16 character";
                    JOptionPane.showConfirmDialog(null, Massg,"Error",
                            JOptionPane.ERROR_MESSAGE);
                } else  if(plaintext.length()<16) {
                    String Massg="Original Text must be 16 character or larger";
                    JOptionPane.showConfirmDialog(null, Massg,"Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    StepsText.setText(" ");
                    StepsText.append("keyword : "+keyworD+'\n');
                    StepsText.append("PlainText : "+plaintext+'\n');
                    mm= new AES( keyworD,plaintext);
                    
                    
                    
                    CipherText.append(mm.ASE_Cipher_loop());
                }
            }
            if(e.getSource()==btnDeCihper){
                if(mm!=null) {
                    
                    DeCipherText.setText(mm.ASE_Decipher_loop());
                }
                
            }
        }
        
    }
    
}

class DocumentSizeFilter extends DocumentFilter {
    int maxCharacters;
    
    public DocumentSizeFilter(int maxChars) {
        maxCharacters = maxChars;
    }
    
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
        
        if ((fb.getDocument().getLength() + str.length()) <= maxCharacters)
            super.insertString(fb, offs, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
    
    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
        
        if ((fb.getDocument().getLength() + str.length()- length) <= maxCharacters)
            super.replace(fb, offs, length, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
    
}



