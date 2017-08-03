package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Campaign;
import com.nttdata.estore.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping(path = "/allCampaigns")
    public @ResponseBody
    Iterable<Campaign> getAllCampaigns() {
        return campaignService.findAll();
    }
}
