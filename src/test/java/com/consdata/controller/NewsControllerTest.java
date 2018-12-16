package com.consdata.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.consdata.entity.ArticleDTO;
import com.consdata.entity.News;
import com.consdata.service.NewsService;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class NewsControllerTest {

	@Autowired 
	private MockMvc mockMvc;

	@MockBean
	private NewsService newsServiceMock;
	
	private static final String NEWS_PL_TECHNOLOGY = "/news/pl/technology/";

	public static final String COUNTRY = "PL";
	public static final String CATEGORY = "TECHNOLOGY";


	@Test
	public void shouldGetArtivlesByCategory() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get(NEWS_PL_TECHNOLOGY);
		
		List<ArticleDTO> articleList = new ArrayList<>();
		ArticleDTO articleOne = new ArticleDTO().builder()
					.author("jszczesny")
					.title("Uważaj na aktualizacje w Windows 10")
					.description("Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć")
					.date("2018-12-15T17:18:48")
					.sourceName("Antyweb.pl")
					.articleUrl("https://antyweb.pl/windows-10-aktualizacja-beta-testy")
					.imageUrl("https://antyweb.pl/wp-content/uploads/2017/07/Windows10abstract-600x400.png")
					.build();
		
		ArticleDTO articleTwo = new ArticleDTO().builder()
				.author("jszczesny")
				.title("Uważaj na aktualizacje w Windows 10")
				.description("Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć")
				.date("2018-12-15T17:18:48")
				.sourceName("Antyweb.pl")
				.articleUrl("https://antyweb.pl/windows-10-aktualizacja-beta-testy")
				.imageUrl("https://antyweb.pl/wp-content/uploads/2017/07/Windows10abstract-600x400.png")
				.build();
		
		articleList.add(articleOne);
		articleList.add(articleTwo);

		News news = new News().builder()
				.country(COUNTRY)
				.category(CATEGORY)
				.article(articleList)
				.build();
		
		when(newsServiceMock.getArticlesByCategory("pl" , "technology")).thenReturn(news);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.country", is(COUNTRY)))
				.andExpect(jsonPath("$.articles", hasSize(2)))
				.andExpect(jsonPath("$.articles[0].author", is("jszczesny")))
				.andExpect(jsonPath("$.articles[1].sourceName", is("Antyweb.pl")))
				.andReturn();

	}
}
