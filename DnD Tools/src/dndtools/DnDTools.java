/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndtools;


import java.io.BufferedReader;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;


/**
 *
 * @author Utente
 */
public class DnDTools {
    
    protected static guiDDtools main;
    protected static String path="";
    protected static int slot=0;
   
    
    protected static int oggetti_rarità1[]=new int[2];;
    protected static int oggetti_rarità2[]=new int[2];;
    protected static int oggetti_rarità3[]=new int[2];;
    protected static int oggetti_rarità4[]=new int[2];;
    protected static int oggetti_rarità5[]=new int[2];;
    protected static int oggetti_rarità6[]=new int[2];;
    
    protected static int mostrolvl1[]=new int[2];;
    protected static int mostrolvl2[]=new int[2];;
    protected static int mostrolvl3[]=new int[2];;
    protected static int mostrolvl4[]=new int[2];;
    protected static int mostrolvl5[]=new int[2];;
    protected static int mostrolvl6[]=new int[2];;
    protected static int mostrolvl7[]=new int[2];;
   
    
    /**
     * @param numero_item
     */
    
    protected static void openFiles() throws FileNotFoundException, IOException
    {
        FileReader file;
        BufferedReader buff;
        
        try
        {
             file = new FileReader("valori_utente.txt");
             buff = new BufferedReader(file);
             set_oggetti_mostri(buff);
             
            System.out.println("Chiudo nel try");
            file.close();
            buff.close();
             
        }
        catch(FileNotFoundException a)
        {    
            
             file = new FileReader("valori_default.txt");
             buff = new BufferedReader(file);
             set_oggetti_mostri(buff);
            
            System.out.println("Chiudo nel catch");
            file.close();
            buff.close();
             
             a.printStackTrace();
        }
        catch (Exception e)
        {   
            System.out.println("non Chiudo");
            e.printStackTrace();
        }

        
        
       
    }
    
