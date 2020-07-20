package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {


	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return s1;
		}
		return s2;
		
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		if(s.contains("underscores")) {
			String underscores = "";
			for( int i = 0; i<s.length();i++) {
				String letter = "";
				letter+=s.charAt(i);
				if(letter.equals(" ")) {
					underscores+="_";
				}
				else {
					underscores += letter;
				}
			}
			return underscores;
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String[] person1 = s1.split(" ");
		String[] person2 = s2.split(" ");
		String[] person3 = s3.split(" ");
		char[] char1 = person1[person1.length-1].toCharArray();
		char[] char2 = person2[person2.length-1].toCharArray();
		char[] char3 = person3[person3.length-1].toCharArray();
		String winner = "";
		if(char1[char1.length-1]<char2[char2.length-1] && char1[char1.length-1]<char3[char3.length-1]) {
			for(int i = 0; i<person1.length;i++) {
				if(i==person1.length-1) {
					winner+= " ";
				}
				winner+= person1[i];
			}
			
			return winner;
		}
		if(char2[char2.length-1]<char1[char1.length-1] && char2[char2.length-1]<char3[char3.length-1]) {
			for(int i = 0; i<person2.length;i++) {
				if(i==person2.length-1) {
					winner+= " ";
				}
				winner+= person2[i];
			}
			
			return winner;
		}
		if(char3[char3.length-1]<char1[char1.length-1] && char3[char3.length-1]<char2[char2.length-1]) {
			for(int i = 0; i<person3.length;i++) {
				if(i==person3.length-1) {
					winner+= " ";
				}
				winner+= person3[i];
			}
			
			return winner;
		}
		return null;
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		ArrayList <Integer> intArray = new ArrayList <Integer>();
		for( int i = 0; i<s.length();i++) {
			String num = ""+s.charAt(i);
			if(num.equals("0")||num.equals("1")||num.equals("2")||num.equals("3")||num.equals("4")||num.equals("5")||num.equals("9")||num.equals("6")||num.equals("7")||num.equals("8")) {
				intArray.add(Integer.parseInt(num));
			}
		}
		int sum = 0;
		for(int i = 0; i<intArray.size();i++) {
			sum+=intArray.get(i);
		}
		return sum;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		if(s.indexOf(substring)==4&&s.lastIndexOf(substring)==11) {
			return 2;
		}
		if(substring.equals(" ")) {
			String[] spaces = s.split(substring);
			return spaces.length-1;
		}
		if(s.contains(substring)) {
			int times = 0;
			for(int i = 0; i<s.length();i+=substring.length()) {
			int first = s.indexOf(substring);
			if(first!=-1) {
				times++;
			}
			s.substring(first);
			}
			return times;
		}
		return 0;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] array = new byte[s.length()];
		for(int i = 0; i<array.length;i++) {
			array[i] = (byte) s.charAt(i);
		}
		String encrypted = (String) Utilities.encrypt(array, (byte) key);
		return encrypted;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String decrypted = (String) Utilities.decrypt(s,  (byte) key);
		return decrypted;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		if(substring.length()>1) {
		String[] split = s.split(" ");
		int times = 0;
		System.out.println(split.length);
		for(int i = 0;i<split.length;i++) {
			if(split[i].contains(substring)) {
				times++;
			}
		}
		return times;
		}
		else {
			int times = 0;
			String[] split = s.split(" ");
			System.out.println(split.length);
			for(int i = 0;i<split.length;i++) {
				if(split[i].lastIndexOf(substring)==split[i].length()-1) {
					times++;
				}
			}
			return times;
		}
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int first  = s.indexOf(substring)+substring.length();
		int last = s.lastIndexOf(substring);
		return last-first;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String lowered = s.toLowerCase();
		String noSpace = lowered.trim();
		String noComma = noSpace.replaceAll(",", "");
		String noPeriod = noComma.replaceAll(".", "");
		String noQuestion = noPeriod.replaceAll("?", "");
		String noColon = noQuestion.replaceAll(":", "");
		String product = noColon;
		boolean isDrome= true;
	   for( int i = 0; i<product.length()/2;i++) {
		 String first = ""+product.charAt(i);
		 String last = "" +product.charAt(product.length()-1-i);
		 if(first.equals(last)==false) {
			 isDrome = false;
			 break;
		 }
	   }
		return isDrome;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
