import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import com.sun.crypto.provider.SunJCE;


public class DES
{
  public static void main(String [] args) throws Exception
  {
            Cipher desCipher;
            int deskey;
            int choice;
            String input;
            String inputString;
            Boolean x = true;
            KeyGenerator keygen = KeyGenerator.getInstance("DES");

            SecretKey desKey = keygen.generateKey();

            while(x= true)
         {
            inputString = JOptionPane.showInputDialog("Choose 1. for Encrypt, 2. for Decrypt, 3. to quit.");
            choice = Integer.parseInt(inputString);
            if(choice == 1)
              {
                  inputString = JOptionPane.showInputDialog("Enter Text to be encrypted");
                    // Create the cipher
                    desCipher = Cipher.getInstance("DES");
                         // Initialize the cipher for encryption
                    
                        desCipher.init(Cipher.ENCRYPT_MODE, desKey);
                        // Our cleartext

                        byte[] cleartext = inputString.getBytes();
 
                        // Encrypt the cleartext
                        byte[] ciphertext = desCipher.doFinal(cleartext);

                        JOptionPane.showMessageDialog(null, " Encrypted text is " + ciphertext );

 

                        // Initialize the same cipher for decryption

                        desCipher.init(Cipher.DECRYPT_MODE, desKey);

                        // Decrypt the ciphertext
                   byte[] cleartext1 = desCipher.doFinal(ciphertext);

          }
                else if(choice == 2)

                {

                    inputString = JOptionPane.showInputDialog("Enter Text to be decrypted");
                                     // Create the cipher
                                        desCipher = Cipher.getInstance("DES");

                     // Initialize the same cipher for decryption

                        desCipher.init(Cipher.DECRYPT_MODE, desKey);

 

                        byte[] ciphertext2 = inputString.getBytes();

                                            // Decrypt the ciphertext

                        byte[] cleartext1 = desCipher.doFinal(ciphertext2);

                        JOptionPane.showMessageDialog(null, " Decrypted text is " + ciphertext2 );

                }
                 else if (choice >= 3)

                {

                    JOptionPane.showMessageDialog(null, " bye!" );

                    System.exit(0);

                }

    }

    }

}
