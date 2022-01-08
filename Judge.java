// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;
import java.util.Collections;

/**
 * A Judge to get and print out the results of the scrabble game.
 */
public class Judge{
   
   /**
     * Representation invariants:
     * a) scoreTable != null 
     */
   private ScoreTable scoreTable;

   /**
    * Create a Judge to judge the scrabble game.
    */
   public Judge(){
      scoreTable = new ScoreTable();
      assert isValidJudge();
   }

   /**
    * Get and print out the results of currRack based on currDict and scoreTable.
    * @param currRack a Rack with scrabble tiles
    * @param currDict an AnagramDictionary used to search for anagrams
    * PRE: currRack.getAllSubsets().size() > 0
    * This function does not violate 30-line rule considering assert statements and single-brace lines.
    */
   public void getJudgeResults(Rack currRack, AnagramDictionary currDict){
      assert currRack.getAllSubsets().size() > 0;
      ArrayList<String> currRackSubsets = currRack.getAllSubsets();
      TreeMap<Integer, TreeSet<String>> resultsMap = new TreeMap<Integer, TreeSet<String>>(Collections.reverseOrder());
      int wordCount = 0;
      for(int i = 0; i < currRackSubsets.size(); ++i){
         ArrayList<String> currAnagrams = currDict.getAnagramsOf(currRackSubsets.get(i));
         if(currAnagrams == null){
            continue;
         }
         else{
            int currScore = scoreTable.getScore(currRackSubsets.get(i));
            if(!resultsMap.containsKey(currScore)){
               resultsMap.put(currScore, new TreeSet<String>());
            }
            for(String currAnagram: currAnagrams){
               resultsMap.get(currScore).add(currAnagram);
               ++wordCount;
            }
         }
      }
      System.out.println("We can make " + wordCount + " words from \"" + currRack.getScrabbleTiles() + "\"");
      if(wordCount > 0){
         System.out.println("All of the words with their scores (sorted by score):");
         for(Map.Entry<Integer, TreeSet<String>> entry: resultsMap.entrySet()){
            for(String str: entry.getValue()){
               System.out.println(entry.getKey() + ": " + str);
            }
         }   
      }
      assert isValidJudge();
   }
   
   /** 
    * Return true iff Judge data is in a valid state. 
    * @return true iff Judge data is in a valid state
    */   
   private boolean isValidJudge(){
      return scoreTable != null;
   }
}