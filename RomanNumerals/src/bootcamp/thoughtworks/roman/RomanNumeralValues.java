package bootcamp.thoughtworks.roman;

import java.util.Hashtable;

public abstract class RomanNumeralValues {
	private static final Hashtable<String, Integer> mRomanValues;
	static{
		mRomanValues = new Hashtable<String, Integer>();
		mRomanValues.put("I", 1);
		mRomanValues.put("V", 5);
		mRomanValues.put("X", 10);
		mRomanValues.put("L", 50);
		mRomanValues.put("C", 100);
		mRomanValues.put("D", 500);
		mRomanValues.put("M", 1000);
	}

	private static int parseIntegerValue(char value){
		String temp = String.valueOf(value).toUpperCase();
		if(mRomanValues.containsKey(temp)){
			return mRomanValues.get(temp);
		}
		return 0;
	}

	public static int parseIntegerValueOf(String mRomanNumeralString) {
		//something like MMXVVI etc
		char[] tempArray = mRomanNumeralString.toCharArray();
		int curIndex = 0;
		int nextIndex = curIndex + 1;
		int total = 0;

		while(curIndex < tempArray.length -1) {
			float curVal = parseIntegerValue(tempArray[curIndex]);
			float nextVal = parseIntegerValue(tempArray[nextIndex]);
			print("curval = " + curVal);
			if(curVal < nextVal){
				total += (nextVal - curVal);
				curIndex++;
				//we then need to skip the next value, so we'll move one now
				//before it moves ahead again outside the if construct
			}else{
				total += curVal;
			}
			curIndex++; nextIndex = curIndex + 1;
		}
		if((tempArray.length - 1) == curIndex){
			total += parseIntegerValue(tempArray[tempArray.length -1]);
		}
		return total;
	}

	private static void print(String message) {
		System.out.print(message + "\n");
	}
}
