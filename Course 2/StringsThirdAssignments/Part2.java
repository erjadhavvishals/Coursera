
/**
 * Write a description of class Part2 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (26-12-2022)
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
    
    public float cgRatio(String dna) {
        int cgCount = 0;
        int cCount = findString(dna, "C");
        int gCount = findString(dna, "G");
        // System.out.println("cCount = " + cCount + ", gCount = " + gCount);
        return (float) (cCount + gCount) / dna.length();
    }
    
    public int findString(String dna, String search) {
        int startIndex = 0;
        int count = 0;
        
        while (true) {
            if (dna.indexOf(search, startIndex) == -1) {
                break;
            }
            count++;
            startIndex = dna.indexOf(search, startIndex) + search.length();
        }
        
        return count;
    }
    
    public int findStopCodon(
        String dna, 
        int startIndex, 
        String stopCodon
    ) {
        int currIndex = dna.indexOf(stopCodon, startIndex);
        
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }
    
    public int countCTG(String dna) {
        int startIndex = 0;
        int count = 0;
        
        while (true) {
            int currIndex = findStopCodon(dna, startIndex, "CTG");
            
            if (currIndex == dna.length()) {
                 break;   
            }
            count++;
            startIndex = currIndex + 3;
        }
        return count;
    }
    
    public static void main (String args[]) {
        Part2 p2 = new Part2();
        float cgRatio = p2.cgRatio("ATGCCATAGG");
        System.out.println("cgRatio for DNA strand (ATGCCATAG) = " + cgRatio);
        
        int ctgCount = p2.countCTG("ATGCTGTAA");
        System.out.println("CTG count in ATGCTGTAA = " + ctgCount);
    }
}
