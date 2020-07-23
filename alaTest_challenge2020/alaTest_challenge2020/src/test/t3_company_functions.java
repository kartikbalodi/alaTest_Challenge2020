package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import tele.Company;
import tele.tele;

public class t3_company_functions {

	@Test
	public void test() {
		Company c1 = new Company("Test 1",null, 0, Long.MAX_VALUE, Double.MAX_VALUE);

		//name functionality tests
		assertEquals(c1.getName(), "Test 1");
		c1.setName("Change name check");
		assertEquals(c1.getName(), "Change name check");

		//map access tests
		assertTrue(c1.getPrices() == null); 
		Map<Long, Double> m1 = new TreeMap<Long,Double>();
		m1.put((long)1,(double)1);
		m1.put((long)2,(double)2);
		m1.put((long)3,(double)3);
		c1.setPrices(m1);
		Map<Long, Double> m_test = c1.getPrices();
		assertTrue(m_test.containsKey((long)1));
		assertTrue(m_test.containsKey((long)2));
		assertTrue(m_test.containsKey((long)3));
		assertTrue(m_test.containsValue((double)1));
		assertTrue(m_test.containsValue((double)2));
		assertTrue(m_test.containsValue((double)3));
		assertFalse(m_test.containsKey((long)0));
		
		//remaining getter and setter tests
		c1.setLongest_matching_extension(10);
		c1.setMost_digits_ext(1);
		c1.setMatching_price(1);
		assertTrue(c1.getLongest_matching_extension() == 10);
		assertTrue(c1.getMost_digits_ext() == 1);
		assertTrue(c1.getMatching_price() == 1);
	}

}
