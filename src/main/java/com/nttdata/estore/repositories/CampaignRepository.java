package com.nttdata.estore.repositories;

import com.nttdata.estore.entities.Campaign;
import org.springframework.data.repository.CrudRepository;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {
}
