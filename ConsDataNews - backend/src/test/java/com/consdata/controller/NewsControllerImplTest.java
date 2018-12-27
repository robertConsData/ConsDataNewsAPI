package com.consdata.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.consdata.TestHelper;
import com.consdata.service.NewsServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(NewsControllerImpl.class)
public class NewsControllerImplTest {

	@Autowired 
	private MockMvc mockMvc;

	@MockBean
	private NewsServiceImpl newsServiceMock;
	
	private static final String NEWS_PL_TECHNOLOGY = "/news/pl/technology/";

	@Test
	public void shouldGetArtivlesByCategory() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get(NEWS_PL_TECHNOLOGY);
		
		when(newsServiceMock.getArticlesByCategory(TestHelper.COUNTRY , TestHelper.CATEGORY)).thenReturn(TestHelper.NEWS_ONE);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.country", is(TestHelper.COUNTRY)))
				.andExpect(jsonPath("$.articles", hasSize(1)))
				.andExpect(jsonPath("$.articles[0].author", is("jszczesny")))
				.andExpect(jsonPath("$.articles[0].sourceName", is("Antyweb.pl")))
				.andReturn();

	}
}
