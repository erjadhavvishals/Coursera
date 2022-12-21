import edu.duke.URLResource;
/**
 * Write a description of class Part4 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (18-12-2022)
 */
public class Part4
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part4
     */
    public Part4()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public static void main (String args[]) {
        // Part4 p4 = new Part4();
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        int counter = 0;
        
        // System.out.println("Working fine");
        
        for (String line : ur.lines()) {
            // System.out.println("Link " + (counter + 1) + " : " + line);
            String lineLower = line.toLowerCase();
            
            if (lineLower.indexOf("youtube.com") != -1) {
                int firstQuoteIndex = line.lastIndexOf("\"", lineLower.indexOf("youtube.com"));
                int lastQuoteIndex = line.indexOf("\"", firstQuoteIndex + 1);
                
                System.out.println(line.substring(firstQuoteIndex + 1, lastQuoteIndex));
            }
            counter++;
        }         
    }
}
