import java.awt.Color;
/**
 * Write a description of class SoupBoiFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SoupBoiFilter extends Filter
{
    private OFImage master;
    private OFImage newImage;
    private int Height;
    private int Width;
    
    /**
     * Constructor for objects of class GrayScaleFilter.
     * @param name The name of the filter.
     */
    public SoupBoiFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        master = new OFImage(image);
        Width = master.getWidth() / 2;
        Height = master.getHeight() / 2;
        //red quadrant/top right
        for(int y = 0; y < Height; y++) {
            for(int x = 0; x < Width; x++) {
                
                image.setPixel(x + Width, y, master.getPixel(x * 2, y * 2));
            }
        }
        //master quadrant/ top left
         for(int y = 0; y < Height; y++) {
            for(int x = 0; x < Width; x++) {
                image.setPixel(x, y, master.getPixel(x * 2, y * 2));
            }
        }
        //green quadrant/bottom left
        for(int y = 0; y < Height; y++) {
            for(int x = 0; x < Width; x++) {
                image.setPixel(x, y + Height, master.getPixel(x * 2, y * 2));
            }
        }
        //blue quadrant/bottom right
          for(int y = 0; y < Height; y++) {
            for(int x = 0; x < Width; x++) {
                image.setPixel(x + Width, y + Height, master.getPixel(x * 2, y * 2));
            }
        }
        
        // top right red channel
         for(int y = 0; y < Height; y++) {
            for(int x = 0; x < Width; x++) {
                Color pix = image.getPixel(x, y);
                int red = pix.getRed();
                
                image.setPixel(x + Width, y, new Color(red, 0, 0));
            }
        }
        
        // bottom left green channel
        for(int y = 0; y < Height; y++) {
            for(int x = 0; x < Width; x++) {
                Color pix = image.getPixel(x, y);
                int green = pix.getGreen();
                
                image.setPixel(x, y + Height, new Color(0, green, 0));
            }
        }
        
        // bottom rightblue channel
        for(int y = 0; y < Height; y++) {
            for(int x = 0; x < Width; x++) {
                Color pix = image.getPixel(x, y);
                int blue = pix.getBlue();
                
                image.setPixel(x + Width, y + Height, new Color(0, 0, blue));
            }
        }
    }
}