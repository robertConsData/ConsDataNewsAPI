package com.consdata.service;

import static com.consdata.TestHelper.ARTICLEDTO_JSON_ARRAY;
import static com.consdata.TestHelper.ARTICLEDTO_LIST;
import static com.consdata.TestHelper.ARTICLEDTO_ONE;
import static com.consdata.TestHelper.ARTICLE_JSON_ARRAY;
import static com.consdata.TestHelper.ARTICLE_ONE;
import static com.consdata.TestHelper.EMPTY_ARTICLEDTO_LIST;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.consdata.TestHelper;
import com.consdata.utils.NewsApiConnectionUtils;

@RunWith(SpringRunner.class)
public class NewsServiceTest {
	
	@Mock
    JSONObject jsonObject;
	
	@Mock
    JSONArray jsonArray;
	
	@InjectMocks
	private NewsService newsService;
	
	@Mock
	private NewsApiConnectionUtils connectionUtilsMock;
	
	@Test
	public void shouldMapToDTO() throws JSONException {
		
		assertNotNull(newsService.mapToDto(ARTICLE_ONE));
		Assert.assertEquals(newsService.mapToDto(ARTICLE_ONE), ARTICLEDTO_ONE);
	}
	
	@Test
	public void shouldGetArticlesByCategory() throws JSONException
	{
		when(connectionUtilsMock.getArticles(TestHelper.COUNTRY, TestHelper.CATEGORY)).thenReturn(ARTICLE_JSON_ARRAY);
		Assert.assertEquals(newsService.getArticlesByCategory(TestHelper.COUNTRY, TestHelper.CATEGORY), TestHelper.NEWS_ONE);
	}
	
	@Test
	public void shouldMapToArticleDto() 
	{
		Assert.assertNotNull(newsService.mapToArticleDto(ARTICLE_JSON_ARRAY));
		Assert.assertEquals(newsService.mapToArticleDto(ARTICLE_JSON_ARRAY), ARTICLEDTO_LIST);
		Assert.assertNotEquals(newsService.mapToArticleDto(ARTICLE_JSON_ARRAY), EMPTY_ARTICLEDTO_LIST);
		Assert.assertNotEquals(newsService.mapToArticleDto(new JSONArray()), ARTICLEDTO_LIST);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowsNullPointerException() throws NullPointerException {
	    newsService.mapToArticleDto(ARTICLEDTO_JSON_ARRAY);
	  }
}
