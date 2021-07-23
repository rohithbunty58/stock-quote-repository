package com.cox.auto.mobility.app.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cox.auto.mobility.app.builder.IStockQuoteResponseBuilder;
import com.cox.auto.mobility.app.config.Loggable;
import com.cox.auto.mobility.app.model.StockQuote;
import com.cox.auto.mobility.app.service.IStockQuoteService;
import com.cox.auto.mobility.app.util.IStockQuoteConstants;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockQuoteService implements IStockQuoteService, IStockQuoteResponseBuilder, IStockQuoteConstants {

	static final Set<String> STOCK_QUOTE_SET = Collections.synchronizedSet(Sets.newTreeSet());

	final List<String> STOCK_QUOTES = Lists.newArrayList();

	@Override
	@Loggable
	public String addStockQuotes(final String quote, final Model model) {
		STOCK_QUOTE_SET.add(quote);
		log.info(" ## StockQuoteService.addStockQuotes() -> stock quotes count : {} ", STOCK_QUOTE_SET.size());

		List<StockQuote> stockQuotes = STOCK_QUOTE_SET.stream().map(stockQuote -> {
			return getStockInfo(stockQuote);
		}).filter(Objects::nonNull).collect(Collectors.toList());

		model.addAttribute(STOCK_QUOTES_LIST, stockQuotes);

		return SUCCESS;
	}

	@Override
	@Loggable
	public List<StockQuote> getAllStocks(Model model) {
		log.info(" ## StockQuoteService.getAllStocks() -> stock quotes count : {} ", STOCK_QUOTE_SET.size());

		List<StockQuote> stockQuotes = STOCK_QUOTE_SET.stream().map(stockQuote -> {
			return getStockInfo(stockQuote);
		}).filter(Objects::nonNull).collect(Collectors.toList());

		model.addAttribute(STOCK_QUOTES_LIST, stockQuotes);

		return stockQuotes;

	}

	@Override
	@Loggable
	public String getStockAvgPrice(final String quote, Model model) {
		log.info(" ## StockQuoteService.getStockAvgPrice() -> stock quotes count : {} ", STOCK_QUOTE_SET.size());

		BigDecimal avgPrice = getStockAvgPrice(quote);

		log.info(" ## StockQuoteService.getStockAvgPrice() -> stock quotes count {} average price {} ", quote,
				avgPrice);

		return avgPrice.toString();
	}

	public synchronized List<String> getStockQuotes() {
		return Collections.unmodifiableList(STOCK_QUOTES);
	}

	@PostConstruct
	@Loggable
	public void initStockQuotes() {
		try (Stream<String> lines = Files.lines(Paths.get(STOCK_QUOTES_FILE_PATH))) {
			STOCK_QUOTES.addAll(lines.collect(Collectors.toList()));
			log.info(" ## StockQuoteService.initStockQuotes() -> stock quotes count : {} ", STOCK_QUOTES.size());
		} catch (IOException e) {
			log.error(" ## Exception occurred at StockQuoteService.initStockQuotes() -> exception : {} ",
					ExceptionUtils.getStackTrace(e));
		}
	}

	@Override
	@Loggable
	public String purgeStockQuotes(final String quote, final Model model) {

		log.info(" ## StockQuoteService.purgeStockQuotes() -> stock quotes count before purge : {} ",
				STOCK_QUOTE_SET.size());

		boolean isQuoteRemoved = STOCK_QUOTE_SET.remove(quote);

		log.info(" ## StockQuoteService.purgeStockQuotes() -> isQuoteRemoved : {} ", isQuoteRemoved);
		log.info(" ## StockQuoteService.purgeStockQuotes() -> stock quotes count after purge: {} ",
				STOCK_QUOTE_SET.size());

		List<StockQuote> stockQuotes = STOCK_QUOTE_SET.stream().map(stockQuote -> {
			return getStockInfo(stockQuote);
		}).filter(Objects::nonNull).collect(Collectors.toList());

		model.addAttribute(STOCK_QUOTES_LIST, stockQuotes);

		return SUCCESS;
	}

}
