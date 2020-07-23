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

public class t13_small_input {

	@Test
	public void test() {
		tele test = new tele();
		String num = "4673212345";
		long phone = Long.parseLong(num);
		test.test("operators.txt",phone);
		assertEquals(test.getFinal_operator_name(),"Operator C");
		assertEquals(test.getFinal_operator_price(),0.3);
	}

}
