package com.siemens.tinyurl;

import com.siemens.tinyurl.services.Base62Converter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureMockMvc
@SpringBootTest
class TinyurlApplicationTests {

	@Autowired
	Base62Converter base62Converter;

	@Test
	void testBaseConversion() {
		long value = 123455;
		Assert.assertEquals(base62Converter.decode(base62Converter.encode(123455)), value);

	}

}
