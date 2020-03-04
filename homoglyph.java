/**
* Decoding homoglyphs by conversion to Roman alphabet characters.
*
* @author Isabella Man
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.nio.file.Path;
import java.util.HashMap;

public class homoglyph {

/**
 * Takes input from command line arguments.
 *
 * Reads homoglyphs txt file and stores each character as a value in HashMap.
 * Each value is associated with a corresponding Roman alphabet key.
 */

public static void main(String[] args) {
   try (BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {
      HashMap<Integer, String> decoder = new HashMap<>();
      String[] alphabet = new String[] {"A","B", "C", "D", "E", "F", "G",
         "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
    	   "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g",
    	   "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
    	   "u", "v", "w", "x", "y", "z"};	
      Scanner glyphs = new Scanner(Path.of("/srv/datasets/homoglyphs_curated.txt"));
      int count = 0;
      while (glyphs.hasNext()) {
         String curLine = glyphs.next();
    	      for (int i = 0; i < curLine.length(); i++) {
    	         int curPt = curLine.codePointAt(i);
     	         decoder.put(curPt, alphabet[count]);
      	    }
     	    count++;
       }
       
       String line;
       StringBuilder finalDecode = new StringBuilder();
       while ((line = stdin.readLine()) != null) {
    	    for (int codePoint : line.codePoints().toArray()) {
    	       if (decoder.containsKey(codePoint)) {
    	          finalDecode.append(decoder.get(codePoint));
    	       }
    	       else {
    	          String notIncluded = Character.toString((char)codePoint);
    	          finalDecode.append(notIncluded);
    	       }
    	     }
    	     finalDecode.append(System.getProperty("line.separator"));
    	  }
        
    	  int length = finalDecode.length();
    	  finalDecode.deleteCharAt(length - 1);
    	  System.out.println(finalDecode.toString());

    	  } catch (Exception e) {
    	     System.err.println("I/O error: " + e);
    	  }
    }   
}  
