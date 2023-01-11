import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of class CsvBabyNames here.
 *
 * @author (Jadhav Vishal S.)
 * @version (02-01-2023)
 */
public class CsvBabyNames
{
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoyBirths = 0;
        int totalGirlBirths = 0;
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBirths = Integer.parseInt(record.get(2));
            totalBirths += numBirths;
            
            if (record.get(1).equals("M")) {
                totalBoyBirths += numBirths;
            } else {
                totalGirlBirths += numBirths;
            }
        }
        
        System.out.println("Total Names = " + totalBirths);
        System.out.println("Total Boys  = " + totalBoyBirths);
        System.out.println("Total Girl  = " + totalGirlBirths);
    }
    
    public void testTotalBirths() {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/example-small.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender) {
        int rank = -1;
        int currRank = 0;
        boolean found = false;
        
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
        CSVParser parser = fr.getCSVParser(false);
        
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                currRank++;
                if (record.get(0).equals(name)) {
                    found = true;
                    break;
                }
                
            }            
        }
        
        return found ? currRank : rank;
    }
    
    public void testGetRank() {
        System.out.println("Rank of William = " + getRank(2012, "William", "M"));
    }
    
    public String getName(int year, int rank, String gender) {
        String name = "NO NAME";
        
        int finalRank = -1;
        int currRank = 0;
        boolean found = false;
        
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
        CSVParser parser = fr.getCSVParser(false);
        
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                currRank++;
                if (currRank == rank) {
                    name = record.get(0);
                    found = true;
                    break;
                }
                
            }            
        }
        
        return name;
    }
    
    public void testGetName() {
        System.out.println("Name of Rank 10 Boy = " + getName(2012, 10, "M"));
    }
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender) {
        String resultName = "";
        
        int nameRank = getRank(year, name, gender);
        
        resultName = getName(newYear, nameRank, gender);
        
        return resultName;
    }
    
    public void testWhatIsNameInYear() {
        System.out.println("Isabella born in 2012 would be " + whatIsNameInYear("Isabella", 2012, 2014, "F") + " if she was born in 2014.");
    }
    
    public int yearOfHighestRank(String name, String gender) {
        int result = -1;
        int lowestRankSoFar = 0;
        int lowestYearSoFar = -1;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            int year = Integer.parseInt(f.getName().substring(3, 7));
            int currRank = getRank(year, name, gender);
            
            if (lowestRankSoFar == 0) {
                lowestRankSoFar = currRank;
                if (currRank != -1) {
                    lowestYearSoFar = year;
                }
            } else if (currRank < lowestRankSoFar) {
                lowestRankSoFar = currRank;
                lowestYearSoFar = year;
            }
        }
        
        return lowestYearSoFar;
    }
    
    public void testYearOfHighestRank() {
        System.out.println("Highest ranking for Mason was in " + yearOfHighestRank("Mason", "M"));
    }
    
    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        
        double totalOfRank = 0.0;
        double rankCount = 0.0;
        
        for (File f : dr.selectedFiles()) {
            int year = Integer.parseInt(f.getName().substring(3, 7));
            int currRank = getRank(year, name, gender);
            
            if (currRank != -1) {
                totalOfRank += currRank;
                rankCount++;
            }
        }
        
        if (totalOfRank == 0.0 && rankCount == 0.0) {
            return -1.0;
        }
        System.out.println(totalOfRank + ":" + rankCount);
        return (totalOfRank / rankCount);
    }
    
    public void testGetAverageRank() {
        System.out.println("Average rank of Jacob Male = " + getAverageRank("Jacob", "M"));
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int totalBirths = 0;
        boolean found = false;
        
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
        
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBirths = Integer.parseInt(record.get(2));
            
            if (record.get(1).equals(gender)) {
                if (record.get(0).equals(name)) {
                    found = true;
                    break;
                }
                totalBirths += numBirths;
            }
            
        }
        
        return found ? totalBirths : 0;
    }
    
    public void testGetTotalBirthsRankedHigher() {
        System.out.println("Total Births Ranked Higher than Ethan in 2012 = " + getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    }
}
