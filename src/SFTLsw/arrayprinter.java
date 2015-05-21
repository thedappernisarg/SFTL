 /*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */
package sftlsw;
 
public class arrayprinter {
    
    /** Creates a new instance of arrayprinter */
    public arrayprinter() {
    }
    public static void printarray(String[][] arr,String label) {
        AESPanel.StepsText.append("-- "+label+" -- "+'\n');
     
        for(int i=0;i<arr.length ;i++) {
            AESPanel.StepsText.append("| ");
            for(int j=0;j<arr[0].length;j++) {
                
                AESPanel.StepsText.append(arr[i][j]+" ");
            }
            AESPanel.StepsText.append("| "+'\n');
        }
    }
}
 /*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */