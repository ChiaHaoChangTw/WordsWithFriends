// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Class WordFinder 
 * WordFinder contains the main method that allows the user to get different results of rack inputs.
 * This class is responsible for processing the command-line argument, and handling any error processing.
 */
public class WordFinder{
   
   /** 
    * Main function to execute scarbble game.
    * This function does not violate 30-line rule considering single-brace lines.
    */
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      String filename = "sowpods.txt";
      Judge currJudge = new Judge();
      try{
         if(args.length > 0){
            filename = args[0];
         }
         AnagramDictionary currDict = new AnagramDictionary(filename);
         System.out.println("Type . to quit.");
         boolean done = false;
         while(!done){
            System.out.print("Rack? ");
            String scrabbleTiles = in.next();
            if(scrabbleTiles.equals(".")){
               done = true;
            }
            else{
               Rack currRack = new Rack(scrabbleTiles);
               currJudge.getJudgeResults(currRack, currDict);
            }
         }
      }
      catch(FileNotFoundException exception){
         System.out.println("ERROR: Dictionary file \"" + filename + "\" does not exist.");
         System.out.println("Exiting program.");
      }
      catch(IllegalDictionaryException exception){
         System.out.println(exception.getMessage());
         System.out.println("Exiting program.");
      }
   }
}