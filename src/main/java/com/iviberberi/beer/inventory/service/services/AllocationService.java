package com.iviberberi.beer.inventory.service.services;

import com.iviberberi.brewery.model.BeerOrderDto;

public interface AllocationService {

    Boolean allocateOrder(BeerOrderDto beerOrderDto);
}
