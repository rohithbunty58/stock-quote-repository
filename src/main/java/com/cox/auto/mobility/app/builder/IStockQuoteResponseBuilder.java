package com.cox.auto.mobility.app.builder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cox.auto.mobility.app.model.StockQuote;
import com.cox.auto.mobility.app.model.StockQuote.StockQuoteBuilder;
import com.cox.auto.mobility.app.util.IStockQuoteConstants;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

public interface IStockQuoteResponseBuilder extends IStockQuoteConstants {

	final Logger log = LoggerFactory.getLogger(IStockQuoteResponseBuilder.class);

	default Stock getStock(String stockName) throws IOException {
		return YahooFinance.get(stockName.toUpperCase(), true);
	}

	default BigDecimal getStockAvgPrice(final String quote) {

		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -10); // from 10 years ago

		try {
			Stock stockAveragePrice = YahooFinance.get(quote, from, to, Interval.WEEKLY);

			if (stockAveragePrice != null && stockAveragePrice.getQuote() != null) {
				return stockAveragePrice.getQuote().getPrice();
			}

			log.info(
					" ## IStockQuoteResponseBuilder.getStockAvgPrice() :: Unable to retrieve average price for given quote : {} ",
					quote);

			return BigDecimal.ZERO;

		} catch (IOException e) {
			log.error(
					" Exception occurred at IStockQuoteResponseBuilder.getStockAvgPrice() :: stockQuote {} -> exception : {} ",
					ExceptionUtils.getStackTrace(e));

			return BigDecimal.ZERO;
		}

	}

	default StockQuote getStockInfo(final String stockName) {
		try {
			Stock stock = YahooFinance.get(stockName.toUpperCase(), true);

			StockQuoteBuilder stockQuoteBuilder = StockQuote.builder();
			stockQuoteBuilder.stockName(stockName);
			stockQuoteBuilder.name(stock.getName());
			stockQuoteBuilder.price(stock.getQuote().getPrice());
			stockQuoteBuilder.change(stock.getQuote().getChange());
			stockQuoteBuilder.currency(stock.getCurrency());
			stockQuoteBuilder.bid(stock.getQuote().getBid());
			stockQuoteBuilder.priceHint(stock.getQuote().getChangeFromYearHighInPercent());

			return stockQuoteBuilder.build();
		} catch (IOException e) {

			log.error(
					" Exception occurred at IStockQuoteResponseBuilder.getStockInfo() :: stockQuote {} -> exception : {} ",
					ExceptionUtils.getStackTrace(e));

			return null;
		}
	}

}