    protected static void set_oggetti_mostri(BufferedReader buff)
    {
        int i=0;
        String str="";
        try
        {
            while(true)
            {
                              
                str=buff.readLine();
                
                if(str==null)
                   break;
                            
                if(!str.equals("Oggetti") && !str.equals("Mostri") && !str.equals(""))
                  calcola_percentuali(i, Integer.parseInt(str));
              
              
                         
              i++;
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    protected static void calcola_percentuali(int riga,int percentuale)
    {
       // System.out.println("i=" + riga + " " + percentuale + "%");
        
        if(riga==1)
        {
            oggetti_rarità1[0]=0;
            oggetti_rarità1[1]=oggetti_rarità1[0]+(percentuale-1);
           // System.out.println(oggetti_rarità1[0] + " " + oggetti_rarità1[1]);
        }
        else if (riga==2)
        {
            oggetti_rarità2[0]=oggetti_rarità1[1]+1;
            oggetti_rarità2[1]=oggetti_rarità2[0]+(percentuale-1);
         //   System.out.println(oggetti_rarità2[0] + " " + oggetti_rarità2[1]);
        }
        else if(riga==3)
        {
            oggetti_rarità3[0]=oggetti_rarità2[1]+1;
            oggetti_rarità3[1]=oggetti_rarità3[0]+(percentuale-1);
          //  System.out.println(oggetti_rarità3[0] + " " + oggetti_rarità3[1]);
        }
        else if (riga == 4)
        {
            oggetti_rarità4[0]=oggetti_rarità3[1]+1;
            oggetti_rarità4[1]=oggetti_rarità4[0]+(percentuale-1);
         //   System.out.println(oggetti_rarità4[0] + " " + oggetti_rarità4[1]);
        }
        else if(riga==5)
        {
            oggetti_rarità5[0]=oggetti_rarità4[1]+1;
            oggetti_rarità5[1]=oggetti_rarità5[0]+(percentuale-1);
          //  System.out.println(oggetti_rarità5[0] + " " + oggetti_rarità5[1]);
        }
        else if (riga==6)
        {
            oggetti_rarità6[0]=oggetti_rarità5[1]+1;
            oggetti_rarità6[1]=oggetti_rarità6[0]+(percentuale);
         //   System.out.println(oggetti_rarità6[0] + " " + oggetti_rarità6[1]);
        }
        else if (riga == 9)
        {
             mostrolvl1[0]=0;
             mostrolvl1[1]=mostrolvl1[0]+(percentuale-1);
           //   System.out.println("OGGETTI\n" + mostrolvl1[0] + " " + mostrolvl1[1]);
        }
        else if (riga == 10)
        {
            mostrolvl2[0]=mostrolvl1[1]+1;
            mostrolvl2[1]=mostrolvl2[0]+(percentuale-1);
          //  System.out.println(mostrolvl2[0] + " " + mostrolvl2[1]);
        }
        else if (riga == 11)
        {
            mostrolvl3[0]=mostrolvl2[1]+1;
            mostrolvl3[1]=mostrolvl3[0]+(percentuale-1);
        //    System.out.println(mostrolvl3[0] + " " + mostrolvl3[1]);
        }
        else if (riga == 12)
        {
            mostrolvl4[0]=mostrolvl3[1]+1;
            mostrolvl4[1]=mostrolvl4[0]+(percentuale-1);
          //  System.out.println(mostrolvl4[0] + " " + mostrolvl4[1]);
        }
        else if (riga == 13)
        {
            mostrolvl5[0]=mostrolvl4[1]+1;
            mostrolvl5[1]=mostrolvl5[0]+(percentuale-1);
         //   System.out.println(mostrolvl5[0] + " " + mostrolvl5[1]);
        }
        else if (riga == 14)
        {
            mostrolvl6[0]=mostrolvl5[1]+1;
            mostrolvl6[1]=mostrolvl6[0]+(percentuale-1);
         //   System.out.println(mostrolvl6[0] + " " + mostrolvl6[1]);
        }
        else if (riga == 15)
        {
            mostrolvl7[0]=mostrolvl6[1]+1;
            mostrolvl7[1]=mostrolvl7[0]+(percentuale);
         //   System.out.println(mostrolvl7[0] + " " + mostrolvl7[1]);
        }
    }
    
    protected static void salva_valori_utente ()
    {
        try
        {
         FileOutputStream path = new FileOutputStream("valori_utente.txt");
         PrintStream scrivi = new PrintStream(path);
         
         scrivi.println("Oggetti");
         scrivi.println(guiDDtools.jTextField2.getText());   
         scrivi.println(guiDDtools.jTextField3.getText());
         scrivi.println(guiDDtools.jTextField4.getText());
         scrivi.println(guiDDtools.jTextField5.getText());
         scrivi.println(guiDDtools.jTextField6.getText());
         scrivi.println(guiDDtools.jTextField1.getText()); 
         scrivi.println("");
         scrivi.println("Mostri");
         
         scrivi.println(guiDDtools.jTextField8.getText());
         scrivi.println(guiDDtools.jTextField9.getText());
         scrivi.println(guiDDtools.jTextField10.getText());
         scrivi.println(guiDDtools.jTextField11.getText());
         scrivi.println(guiDDtools.jTextField12.getText());
         scrivi.println(guiDDtools.jTextField13.getText());
         scrivi.println(guiDDtools.jTextField7.getText());
         
         scrivi.close();
         path.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    protected static void randomItem(int numero_item)
    {
         int i;
         int randomNum;
     
         for (i=0; i<numero_item; i++)
         {
             randomNum=ThreadLocalRandom.current().nextInt(0, 100 + 1);
             
             if(randomNum >= oggetti_rarità1[0] && randomNum <= oggetti_rarità1[1]) // 60%
             {
                if(guiDDtools.jCheckBox1.isSelected())
                    DnDTools.readExcel("lista-tier-1.xlsx");
                else i--;
             }
             else if(randomNum >= oggetti_rarità2[0] && randomNum <=oggetti_rarità2[1]) // 15%
             {
                  if(guiDDtools.jCheckBox2.isSelected())
                     DnDTools.readExcel("lista-tier-2.xlsx");
                  else i--;
             }
             else if(randomNum >= oggetti_rarità3[0] && randomNum <= oggetti_rarità3[1]) // 10%
             {
                 if(guiDDtools.jCheckBox3.isSelected())
                    DnDTools.readExcel("lista-tier-3.xlsx");
                 else
                     i--;
             }
             else if(randomNum >= oggetti_rarità4[0] && randomNum <= oggetti_rarità4[1]) // 7%
             {
                  if(guiDDtools.jCheckBox4.isSelected())
                     DnDTools.readExcel("lista-tier-4.xlsx");
                  else i--;
             }
             else if(randomNum >= oggetti_rarità5[0] && randomNum <= oggetti_rarità5[1] ) // 5%
             {
                 if(guiDDtools.jCheckBox5.isSelected())
                     DnDTools.readExcel("lista-tier-5.xlsx");
                 else
                     i--;
             }
             else if(randomNum >= oggetti_rarità6[0] && randomNum <= oggetti_rarità6[1]) 
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
                InputStream ExcelFileToRead = new FileInputStream(path+"\\"+nomefile);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
                
                int n=sheet.getPhysicalNumberOfRows();
                int randomNum=ThreadLocalRandom.current().nextInt(3, n + 1);
                
                
               // System.out.println("n_righe:"+n + "nrand="+randomNum);
                
		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{       
                        
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
                        
                        if(n_righe==randomNum)
                        {
                            while (cells.hasNext())
                            {   
                           
				cell=(XSSFCell) cells.next();
                                
                            if(n_righe>2)
                            {
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{       
                                                            
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
                            }
                                
                                n_colonna++;
                            }
                        }
                       // System.out.println("Riempio con: " + c1 + c2 + c3 + c4 + c5);
                       if(n_righe==randomNum)
                        riempi_Tabella(c1,c2,c3,c4,c5,c6);
                       
                       
			//System.out.println();
                        n_colonna=0;
                        n_righe++;
		}
            }
            catch (FileNotFoundException e)
            {
               JOptionPane.showMessageDialog(main, "Files Excel non trovati.\nControlla il percorso della cartella degli oggetti magici","Messaggio d'errore", JOptionPane.ERROR_MESSAGE);
               e.printStackTrace();
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
        filechooser.loadpath();
        main= new guiDDtools();
        main.setVisible(true);
        try
        {
        openFiles();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
       
    }
    
}
