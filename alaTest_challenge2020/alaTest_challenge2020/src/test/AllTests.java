package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ t1_bad_read.class, t10_medium_input3.class, t11_medium_input4.class, t12_medium_input5.class,
		t13_small_input.class, t14_small_input2.class, t15_small_input3.class, t2_bad_read2.class,
		t3_company_functions.class, t4_comparator.class, t5_empty.class, t6_operator_read.class,
		t7_operator_max_extension_len.class, t8_medium_input.class, t9_medium_input2.class })
public class AllTests {

}
