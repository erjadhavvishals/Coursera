
/**
 * Write a description of class Part3 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (18-12-2022)
 */
public class Part3
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part3
     */
    public Part3()
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
    
    public Boolean twoOccurrences(String stringa, String stringb) {
        Boolean result = false;
        
        int firstOccurrenceIndex = stringb.indexOf(stringa);
        int secondOccurrenceIndex = stringb.indexOf(stringa, firstOccurrenceIndex + stringa.length());
        
        if (firstOccurrenceIndex != -1 && secondOccurrenceIndex != -1) {
            result = true;
        }
        return result;
    }
    
    public void testing() {
        // Boolean hasTwoOccurrences = false;
        
        // hasTwoOccurrences = twoOccurrences("by", "A story by Abby Long");
        System.out.println("twoOccurrences Result for 'by', 'A story by Abby Long' = " + twoOccurrences("by", "A story by Abby Long"));
        System.out.println("twoOccurrences Result for 'a', 'banana' = " + twoOccurrences("a", "banana"));
        System.out.println("twoOccurrences Result for 'atg', 'ctgtatgta' = " + twoOccurrences("atg", "ctgtatgta"));
         
        System.out.println("lastPart Result for 'an', 'banana' = " + lastPart("an", "banana"));
        System.out.println("lastPart Result for 'zoo', 'forest' = " + lastPart("zoo", "forest"));
        System.out.println("lastPart Result for 'cd', 'abcdefgh' = " + lastPart("cd", "abcdefgh"));
    }
    
    public String lastPart(String stringa, String stringb) {
        String result = "";
        // System.out.println(stringa.length());
        int firstOccurrenceIndex = stringb.indexOf(stringa);
        
        if (firstOccurrenceIndex == -1) {
            result = stringb;
        } else {
            result = stringb.substring(firstOccurrenceIndex, firstOccurrenceIndex + stringa.length() + 1);
        }
        
        return result;
    }
    
    public static void main (String args[]) {
        Part3 p3 = new Part3();
        p3.testing();
    }
}
