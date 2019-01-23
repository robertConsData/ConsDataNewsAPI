package com.consdata.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class News 
{
	
	private String country;
	private String category;
	
	@JsonProperty("articles")
	private List<ArticleDTO> article;

}
