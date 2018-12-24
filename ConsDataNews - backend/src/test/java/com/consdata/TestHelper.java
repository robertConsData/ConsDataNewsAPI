package com.consdata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.consdata.entity.Article;
import com.consdata.entity.ArticleDTO;
import com.consdata.entity.News;
import com.consdata.entity.Source;
import com.google.common.collect.ImmutableList;


public class TestHelper {
	
	public static final String COUNTRY = "pl";
	public static final String CATEGORY = "technology";
	
	public static final JSONObject SOURCE_JSON = new JSONObject()
			.put("id", "")
			.put("name", "Antyweb.pl");
	
	public static final JSONObject ARTICLE_JSON = new JSONObject()
	            .put("author", "jszczesny")
	            .put("title", "Uważaj na aktualizacje w Windows 10")
	            .put("description", "Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć")
	            .put("url", "https://antyweb.pl/windows-10-aktualizacja-beta-testy")
	            .put("urlToImage", "https://antyweb.pl/wp-content/uploads/2017/07/Windows10abstract-600x400.png")
	            .put("publishedAt", "2018-12-15T17:18:48")
	            .put("source", SOURCE_JSON)
				.put("content", "Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć. Microsoft w ostatnim czasie nie ma spokoju, jeżeli chodzi albo o aktualizacje dla systemu Windows, albo w kontekście nieporozumień związanych z funkcjonowaniem niektórych mechanizmów systemu operacyjnego. ");


	public static final JSONArray ARTICLE_JSON_ARRAY = new JSONArray()
				.put(ARTICLE_JSON);
	
	public static final JSONObject ARTICCLEDTO_JSON_ONE = new JSONObject()
            .put("author", "jszczesny")
            .put("title", "Uważaj na aktualizacje w Windows 10")
            .put("description", "Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć")
            .put("date", "2018-12-15T17:18:48")
            .put("sourceName", "Antyweb.pl")
            .put("articleUrl", "https://antyweb.pl/windows-10-aktualizacja-beta-testy")
            .put("imageUrl", "https://antyweb.pl/wp-content/uploads/2017/07/Windows10abstract-600x400.png");
	
	public static final JSONArray ARTICLEDTO_JSON_ARRAY = new JSONArray()
			.put(ARTICCLEDTO_JSON_ONE);
	
	
	public static final ArticleDTO ARTICLEDTO_ONE = new ArticleDTO().builder()
			.author("jszczesny")
			.title("Uważaj na aktualizacje w Windows 10")
			.description("Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć")
			.date("2018-12-15T17:18:48")
			.sourceName("Antyweb.pl")
			.articleUrl("https://antyweb.pl/windows-10-aktualizacja-beta-testy")
			.imageUrl("https://antyweb.pl/wp-content/uploads/2017/07/Windows10abstract-600x400.png")
			.build();
	
	public static final ImmutableList<ArticleDTO> EMPTY_ARTICLEDTO_LIST =  ImmutableList.of();
	public static final ImmutableList<ArticleDTO> ARTICLEDTO_LIST =  ImmutableList.of(ARTICLEDTO_ONE);
	
	public static final Source SOURCE = new Source("Antyweb.pl", "");
	
	public static final Article ARTICLE_ONE = new Article().builder()
			.author("jszczesny")
			.title("Uważaj na aktualizacje w Windows 10")
			.description("Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć")
			.date("2018-12-15T17:18:48")
			.articleUrl("https://antyweb.pl/windows-10-aktualizacja-beta-testy")
			.imageUrl("https://antyweb.pl/wp-content/uploads/2017/07/Windows10abstract-600x400.png")
			.source(SOURCE)
			.content("Nadgorliwi staną się beta-testerami i mogą nawet o tym nie wiedzieć. Microsoft w ostatnim czasie nie ma spokoju, jeżeli chodzi albo o aktualizacje dla systemu Windows, albo w kontekście nieporozumień związanych z funkcjonowaniem niektórych mechanizmów systemu operacyjnego. ")
			.build();
	
	public static final ImmutableList<Article> ARTICLE_LIST =  ImmutableList.of(ARTICLE_ONE);
	
	public static final News NEWS_ONE = new News(COUNTRY, CATEGORY, ARTICLEDTO_LIST );
   
}
