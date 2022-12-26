
/**
 * Write a description of class Part3 here.
 *
 * @author (Jadhav Vishal S.)
 * @version (22-12-2022)
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
    
    public void testFindStopCodon() {
        int startIndex = 0;
        
        String dna1 = "ATGCTGTAA";
        System.out.println("DNA 1 = " + dna1);
        System.out.println("Stop Codon TAA = " + findStopCodon(dna1, startIndex, "TAA"));
        
        String dna2 = "CTGCTGTTA";
        System.out.println("DNA 2 = " + dna2);
        System.out.println("Stop Codon TAA = " + findStopCodon(dna2, startIndex, "TAA"));
    }
    
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        
        if (startIndex == -1) {
            return "";
        }
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int tempMin = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        // System.out.println(taaIndex + " " + tagIndex + " " + tgaIndex);return "";     
        if (minIndex == dna.length()) {
            return "";
        }
        
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void testFindGene() {
        int startIndex = 0;
        String dna1 = "CTGACG";
        System.out.println("DNA 1 = " + dna1 + ", Gene 1 = " + findGene(dna1, startIndex));
        
        String dna2 = "ATGTAA";
        System.out.println("DNA 2 = " + dna2 + ", Gene 2 = " + findGene(dna2, startIndex));
        
        String dna3 = "CTCATGTGCTAATAG";
        System.out.println("DNA 3 = " + dna3 + ", Gene 3 = " + findGene(dna3, startIndex));
        
        String dna4 = "CTCATGTGCTAGTAA";
        System.out.println("DNA 4 = " + dna4 + ", Gene 4 = " + findGene(dna4, startIndex));
        
        String dna5 = "CTCATGTTA";
        System.out.println("DNA 5 = " + dna5 + ", Gene 5 = " + findGene(dna5, startIndex));
    }
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            
            if (currentGene.isEmpty()) {
                 break;   
            }
            System.out.println(currentGene);
            
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        
    }
    
    public int countGenes(String dna) {
        int startIndex = 0;
        int genesCount = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty()) {
                break;
            }
            
            genesCount++;
            
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        
        return genesCount;
    }
    
    public void testCountGenes() {
        System.out.println("Gene count for \"ATGTAAGATGCCCTAGT\" = " + countGenes("ATGTAAGATGCCCTAGT"));
        System.out.println("Gene count for \"ATGTAA\" = " + countGenes("ATGTAA"));
        System.out.println("Gene count for \"ATGTAATAGATGTGACGDATGTGCTAA\" = " + countGenes("ATGTAATAGATGTGACGDATGTGCTAA"));
    }
    
    public static void main(String args[]) {
        Part3 p3 = new Part3();
        // p1.testFindStopCodon();
        // System.out.println("DNA Strand ATGTAAGATGCCCTAGT");
        // p3.printAllGenes("ATGTAAGATGCCCTAGT");
        // int genesCount = p3.countGenes("ATGTAAGATGCCCTAGT");
        // System.out.println("Gene count for \"ATGTAAGATGCCCTAGT\" = " + p3.countGenes("ATGTAAGATGCCCTAGT"));
        
        p3.testCountGenes();
        
    }
}
