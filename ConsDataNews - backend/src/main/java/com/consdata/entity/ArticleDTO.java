package com.consdata.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

	private String author;
	private String title;
	private String description;
	private String date;
	private String sourceName;
	private String articleUrl;
	private String imageUrl;
	
}
