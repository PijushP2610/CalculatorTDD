package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			String delimiter = ",";
			if(text.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}
			
			String numList[] = splitNumbers(text, delimiter + "|\n");
			return sum(numList);
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String divider){
	    return numbers.split(divider);
	}
	private static int comma(String text){
 	    int total = 0;
 	    String commaString = "";

 	   if(text.matches(",\n")||text.matches("\n,"))
 		   return 0;
 	   else
 		   total=add(text);

//		if(!negString.equals("")){
//			throw new IllegalArgumentException("Negatives not allowed: " + negString);
//		}

		return total;
	}

	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
        	if(toInt(number) < 1000)
		    	total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
	}

}
