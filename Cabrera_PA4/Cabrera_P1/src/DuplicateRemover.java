import java.util.*;
import java.io.*;

public class DuplicateRemover {
	
	private HashSet<String> uniqueWords = new HashSet<String>();

	public void remove(String dataFile) throws IOException{
		
		FileInputStream fileByteStream = null;
	    Scanner scnr = null;
	    String word;
		
		fileByteStream = new FileInputStream(dataFile);
	    scnr = new Scanner(fileByteStream);
	    
	    while (scnr.hasNext()) {
	         word = scnr.next();
	         uniqueWords.add(word);
	    }
	    
	    fileByteStream.close();
	    scnr.close();
	    
	}
	
	public void write(String outputFile) throws IOException{
		
		FileOutputStream fileByteStream = null;
	    PrintWriter outFS = null;
	    String word;
	    Iterator<String> iter = uniqueWords.iterator();

	    fileByteStream = new FileOutputStream(outputFile);
	    outFS = new PrintWriter(fileByteStream);
	    
	    for(int i = 0; i < uniqueWords.size(); i++) {
	    	
	    	word = iter.next();
	    	outFS.println(word);
	    	
	    }
	    
	    outFS.flush();
	    fileByteStream.flush();
	    fileByteStream.close();
	    outFS.close();
	
	}
}
