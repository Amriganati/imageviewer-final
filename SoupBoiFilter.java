import java.awt.Color;
/**
 * Write a description of class SoupBoiFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SoupBoiFilter extends Filter
{
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int Blue = (pix.getBlue());
                //int avg = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3;
                image.setPixel(x, y, new Color(Blue, Blue, Blue));
            }
        }
    }
}