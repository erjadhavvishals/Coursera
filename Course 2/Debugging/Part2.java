
/**
 * Write a description of class One here.
 *
 * @author (Jadhav Vishal S.)
 * @version (24-12-2022)
 */
public class Part2
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class One
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
    
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            // System.out.println("index + 1 = " + (index + 1) + ", index + 4 = " + (index + 4));
            // System.out.println("Index = " + index);
            String found = input.substring(index + 1, index + 4);
            System.out.println(found);
            index = input.indexOf("abc", index + 3);
            // System.out.println("index after updating = " + index);
        }
    }
    
    public void test() {
         // findAbc("abcd");
         // findAbc("abcdabc");
         // findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
         findAbc("abcabcabcabca");
    }
}
