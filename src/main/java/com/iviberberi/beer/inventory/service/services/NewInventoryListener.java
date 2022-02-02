package com.iviberberi.beer.inventory.service.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iviberberi.beer.inventory.service.config.JmsConfig;
import com.iviberberi.beer.inventory.service.domain.BeerInventory;
import com.iviberberi.beer.inventory.service.repositories.BeerInventoryRepository;
import com.iviberberi.comon.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    private void list(NewInventoryEvent event) {
        log.debug("Got inventory: " + event.toString());

        beerInventoryRepository.save(BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .upc(event.getBeerDto().getUpc())
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .build());
    }
}
