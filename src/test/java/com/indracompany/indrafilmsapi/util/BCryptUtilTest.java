package com.indracompany.indrafilmsapi.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BCryptUtilTest {

	@Test
	public void test_crypt() {
		//	Prepare
		String message = "123456";
		
		//	Expected
		String result = BCryptUtil.crypt(message);
				
		//	Test
		assertNotNull(result);
	}
	
	@Test
	public void test_isValid() {
		//	Prepare
		String message = "123456";
		String hash = "$2a$12$fls8CbcSv/1tfOMgdYZ23uSQscxF3UzywItaauV9g7kO1qHo9tU7W";
		
		//	Expected
		boolean result = BCryptUtil.isValid(message, hash);
		
		//	Test
		assertTrue(result);
	}

}
