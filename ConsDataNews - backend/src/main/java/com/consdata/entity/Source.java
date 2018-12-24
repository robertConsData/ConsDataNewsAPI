package com.consdata.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Source {
	@JsonProperty("name")
	private String sourceName;
	
	@JsonProperty("id")
	private String id;
	
}
