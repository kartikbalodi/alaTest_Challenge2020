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

public class t12_medium_input5 {

	@Test
	public void test() {
		tele test = new tele();
		String num = "918860249757";
		long phone = Long.parseLong(num);
		test.test("operators_stress.txt",phone);
		assertEquals(test.getFinal_operator_name(),"Operator J");
		assertEquals(test.getFinal_operator_price(),1.11);
	}

}
