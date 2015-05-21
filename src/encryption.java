

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author LenovoInside
 */
public class encryption extends JPanel implements ActionListener {

    char[]  str={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] str1={'!','@','#','$','%','^','&','*','(',')','-','=','_','+','`','|','{','}','[',']',';',':',',','<','>','/'};
    String k="";
    String l="";
    char[] a=new char[50];
    char[] b=new char[50];
    JLabel plain_lbl,enc_lbl,dec_lbl;
    JTextField tplain_txt,tenc_txt,tdec_txt;
    JButton bencrypt,bdecrypt,bclear,bexit;
    Font f1;

    public encryption()
    {
     f1=new Font(Font.MONOSPACED,Font.BOLD,20);

    plain_lbl=new JLabel("Plain Text");
    enc_lbl=new JLabel("Encrypted Text");
    dec_lbl=new JLabel("Decrypted Text");

    plain_lbl.setFont(f1);
    enc_lbl.setFont(f1);
    dec_lbl.setFont(f1);


    //JTextField

    tplain_txt=new JTextField(20);
    tenc_txt=new JTextField(20);
    tdec_txt=new JTextField(20);
    tenc_txt.setEditable(false);
    tdec_txt.setEditable(false);

    tplain_txt.setFont(f1);
    tenc_txt.setFont(f1);
    tdec_txt.setFont(f1);


    //JButton

    bencrypt=new JButton("Encryption");
    bdecrypt=new JButton("Decryption");
    bclear=new JButton("Clear");
    bexit=new JButton("Exit");

    //bencrypt.setEnabled(false);
    bdecrypt.setEnabled(false);
        
    bencrypt.setFont(f1);
    bdecrypt.setFont(f1);
    bclear.setFont(f1);
    bexit.setFont(f1);

    setLayout(null);

    add(plain_lbl);
    add(tplain_txt);
    add(enc_lbl);
    add(tenc_txt);
    add(dec_lbl);
    add(tdec_txt);
    add(bencrypt);
    add(bdecrypt);
    add(bclear);
    add(bexit);

    //Setbounds

    plain_lbl.setBounds(20, 20, 200,30);
    tplain_txt.setBounds(220,20,200,30);

    enc_lbl.setBounds(20,80,200,30);
    tenc_txt.setBounds(220,80,200,30);

    dec_lbl.setBounds(20,140, 200,30);
    tdec_txt.setBounds(220,140,200,30);

    bencrypt.setBounds(30,200,160,30);
    bdecrypt.setBounds(240,200,160,30);

    bclear.setBounds(30,240,160,30);
    bexit.setBounds(240,240,160,30);
    
    bencrypt.addActionListener(this);
    bdecrypt.addActionListener(this);
    bclear.addActionListener(this);
    bexit.addActionListener(this);

    //tplain_txt.addKeyListener(this);


    }
public void actionPerformed(ActionEvent ae)
    {
    String action=ae.getActionCommand();
    if(action.equals("Encryption"))
    {
         k=tplain_txt.getText().toString().toLowerCase();
        if(k.equals(""))
        {
            tplain_txt.setFocusable(true);
            JOptionPane.showMessageDialog(this, "Please Enter Any text !", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }
 else
        {
        bdecrypt.setEnabled(true);
        bencrypt.setEnabled(false);
       
        a=k.toCharArray();
        for(int i=0;i<k.length();i++)
        {
            for(int j=0;j<26;j++)
            {
             if(a[i]==str[j])
             {
                 a[i]=str1[j];
                 j=26;
             }
            }

        }
        for(int i=0;i<k.length();i++)
        {
          l=l+a[i] ;
        }
        tenc_txt.setText(l);
        l="";

       // JOptionPane.showMessageDialog(bencrypt,l.toString(),"Message",JOptionPane.INFORMATION_MESSAGE);

    }
  }
 else if(action.equals("Decryption"))
    {
  String x=tenc_txt.getText().toString();
  String y="";
  if(x.equals(""))
  {
      JOptionPane.showMessageDialog(this,"No Encrypted Message","Warning",JOptionPane.WARNING_MESSAGE);
  }
 else
  {
  b=x.toCharArray();
   //JOptionPane.showMessageDialog(this,k.toString(),"Warning",JOptionPane.WARNING_MESSAGE);
  for(int i=0;i<x.length();i++)
  {
      for(int j=0;j<26;j++)
      {
      if(b[i]==str1[j])
      {
          b[i]=str[j];
          j=26;
      }
      }
  }
  for( int i=0;i<x.length();i++)
  {
      y=y+b[i];
  }
  tdec_txt.setText(y);
  y="";
 }
 }
 else if(action.equals("Clear"))
    {
     
     tplain_txt.setText("");
     tenc_txt.setText("");
     tdec_txt.setText("");
     tplain_txt.setFocusable(true);
     bdecrypt.setEnabled(false);
     bencrypt.setEnabled(true);
     
    }
 else if(action.equals("Exit"))
    {
     System.exit(0);
 }
}
    public static void main(String[] args) {
        JFrame n=new JFrame();
        n.getContentPane().add(new encryption());
        n.setSize(440,310);
        n.setVisible(true);
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }
}

