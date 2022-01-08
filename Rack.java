// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Rack class holds scrabble tiles.
 * Can return all subsets of scrabble tiles on Rack.
 */
public class Rack{
   
   /**
     * Representation invariants:
     * a) allSubsetsOnRack.size() > 0
     */
   private ArrayList<String> allSubsetsOnRack;
   private String currScrabbleTiles;
   
   /**
    * Create an empty rack with no scarbbleTiles.
    */
   public Rack(){
      currScrabbleTiles = "";
      String unique = "";
      int[] mult = {};
      allSubsetsOnRack = allSubsets(unique, mult, 0);
      assert isValidRack();
   }
   
   /**
    * Create a rack with characters from scrabbleTiles.
    * Subsets of characters are generated, and stored in class. 
    * All subset strings are sorted.
    * @param scrabbleTiles a string represents scrabble tiles on rack
    */
   public Rack(String scrabbleTiles){
      currScrabbleTiles = scrabbleTiles;
      TreeMap<Character, Integer> charCount = new TreeMap<Character, Integer>();
      int pos = 0;
      while(pos < scrabbleTiles.length()){
         if(!charCount.containsKey(scrabbleTiles.charAt(pos))){
            charCount.put(scrabbleTiles.charAt(pos), 1);
         }
         else{
            charCount.put(scrabbleTiles.charAt(pos), charCount.get(scrabbleTiles.charAt(pos)) + 1);
         }
         ++pos;
      }
      String unique = "";
      int[] mult = new int[charCount.size()];
      int multPos = 0;
      for(Map.Entry<Character, Integer> entry: charCount.entrySet()){
         unique += entry.getKey();
         mult[multPos] = entry.getValue();
         ++multPos;
      }
      allSubsetsOnRack = allSubsets(unique, mult, 0);
      assert isValidRack();
   }
   
   /**
    * Return all subsets of current scrabble tiles on rack.
    * Subset strings are sorted subsets.
    * Subsets include empty string.
    * @return all subsets of current scrabble tiles on rack
    */
   public ArrayList<String> getAllSubsets(){
      assert isValidRack();
      return allSubsetsOnRack;
   }
   
   /**
    * Return original scrabbleTiles string input by client or default value.
    * @return original scrabbleTiles string input by client or default value
    */
   public String getScrabbleTiles(){
      assert isValidRack();
      return currScrabbleTiles;
   }

   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    *      unique.charAt(i).
    * PRE: mult.length must be at least as big as unique.length()
    *      0 <= k <= unique.length()
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.  
    * @param k the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
    * each subset is represented as a String that can have repeated characters in it.
    * @author Claire Bono, modified by Chia-Hao Chang
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k){
      assert mult.length >= unique.length() && k >= 0 && k <= unique.length();
      ArrayList<String> allCombos = new ArrayList<>();
      if(k == unique.length()){
         allCombos.add("");
         return allCombos;
      }
      ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);
      String firstPart = "";
      for(int n = 0; n <= mult[k]; n++){   
         for(int i = 0; i < restCombos.size(); i++){
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);
      }
      return allCombos;
   }
   
   /** 
    * Return true iff Rack data is in a valid state. 
    * @return true iff Rack data is in a valid state
    */   
   private boolean isValidRack(){
      return allSubsetsOnRack.size() > 0;
   }
}