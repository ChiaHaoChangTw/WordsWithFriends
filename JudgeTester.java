// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.io.*;
import java.util.*;

public class JudgeTester{
   public static void main(String[] args){
      //---
      System.out.println("Test constructor");
      Judge myJudge = new Judge();
      //---
      System.out.println("Test getJudgeResults \"cmal\" [exp: same as PA example]");
      Rack myRack = new Rack("cmal");
      try{
         AnagramDictionary myDict = new AnagramDictionary("sowpods.txt");
         myJudge.getJudgeResults(myRack, myDict);
      }
      catch(FileNotFoundException exception){
         System.out.println("ERROR: Dictionary file \"" + "sowpods.txt" + "\" does not exist.");
         System.out.println("Exiting program.");
      }
      catch(IllegalDictionaryException exception){
         System.out.println(exception.getMessage());
         System.out.println("Exiting program.");
      }
      //---
      System.out.println("Test getJudgeResults \"\" [exp: 0 words]");
      myRack = new Rack("");
      try{
         AnagramDictionary myDict = new AnagramDictionary("sowpods.txt");
         myJudge.getJudgeResults(myRack, myDict);
      }
      catch(FileNotFoundException exception){
         System.out.println("ERROR: Dictionary file \"" + "sowpods.txt" + "\" does not exist.");
         System.out.println("Exiting program.");
      }
      catch(IllegalDictionaryException exception){
         System.out.println(exception.getMessage());
         System.out.println("Exiting program.");
      }
      //---
   }
}