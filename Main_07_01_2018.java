
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
    
    public static double MINTEMP,MAXTEMP,HIGHTEMP;
    public static int TOL;
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        
        MINTEMP=20.0;       //max temperature of the scale
        MAXTEMP=40.0;       //min temperature of the scale
        HIGHTEMP=37.0;      //high temperature of the surface
        TOL=64;             //tolerance for find the nearest color from color palletes  
        
        
        
        Color_Palletes CP=new Color_Palletes();
        CP.Rain();                     //run the function for 7colour heat map rgb creation
        CP.Rainbow();                  //run the function for 5colour heat map rgb creation
        CP.Color2_Heat_Map();          //run the function for 2colour heat map rgb creation
        CP.White_Hot();                //run the function for 2colour mono heat map rgb creation
        CP.Fusion();                   // run the function for fusion heat map rgb creation 
        
        
        
        //get the path of the folder/images
        File Infilepath= new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images");
        
        
        int S=0;        //s=0 image selection , s=1 folder selection
        
        //image selection
        if(S==0){
            File [] Infiles=Infilepath.listFiles();
            
            MulImgRead(Infiles,Infilepath,CP);
        
        //folder selection    
        } else if (S==1){
            File [] Infiles= Infilepath.listFiles(File::isDirectory);
            Infilepath=Infiles[0];
            Infiles=Infilepath.listFiles();

            MulImgRead(Infiles,Infilepath,CP);
        
        } // end of else if (S==1...)
        
        
    }//end of Main(String [] args....)
  
    
    
    
    //Reads the multiples images from folder selection
    private static void MulImgRead(File [] Infiles,File Infilepath,Color_Palletes CP) throws IOException {
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String PREFIX="Results "+dateFormat.format(date);        //Output file's folder name
        
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
     
    
    }//end of MulImgRead_Folder....
    
   
    
    
    
    
    
}//End of the Main class
