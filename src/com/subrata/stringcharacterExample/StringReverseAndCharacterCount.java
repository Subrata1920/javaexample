package com.subrata.stringcharacterExample;

import java.util.HashMap;
import java.util.Map;

/**
 * String reverse and character count using java
 * @author subrata
 *
 */
public class StringReverseAndCharacterCount {
	public static void main(String[] args) {
		String str = "This is used to test the coding."
				+ " skills of the candidate and that's why it's very "
				+ "important to prepare for these questions anytime you go for an interview.";
		char[] arr = str.toCharArray();
		String temp = "";
		String finalStr = "";
		for(int i=0;i<arr.length;i++){
			if(arr[i] != '.')
				temp += arr[i];
			else
				temp += " ";
			
			if(arr[i] == ' ' || arr[i] == '.'){
				finalStr += reverseString(temp);
				temp = "";
			}
			
			if(arr[i] == '.'){
				finalStr = finalStr.trim();
				finalStr += "."; 
			}
		}
		System.out.println(finalStr.trim());
		System.out.println(reverseString(str));
		characterCount(str);
		System.out.println("------------------------------------");
		characterCountWithOutCollection(str);
		System.gc();
	}
	private static String reverseString(String temp) {
		String string = "";
		  char[] charArr = temp.toCharArray();
	      for(int i = charArr.length-1; i>=0;i--){
	    	  string +=charArr[i];
	      }
	    return string;
	}
	private static void characterCount(String str) {
		char[] arr = str.toCharArray();
		Map<Character, Integer> mapOfChar = new HashMap<Character, Integer>();
		for (char c : arr) {
			if(c != ' ')
			mapOfChar.put(c, mapOfChar.get(c)==null ? 1: mapOfChar.get(c)+1);
		}
		for (Map.Entry<Character, Integer> entry : mapOfChar.entrySet()) {
			System.out.println("Key : "+entry.getKey()+", Value : "+entry.getValue());
		}
	}
	private static void characterCountWithOutCollection(String str) {
		char[] arr = str.toCharArray();
		String strCheck = "";
		String temp = "";
		int wordCount = 0;
		boolean flagCharacter = false;
		for (int i = 0; i < arr.length; i++) {
			flagCharacter = checkCharacter(arr[i], strCheck);
			if(flagCharacter == true){
				strCheck += arr[i];
				System.out.println("Key : "+arr[i] +", Value : "+ countChar(arr[i],arr));
			} 
			if(arr[i] != '.')
				temp += arr[i];
			
			if(arr[i] == ' ' || arr[i] == '.'){
				wordCount += 1;
				temp = "";
			}
		}
		System.out.println(wordCount);
	}
	private static int countChar(char c, char[] arr) {
		int charCount = 0;
		for (char d : arr) {
			if(c==d)
				charCount++;
		}
		return charCount;
	}
	private static boolean checkCharacter(char c, String strCheck) {
		if(strCheck.length() != 0){
			char[] arrStr = strCheck.toCharArray();
			for (int i = 0; i < arrStr.length; i++) {
				if(c == arrStr[i])
					return false;
			}
			return true;
		} else
			return true;
	}
}
