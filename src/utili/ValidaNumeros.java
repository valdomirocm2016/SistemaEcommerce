/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utili;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Valdomiro
 */
public class ValidaNumeros extends PlainDocument{
    
    @Override
    public void insertString(int offs,String str,javax.swing.text.AttributeSet a) throws BadLocationException{
        super.insertString(offs, str.replaceAll("[^0-9|^.]",""), a);
        
    }
  
}
