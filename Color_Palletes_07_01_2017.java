
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
        
    private int i=0,r,g,b,x;

    //create 7colour heat map rgb values
    public void Rain() {
        
        i=0;
        while (i<1792){
            
            //from white to red
            for ( x=255; x>=0; x--,i++) C7[i]=new Color(255,x,x);
            //from red to yellow
            for (g=0; g<=255; g++,i++) C7[i]=new Color(255,g,0);
            //from yellow to green
            for (r=255; r>=0; r--,i++) C7[i]=new Color(r,255,0);
            //from green to cyan
            for (b=0; b<=255; b++,i++) C7[i]=new Color(0,255,b);
            //from cyan to blue
            for (g=255; g>=0; g--,i++) C7[i]=new Color(0,g,255);
            //from blue to voilet
            for (r=0; r<=255; r++,i++) C7[i]=new Color(r,0,255);
            //from voilet to black
            for (x=255; x>=0; x--,i++) C7[i]=new Color(x,0,x);
            
            }//end of while
        
        }//end of Rain
    
    
    //create fusion 6 color heat map
    public void Fusion() {
        i=0;
        while (i<895){
            //from white to yellow
            for (b=255; b>0; b--,i++) CF[i]=new Color(255,255,b);
            //from yellow to orange
            for (g=255; g>=128; g--,i++) CF[i]=new Color(255,g,0);
            //from orange to voilet
            for (b=0; b<=255; b++,i++) CF[i]=new Color(255,128-b/2,b);
            //from voilet to lightblue
            for (r=255; r>=128; r--,i++) CF[i]=new Color(r,0, 255);
            //from lightblue to black
            for (b=255; b>0; b=b-2,i++) CF[i]=new Color(b/2,0,b);
            
            }//end of while        
        }//end of Fusion
    
    
    
    
    //create 5color heat map rgb values
    public void Rainbow() {
        
        i=0;
        while (i<1024 ){  
            
            //from white to red
            for (x=255; x>=0; x--,i++) C5[i]=new Color(x,255,x,x);
            //from red to green
            for (g=0; g<=255; g++,i++) C5[i]=new Color(255-g,g,0);
            //from green to blue
            for (b=0; b<=255; b++,i++) C5[i]=new Color(0,255-b,b);
            //from blue to black
            for (b=0; b<=255; b++,i++) C5[i]=new Color(0,0,255-b);
            
            }//end of while
        
        }//end of Rainboe
    
    
    //create 2color mono or gray scale heat map rgb values 
    public void White_Hot() {
        
        i=0;
        while (i<256 ){
            //from white to black
            for (x=255; x>=0; x--,i++) C2M[i]=new Color(x,x,x);
            }//end of while
        
        }//end of White_Hot
    
    
    //create 2color heat map rgb values
    public void Color2_Heat_Map() {
        
        i=0;
        while (i<256 ){
            //from red to blue
            for (x=255; x>=0; x--,i++) C2[i]=new Color(x,0,255-x);
            }//end of while
        
        }//end of Color2_.....  
    
    
    
    
    public void Read_Image(File Infile,File Outfile) throws IOException {
        
        BufferedImage image = ImageIO.read(Infile);
        int y,x,clr,red,green,blue;
        
        // Getting pixel color by position x and y 
        int HIEGHT=image.getHeight();
        int WIDTH=image.getWidth();
        CINPUT= new Color[HIEGHT][WIDTH];           //Create array for save rgb values of every pixel
        
        
        for (y=0 ; y<HIEGHT;y++){
            for(x=0;x<WIDTH;x++) {
                clr=  image.getRGB(x,y); 
                red   = (clr & 0x00ff0000) >> 16;
                green = (clr & 0x0000ff00) >> 8;
                blue  =  clr & 0x000000ff;
                
                this.CINPUT[y][x]=new Color(red,green,blue);    //add rgb values to the array
                
            }//end of for(x=0....)
        }//end of for(y=0...)
        
        System.out.print("Image size = "+CINPUT[0].length+" x "+CINPUT.length+" pixels\n");
        
        Temp_Converter_Image(MAXTEMP,MINTEMP,HIGHTEMP,TOL,this.CF,this.CINPUT,Infile,Outfile);       //run the function for convert to temperature values from rgb value
      
    }//end of Read_Image....

    
    
    
    
}//end of Color_Palletes class
