package com.cox.auto.mobility.app.service;

import java.util.List;

import org.springframework.ui.Model;

import com.cox.auto.mobility.app.model.StockQuote;

public interface IStockQuoteService {

	String addStockQuotes(String quote, Model model);

	List<StockQuote> getAllStocks(Model model);

	String getStockAvgPrice(String quote, Model model);

	String purgeStockQuotes(String quote, Model model);

}
