package MODEL;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Windows
 */
public class LimiteDigitos extends  PlainDocument{
  private int quantidadeMax;
  
  public LimiteDigitos(int maxLen){
      super();
      if(maxLen<=0)
          throw new IllegalArgumentException("Especifique a quantidade");
      quantidadeMax = maxLen;
  }
    
  @Override
  public void insertString(int offset, String str, AttributeSet atr)
  throws BadLocationException{      
  if(str==null||getLength()==quantidadeMax)
      return;
  int totalQuantia=(getLength()+str.length());
  try{
  if(totalQuantia<=quantidadeMax){
      super.insertString(offset, str.replaceAll("[^0-9]", ""), atr);
  }
  
  String nova = str.substring(0,getLength()-quantidadeMax);
  super.insertString(offset, nova, atr);
  }
  catch(StringIndexOutOfBoundsException ex){
      System.out.println("Limite máximo de caracteres não preenchidos.");
  }
        
  }
    
}
