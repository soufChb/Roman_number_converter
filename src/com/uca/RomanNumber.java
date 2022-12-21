package com.uca;

public class RomanNumber extends Number implements Comparable{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	
	public String getRoman() throws NullPointerException{
		if(this.roman == null){
			throw new NullPointerException("object not yet initialized");
		}
		return this.roman;
	}
	
	public int getValue() throws NullPointerException{
			if(this.value == 0){
				throw new NullPointerException("object not yet initialized");
			}
			return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	
	
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		return (double) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue(){
		return (float) this.value;
		
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		return this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public String toString() {
		return "" + this.value;
	}

	@Override
	public int compareTo(Object o) throws IllegalArgumentException{
		String type = o.getClass().getName();
		System.out.println(type);
		try{
			switch(type){
				case "java.lang.Integer":
					return (int) o < this.value ? 1 : (int) o == this.value ? 0 : -1;
				case "java.lang.Float":
					return  (float) o < this.floatValue() ? 1 : (float) o == this.floatValue() ? 0 : -1;
				case "java.lang.Double":
					return (double) o < (double) this.doubleValue() ? 1 : (double) o == this.doubleValue() ? 0 : -1;
				case "java.lang.Long":
					return (long) o < (long) this.longValue() ? 1 : (long) o == (long) this.longValue() ? 0 : -1;
				case "java.lang.String":
					return RomanConverter.getNumberFromRoman((String) o) < this.value ? 1 : RomanConverter.getNumberFromRoman((String) o) == this.value ? 0 : -1;
				default:
					throw new IllegalArgumentException("Object not comparable");
				}
			}catch(Exception e){
				System.out.println("cannot compare");
		}
		return 1000;

		}
		
	

}
