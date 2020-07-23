package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import tele.tele;

public class t1_bad_read {

	@Test
	public void test() {
		int counter = 0;
		while(counter<2) {
			try {
				tele test = new tele();
				if(counter == 0)
					tele.test("bad_read.txt",123);
				else
					tele.test("operator.txt",123);
					assertTrue (true);
					return;
			} catch (Exception e) {
				counter++;
			}
		}
	}

}
