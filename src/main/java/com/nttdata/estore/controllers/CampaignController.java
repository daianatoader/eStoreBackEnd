package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Campaign;
import com.nttdata.estore.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping(path = "/campaigns")
    public @ResponseBody
    Iterable<Campaign> getAllCampaigns() {
        return campaignService.findAll();
    }

    @GetMapping(path = "/campaigns/{id}")
    public ResponseEntity getCampaigns(@PathVariable("id") int id){
        Campaign campaign = campaignService.getById(id);
        if (campaign == null) {
            return new ResponseEntity("No Campaign found for id " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(campaign, HttpStatus.OK);
    }

    @DeleteMapping(path= "/campaigns/{id}")
    public ResponseEntity deleteCampaign(@PathVariable int id){
        campaignService.deleteCampaign(id);
        return new ResponseEntity(id,HttpStatus.OK);
    }

    @PostMapping(path = "/campaigns")
    public ResponseEntity createCampaign(@RequestBody Campaign campaign) {
        campaignService.createCampaign(campaign);
        return new ResponseEntity(campaign, HttpStatus.OK);
    }

    @PutMapping(path = "/campaigns/{id}")
    public ResponseEntity updateCampaign(@PathVariable int id, @RequestBody Campaign campaign) {
        Campaign oldCampaign = campaignService.getById(id);
        oldCampaign = campaign;
        campaignService.createCampaign(oldCampaign);
        if (null == oldCampaign) {
            return new ResponseEntity("No Campaign found for id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(oldCampaign, HttpStatus.OK);
    }
}
