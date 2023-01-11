import edu.duke.*;
import java.io.File;
/**
 * Write a description of class ImageFilter here.
 *
 * @author (Jadhav Vishal S.)
 * @version (07-01-2023)
 */
public class ImageFilter
{
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for (Pixel px : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(px.getX(), px.getY());
            int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            
            px.setRed(average);
            px.setGreen(average);
            px.setBlue(average);
        }
        
        return outImage;
    }
    
    public void testGraySingleFile() {
        ImageResource inImage = new ImageResource();
        ImageResource grayImage = makeGray(inImage);
        
        String fname = inImage.getFileName();
        String newName = "gray-" + fname;
        
        grayImage.setFileName(newName);
        grayImage.draw();
        grayImage.save();
    }
    
    public void testGrayMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource grayImage = makeGray(inImage);
            
            String fname = inImage.getFileName();
            String newName = "gray-" + fname;
            
            grayImage.setFileName(newName);
            grayImage.draw();
            grayImage.save();
        }
    }
    
    public ImageResource inverseImage(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for (Pixel px : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(px.getX(), px.getY());
            
            px.setRed(255 - inPixel.getRed());
            px.setGreen(255 - inPixel.getGreen());
            px.setBlue(255 - inPixel.getBlue());
        }
        
        return outImage;
    }
    
    public void testInverseSingleFile() {
        ImageResource inImage = new ImageResource();
        ImageResource inverseImage = inverseImage(inImage);
        
        String fname = inImage.getFileName();
        String newName = "inverse-" + fname;
        
        inverseImage.setFileName(newName);
        inverseImage.draw();
        inverseImage.save();
    }
}
