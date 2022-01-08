// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

/**
 * A scoreTable class to store scores of all English letters
 * Can calculate total score of a string.
 * Note: this class works for both upper and lower case versions of the letters.
 */
public class ScoreTable{
   
   /**
     * Declare constants used in this calss:
     * a) EN_LETTERS: total number of English letters 
     * b) *_SCORE: scores for different English letters. Eg, QZ_SCORE is the score for Q and Z.
     */
   public static final int EN_LETTERS = 26;
   public static final int QZ_SCORE = 10;
   public static final int JX_SCORE = 8;
   public static final int K_SCORE = 5;
   public static final int FHVWY_SCORE = 4;
   public static final int BCMP_SCORE = 3;
   public static final int DG_SCORE = 2;
   public static final int AEIOULNSTR_SCORE = 1;
   
   /**
     * Representation invariants:
     * a) scoreTable.length == EN_LETTERS
     */
   private int[] scoreTable;
   
   /**
    * Create a score table for all English letters.
    * Letters that occur more often in the English language are worth less,
    * and letters that occur less often are worth more.
    */
   public ScoreTable(){
      scoreTable = new int[EN_LETTERS];
      for(int i = 0; i < scoreTable.length; ++i){
         int currChar = i + 'a';
         if(currChar == 'q' || currChar == 'z'){
            scoreTable[i] = QZ_SCORE;
         }
         else if(currChar == 'j' || currChar == 'x'){
            scoreTable[i] = JX_SCORE;
         }
         else if(currChar == 'k'){
            scoreTable[i] = K_SCORE;
         }
         else if(currChar == 'f' || currChar == 'h' || currChar == 'v' || currChar == 'w' || currChar == 'y'){
            scoreTable[i] = FHVWY_SCORE;
         }
         else if(currChar == 'b' || currChar == 'c' || currChar == 'm' || currChar == 'p'){
            scoreTable[i] = BCMP_SCORE;
            
         }
         else if(currChar == 'd' || currChar == 'g'){
            scoreTable[i] = DG_SCORE;
         }
         else{
            scoreTable[i] = AEIOULNSTR_SCORE;
         }
      }
      assert isValidScoreTable();
   }
   
   /**
    * Get total score of the given string based on the score table. This method is not case-sensitive.
    * E.g. "CARE" and "race" will have the same score.
    * @param a string to process
    * @return a score number of the given string
    * PRE: (string[i] >= 'A' && string[i] <= 'Z') || (string[i] >= 'a' && string[i] <= 'z')
    */
   public int getScore(String string){
      for(int i = 0; i < string.length(); ++i){
         assert ((string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') || (string.charAt(i) >= 'a' && string.charAt(i) <= 'z'));
      }
      int totalScore = 0;
      for(int i = 0; i < string.length(); ++i){
         if(string.charAt(i) <= 'Z'){
            totalScore += scoreTable[string.charAt(i) - 'A'];
         }
         else{
            totalScore += scoreTable[string.charAt(i) - 'a'];
         }
      }
      assert isValidScoreTable();
      return totalScore;
   }
   
   /** 
    * Return true iff ScoreTable data is in a valid state. 
    * @return true iff ScoreTable data is in a valid state
    */   
   private boolean isValidScoreTable(){
      return scoreTable.length == EN_LETTERS;
   }
}