package com.cox.auto.mobility.app.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Builder
@Data
public class StockQuote {

	private BigDecimal bid;
	private BigDecimal change;
	private String currency;
	private String name;
	private BigDecimal price;
	private BigDecimal priceHint;
	private String stockName;

}
