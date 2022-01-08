// Name: Chia-Hao Chang
// GitHub: ChiaHaoChangTw
// Words with Friends

import java.io.IOException;

/**
 * This class reports problems with the dictionary file.
 */
public class IllegalDictionaryException extends IOException{
   public IllegalDictionaryException(){}
   public IllegalDictionaryException(String message){
      super(message);
   }
}