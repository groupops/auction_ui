package com.epam.training.auction.controllers.rest;

import com.epam.training.auction.common.AuctionTransferObject;
import com.epam.training.auction.common.AuctionsService;
import com.epam.training.auction.common.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public final class AuctionRESTController {

  @Autowired
  private AuctionsService auctionsService;

  @Autowired
  private BiddingService biddingService;

  @RequestMapping(method = RequestMethod.GET, value = "/auctions")
  public ModelAndView getAuctions() {
    ModelAndView model = new ModelAndView();
    model.addObject(this.auctionsService.getActiveAuctions());
    model.setViewName("auctions");
    return model;
  }

  @RequestMapping(value = "/auctions/add", method = RequestMethod.POST)
  public ModelAndView addAuction(@ModelAttribute("auction") AuctionTransferObject auction) {
    ModelAndView model = new ModelAndView();
    model.addObject("auctionCreated", "Auction was successfuly created.");
    model.setViewName("/auction/{auctionId}");
    this.auctionsService.addAuction(auction);
    return model;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/auction/{auctionId}")
  public ModelAndView getAuction(@PathVariable Long auctionId) {
    ModelAndView model = new ModelAndView();
    model.addObject(this.auctionsService.getAuctionById(auctionId));
    return model;
  }

  @RequestMapping(method = RequestMethod.POST,
      value = "/auction/{auctionId}/maxBid")
  public ModelAndView maxBid(@PathVariable Long auctionId) {
    ModelAndView model = new ModelAndView();
    model.addObject(this.biddingService.getMaxBid(auctionId));
    return model;
  }

  @RequestMapping(method = RequestMethod.POST,
      value = "/auction/{auctionId}/bid/{amount}")
  public String doBid(@PathVariable Long auctionId,
                      @PathVariable Long amount,
                      @PathVariable Long userId) {
    this.biddingService.bid(auctionId, amount, userId);
    return "/auction/{auctionId}";
  }

}
