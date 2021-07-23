package com.cox.auto.mobility.app.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cox.auto.mobility.app.handler.ExceptionResponse;
import com.cox.auto.mobility.app.handler.StockQuoteException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/")
@Api(tags = "Main Service API")
public interface IMainControllerApi {

	@ApiOperation(value = "Get Entity Matching For Same Label Details", nickname = "Get Entity Matching For Same Label Details", notes = "End point to get Entity Matching for same-TIN / same-email / same-phone entity", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieved Get Entity Matching For Same Label Details Successfully", response = String.class),
			@ApiResponse(code = 500, message = "Failed While Retrieving Get Entity Matching For Same Label Details", response = ExceptionResponse.class) })
	@GetMapping(value = { "/", "/index" })
	String entryEndpoint(Model model) throws StockQuoteException;

}
