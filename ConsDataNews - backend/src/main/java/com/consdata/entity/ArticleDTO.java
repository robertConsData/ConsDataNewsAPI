package com.consdata.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO 
{

	private String sourceName;

	@JsonProperty("author")
	private String author;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@JsonProperty("publishedAt")
	private String date;

	@JsonProperty("url")
	private String articleUrl;

	@JsonProperty("urlToImage")
	private String imageUrl;

	@JsonProperty("source")
	private void unpackNested(Map<String,Object> source) 
	{
		this.sourceName = (String)source.get("name");
	}

	@JsonProperty("content")
	private String content;

}
