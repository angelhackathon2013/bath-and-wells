package bootcamp.thoughtworks.roman;
import java.util.regex.Pattern;

public class RomanNumeralString {

	//Rule to check if it contains valid numerals in the first place, and not any unknowns
	private final Pattern TEST_RULE_VALID_NUMERALS = Pattern.compile("^[I|V|L|C|D|M|X]*$");

	private final Pattern TEST_ROMAN_NUMERALS_VALID_ORDER = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	private String mRomanNumeralString;
	private boolean mIsNumeralStringValid = false;

	public RomanNumeralString(String romanNumeralString){
		if(romanNumeralString != null && romanNumeralString.trim().length() >0){

			mRomanNumeralString = romanNumeralString.trim();
			print(mRomanNumeralString);
			mIsNumeralStringValid =
					TEST_RULE_VALID_NUMERALS.matcher(mRomanNumeralString).matches()
					&& TEST_ROMAN_NUMERALS_VALID_ORDER.matcher(mRomanNumeralString).matches();
		}
	}

	public boolean isValidNumerals(){
		return mIsNumeralStringValid;
	}

	public int parseIntegerValue(){
		if(mIsNumeralStringValid){
            return RomanNumeralValues.parseIntegerValueOf(mRomanNumeralString);
		}
		return 0;
	}

	public void print(String message){
		System.out.print(message);
	}
}
