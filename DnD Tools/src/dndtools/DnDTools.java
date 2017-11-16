/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndtools;


import java.util.concurrent.ThreadLocalRandom;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;


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
                    DnDTools.readExcel("lista-tier-1.xlsx");
                else i--;
             }
             else if(randomNum >= 60 && randomNum <=74) // 15%
             {
                  if(guiDDtools.jCheckBox2.isSelected())
                     DnDTools.readExcel("lista-tier-2.xlsx");
                  else i--;
             }
             else if(randomNum >= 75 && randomNum <= 84) // 10%
             {
                 if(guiDDtools.jCheckBox3.isSelected())
                    DnDTools.readExcel("lista-tier-3.xlsx");
                 else
                     i--;
             }
             else if(randomNum >= 85 && randomNum <= 92) // 7%
             {
                  if(guiDDtools.jCheckBox4.isSelected())
                     DnDTools.readExcel("lista-tier-4.xlsx");
                  else i--;
             }
             else if(randomNum >= 93 && randomNum <= 97 ) // 5%
             {
                 if(guiDDtools.jCheckBox5.isSelected())
                     DnDTools.readExcel("lista-tier-5.xlsx");
                 else
                     i--;
             }
             else // 3%
             {  
                  if(guiDDtools.jCheckBox6.isSelected())
                     DnDTools.readExcel("lista-tier-epico-leggendario.xlsx");
                  else
                      i--;
             }
         }
    }
    
    protected static void readExcel(String nomefile)
    {
            try
            {   
                String c1="",c2="",c3="",c4="",c5="",c6="";
                int n_colonna=0, n_righe=0;
                InputStream ExcelFileToRead = new FileInputStream(filechooser.path+"\\"+nomefile);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{       
                        
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                
                            if(n_righe>2)
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{       
                                        
					//System.out.print(n_colonna + "=>" + cell.getStringCellValue()+" ");
                                        
                                        if (n_colonna==1)
                                            c1=cell.getStringCellValue();
                                        else if(n_colonna==2)
                                            c2=cell.getStringCellValue();
                                        else if(n_colonna==3)
                                            c3=cell.getStringCellValue();
                                        else if(n_colonna==4)
                                            c4=cell.getStringCellValue();
                                        else if(n_colonna==6)
                                            c6=cell.getStringCellValue();
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{       
                                        if(n_colonna==5)
                                            c5=Integer.toString((int)cell.getNumericCellValue());
                                        else if(n_colonna==6)
                                            c6=Integer.toString((int)cell.getNumericCellValue());
                                             
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
                                
                                n_colonna++;
			}
                       // System.out.println("Riempio con: " + c1 + c2 + c3 + c4 + c5);
                       if(n_righe>2)
                        riempi_Tabella(c1,c2,c3,c4,c5,c6);
                       
                       
			System.out.println();
                        n_colonna=0;
                        n_righe++;
		}
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
	
    }
    
     protected static void riempi_Tabella(String rarità, String nome, String descrizione,String spazio,String quantità, String proiettili)
    {
        //Upcast del JTable in DefaultTableModel per poter inserire righe nella tab
        DefaultTableModel model = (DefaultTableModel) guiDDtools.jTable2.getModel();
    
        model.insertRow(model.getRowCount(), (new Object[]{ rarità,nome,descrizione,spazio,quantità,proiettili}));
           
        
        
        
    }
     
     
    public static void main(String[] args) {
        // TODO code application logic here
       
        guiDDtools main= new guiDDtools();
        main.setVisible(true);
    }
    
}
