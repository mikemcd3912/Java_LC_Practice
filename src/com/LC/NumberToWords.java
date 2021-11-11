package com.LC;

public class NumberToWords {
    StringBuilder ans;
    
	public String numberToWords(int num) {
		if(num == 0) {
			return "Zero";
		}
		
		ans = new StringBuilder();
        while(num>=1000000000) {
        	ans.append(hundreds(num/1000000000)+ " Billion");
        	num=num%1000000000;
        }
        while(num>=1000000) {
        	ans.append(hundreds(num/1000000)+ " Million");
        	num=num%1000000;
        }
        while(num>=1000) {
        	ans.append(hundreds(num/1000)+ " Thousand");
        	num=num%1000;
        }
        ans.append(hundreds(num));
        return ans.toString().trim();
        
    }
    
    private String hundreds(int num) {
    	if(num>=100) {
    		int digit = num / 100;
    		return ones(digit) + " Hundred" + tens(num);
    	}
    	
    	return tens(num);
    }
    
    private String tens(int num) {
    	int range = (num%100)/10;
    	switch(range) {
    		case 0: return ones(num%10);
	    	case 1: return teens(num%100);
	    	case 2: return " Twenty" + ones(num%10);
			case 3: return " Thirty" + ones(num%10);
			case 4: return " Forty" + ones(num%10);
			case 5: return " Fifty" + ones(num%10);
			case 6: return " Sixty" + ones(num%10);
			case 7: return " Seventy" + ones(num%10);
			case 8: return " Eighty" + ones(num%10);
			case 9: return " Ninety" + ones(num%10);
		}
		return null;
    }
    
    private String teens(int nums) {
    	switch(nums) {
    		case 10: return " Ten";
	    	case 11: return " Eleven";
	    	case 12: return " Twelve";
			case 13: return " Thirteen";
			case 14: return " Fourteen";
			case 15: return " Fifteen";
			case 16: return " Sixteen";
			case 17: return " Seventeen";
			case 18: return " Eighteen";
			case 19: return " Nineteen";
    	}
    	return null;
    }
    
    private String ones(int digit) {
    	switch(digit) {
    		case 0: return "";
	    	case 1: return " One";
	    	case 2: return " Two";
			case 3: return " Three";
			case 4: return " Four";
			case 5: return " Five";
			case 6: return " Six";
			case 7: return " Seven";
			case 8: return " Eight";
			case 9: return " Nine";
    	}
    	return null;
    }
}
