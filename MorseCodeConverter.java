import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseCodeConverter {
	
	/**
     * Tree of letters
     */
	// Instance of the MorseCodeTree class that be used to perform the morse code translation
	   private static MorseCodeTree tree = new MorseCodeTree();
	   
	   /**
	    * Constructor for MorseCodeConverter
	    */
	   public MorseCodeConverter()
	   {
	      
	   }
	   
	    /**
	     * This method converts morse code to English from text
	     * @param text Morse code to be translated
	     * @return text converted into English
	     */
	   public static String convertToEnglish(String text) {
		   String output = "";
		   String[] wholeCode; //words
		   String[][] codeSet; //letters
		   
		   wholeCode = text.split("/");
		   //codeSets = fullCode[i].split(" "); //doesnt work, try something else
		   codeSet = new String[wholeCode.length][];
		   
		   for (int i = 0; i < codeSet.length; i++) {
			   codeSet[i] = wholeCode[i].split(" ");
		   }
		   
		   for (int j = 0; j < codeSet.length; j++) {
			   for(int z = 0; z < codeSet[j].length; z++) {
				   codeSet[j][z] = tree.fetch(codeSet[j][z]);
	                output += codeSet[j][z];
			   }
			   output += " "; //adds a space per word
		   }
		   return output;
	   }
	   
	   /**
	     * This method converts morse code to English from file
	     * @param selectedFile Morse code to be translated
	     * @return text converted into English
	     */
	   public static String convertToEnglish(File selectedFile) throws FileNotFoundException {
	    	String output = "";
	    	ArrayList<String>line = new ArrayList<String>();
	        Scanner inputFile = new Scanner(selectedFile);
	        String[] w;
	        String[] l;
	        
	        while (inputFile.hasNextLine())
	        {  
	            output += inputFile.nextLine();
	        }
	        inputFile.close();
	        
	     // loop through the ArrayList containing all the lines
	        for(int i = 0; i < line.size(); i++){
	            w = line.get(i).split(" / ");

	            for(int j = 0; j < w.length; j++) {
	                l = w[j].split(" ");
	               
	                for(int z = 0; z < l.length; z++)
	                {
	                    output += tree.fetch(l[z]);  
	                }
	               
	                //add a space after each word has been translated
	                output += " ";
	            }
	        }
	        
	        output = output.trim();
	        return output;      
	    }
	    
	    /**
	     * Prints all nodes in the tree
	     * @return string representation of tree
	     */
	    public static String printTree() {
	        String print = "";
	        for (String i : tree.toArrayList()) {
	            print += i + " ";
	        }
	        return print;
	    }

}