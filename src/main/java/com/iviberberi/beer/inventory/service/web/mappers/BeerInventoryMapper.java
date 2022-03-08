package com.iviberberi.beer.inventory.service.web.mappers;

import com.iviberberi.beer.inventory.service.domain.BeerInventory;
import com.iviberberi.brewery.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
