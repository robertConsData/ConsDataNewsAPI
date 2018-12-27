package com.consdata.utils;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
public class ConnectionUtilsTest {
	
	public static final String NEWS_API_TECHNOLOGY_PL_URL = "https://newsapi.org/v2/top-headlines?country=pl&category=technology&apiKey=0ebd108da98748099a2c81546ab02151";
	
	@InjectMocks
	NewsApiConnectionUtilsImpl connectionUtils = new NewsApiConnectionUtilsImpl();
	
	@Test
	public void shouldGetUrl()
	{
		
		String actualResult = connectionUtils.getURL("pl", "technology");
		
		assertEquals(NEWS_API_TECHNOLOGY_PL_URL, actualResult);
	}
	

}
