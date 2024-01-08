package com.scrapping.linkedinjobs.controllers;

import com.scrapping.linkedinjobs.enums.LocationsEnum;
import com.scrapping.linkedinjobs.enums.TechnologiesEnum;
import com.scrapping.linkedinjobs.services.JobService;
import com.scrapping.linkedinjobs.services.LinkedinRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService, LinkedinRequestService linkedinRequestService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<String> index() {

        return ResponseEntity.ok(this.jobService.getJobs());
    }

}
