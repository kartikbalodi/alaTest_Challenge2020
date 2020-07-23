package tele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.*;

public class tele {
	private static Vector<Company> all_prices;
	private static long input_num;
	private static String final_operator_name;
	private static double final_operator_price;

	/*
	 * getters for all private member objects of tele class.
	 * mainly used for testing
	 */	
	public static Vector<Company> getAllPrices(){
		return all_prices;
	}
	
	public static long getInputNum(){
		return input_num;
	}
	
	public static String getFinal_operator_name() {
		return final_operator_name;
	}

	public static double getFinal_operator_price() {
		return final_operator_price;
	}
	// end of getters
	
 	public static void readFile(BufferedReader br) throws IOException {
 		/*
 		 * reads file from the bufferedreader to populate all_prices
 		 */
		String line = br.readLine();
		String op_name = null;
		Map<Long,Double> op_list = null;
		int max_ext_len = 0;
		while(line!=null) {
			if(line.toLowerCase().contains("operator")) { //for each new operator, we want to create a new map for it
				if(op_name!=null && op_list!=null) {
					Company temp = new Company(op_name,op_list, max_ext_len, Long.MAX_VALUE, Double.MAX_VALUE);
					all_prices.addElement(temp);
				}
				max_ext_len = 0;
				op_name = line.trim().substring(0, line.length()-1);
				op_list = new TreeMap<Long,Double>();
			}
			else if(line.trim()!= "" && line.trim() != null) {
				String[] nums = line.split("\\s");
				if (nums.length == 2) {
					int ext_len = String.valueOf(nums[0]).length();
					if(max_ext_len<ext_len) {
						max_ext_len = ext_len;
					}
					op_list.put(Long.parseLong(nums[0]),Double.parseDouble(nums[1]));
				}
			}
			line=br.readLine();
		}
		if(op_name!=null && op_list!=null) {
			Company temp = new Company(op_name,op_list,max_ext_len, Long.MAX_VALUE, Double.MAX_VALUE);
			all_prices.addElement(temp);
		}
	}

	public static Boolean operate(String fileName) {
		/*
		 * reads in fileName, outputs error if any issues
		 */
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			readFile(br);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
			return false;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return false;
		} catch (NumberFormatException nfe) {
			System.out.println("Number format wrong in file, "+nfe.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					System.out.print(ioe.getMessage());
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException ioe) {
					System.out.print(ioe.getMessage());
				}
			}
		}
		return true;
	}
	
	private static Company best_price(long input) {
		/*
		 * sorts the best_price vector and returns the company with the best price
		 */
		if(all_prices.isEmpty()) { //if no company was successfully parsed/empty file
			Company temp = new Company("Empty",new TreeMap<Long,Double>(),0,Long.MAX_VALUE,Double.MAX_VALUE);
			return temp;
		}
		
		for(int i=0; i<all_prices.size(); i++) { //for each operator
			Company operatr = all_prices.elementAt(i);
			Map<Long,Double> operator_price_map = operatr.getPrices(); //take its ext to price map
			//find which extension is the longest for a certain operator.
			//in so doing we are able cut the input number's digit search
			//to the longest extension (in terms of number of digits) available 
			int longest_extension_digits = operatr.getMost_digits_ext(); 
			String str_input = String.valueOf(input);
			for(int j=longest_extension_digits; j>0; j--) { //going from longest possible substring of input num for an operator
				String input_digit_substring = str_input.substring(0, j);
				long digit_prefix = Long.valueOf(input_digit_substring);
				if (operator_price_map.containsKey(digit_prefix)) { //if the operator has a match with the number, we terminate search because the longest possible extension has been chosen
					operatr.setLongest_matching_extension(digit_prefix);
					operatr.setMatching_price(operator_price_map.get(digit_prefix));
					break; //break because we want to prioritize the longest extension that matches
				}
			}
		}
		Collections.sort(all_prices, new CompanyComparator());
		
		Company result = all_prices.elementAt(0);
		return result;
	}
		
	public static void main(String[] args) {
		/*
		 * main reads in system inputs which get fed to the operate function to 
		 * populate the all_prices vector, and another input for best_price, which
		 * reads an int argument to print out the company with the best price on offer
		 */
		all_prices = new Vector<Company>();
		Scanner in; String fileName;
		Boolean correctRead = false;
		while(!correctRead) { //reads in txt filename with operators from system input
			in = new Scanner(System.in);
			System.out.print("Enter the file name: ");
			fileName = in.nextLine();
			correctRead = operate(fileName);
		}
		correctRead = false;
		while(!correctRead) { //reads phone number from system input
			try{
				in = new Scanner(System.in);
				System.out.print("Enter the phone number: ");
				input_num = in.nextLong();
				correctRead = true;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Please enter a valid phone number.");
			}
		}
		
		Company result = best_price(input_num);
		if (result.getMatching_price() == Double.MAX_VALUE) {
			final_operator_name = "";
			final_operator_price = -1;
			System.out.println("No phone operator can provide services for this phone number.");
		} else {
			final_operator_name = result.getName();
			final_operator_price = result.getMatching_price();
			System.out.println("The lowest price you have to pay is $"+final_operator_price+"/min with "+
					final_operator_name+".");
		}
	}
	
	static class CompanyComparator implements Comparator<Company>{ 
		/*
		 * custom comparator to sort the vector all_prices
		 * in terms of their lowest price across companies
		 * first element of vector is the company with the lowest price
		 * for the phone number
		 */
        public int compare(Company c1, Company c2) { 
            if (c1.getMatching_price()<c2.getMatching_price()) {
            	return -1;
            }
            else if (c1.getMatching_price()>c2.getMatching_price()) {
            	return 1;
            }
            else {
                return 0; 
            }
        }
	}
	
	public static void test(String string1, long phone) {
		/*
		 * same as the main function, except this one custom test function
		 * inputs the fileName and phone number for testing
		 */
		all_prices = new Vector<Company>();
		String fileName = string1;
		boolean correctRead = operate(fileName);
		input_num = phone;
		Company result = best_price(phone);
		if (result.getMatching_price() == Double.MAX_VALUE) {
			final_operator_name = "";
			final_operator_price = -1;
			System.out.println("No phone operator can provide services for this phone number.");			
		} else {
			final_operator_name = result.getName();
			final_operator_price = result.getMatching_price();
			System.out.println("The lowest price you have to pay is $"+final_operator_price+"/min with "+
					final_operator_name +".");
		}
	}
	
}