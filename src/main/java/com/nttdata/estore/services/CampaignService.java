package com.nttdata.estore.services;

import com.nttdata.estore.entities.Campaign;
import com.nttdata.estore.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public Iterable<Campaign> findAll() {
        return campaignRepository.findAll();

    }



}
