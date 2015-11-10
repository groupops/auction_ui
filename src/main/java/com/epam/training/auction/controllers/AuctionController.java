package com.epam.training.auction.controllers;

import com.epam.training.auction.common.AuctionTransferObject;
import com.epam.training.auction.common.AuctionsService;
import com.epam.training.auction.common.BiddingService;
import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import static com.epam.training.auction.common.AuctionTransferObject.getBuilder;

@Controller
@RequestMapping(value = "/auctions")
public final class AuctionController {
    private final AuctionsService auctionsService;
    private final BiddingService biddingService;

    @Autowired
    public AuctionController(AuctionsService auctionsService, BiddingService biddingService) {
        this.auctionsService = auctionsService;
        this.biddingService = biddingService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView getAuctions() {
        ModelAndView model = new ModelAndView();

        List<AuctionTransferObject> activeAuctions = new ArrayList<>();
        activeAuctions.add(getBuilder("Cool old shoes", null).setId(1L).setDescription("Stink a little").build());
        activeAuctions.add(getBuilder("Nothing", null).setId(2L).setDescription("Some air").build());
        activeAuctions.add(getBuilder("Gold bar", null).setId(3L).setDescription("Only 5$").build());

        model.addObject("activeAuctions", activeAuctions);
        model.setViewName("auctions");
        return model;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String showAddAuction() {
        return "auctionAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAuction(@RequestParam String title, @RequestParam String description, @AuthenticationPrincipal User currentUser) {
        UserTransferObject userTransferObject = new UserTransferObject(currentUser.getId(), currentUser.getUsername(), currentUser.getPassword());
        AuctionTransferObject auction = getBuilder(title, userTransferObject).setDescription(description).build();
        auctionsService.addAuction(auction);
        return "redirect:/auctions";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{auctionId}")
    public ModelAndView getAuction(@PathVariable Long auctionId) {
        ModelAndView model = new ModelAndView();
        model.setViewName("auction");
        AuctionTransferObject auction = getBuilder("Example auction", null).setDescription("Hello. Is it me you're looking for?").setId(auctionId).build();
        model.addObject("auction", auction);
        model.addObject(auctionsService.getAuctionById(auctionId));
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bid")
    public String doBid(@RequestParam Long auctionId, @RequestParam Long amount, @AuthenticationPrincipal User currentUser, RedirectAttributes redirectAttrs) {
        biddingService.bid(auctionId, amount, currentUser.getId());
        redirectAttrs.addFlashAttribute("auctionId", auctionId)
                .addFlashAttribute("message", "There's no error actually but also there's no camel so I am faking this error message because nothing happened.");
        return "redirect:/auctions/" + auctionId;
    }
}
