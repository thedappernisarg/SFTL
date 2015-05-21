import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class assig extends JFrame

{

    private static class cahr {

        public cahr() {
        }
    }



private JTextField txtKey,txtInp,txtOut;
private JLabel lab=new JLabel("I = j AND i");
cahr toBeFound1, toBeFound2;






private JButton comClear,comDec,comEnc,ext;
Container container = getContentPane();
public void division()
{

char m[];


String mou=txtKey.getText().toUpperCase();
m=new char[mou.length()];

int zx=0;
char zz[];



String mou1="ABCDEFGHIKLMNOPQRSTUVWXYZ";
int i,j;
String out=" ";
String key = "";
zz=new char[mou1.length()];
//input data to key
for( i=0; i<mou1.length();i++)
{for ( j=0;j<key.length();j++)
{
if((mou1.charAt(i)==key.charAt(j))||(mou1.charAt(i)=='i'&& key.charAt(j)=='j')||(mou1.charAt(i)=='j'&& key.charAt(j)=='i'))
break;
}
if (j==key.length()){
out+=mou1.charAt(i);
}
out=key+out;




for(i=0;i<mou.length();i++)
{
m[i]=mou.charAt(i);
}//end for

}

}//end Division




public assig()
{
super("assignment#1");
createFrame();

comClear.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent e)
{
for(int i=0;i<5;i++)
txtOut.setText("");
txtInp.setText("");
txtKey.setText("");
}});

//String c=txtOut.getText();

comDec.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent e)
{
division();



txtInp.setText("");
txtOut.setText("djsklgjsdgj");



}});

comEnc.addActionListener(new ActionListener()
{
String mz=txtInp.getText();
public void actionPerformed(ActionEvent e)
{

txtInp.setText(mz);
txtOut.setText("");


}});


ext.addActionListener(new ActionListener()
{public void actionPerformed(ActionEvent e)
{
System.exit(0);

}});

}//end constracter



public void createFrame()
{
container.setLayout(null);




//textfield
txtKey = new JTextField("key");
txtInp = new JTextField("Input");
txtOut = new JTextField("out");
//array=new JTextField[5][5];
comClear=new JButton("Clear");
comEnc=new JButton("DECRYPT");
comDec=new JButton("ENCRYPT");
ext=new JButton("Exit");
lab.setBounds(200,150,200, 200);






txtKey .setBounds(500,10,100,30);
txtInp.setBounds(10,50,150,100);
txtOut.setBounds(10,160,150,100);
comClear.setBounds(10,10,100,30);
comDec.setBounds(120,10,100,30);
comEnc.setBounds(230,10,100,30);
ext.setBounds(340,10,100,30);

// array1[0].setBounds(230,10,100,30);


container.add(lab);
container.add(txtKey);
container.add(txtInp);
container.add(txtOut);
container.add(comClear);
container.add(comDec);
container.add(comEnc);
container.add(ext);




}//end method createframe

public static void main(String asd[])
{
assig assig = new assig();
assig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
assig.setSize(700,450);
assig.setLocation(180,100);
assig.setVisible(true);
}//end main


}//end class 

