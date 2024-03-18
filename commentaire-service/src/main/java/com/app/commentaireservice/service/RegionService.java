package com.app.commentaireservice.service;

import com.app.commentaireservice.dto.RegionRequest;
import com.app.commentaireservice.model.Region;
import com.app.commentaireservice.repository.RegionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public Region createRegion(RegionRequest regionRequest) {
        Region region = Region.builder()
                .content(regionRequest.getContent())
                .imageUrl(regionRequest.getImageUrl())
                .build();
        log.info("Region is saved");
        return regionRepository.saveAndFlush(region);
    }
}
