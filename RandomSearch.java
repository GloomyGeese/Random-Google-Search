package randosearch;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RandomSearch {

  public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
	  
	  
	  
	  Scanner reader = new Scanner(System.in); // Asks the user for number of searches
		System.out.println("Enter the number of random google searches you would like:"); 
		int loop = reader.nextInt();
		if (loop>0) {
		int totalloop = loop;
     Map<String,Integer> map = new HashMap<String,Integer>();
     for(int i = 0; i < 1000; ++i)
     {
        String s = choose(new File("customization//searches.txt"));
        if(!map.containsKey(s))
           map.put(s, 0);
        map.put(s, map.get(s) + 1);
     }
	  while (loop>0) {// while loop
     Random generator = new Random();
     Object[] values = map.values().toArray();
     Object randomValue = values[generator.nextInt(values.length)]; // generates 1st random #
     Object randomValue2 = values[generator.nextInt(values.length)]; // generates 2nd random #
     Object name = getKeyFromValue(map, randomValue); // Associates 1st random # with a word
     Object name2 = getKeyFromValue(map, randomValue2); // Associates 1st random # with a word
     Desktop d = Desktop.getDesktop(); // short cut variable
     
     if (name == name2) // tests to not have duplicate words in search
     {
         Object randomValue3 = values[generator.nextInt(values.length)]; // generates 2nd random #
         Object name3 = getKeyFromValue(map, randomValue3); // Associates 1st random # with a word
         d.browse(new URI("https://www.google.com/search?q=" + name + "%20" + name3)); // Opens default browser with the google search query of the random values
     }
     else {
     d.browse(new URI("https://www.google.com/search?q=" + name + "%20" + name2)); // Opens default browser with the google search query of the random values 
     }
     loop--;
 
		}
	System.out.println("Opened a total of " + totalloop + " random google searches!");
    reader.close();
    TimeUnit.SECONDS.sleep(5);
	}
	else {
		System.out.println("That is not a valid number of random google searches.");
		TimeUnit.SECONDS.sleep(5);
	}
  }

  public static String choose(File f) throws FileNotFoundException // reads the list of words
  {
     String result = null;
     Random rand = new Random();
     int n = 0;
     for(Scanner sc = new Scanner(f); sc.hasNext(); )
     {
        ++n;
        String line = sc.nextLine();
        if(rand.nextInt(n) == 0)
           result = line;         
     }
     n--;
     return result;      
  }
  public static Object getKeyFromValue(Map<String, Integer> hm, Object value) { // gets the word with the #
	    for (Object o : hm.keySet()) {
	      if (hm.get(o).equals(value)) {
	        return o;
	      }
	    }
	    return null;
	  }
	}
