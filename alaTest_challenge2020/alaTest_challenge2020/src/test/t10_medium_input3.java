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

public class t10_medium_input3 {

	@Test
	public void test() {
		tele test = new tele();
		String num = "8613318738121";
		long phone = Long.parseLong(num);
		test.test("operators_stress.txt",phone);
		assertEquals(test.getFinal_operator_name(),"Operator R");
		assertEquals(test.getFinal_operator_price(),0.88);
	}

}
