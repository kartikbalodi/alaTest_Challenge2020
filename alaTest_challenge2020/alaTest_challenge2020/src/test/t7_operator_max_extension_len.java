package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import org.junit.Test;

import tele.Company;
import tele.tele;

public class t7_operator_max_extension_len {

	@Test
	public void test() {
		tele test = new tele();
		test.test("operators_max_ext_len_check.txt",1234567890);
		Vector<Company> m_test = test.getAllPrices();
		for(int i=0; i<m_test.size();i++) {
			Company c = m_test.get(i);
			Map<Long,Double> op_map = c.getPrices();
			assertEquals(op_map.size(),Math.pow(2, i+1));
		}
	}

}
