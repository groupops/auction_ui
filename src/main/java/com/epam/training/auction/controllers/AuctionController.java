package com.epam.training.auction.controllers;

import com.epam.training.auction.common.AuctionTransferObject;
import com.epam.training.auction.common.AuctionsService;
import com.epam.training.auction.common.BiddingService;
import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.user.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/auctions")
public final class AuctionController {

  private AuctionsService auctionsService;
  private BiddingService biddingService;

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public ModelAndView getAuctions() {
    ModelAndView model = new ModelAndView();

    List<AuctionTransferObject> activeAuctions = new ArrayList<>();
    activeAuctions.add(
        AuctionTransferObject.getBuilder("Cool old shoes", null).setId(1L)
            .setDescription("Stink a little").build());
    activeAuctions.add(AuctionTransferObject.getBuilder("Nothing", null).setId(
        2L)
        .setDescription("Some air").build());
    activeAuctions.add(AuctionTransferObject.getBuilder("Gold bar", null).setId(3L)
        .setDescription("Only 5$").build());

    model.addObject("activeAuctions", activeAuctions);
    model.setViewName("auctions");
    return model;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/add")
  public String showAddAuction() {
    return "auctionAdd";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String addAuction(
      @ModelAttribute String title,
      @ModelAttribute String description,
      @AuthenticationPrincipal User currentUser) {
    ModelAndView model = new ModelAndView();
    UserTransferObject userTransferObject =
        new UserTransferObject(currentUser.getId(), currentUser.getUsername(),
            currentUser.getPassword());
    AuctionTransferObject auction =
        AuctionTransferObject.getBuilder(title, userTransferObject)
            .setDescription(description).build();

    //this.auctionsService.addAuction(auction);
    return "redirect:/auctions";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{auctionId}")
  public ModelAndView getAuction(@PathVariable Long auctionId) {
    ModelAndView model = new ModelAndView();
    model.addObject(this.auctionsService.getAuctionById(auctionId));
    return model;
  }

  @RequestMapping(method = RequestMethod.POST,
      value = "/{auctionId}/bid")
  public String doBid(@PathVariable Long auctionId,
                      @ModelAttribute Long amount,
                      @AuthenticationPrincipal User currentUser) {
    this.biddingService.bid(auctionId, amount, 0);
    return "/auction/{auctionId}";
  }

}
