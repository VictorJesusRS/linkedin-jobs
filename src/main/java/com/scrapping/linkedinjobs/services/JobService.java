package com.scrapping.linkedinjobs.services;

import com.scrapping.linkedinjobs.enums.LocationsEnum;
import com.scrapping.linkedinjobs.enums.TechnologiesEnum;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final LinkedinRequestService linkedinRequestService;
    private  final ScrappingService scrappingService;

    public JobService(LinkedinRequestService linkedinRequestService, ScrappingService scrappingService) {
        this.linkedinRequestService = linkedinRequestService;
        this.scrappingService = scrappingService;
    }

    /**
     * Generate and Get the linkedin Url, with the provided params (now hardcoded)
     * @return
     */
    public String getJobsUrl() {
        this.linkedinRequestService.setKeywords(TechnologiesEnum.JAVA.getValue());
        this.linkedinRequestService.setLocation(LocationsEnum.LATAM.getValue());
        this.linkedinRequestService.buildUrl();
        return this.linkedinRequestService.getUrl();
    }

    /**
     * Get the jobs obtained with web scraping
     * @return
     */
    public  String getJobs() {
        Document data = this.scrappingService.getPageData(this.getJobsUrl());
        this.scrappingService.getJobs(data);
        return "aa";
    }



}
