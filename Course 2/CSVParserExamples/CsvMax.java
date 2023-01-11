import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

/**
 * Write a description of class CsvMax here.
 *
 * @author (Jadhav Vishal S.)
 * @version (30-12-2022)
 */
public class CsvMax
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CsvMax
     */
    public CsvMax()
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
    
    public CSVRecord highestOfTwo(CSVRecord record, CSVRecord highestSoFar) {
        if (highestSoFar == null) {
            highestSoFar = record;
        } else if (Double.parseDouble(record.get("TemperatureF")) > Double.parseDouble(highestSoFar.get("TemperatureF"))) {
            highestSoFar = record;
        }
        
        return highestSoFar;
    }
    
    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord highestSoFar = null;
        
        for (CSVRecord record : parser) {
            highestSoFar = highestOfTwo(record, highestSoFar);
        }
        
        return highestSoFar;
    }

    public CSVRecord lowestOfTwo(CSVRecord record, CSVRecord lowestSoFar) {
        if (lowestSoFar == null) {
            lowestSoFar = record;
        } else if (Double.parseDouble(record.get("TemperatureF")) != -9999 && Double.parseDouble(record.get("TemperatureF")) < Double.parseDouble(lowestSoFar.get("TemperatureF"))) {
            lowestSoFar = record;
        }
        
        return lowestSoFar;
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        
        for (CSVRecord record : parser) {
            lowestSoFar = lowestOfTwo(record, lowestSoFar);
        }
        
        return lowestSoFar;
    }
    
    public void testHottestHourInFile() {
        FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-01.csv");
        
        CSVRecord highestInFile = hottestHourInFile(fr.getCSVParser());
        System.out.println("Hottest weather on 2012-01-01 was " + highestInFile.get("TemperatureF") + " at " + highestInFile.get("TimeEST"));
    }
    
    public CSVRecord hottestHourInMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord highestInMultipleFiles = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord highestSoFar = hottestHourInFile(fr.getCSVParser());
            highestInMultipleFiles = highestOfTwo(highestSoFar, highestInMultipleFiles);
        }
        
        return highestInMultipleFiles;
    }
    
    public CSVRecord coldestHourInMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestInMultipleFiles = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord lowestSoFar = coldestHourInFile(fr.getCSVParser());
            lowestInMultipleFiles = lowestOfTwo(lowestSoFar, lowestInMultipleFiles);
        }
        
        return lowestInMultipleFiles;
    }
    
    public void testHottestHourInMultipleFiles() {
        CSVRecord highestInMultipleFiles = hottestHourInMultipleFiles();
        System.out.println("Hottest weather was " + highestInMultipleFiles.get("TemperatureF") + " at " + highestInMultipleFiles.get("DateUTC"));
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-05-01.csv");
        
        CSVRecord lowestInFile = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest weather on 2012-01-01 was " + lowestInFile.get("TemperatureF") + " at " + lowestInFile.get("DateUTC"));
    }
    
    public void testColdestHourInMultipleFiles() {
        CSVRecord lowestInMultipleFiles = coldestHourInMultipleFiles();
        System.out.println("Lowest weather was " + lowestInMultipleFiles.get("TemperatureF") + " at " + lowestInMultipleFiles.get("DateUTC"));
    }
    
    public String fileWithColdestTemperature() {
        String result = "";
        
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestInMultipleFiles = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord lowestSoFar = coldestHourInFile(fr.getCSVParser());
            
            if (lowestInMultipleFiles == null) {
                lowestInMultipleFiles = lowestSoFar;
                result = f.getName();
                // System.out.println("First Time");
            } else if (Double.parseDouble(lowestSoFar.get("TemperatureF")) < Double.parseDouble(lowestInMultipleFiles.get("TemperatureF"))) {
                result = f.getName();
                lowestInMultipleFiles = lowestSoFar;
                // System.out.println("First Time ++");
            }
        }
        
        return result;
    }
    
    public void testFileWithColdestTemperature() {
        String fileWithColdestTemperature = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + fileWithColdestTemperature);
        
        FileResource fr = new FileResource("nc_weather/2014/" + fileWithColdestTemperature);
        CSVRecord lowestInFile = coldestHourInFile(fr.getCSVParser());
        
        System.out.println("Coldest temperature on that day was " + lowestInFile.get("TemperatureF"));
        
        System.out.println("All the Temperatures on the coldest day were:");
        
        for (CSVRecord record : fr.getCSVParser()) {
            System.out.println(record.get("DateUTC") + ":" + record.get("TemperatureF"));
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumiditySoFar = null;
        
        for (CSVRecord record : parser) {
            if (lowestHumiditySoFar == null) {
                lowestHumiditySoFar = record;
            } else if (!record.get("Humidity").equals("N/A") && Integer.parseInt(record.get("Humidity")) < Integer.parseInt(lowestHumiditySoFar.get("Humidity"))) {
                lowestHumiditySoFar = record;
            }
        }
        
        return lowestHumiditySoFar;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-04-01.csv");
        CSVRecord record = lowestHumidityInFile(fr.getCSVParser());
        
        System.out.println("Lowest Humidity was " + record.get("Humidity") + " at " + record.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityInMultipleFiles = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord lowestHumiditySoFar = lowestHumidityInFile(fr.getCSVParser());
            
            if (lowestHumidityInMultipleFiles == null) {
                lowestHumidityInMultipleFiles = lowestHumiditySoFar;
            } else if (!lowestHumiditySoFar.get("Humidity").equals("N/A") && Integer.parseInt(lowestHumiditySoFar.get("Humidity")) < Integer.parseInt(lowestHumidityInMultipleFiles.get("Humidity"))) {
                lowestHumidityInMultipleFiles = lowestHumiditySoFar;
            }
        }
        
        return lowestHumidityInMultipleFiles;
    }
    
    public void testLowestHumidityInManyFiles() {
        CSVRecord lowestHumidityInMultipleFiles = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumidityInMultipleFiles.get("Humidity") + " at " + lowestHumidityInMultipleFiles.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser) {
        double totalTemperature = 0.0;
        int count = 0;
        
        for (CSVRecord record : parser) {
            totalTemperature += Double.parseDouble(record.get("TemperatureF"));
            count++;
        }
        
        return totalTemperature / count;
    }
    
    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-06-01.csv");
        double averageTemperature = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemperature);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double totalTemperature = 0.0;
        int count = 0;
        
        for (CSVRecord record : parser) {
            double currTemp = Double.parseDouble(record.get("TemperatureF"));
            if (Integer.parseInt(record.get("Humidity")) >= value) {
                totalTemperature += currTemp;
                count++;
            }
        }
        
        return totalTemperature / count;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-03-30.csv");
        double averageTemperature = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        
        if (Double.isNaN(averageTemperature)) {
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average temperature in file is " + averageTemperature);
        }
    }
}
