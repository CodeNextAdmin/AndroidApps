/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;


public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;

    ArrayList<String> wordList=new ArrayList<String>();
    private HashSet<String>  wordSet = new HashSet<>();
    private HashMap<String, ArrayList<String>> lettersToWord = new HashMap<>();


    private Random random = new Random();

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();

            wordList.add(word);
            wordSet.add(word);
           // System.out.print(word);
            String k = sortLetters(word);

            if(lettersToWord.containsKey(k)){

                lettersToWord.get(k).add(word);
            } else{

                ArrayList<String> newWord = new ArrayList<String>();
                newWord.add(word);
                lettersToWord.put(k, newWord);

            }




        }

        Log.d("Letters to Word ", lettersToWord.toString());
    }


    public boolean isGoodWord(String word, String base) {

        //Asserts that the given word is in the dictionary and isn't formed by adding a letter to the start or end of the base word.

        Log.d("isGoodWord", "base: " + base + " and word: " + word);

        if(wordSet.contains(word) && word.contains(base) == false ){

            Log.d("isGoodWord", "word is good :"+ word);
            return true;


        }

        return false;







    }

    public List<String> getAnagramsWithOneMoreLetter(String target){


        ArrayList<String> result = new ArrayList<String>();
        String newWord;

        for(char i = 'a'; i<='z' ;  i++){



            //append to my word
            newWord = sortLetters(target.concat(""+i));

            Log.d("newWord: " , newWord);

            if(lettersToWord.containsKey(newWord)){

                result.addAll(lettersToWord.get(newWord));


            }

        }

        return result;

    }

    public List<String> getAnagrams(String targetWord) {
        //Creates a list of all possible anagrams of a given word.



        ArrayList<String> result = new ArrayList<String>();

       // result.add(targetWord);

       // Log.d("result", String.valueOf(result));

        Log.d("targetword" , targetWord);

        Log.d("sorted", sortLetters(targetWord));

        for (int i = 0; i < wordList.size(); i++){

           String thisWord = wordList.get(i);


            if(sortLetters(targetWord).equals(sortLetters(thisWord))){

                Log.d("We have a match", thisWord );
                result.add(thisWord);


            }
        }




        Log.d("The anagram words are: " , result.toString());
        return result;
    }


    public String pickGoodStarterWord() {

        //Randomly selects a word with at least the desired number of anagrams.
        return "post";
    }


    public String sortLetters(String word){

        //word = word + " ++++++ ";

        char[] charArray = word.toCharArray();

        Arrays.sort(charArray);

        String s = String.valueOf(charArray);


        return s;
    }
}
