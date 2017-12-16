
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
       
        File Infile= new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\1.jpg");
        File Outfile = new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\Output1.png");
//        
//        File Infile2= new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\thermal-image1-26_2_3.jpg");
//        File Outfile2 = new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\Output7.png");
        
        //File Infile2= new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\thermal-image1-26_2_3.jpg");
//        File Outfile2 = new File("C:\\Users\\Ruzain Ahmedh J\\Desktop\\Images\\Output7.png");
//        //Scaller s=new Scaller();
//        //s.Color7_Heat_Map();
//        
//        //ReadAndWriteImage RWI=new ReadAndWriteImage();
////        ReadImage RI=new ReadImage();
////        RI.RWImage(Infile,Outfile);
//        
        //Color [] c7 = new Color[1792];
        Color_Palletes CP=new Color_Palletes();
        CP.Rain();
//        //Rain();                     //run the function for 7colour heat map rgb creation
        CP.Rainbow();                  //run the function for 5colour heat map rgb creation
        CP.Color2_Heat_Map();          //run the function for 2colour heat map rgb creation
        CP.White_Hot();                //run the function for 2colour mono heat map rgb creation
        CP.Fusion();  
        CP.Read_Image(Infile,Outfile);
        
        
//        Converter Cnv= new Converter();
//        Cnv.Temp_Converter(40.0,20.0, c7);
        
//          test t=new test();
//          t.ColorFrame(400,250);
        
        
        
        
        
    }
    
}
