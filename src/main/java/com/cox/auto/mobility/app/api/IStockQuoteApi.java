package com.cox.auto.mobility.app.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cox.auto.mobility.app.handler.ExceptionResponse;
import com.cox.auto.mobility.app.handler.StockQuoteException;
import com.cox.auto.mobility.app.model.StockQuote;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/stock/")
@Api(tags = "Stock Quote Service API")
public interface IStockQuoteApi {

	@ApiOperation(value = "Persist stock quote details", nickname = "Persist stock quote details", notes = "End point to Persist stock quote details", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Persisted stock quote details Successfully", response = String.class),
			@ApiResponse(code = 500, message = "Failed While Persisting stock quote details", response = ExceptionResponse.class) })
	@GetMapping(value = "addStockQuotes/{quote}", produces = MediaType.APPLICATION_JSON_VALUE)
	String addStockQuotes(@PathVariable final String quote, Model model) throws StockQuoteException;

	@ApiOperation(value = "Get All Stock Quote(s) Details", nickname = "Get All Stock Quote(s) Details", notes = "End point to get All Stock Quote(s) Details", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieved All Stock Quote(s) Details Successfully", response = String.class),
			@ApiResponse(code = 500, message = "Failed While All Stock Quote(s) Details", response = ExceptionResponse.class) })
	@GetMapping(value = "getAllStocks", produces = MediaType.APPLICATION_JSON_VALUE)
	List<StockQuote> getAllStocks(Model model) throws StockQuoteException;

	@ApiOperation(value = "Get Average Price for given stock quote", nickname = "Get Average Price for given stock quote", notes = "End point to retrieve Average Price for given stock quote", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieved Average Price for given stock quote Successfully", response = String.class),
			@ApiResponse(code = 500, message = "Failed While Retrieving Average Price for given stock quote", response = ExceptionResponse.class) })
	@GetMapping(value = "getStockAvgPrice/{quote}", produces = MediaType.APPLICATION_JSON_VALUE)
	String getStockAvgPrice(@PathVariable final String quote, Model model) throws StockQuoteException;

	@ApiOperation(value = "purge stock quote details", nickname = "purge stock quote details", notes = "End point to purge stock quote details", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "purged stock quote details Successfully", response = String.class),
			@ApiResponse(code = 500, message = "Failed While purging stock quote details", response = ExceptionResponse.class) })
	@DeleteMapping(value = "addStockQuotes/{quote}", produces = MediaType.APPLICATION_JSON_VALUE)
	String purgeStockQuotes(@PathVariable final String quote, Model model) throws StockQuoteException;

}
