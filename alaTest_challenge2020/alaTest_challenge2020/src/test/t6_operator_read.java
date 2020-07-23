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

public class t6_operator_read {

	@Test
	public void test() {
		tele test = new tele();
		test.test("operator_read.txt",1234567890);
		assertEquals(test.getAllPrices().size(), 2);
		assertEquals(test.getInputNum(),1234567890);
	}

}
