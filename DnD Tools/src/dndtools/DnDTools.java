/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndtools;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Utente
 */
public class DnDTools {

    /**
     * @param numero_item
     */
    
    protected static void randomItem(int numero_item)
    {
         int i;
         int randomNum;
     
         for (i=0; i<numero_item; i++)
         {
             randomNum=ThreadLocalRandom.current().nextInt(0, 100 + 1);
             
             if(randomNum >= 0 && randomNum <= 59) // 60%
             {
                if(guiDDtools.jCheckBox1.isSelected())
                    System.out.println("RARITA 1" + " : " + randomNum);
                else i--;
             }
             else if(randomNum >= 60 && randomNum <=74) // 15%
             {
                  if(guiDDtools.jCheckBox2.isSelected())
                    System.out.println("RARITA 2"+ " : " + randomNum);
                  else i--;
             }
             else if(randomNum >= 75 && randomNum <= 84) // 10%
             {
                 if(guiDDtools.jCheckBox3.isSelected())
                    System.out.println("RARITA 3"+ " : " + randomNum);
                 else
                     i--;
             }
             else if(randomNum >= 85 && randomNum <= 92) // 7%
             {
                  if(guiDDtools.jCheckBox4.isSelected())
                    System.out.println("RARITA 4"+ " : " + randomNum);
                  else i--;
             }
             else if(randomNum >= 93 && randomNum <= 97 ) // 5%
             {
                 if(guiDDtools.jCheckBox5.isSelected())
                    System.out.println("RARITA 5"+ " : " + randomNum);
                 else
                     i--;
             }
             else // 3%
             {  
                  if(guiDDtools.jCheckBox6.isSelected())
                    System.out.println("RARITA 6"+ " : " + randomNum);
                  else
                      i--;
             }
         }
    }
    
    protected static void readExcel(int indice)
    {
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
       
        guiDDtools main= new guiDDtools();
        main.setVisible(true);
    }
    
}
