// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.io.*;
import java.util.*;

public class ScoreTableTester{
   public static void main(String[] args){
      ScoreTable myScoreTable = new ScoreTable();
      //---
      System.out.println("Test getScore method on \"calm\" [exp: 8]: ");
      System.out.println(myScoreTable.getScore("calm"));
      //---
      System.out.println("Test getScore method on \"CALM\" [exp: 8]: ");
      System.out.println(myScoreTable.getScore("CALM"));
      //---
      System.out.println("Test getScore method on \"CaLm\" [exp: 8]: ");
      System.out.println(myScoreTable.getScore("CaLm"));
      //---
      System.out.println("Test getScore method on \"\" [exp: 0]: ");
      System.out.println(myScoreTable.getScore(""));
      //---
      System.out.println("Test getScore method on \"lam\" [exp: 5]: ");
      System.out.println(myScoreTable.getScore("lam"));
      //---
      System.out.println("Test getScore method on \"alm\" [exp: 5]: ");
      System.out.println(myScoreTable.getScore("alm"));
      //---
   }
}