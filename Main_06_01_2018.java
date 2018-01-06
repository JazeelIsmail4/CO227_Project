
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ruzain Ahmedh J
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        
        File Infilepath= new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\New folder");
        File [] Infiles= Infilepath.listFiles();
          
        Color_Palletes CP=new Color_Palletes();
        CP.Rain();                      //run the function for 7colour heat map rgb creation
        CP.Rainbow();                  //run the function for 5colour heat map rgb creation
        CP.Color2_Heat_Map();          //run the function for 2colour heat map rgb creation
        CP.White_Hot();                //run the function for 2colour mono heat map rgb creation
        CP.Fusion();                   // run the function for fusion heat map rgb creation  
        

        MulImgRead_Folder(Infiles,Infilepath,CP);
        
    }//end of Main(String [] args....)
  
    
    //Reads the multiples images 
    private static void MulImgRead_Folder(File [] Infiles,File Infilepath,Color_Palletes CP) throws IOException {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String PREFIX="Results "+dateFormat.format(date);        //Output file's folder name
        
        
        if (Infiles != null) {
            
            //reads images one by one
            for (File Afile:Infiles) {

                String FileName=Afile.getName();        //get the image name

                //only reads jpg/png/jpeg images
                if (FileName.endsWith(".jpg") == true ||FileName.endsWith(".png") == true || 
                    FileName.endsWith(".jpeg") == true ) {

                    String OutImageName =FileName.replace(".jpg", "_Output.png");       //replace the extention of the image as _output.png
                    String OutputFilePath = Infilepath+"\\"+PREFIX+"\\"+OutImageName;
                    File Outfile = new File(OutputFilePath);                            //Create the outpul file
                    Outfile.mkdirs();                                                   //making directory for output print

                    System.out.print(FileName+"\n");
                    CP.Read_Image(Afile,Outfile);

                }//end of if(FileName.endsWith.......)

            }//end of for(File ....)     
        
        } //end of if(...)

        
     
    
    
    }//end of MulImgRead_Folder....
    
   
    
    
}//End of the Main class
