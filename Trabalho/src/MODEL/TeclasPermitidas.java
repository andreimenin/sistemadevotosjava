package MODEL;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Windows
 */
public class TeclasPermitidas extends PlainDocument{
   
    @Override
    public void insertString(int offSet, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offSet, str.replaceAll("[^0-9]",""), attr);       
    }
        
    public void replace(int offSet, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offSet, str.replaceAll("[^0-9]",""), attr);       
    }
        
    
}
