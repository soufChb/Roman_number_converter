package com.uca;


import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.*;

public class RomanConverter{
	
	// Table des symboles
	private static final Collection<RomanNumber> SYMBOLS = new ArrayList<>();
	static {
		SYMBOLS.add(new RomanNumber(1000, "M"));
		SYMBOLS.add(new RomanNumber(900, "CM"));
		SYMBOLS.add(new RomanNumber(500, "D"));
		SYMBOLS.add(new RomanNumber(400, "CD"));
		SYMBOLS.add(new RomanNumber(100, "C"));
		SYMBOLS.add(new RomanNumber(90, "XC"));
		SYMBOLS.add(new RomanNumber(50, "L"));
		SYMBOLS.add(new RomanNumber(40, "XL"));
		SYMBOLS.add(new RomanNumber(10, "X"));
		SYMBOLS.add(new RomanNumber(9, "IX"));
		SYMBOLS.add(new RomanNumber(5, "V"));
		SYMBOLS.add(new RomanNumber(4, "IV"));
		SYMBOLS.add(new RomanNumber(1, "I"));
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

	public static String getRomanFromNumber(int a) throws IllegalArgumentException{
		if(a<=0 || a>3999){
			throw new IllegalArgumentException("a should be between 0 and 3999");
		}
		
		String res = "";
		for(RomanNumber roman_number : SYMBOLS)
		{
			while(a >= roman_number.getValue())
			{
				res = res + roman_number.getRoman();
				a = a - roman_number.getValue();
			}
		}
		return res;
	}
	
	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		
		Matcher matcher = VALIDATION_RE.matcher(a);
		boolean matches = matcher.matches();
		if(!matches){
			throw new IllegalArgumentException("roman syntax error");
		}
		
		int result = 0;
		int index = 0;
		for(RomanNumber number_roman : SYMBOLS)
		{
			while(index + number_roman.getRoman().length() <= a.length() && a.substring(index, index + number_roman.getRoman().length()).equals(number_roman.getRoman()))
			{
				result = result + number_roman.getValue();
				index = index + number_roman.getRoman().length();
			}
		}
		return result;
	}
}
