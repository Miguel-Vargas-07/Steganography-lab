import java.awt.Color;
public class Steganography
{
    public static void main(String[] args)
    {
        //Notice how the picture needs to be created!
        //Don't change the String value in the Picture parameter.
        Picture beach = new Picture("beach.jpg");
        //beach.explore();
        beach = testClearLow(beach);
        int i = 183;
        i /=4;
        i *= 4;
        System.out.println(i);
        i=+2;// this would store 1 in that place
       
       
        //what operation could we do to 
        //to retrieve the value of the alst 2 bits?
        System.out.println(i%4);
        
        
        beach.write("test.jpg");
    }
    
    /**
    * Clear the lower (rightmost) two bits in a pixel.
    */
    public static void clearLow( Pixel p )
    {
        /* To be implemented */
        Color oldColor= p.getColor();
        int r = oldColor.getRed();
        int g = oldColor.getGreen();
        int b = oldColor.getBlue();
       //clear the right-most bit
        r/=2;
        r*=2;
        
        g/=2;
        g*=2;
        
        b/=2;
        b*=2;

        p.setColor(new Color(r,g,b));

    }
    
    /**
     * Returns a new Picture object with the lowest two bits of each pixel cleared.
     */
    public static Picture testClearLow(Picture p)
    {
        /* To be implemented */
        Picture p2 = new Picture(p);
        Pixel[][]pix = p2.getPixels2D();
        //write nested for loops
        for(int r = 0; r<pix.length;r++){
            for(int c = 0;c < pix[0].length;c++){
                Pixel x = pix[r][c];
                clearLow(x);
            }
        }
        
        return p2;
    }
    
    
}
