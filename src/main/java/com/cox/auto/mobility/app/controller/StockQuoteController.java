package com.cox.auto.mobility.app.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.cox.auto.mobility.app.api.IStockQuoteApi;
import com.cox.auto.mobility.app.config.Loggable;
import com.cox.auto.mobility.app.handler.StockQuoteException;
import com.cox.auto.mobility.app.model.StockQuote;
import com.cox.auto.mobility.app.service.IStockQuoteService;
import com.cox.auto.mobility.app.util.IStockQuoteConstants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StockQuoteController implements IStockQuoteApi, IStockQuoteConstants {

	private final IStockQuoteService stockQuoteService;

	@Override
	@Loggable
	public String addStockQuotes(final String quote, final Model model) throws StockQuoteException {
		log.info(" ## StockQuoteController.addStockQuotes() -> request : {}", quote);

		return stockQuoteService.addStockQuotes(quote, model);
	}

	@Override
	@Loggable
	public List<StockQuote> getAllStocks(Model model) throws StockQuoteException {
		log.info(" ## StockQuoteController.getAllStocks()");

		return stockQuoteService.getAllStocks(model);
	}

	@Override
	@Loggable
	public String getStockAvgPrice(String quote, Model model) throws StockQuoteException {
		log.info(" ## StockQuoteController.getStockAvgPrice() -> request : {}", quote);

		return stockQuoteService.getStockAvgPrice(quote, model);
	}

	@Override
	@Loggable
	public String purgeStockQuotes(final String quote, final Model model) throws StockQuoteException {
		log.info(" ## StockQuoteController.purgeStockQuotes() -> request : {}", quote);

		return stockQuoteService.purgeStockQuotes(quote, model);
	}

}
