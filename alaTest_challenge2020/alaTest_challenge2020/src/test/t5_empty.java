package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import tele.Company;
import tele.tele;

public class t5_empty {

	@Test
	public void test() {
		tele test = new tele();
		String num = "4673212345";
		long phone = Long.parseLong(num);
		test.test("empty.txt",phone);
		assertEquals(test.getFinal_operator_name(),"");
		assertEquals(test.getFinal_operator_price(),-1);
	}

}
