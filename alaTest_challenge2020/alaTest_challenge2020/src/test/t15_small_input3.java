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

public class t15_small_input3 {

	@Test
	public void test() {
		tele test = new tele();
		String num = "64028672";
		long phone = Long.parseLong(num);
		test.test("operators3.txt",phone);
		assertEquals(test.getFinal_operator_name(),"Operator E");
		assertEquals(test.getFinal_operator_price(),0.01);
	}

}
