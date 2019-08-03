package CountChar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 *This class contains method to count distinct characters in given input string.
 * It also uses hash map to cache previous calculated result.
 * @author Twinkle Garg
 */
public class CountCharacters {

    HashMap<String,Integer> wordCache;
    
    /**
     * Constructor initializes the hash map for cache
     */
    public CountCharacters(){
        wordCache=new HashMap<>();
    }
    
    /**
     * This method counts distinct characters from given input string
     * @param word
     * @return number of distinct characters
     */
    public int CountChracters(String word){
        if(wordCache.containsKey(word)){
            return wordCache.get(word);
        }
        ArrayList<Character> arrayOfChar=new ArrayList<Character>();
        for(int count=0; count < word.length(); count++){
            if(!arrayOfChar.contains(word.charAt(count))){
                arrayOfChar.add(word.charAt(count));
            }
        }
        wordCache.put(word,arrayOfChar.size());
        return arrayOfChar.size();
    }
    
}