package com.cox.auto.mobility.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.cox.auto.mobility.app.model.StockQuote;
import com.cox.auto.mobility.app.service.impl.StockQuoteService;
import com.cox.auto.mobility.app.util.IStockQuoteConstants;

@ExtendWith(MockitoExtension.class)
public class StockQuoteServiceTest {

	private static final String INDA = "INDA";

	private StockQuoteService stockQuoteService = new StockQuoteService();

	@Mock
	private Model model;

	@Test
	void addStockQuotesTest() {

		stockQuoteService.addStockQuotes(INDA, model);

		List<StockQuote> quotesList = stockQuoteService.getAllStocks(model);

		assertTrue(!quotesList.isEmpty());

	}

	@Test
	void getStockAvgPriceTest() {

		stockQuoteService.addStockQuotes(INDA, model);

		BigDecimal averagePrice = stockQuoteService.getStockAvgPrice(INDA);

		assertNotNull(averagePrice);
	}

	@Test
	void purgeStockQuotesTest() {

		stockQuoteService.addStockQuotes(INDA, model);

		String response = stockQuoteService.purgeStockQuotes(INDA, model);

		assertEquals(IStockQuoteConstants.SUCCESS, response);

		List<StockQuote> quotesList = stockQuoteService.getAllStocks(model);

		assertTrue(quotesList.isEmpty());
	}

}
