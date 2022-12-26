import edu.duke.*;
/**
 * Write a description of class Part3 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (26-12-2022)
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
    
    public float cgRatio(String dna) {
        int cgCount = 0;
        int cCount = findString(dna, "c");
        int gCount = findString(dna, "g");
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
    
    public void processGenes(StorageResource sr) {
        int greaterThanNineChars = 0;
        int cgRatioHigher = 0;
        int longestGene = 0;
        
        for (String s : sr.data()) {
            StorageResource geneList = getAllGenes(s);
            
            for (String s1 : geneList.data()) {
                if (s1.length() > 9) {
                    System.out.println(s1);
                    greaterThanNineChars++;
                }    
                
                if (cgRatio(s1) > 0.35) {
                    System.out.println(s1);
                    cgRatioHigher++;
                }
                
                if (s1.length() > longestGene) {
                    longestGene = s1.length();
                }
            }
        }
        
        System.out.println("Number of strings longer that 9 chars = " + greaterThanNineChars);
        System.out.println("Number of strings having cgRatio > 0.35 = " + cgRatioHigher);
        System.out.println("Length of longest gene = " + longestGene);
    }
    
    public int findStopCodon(
        String dna, 
        int startIndex, 
        String stopCodon
    ) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            
            if (currentGene.isEmpty()) {
                 break;   
            }
            // System.out.println(currentGene);
            geneList.add(currentGene);
            
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        
        return geneList;
    }
    
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG".toLowerCase(), where);
        
        if (startIndex == -1) {
            return "";
        }
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA".toLowerCase());
        int tagIndex = findStopCodon(dna, startIndex, "TAG".toLowerCase());
        int tgaIndex = findStopCodon(dna, startIndex, "TGA".toLowerCase());
        
        int tempMin = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
             
        if (minIndex == dna.length()) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void testProcessGenes() {
        // FileResource fr = new FileResource("./dna/brca1line.fa");
        // String dna = fr.asString();
        // StorageResource sr = new StorageResource();
        // sr.add("ATGCTGCTGTAA");
        // sr.add("ATGTAA");
        // sr.add("ATGCCCCTAA");
        // sr.add("ATGTAA");
        
        // processGenes(sr);
        // processGenes(getAllGenes("ATGATGCTGTAA"));
        // processGenes(getAllGenes("ATGTAA"));
        // processGenes(getAllGenes("ATGCTGCTGTAA"));
        // processGenes(getAllGenes("ATGCTTTAA"));
        
        // System.out.println(getAllGenes(new FileResource("./dna/brca1line.fa").asString()).size());
        processGenes(getAllGenes(new FileResource("./dna/brca1line.fa").asString()));
    }
}
