package com.indracompany.indrafilmsapi.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DateFormatUtilTest {
	
	@Test
	public void test_formatDate() {
		//	Prepare
		String stringDate = "2020-10-23";
		
		//	Result
		Date date = DateFormatUtil.formatToDate(stringDate);
		String result = DateFormatUtil.formatToString(date);
		
		//	Test
		assertEquals("23/10/2020", result);
	}

}
