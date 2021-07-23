package com.cox.auto.mobility.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.cox.auto.mobility.app.api.IMainControllerApi;
import com.cox.auto.mobility.app.config.Loggable;
import com.cox.auto.mobility.app.handler.StockQuoteException;
import com.cox.auto.mobility.app.service.impl.StockQuoteService;
import com.cox.auto.mobility.app.util.IStockQuoteConstants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController implements IStockQuoteConstants, IMainControllerApi {

	private final StockQuoteService stockQuoteService;

	@Override
	@Loggable
	public String entryEndpoint(Model model) throws StockQuoteException {

		log.info(" ## MainController.entryEndpoint() ");

		List<String> stockQuotes = stockQuoteService.getStockQuotes();

		model.addAttribute(TASKS, stockQuotes);

		model.addAttribute(STOCK_QUOTES_LIST, stockQuoteService.getAllStocks(model));

		return INDEX;
	}

}
