// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A dictionary of all anagram sets. 
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary{
   
   /**
     * Representation invariants:
     * a) Size of ArrayList<String> in HashMap > 0
     */
   private HashMap<String, ArrayList<String>> anagramDictionary;
   
   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName. 
    * All keys in anagramDictionary are char-sorted string. (ex: "act" not "cat")
    * @param fileName the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    * @throws IllegalDictionaryException  if the dictionary has any duplicate words
    * PRE: fileName.length() > 0 
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException,
                                                    IllegalDictionaryException{
      assert fileName.length() > 0;                                                
      anagramDictionary = new HashMap<String, ArrayList<String>>();  
      File dictFile = new File(fileName);
      try(Scanner in = new Scanner(dictFile)){
         while(in.hasNext()){
            String currStr = in.next();
            char[] chars = currStr.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!anagramDictionary.containsKey(sortedStr)){
               anagramDictionary.put(sortedStr, new ArrayList<String>());
               anagramDictionary.get(sortedStr).add(currStr);
            }
            else{
               if(anagramDictionary.get(sortedStr).contains(currStr)){
                  throw new IllegalDictionaryException("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + currStr);
               }
               else{
                  anagramDictionary.get(sortedStr).add(currStr);
               }
            }
         }
      }
      assert isValidDict();                                                
   }
   
   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * @param s string to process
    * @return a list of the anagrams of s. return null if string not found in AnagramDictionary
    */
   public ArrayList<String> getAnagramsOf(String string){
      char[] chars = string.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars);
      assert isValidDict();
      return anagramDictionary.get(sortedString);
   }
   
   /** 
    * Return true iff AnagramDictionary data is in a valid state. 
    * @return true iff AnagramDictionary data is in a valid state
    */   
   private boolean isValidDict(){
      for(Map.Entry<String, ArrayList<String>> entry: anagramDictionary.entrySet()){
         if(entry.getValue().size() == 0){
            return false;
         }
      }
      return true;
   }
}