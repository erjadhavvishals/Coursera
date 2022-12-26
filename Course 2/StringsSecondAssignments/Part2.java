
/**
 * Write a description of class Part2 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (22-12-2022)
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
    
    public int howMany(String stringa, String stringb) {
        int howMany = 0;
        int startIndex = 0;
        int currIndex = 0;
        // int currIndex = stringb.indexOf(stringa);
        
        while (currIndex != -1) {
            currIndex = stringb.indexOf(stringa, startIndex);
            if (currIndex != -1) {
                howMany++;
                startIndex = currIndex + stringa.length();
            }
        }
        return howMany;
    }
    
    public void testHowMany() {
        System.out.println("howMany(“GAA”, “ATGAACGAATTGAATC”)  = " + howMany("GAA", "ATGAACGAATTGAATC"));
        
        System.out.println("howMany(“AA”, “ATAAAA”)  = " + howMany("AA", "ATAAAA"));
        
        System.out.println("howMany(“BB”, “ATAAAA”)  = " + howMany("BB", "ATAAAA"));
        
        System.out.println("howMany(“BB”, “ATAAAABBATCGBBATVASBBAADGAHSBB”)  = " + howMany("BB", "ATAAAABBATCGBBATVASBBAADGAHSBB"));
    }
}
