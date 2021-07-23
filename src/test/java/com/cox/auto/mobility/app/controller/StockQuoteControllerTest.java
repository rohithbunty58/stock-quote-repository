package com.cox.auto.mobility.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.MimeTypeUtils;

import com.cox.auto.mobility.app.service.IStockQuoteService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StockQuoteController.class)
public class StockQuoteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IStockQuoteService stockQuoteService;

	@Test
	void addStockQuotesWhenValidInput_thenReturns200() throws Exception {

		// When
		final ResultActions result = mockMvc
				.perform(get("/stock/addStockQuotes/{quote}", "SVXY").accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

		// Then
		result.andExpect(status().isOk());
	}

	@Test
	void getAllStocksWhenValidInput_thenReturns200() throws Exception {

		// When
		final ResultActions result = mockMvc
				.perform(get("/stock/getAllStocks").accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

		// Then
		result.andExpect(status().isOk());
	}

	@Test
	void getStockAvgPriceWhenValidInput_thenReturns200() throws Exception {

		// When
		final ResultActions result = mockMvc
				.perform(get("/stock/getStockAvgPrice/{quote}", "SVXY").accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

		// Then
		result.andExpect(status().isOk());
	}

	@Test
	void purgeStockQuotesWhenValidInput_thenReturns200() throws Exception {

		// When
		final ResultActions result = mockMvc
				.perform(delete("/stock/addStockQuotes/{quote}", "SVXY").accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

		// Then
		result.andExpect(status().isOk());
	}
}
