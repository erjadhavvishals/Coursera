
/**
 * Write a description of class Part1 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (18-12-2022)
 */
public class Part1
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part1
     */
    public Part1()
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
    
    public String findSimpleGene(String dna) {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        
        if (startIndex == -1) {
            return "";
        }
        
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        
        if (stopIndex == -1) {
            return "";
        }
        
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex + 3);
        }
        
        return result;
    }
    
    public void testSimpleGene() {
        String dna1 = "ATCGTAA";
        System.out.println("DNA 1 = " + dna1 + ", Gene 1 = " + findSimpleGene(dna1));
        String dna2 = "ATGCGTAG";
        System.out.println("DNA 2 = " + dna2 + ", Gene 2 = " + findSimpleGene(dna2));
        String dna3 = "ATCGTTA";
        System.out.println("DNA 3 = " + dna3 + ", Gene 3 = " + findSimpleGene(dna3));
        String dna4 = "ATGCGGTAA";
        System.out.println("DNA 4 = " + dna4 + ", Gene 4 = " + findSimpleGene(dna4));
        String dna5 = "ATGCGTAA";
        System.out.println("DNA 5 = " + dna5 + ", Gene 5 = " + findSimpleGene(dna5));
        
    }
    
    public static void main (String args[]) {
        Part1 p1 = new Part1();
        p1.testSimpleGene();
    }
}
