
import java.awt.*;
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
public class Color_Palletes extends Converter {
    

    //public List<int> arraylist= new Arraylist <int> ();
    
    int i=0,r,g,b,x;
    //public Color [] cheat={"white", "gold", "#c07", "#20008c", "black"};
   // public static float mul,Temp;
    
 
    //create 7colour heat map rgb values
    public void Rain() {
        
        i=0;
        while (i<1792){
            
            //from white to red
            for ( x=255; x>=0; x--,i++) c7[i]=new Color(255,x,x);
            //from red to yellow
            for (g=0; g<=255; g++,i++) c7[i]=new Color(255,g,0);
            //from yellow to green
            for (r=255; r>=0; r--,i++) c7[i]=new Color(r,255,0);
            //from green to cyan
            for (b=0; b<=255; b++,i++) c7[i]=new Color(0,255,b);
            //from cyan to blue
            for (g=255; g>=0; g--,i++) c7[i]=new Color(0,g,255);
            //from blue to voilet
            for (r=0; r<=255; r++,i++) c7[i]=new Color(r,0,255);
            //from voilet to black
            for (x=255; x>=0; x--,i++) c7[i]=new Color(x,0,x);
            
            
            }
        
        }
    
    //create fusion 6 color heat map
    public void Fusion() {
        //64
        i=0;
        while (i<895){
            //from white to yellow
            for (b=255; b>0; b--,i++) cf[i]=new Color(255,255,b);
            //from yellow to orange
            for (g=255; g>=128; g--,i++) cf[i]=new Color(255,g,0);
            //from orange to voilet
            for (b=0; b<=255; b++,i++) cf[i]=new Color(255,128-b/2,b);
            //from voilet to lightblue
            for (r=255; r>=128; r--,i++) cf[i]=new Color(r,0, 255);
            //from lightblue to black
            for (b=255; b>0; b=b-2,i++) cf[i]=new Color(b/2,0,b);
            
            }        
        }
    
    
    
    
    //create 5color heat map rgb values
    public void Rainbow() {
        
        i=0;
        while (i<1024 ){  
            
            //from white to red
            for (x=255; x>=0; x--,i++) c5[i]=new Color(x,255,x,x);
            //from red to green
            for (g=0; g<=255; g++,i++) c5[i]=new Color(255-g,g,0);
            //from green to blue
            for (b=0; b<=255; b++,i++) c5[i]=new Color(0,255-b,b);
            //from blue to black
            for (b=0; b<=255; b++,i++) c5[i]=new Color(0,0,255-b);
            
            }
        
        }
    
    
    //create 2color mono or gray scale heat map rgb values 
    public void White_Hot() {
        
        i=0;
        while (i<256 ){
            //from white to black
            for (x=255; x>=0; x--,i++) c2m[i]=new Color(x,x,x);
            }
        
        }
    
    
    //create 2color heat map rgb values
    public void Color2_Heat_Map() {
        
        i=0;
        while (i<256 ){
            //from red to blue
            for (x=255; x>=0; x--,i++) c2[i]=new Color(x,0,255-x);
            }
        
        }  
    
    
    
    
    public void Read_Image(File Infile,File Outfile) throws IOException {
        
        
        BufferedImage image = ImageIO.read(Infile);
        int y,x,clr,red,green,blue;
        
        // Getting pixel color by position x and y 
        int HIEGHT=image.getHeight();
        int WIDTH=image.getWidth();
        cinput= new Color[HIEGHT][WIDTH];           //Create array for save rgb values of every pixel
        
        
        for (y=0 ; y<HIEGHT;y++){
            for(x=0;x<WIDTH;x++) {
                clr=  image.getRGB(x,y); 
                //int alpha=(clr & 0xff000000) >>24;
                red   = (clr & 0x00ff0000) >> 16;
                green = (clr & 0x0000ff00) >> 8;
                blue  =  clr & 0x000000ff;
                
                this.cinput[y][x]=new Color(red,green,blue);    //add rgb values to the array
                
            }
        }
        
        System.out.print("Image size = "+cinput[0].length+" x "+cinput.length+" pixels\n");
        
        Temp_Converter_Image(45.0,15.0,30.5,64,this.cf,this.cinput,Infile,Outfile);       //run the function for convert to temperature values from rgb value
    
        
    }

    
}
