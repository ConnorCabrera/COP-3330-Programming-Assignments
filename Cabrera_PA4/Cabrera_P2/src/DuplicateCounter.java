import java.util.*;
import java.io.*;

public class DuplicateCounter {

	private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

	public void count(String dataFile) throws IOException{
		
		FileInputStream fileByteStream = null;
	    Scanner scnr = null;
	    String word;
	    //int base = 0;
		
		fileByteStream = new FileInputStream(dataFile);
	    scnr = new Scanner(fileByteStream);
	    
	    while (scnr.hasNext()) {
	         word = scnr.next();
	         if(!wordCounter.containsKey(word)) {
	        	 wordCounter.put(word, 1);
	         }
	         else {
	        	 wordCounter.put(word,  (wordCounter.get(word) + 1));
	         }
	    }
	    
	    fileByteStream.close();
	    scnr.close();
	    
	}
	
	public void write(String outputFile) throws IOException{
		
		FileOutputStream fileByteStream = null;
	    PrintWriter outFS = null;
	    Iterator iter = wordCounter.entrySet().iterator();

	    fileByteStream = new FileOutputStream(outputFile);
	    outFS = new PrintWriter(fileByteStream);
	    
	    for(int i = 0; i < wordCounter.size(); i++) {
	    	
	    	Map.Entry mapElement = (Map.Entry)iter.next();
	    	outFS.println(mapElement.getKey() + " appears " + (int)mapElement.getValue() + " times.");
	    	
	    }
	    
	    
	    outFS.flush();
	    fileByteStream.flush();
	    fileByteStream.close();
	    outFS.close();
	
	}
	
}
