// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.io.*;
import java.util.*;

public class AnagramDictionaryTester{
   public static void main(String[] args){
      String filename = "";
      try{
         if(args.length > 0){
            filename = args[0];
         }
         AnagramDictionary currDict = new AnagramDictionary(filename);
         //---
         System.out.println("Test getAnagramsOf \"mlac\" [exp: calm clam (could be different sequences)]: ");
         ArrayList<String> currAnagrams = currDict.getAnagramsOf("mlac");
         if(currAnagrams == null){
            System.out.print("null");
         }
         else{
            for(String anagram: currAnagrams){
               System.out.print(anagram + " ");
            }
         }
         System.out.println();
         //---
         System.out.println("Test getAnagramsOf \"rlee\" [exp: leer lere reel (could be different sequences)]: ");
         currAnagrams = currDict.getAnagramsOf("rlee");
         if(currAnagrams == null){
            System.out.print("null");
         }
         else{
            for(String anagram: currAnagrams){
               System.out.print(anagram + " ");
            }
         }
         System.out.println();
         //---
         System.out.println("Test getAnagramsOf \"amc\" [exp: cam mac (could be different sequences)]: ");
         currAnagrams = currDict.getAnagramsOf("amc");
         if(currAnagrams == null){
            System.out.print("null");
         }
         else{
            for(String anagram: currAnagrams){
               System.out.print(anagram + " ");
            }
         }
         System.out.println();
         //---
         System.out.println("Test getAnagramsOf \"\" [exp: null]: ");
         currAnagrams = currDict.getAnagramsOf("");
         if(currAnagrams == null){
            System.out.print("null");
         }
         else{
            for(String anagram: currAnagrams){
               System.out.print(anagram + " ");
            }
         }
         System.out.println();
         //---
         System.out.println("Test getAnagramsOf \"kk\" [exp: null]: ");
         currAnagrams = currDict.getAnagramsOf("kk");
         if(currAnagrams == null){
            System.out.print("null");
         }
         else{
            for(String anagram: currAnagrams){
               System.out.print(anagram + " ");
            }
         }
         System.out.println();
         //---
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