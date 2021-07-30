package com.azhagesan.assessment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.azhagesan.assessment.entity.StockEntity;
import com.azhagesan.assessment.model.Stock;
import com.azhagesan.assessment.repository.StockRepository;

@Component
@Path("stockinventory")
public class StockInventoryController {
	
	private static Logger log = LoggerFactory.getLogger(StockInventoryController.class);

	@Autowired
	StockRepository stockRepository;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("save")
	public Stock save(@RequestBody Stock stock) {
		log.debug("Entered save");
		StockEntity entity = new StockEntity();
		BeanUtils.copyProperties(stock, entity);		
		entity = stockRepository.save(entity);
		log.debug("Saved successfully");
		return stock;
	}

	@GET
	@Produces("application/json")
	@Path("/get/{stockNumber}")
	public List<Stock> getStockByNumber(@PathParam("stockNumber") String stockNumber) {
		log.debug("Entered getStockByNumber: {}", stockNumber);		
		List<Stock> stockList = new ArrayList<>();
		Stock stock = null;
		List<StockEntity> stockEntity = stockRepository.findByStockNumber(stockNumber);		
		for(StockEntity entity: stockEntity) {
			stock =  new Stock();
			BeanUtils.copyProperties(entity, stock);			
			stockList.add(stock);
		}
		log.debug("retrieved stock: {}", stock.getStockName());
		return stockList;
	}

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/update/{stockNumber}")
	public Stock updateStockByNumber(@PathParam("stockNumber") int stockNumber, @RequestBody Stock stock) {

		StockEntity entity = new StockEntity();
		BeanUtils.copyProperties(stock, entity);		
		entity = stockRepository.save(entity);
		return stock;
	}

}
