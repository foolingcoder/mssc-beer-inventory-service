package guru.sfg.beer.inventory.service.web.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.beer.inventory.service.web.mappers.BeerInventoryMappers;
import guru.sfg.brewery.model.BeerInventoryDto;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jt on 2019-05-31.
 */
@Slf4j
@RestController
@NoArgsConstructor
public class BeerInventoryController {

	@Autowired
	private BeerInventoryRepository beerInventoryRepository;
	
	@Autowired
	private BeerInventoryMappers beerInventoryMappers;

	@GetMapping("api/v1/beer/{beerId}/inventory")
	List<BeerInventoryDto> listBeersById(@PathVariable UUID beerId) {
		log.debug("Finding Inventory for beerId:" + beerId);

		return beerInventoryRepository.findAllByBeerId(beerId).stream()
				.map(beerInventoryMappers::beerInventoryToBeerInventoryDto).collect(Collectors.toList());
	}
}
