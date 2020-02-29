package com.sunandan.PrintDictionary;

import java.lang.*;

class PrintingDictionary{
	public static void main(String[] args) {
		new PrintingDictionary().parseDictionary("{\"ab\":\"cd\"}",0);
	}

	private void parseDictionary(String validatedString, int level){
		char[] key =  new char[100];
		char[] value =  new char[100];
		level ++;
		int j=0;
		for(int i=0;i<validatedString.length();i++){
			if(validatedString.charAt(i)=='\"'){
				for(j=i++;validatedString.charAt(j)=='\"';j++){
					key[j-i]=validatedString.charAt(j);
				}
				i=j++;
			}
			print(new String(key), level);
			if(validatedString.charAt(i)==':'){
				if(validatedString.charAt(i)=='\"'){
					for(j=i++;validatedString.charAt(j)=='\"';j++){
						 value[j-i]=validatedString.charAt(j);
					}
					i=j++;
				}
				System.out.print("	:	");
				print(new String(value), level);
				System.out.println();
			}
			if(validatedString.charAt(i)==',' || validatedString.charAt(i)=='}')
				System.out.println();
		}

	}

	private void print(String stringToPrint,int level){
		for(int i=0;i<level;i++)
			System.out.print("/t");
		System.out.print(stringToPrint);
	}
}