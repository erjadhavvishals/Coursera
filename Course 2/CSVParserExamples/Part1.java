import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of class Part1 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (27-12-2022)
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
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // System.out.println("Nauru Info : " + countryInfo(parser, "Nauru"));
        
        // parser = fr.getCSVParser();
        // listExportersTwoProducts(parser, "gold", "diamonds");
        
        // parser = fr.getCSVParser();
        // System.out.println("Number of Exporters of Gold = " + numberOfExporters(parser, "sugar"));
        
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country) {
        String result = "NOT FOUND";        
        
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
                result = record.get("Country") + ":" + record.get("Exports") + ":" + record.get("Value (dollars)");
                break;
            }
        }
        return result;
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        
        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportItem)) {
                count++;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            if (record.get("Value (dollars)").length() > amount.length()) {
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }
}
