// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.io.*;
import java.util.*;

public class RackTester{
   public static void main(String[] args){
      //---
      System.out.println("Test default constructor");
      Rack myRack = new Rack();
      System.out.println("Test getAllSubsets method [exp: 1 subset]");
      ArrayList<String> currSubsets = myRack.getAllSubsets();
      for(String subset: currSubsets){
         System.out.print(subset + ",");
      }
      System.out.println();
      System.out.println("Test getScrabbleTiles method [exp: <empty>]");
      System.out.println(myRack.getScrabbleTiles());
      //---
      System.out.println("Test constructor with arguments \"rlee\"");
      myRack = new Rack("rlee");
      System.out.println("Test getAllSubsets method [exp: 12 subsets, string sorted]");
      currSubsets = myRack.getAllSubsets();
      for(String subset: currSubsets){
         System.out.print(subset + ",");
      }
      System.out.println();
      System.out.println("Test getScrabbleTiles method [exp: rlee]");
      System.out.println(myRack.getScrabbleTiles());
      //---
      System.out.println("Test constructor with arguments \"\"");
      myRack = new Rack("");
      System.out.println("Test getAllSubsets method [exp: 1 subset]");
      currSubsets = myRack.getAllSubsets();
      for(String subset: currSubsets){
         System.out.print(subset + ",");
      }
      System.out.println();
      System.out.println("Test getScrabbleTiles method [exp: <empty>]");
      System.out.println(myRack.getScrabbleTiles());
      //---
   }
}