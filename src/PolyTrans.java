
import java.util.Scanner;

public class PolyTrans {
    
    /** Creates a new instance of PolyTrans */
    public PolyTrans(String key, String plain) {
        keyword=key;
        PlainText=plain;
    }
    
    public void UserEntery() {
        
        
        
        
        
        
        Encrypt();
        FillCharacMatrix();
        Decrypt();
        
    }
    
    public String getCipher(){
        return cyphir;
    }
    
    
    public String getDeCipher(){
        return dcyphir;
    }
    
    
    public void FillCharacMatrix(){
        
        for(int i=0; i<=25; i++){
            for(int j=0; j<=25; j++){
                CharMatrix[i][j]=characters[(j+i)%26];
            }
        }
        
        for(int i=0;i<=25;i++) {
            
            System.out.print(" | ");
            for(int j=0;j<=25;j++) {
                
                
                System.out.print(" "+CharMatrix[i][j]+" ");
            }
            System.out.println(" | ");
            
        }
    }
    
    public void Encrypt() {
        int sub1=0,sub2=0,sub3=0;
        int sub=0;
        char char_num;
        int start=0;
        for(int i=0; i<PlainText.length(); i++) {
            sub1=PlainText.substring(i,i+1).codePointAt(0);
            sub2=keyword.substring(start,start+1).codePointAt(0);
            start++;
            sub3=sub1+sub2;
            sub3=sub3%97;
            sub=sub3%26;
            
            if(cyphir==null)
                cyphir=""+characters[sub];
            else
                cyphir+=characters[sub];
            
            
            
            if(start==keyword.length()){
                start=0;
            }
            
            
        }
        System.out.println("The Cipher Text is: "+ cyphir);
    }
    public void Decrypt(){
        int sub1=0,sub2=0,sub3=0;
        int keyword_len;
        int sub=0;
        int cyphir_len;
        char char_num;
        int start=0;
        for(int i=0; i<PlainText.length(); i++) {
            sub1=cyphir.substring(i,i+1).codePointAt(0);
            sub2=keyword.substring(start,start+1).codePointAt(0);
            
            start++;
            
            sub1=(sub1%97)%26;
            sub2=(sub2%97)%26;
            
            
            for(int k=0; k<26; k++) {
                sub3=(Integer.parseInt(""+(short)CharMatrix[sub2][k])%97)%26;
                
                if(sub1==sub3){
                    
                    if(dcyphir==null)
                        dcyphir=Character.toString(CharMatrix[0][k]);
                    else
                        dcyphir+=Character.toString(CharMatrix[0][k]);
                }
            }
            
            
            
            
            
            
            if(start==keyword.length()){
                start=0;
            }
            
            
        }
        System.out.println("The Dciphir Text is: "+ dcyphir);
        
    }
    
    
    private  int Len=0;
    private String keyword;
    private String PlainText;
    private String cyphir;
    private String [][] charmatriex;
    private String matrixv;
    private char [][] CharMatrix=new char[26][26];
    private char characters[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private String dcyphir;
    
}
