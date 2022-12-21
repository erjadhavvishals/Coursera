
/**
 * Write a description of class Part2 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (18-12-2022)
 */
public class Part2
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part2
     */
    public Part2()
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
    
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String result = "";
        String dnaLowerCase = dna.toLowerCase();
        int startIndex = dnaLowerCase.indexOf(startCodon.toLowerCase());
        
        if (startIndex == -1) {
            return "";
        }
        
        int stopIndex = dnaLowerCase.indexOf(stopCodon.toLowerCase(), startIndex + 3);
        
        if (stopIndex == -1) {
            return "";
        }
        
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex + 3);
        }
        
        return result;
    }
    
    public void testSimpleGene() {
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String dna1 = "ATGGGTTAAGTC";
        System.out.println("DNA 1 = " + dna1 + ", Gene 1 = " + findSimpleGene(dna1, startCodon, stopCodon));
        String dna2 = "gatgctataat";
        System.out.println("DNA 2 = " + dna2 + ", Gene 2 = " + findSimpleGene(dna2, startCodon, stopCodon));
        String dna3 = "ATCGTTA";
        // System.out.println("DNA 3 = " + dna3 + ", Gene 3 = " + findSimpleGene(dna3, startCodon, stopCodon));
        // String dna4 = "ATGCGGTAA";
        // System.out.println("DNA 4 = " + dna4 + ", Gene 4 = " + findSimpleGene(dna4, startCodon, stopCodon));
        // String dna5 = "ATGCGTAA";
        // System.out.println("DNA 5 = " + dna5 + ", Gene 5 = " + findSimpleGene(dna5, startCodon, stopCodon));
        
    }
    
    public static void main (String args[]) {
        Part2 p2 = new Part2();
        p2.testSimpleGene();
    }
}
