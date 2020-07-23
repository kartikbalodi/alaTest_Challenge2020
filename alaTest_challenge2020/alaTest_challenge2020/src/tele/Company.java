package tele;

import java.util.Map;

public class Company {
	/*
	 * contains the operator's name, a map of integer to double 
	 * representing the map from extension number to its price,
	 * most_digits_ext which represents the digits of the longest extension in the map, 
	 * longest_extension which stores the extension with cheapest price, and
	 * lowest_price which stores the double value of the cheapest price
	 */
	private String name;
	private Map<Long,Double> prices;
	private int most_digits_ext;
	private long longest_matching_extension;
	private double matching_price;
	
	public Company(String name, Map<Long, Double> prices, int most_digits_ext, long longest_matching_extension, double matching_price) {
		this.name = name;
		this.prices = prices;
		this.most_digits_ext = most_digits_ext;
		this.longest_matching_extension = longest_matching_extension;
		this.matching_price = matching_price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Long, Double> getPrices() {
		return prices;
	}
	public void setPrices(Map<Long, Double> prices) {
		this.prices = prices;
	}
	public long getLongest_matching_extension() {
		return longest_matching_extension;
	}
	public void setLongest_matching_extension(long digit_prefix) {
		this.longest_matching_extension = digit_prefix;
	}
	public double getMatching_price() {
		return matching_price;
	}
	public void setMatching_price(double matching_price) {
		this.matching_price = matching_price;
	}
	public int getMost_digits_ext() {
		return most_digits_ext;
	}
	public void setMost_digits_ext(int most_digits_ext) {
		this.most_digits_ext = most_digits_ext;
	}
	
	
}
