
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
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
public class Converter extends Main {
    
    
    public static final Color [] C7= new Color [1792];
    public static final Color [] CF= new Color [895];
    public static final Color [] C5= new Color [1024];
    public static final Color [] C2= new Color [256];
    public static final Color [] C2M= new Color [256];    
    public static Color [][] CINPUT;
    private float multip,Temp;
    public  ArrayList<Point>  Temprorary=new ArrayList<> ();
    public ArrayList< ArrayList<Point> > Templst=new ArrayList <  >();
    private int wounds;
    
    
    
    
    
    public void Temp_Converter_Image( Double MAX, Double MIN,Double HIGHTEMP,int TOL, Color [] cplt, Color [][] cimg,File infile,File outfile) throws IOException {
        
        int cpltlength=cplt.length;
        int cimgrows=cimg.length;
        int cimgcoloumn=cimg[0].length;
        int MaxTempCount=0,Matched=0;
        
        
        multip= (float)( (MAX-MIN)/cpltlength );    //Multiplier for temp converting process

        
        //find the pre defined rgb value from color palletes and find temp
        for (int x=0; x<cimgrows;x++) {
            for (int y=0;y<cimgcoloumn;y++){
                for(int z=0;z<cpltlength;z++){
                
                    //find the exactly equal rgb value  
                    if ( cimg[x][y].equals(cplt[z]) == true ) {
                        Matched++;
                        Temp= (float)( (multip*(cpltlength-z) )+ MIN );     //Temperaturre of the colour w.r.t. temp.range
                    
                        if (Temp>=HIGHTEMP) {
                        MaxTempCount++;
                        cimg[x][y]=new Color(0,255,0);
                        Point pnt = new Point(x,y);
                        Temprorary.add(pnt);
                        }
                     

                    // or find the nearest bench mark point with a tollerance    
                    } else if (  ( abs(cimg[x][y].getRed()-cplt[z].getRed() ) <TOL) && 
                                 ( abs(cimg[x][y].getGreen()-cplt[z].getGreen() ) <TOL) && 
                                 ( abs(cimg[x][y].getBlue()-cplt[z].getBlue() ) <TOL)      ) {
                        Matched++;
                        Temp= (float)( (multip*(cpltlength-z) )+ MIN );     //Temperature of the colour w.r.t temp.range
                    
                        if (Temp>=HIGHTEMP) {
                        MaxTempCount++;
                        cimg[x][y]=new Color(0,255,0);
                        Point pnt = new Point(x,y);
                        Temprorary.add(pnt);
                                                
                        } //end of if(Temp >...)
                    }// end of else if(cimg [] []....)
                
                }// end of for (z=0 ....)
            }// end of for (y=0 ...)
        }//end of for (x=0 ....)
        
        
        
        //System.out.print("Max Temp : "+MAX+"\t\tMin Temp : "+MIN+"\n");
        System.out.print("High Temperature Areas (Temperature >= "+HIGHTEMP+" ) =  "+( (MaxTempCount)*100f/(Matched) )+"%\n");
        //System.out.print("Converting Ratio = "+Matched*100/(cimgrows*cimgcoloumn)+" %\n" );


        printimage(infile,outfile,cimg);    //for printing image
        Wound_Count();                      //for counting wounds
    
    
    }//end of Temo_Converter_Image
    
    
    
    
    
    //for print the image as output file
    private void printimage(File infile,File outfile,Color [][] array) throws IOException {
        
        int x,y,clr,red,green,blue,Y,X;
        
        BufferedImage image = ImageIO.read(infile);
        Y=array.length;
        X=array[0].length;
        for(y=0;y<Y;y++) {
            for (x=0;x<X;x++) {
                
                red=array[y][x].getRed();
                green=array[y][x].getGreen();
                blue=array[y][x].getBlue();
                clr=(red<<16)|(green<<8)|(blue);
                image.setRGB(x, y, clr);
            
            } // end of for(x=0 ...)
        }// end of for (y=0....)
        
        
        try{
            ImageIO.write(image, "png", outfile);
            
        } catch (IOException e){
            System.out.print(e);
        }//end of catch
    
    
    }//end of printimage
    
    
    
    
    //for count wounds 
    private void Wound_Count() {
        
        wounds=0;
        
        for(Point p1:Temprorary){
        
            if(iscontain(p1) == false) {
                ArrayList<Point> li=new ArrayList<>();
                Templst.add(li);
                li.add(p1);
                
                //find the closest points and add to the list
                Point current;
                int cnt=0;
                wounds++;
                while(cnt<li.size()) {
                    current=li.get(cnt);
                    int x=(int) current.getX();
                    int y=(int) current.getY();
                    
                    if( Temprorary.contains( new Point(x-1,y-1) ) == true  && iscontain( new Point(x-1,y-1) ) == false ){
                        li.add( new Point(x-1,y-1) );
                    }
                    
                    if( Temprorary.contains( new Point(x,y-1) ) == true && iscontain( new Point(x,y-1) ) == false ){
                        li.add( new Point(x,y-1) );
                    }
                    
                    if( Temprorary.contains( new Point(x+1,y-1) ) == true && iscontain( new Point(x+1,y-1) ) == false ){
                        li.add( new Point(x+1,y-1) );
                    }
                    
                    if( Temprorary.contains( new Point(x-1,y) ) == true && iscontain( new Point(x-1,y) ) == false ){
                        li.add( new Point(x-1,y) );
                    }
                    
                    if( Temprorary.contains( new Point(x+1,y) ) == true && iscontain( new Point(x+1,y) ) == false ){
                        li.add( new Point(x+1,y) );
                    } 
                    
                    if( Temprorary.contains( new Point(x-1,y+1) ) == true && iscontain( new Point(x-1,y+1) ) == false ){
                        li.add( new Point(x-1,y+1) );
                    } 
                    
                    if( Temprorary.contains( new Point(x,y+1) ) == true && iscontain( new Point(x,y+1) ) == false ){
                        li.add( new Point(x,y+1) );
                    } 
                    
                    if( Temprorary.contains( new Point(x+1,y+1) ) == true && iscontain( new Point(x+1,y+1) ) == false ){
                        li.add( new Point(x+1,y+1) );
                    } 
                    
                    cnt++;
                    

                }//end of while(cnt ...)
            }//end of if(iscontain....)
            
        }//end of for(Point p1....)
        
        System.out.print("Total Wounds : "+wounds+"\n\n\n");
        Temprorary.clear();
        Templst.clear();

    }//end of Wound_Count


    
    //for check the point which was already added to the list or not
    private boolean iscontain(Point Ap) {
        
        //iterate through Templst lists
        for( ArrayList<Point> list : Templst) {
           if(list.contains(Ap) == true) {
               return true;         //return true if the point is already in list
           } 
        }//end of for(ArrayList...)
    
    return false;                  //return false if the point is already not in list
    }//end of iscontain(Point....)
    
    
    
    
    
    
    
}// end of Converter class
