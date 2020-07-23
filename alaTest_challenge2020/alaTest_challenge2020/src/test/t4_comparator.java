package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import tele.Company;
import tele.tele;

public class t4_comparator {

	@Test
	public void test() {
		tele test = new tele();
		tele.test("comparator_check.txt", 1234567890);
		assertEquals(test.getAllPrices().get(0).getName(), "Operator First");
		assertEquals(test.getAllPrices().get(1).getName(), "Operator Second");
		assertEquals(test.getAllPrices().get(2).getName(), "Operator Third");
		assertEquals(test.getAllPrices().get(3).getName(), "Operator Last");
	}

}
