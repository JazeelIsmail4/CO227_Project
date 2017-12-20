
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.imageio.ImageIO;

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
        
        File Infilepath= new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images");
        File [] Infiles= Infilepath.listFiles();


       // File Outfile = new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\Output1.png");

//        //Scaller s=new Scaller();
//        //s.Color7_Heat_Map();
//        
//        //ReadAndWriteImage RWI=new ReadAndWriteImage();
////        ReadImage RI=new ReadImage();
////        RI.RWImage(Infile,Outfile);
//        
        //Color [] c7 = new Color[1792];
        Color_Palletes CP=new Color_Palletes();
        CP.Rain();                      //run the function for 7colour heat map rgb creation
        CP.Rainbow();                  //run the function for 5colour heat map rgb creation
        CP.Color2_Heat_Map();          //run the function for 2colour heat map rgb creation
        CP.White_Hot();                //run the function for 2colour mono heat map rgb creation
        CP.Fusion();                   // run the function for fusion heat map rgb creation  
        

        //Main M=new Main();
        MulImgRead_Folder(Infiles,Infilepath,CP);
        
//        Converter Cnv= new Converter();
//        Cnv.Temp_Converter(40.0,20.0, c7);
        
//          test t=new test();
//          t.ColorFrame(400,250);
        
        
        
        
        
    }
    
    
    private static void MulImgRead_Folder(File [] Infiles,File Infilepath,Color_Palletes CP) throws IOException {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        String PREFIX="Results "+dateFormat.format(date).toString();        //Output file's folder name
        System.out.print(PREFIX+"\n");
        
        
        
        
        if (Infiles != null) {
      
            for (File Afile:Infiles) {

                String FileName=Afile.getName();

                //only reads jpg/png/jpeg images
                if (FileName.endsWith(".jpg") == true ||FileName.endsWith(".png") == true || 
                    FileName.endsWith(".jpeg") == true ) {

                    String OutImageName =FileName.replace(".jpg", "_Output.png");
                    String OutputFilePath = Infilepath+"\\"+PREFIX+"\\"+OutImageName;
                    File Outfile = new File(OutputFilePath);
                    Outfile.mkdirs();               //making directory for output print

                    //System.out.print(f+"\n");
                    CP.Read_Image(Afile,Outfile);

                }

            }     
        
        
        } else  {
    
            String FileName=Infilepath.getName();
            //System.out.print(FileName+"\n");
            
                //only reads jpg/png/jpeg images
                if (FileName.endsWith(".jpg") == true ||FileName.endsWith(".png") == true || 
                    FileName.endsWith(".jpeg") == true ) {

                    String OutImageName =FileName.replace(".jpg", "_Output.png");
                    String Inpath = Infilepath.getParent();
                    //System.out.print(Inpath+"\n");
                    String OutputFilePath = Inpath+"\\"+PREFIX+"\\"+OutImageName;
                    File Outfile = new File(OutputFilePath);
                    Outfile.mkdirs();               //making directory for output print

                    //System.out.print(f+"\n");
                    CP.Read_Image(Infilepath,Outfile);

                }
    
        }
        
     
    
    
    }
    
}
