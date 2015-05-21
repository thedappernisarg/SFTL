package substitution;

import ase.SBox.SBox;
import ase.SBox.invSBOX;

/**
 *
 * @author LenovoInside
 */
public class substitute_bytes {
    
    /** Creates a new instance of substitute_bytes */
    public substitute_bytes() 
    {
    }
    public String  getsubstitue_bytes(String cell)
    { 
          return sbox.getSbox(cell);
    }
     public String  invgetsubstitue_bytes(String cell)
    { 
          return invsbox.getinvSbox(cell);
    }

    private SBox sbox=new SBox();
    private invSBOX invsbox=new invSBOX();
    private int row;
    private int col;
    
}
