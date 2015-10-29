package com.epam.training.auction.controllers.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmytro_Ulanovych on 10/27/2015.
 */
@RestController
public final class AuctionRESTController {

    @RequestMapping(method = RequestMethod.GET, value = "/auctions")
    public List<String> getAuctions() {
        return Arrays.asList("Auction A", "Auction B", "Auction C");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/auction/{auctionId}")
    public String getAuction(@PathVariable Integer auctionId) {
        return "Auction " + auctionId;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/auction/{auctionId}/bid/{amount}")
    public String doBid(@PathVariable Integer auctionId, @PathVariable Double amount) {
        return "Auction " + auctionId + " bid = " + amount;
    }
}
