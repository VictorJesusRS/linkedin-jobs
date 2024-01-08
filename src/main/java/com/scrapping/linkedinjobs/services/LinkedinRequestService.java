package com.scrapping.linkedinjobs.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Getter
@Setter
@NoArgsConstructor
@Component
public class LinkedinRequestService {
    private final String BASE_URL = "/jobs/search/";
    private final String TIME_PERIOD = "f_TPR=r86400"; //24 horas
    private final String WORK_TYPE = "f_WT=2"; //#remoto
    private final String ORIGIN ="origin=JOB_SEARCH_PAGE_JOB_FILTER";
    private final String SORT_BY = "sortBy=DD";
    private String location;
    private String keywords;
    private String page = "pageNum=0";
    private String position = "position=1";
    private String start = "start=0";
    private String url;

    public LinkedinRequestService(String location, String keywords) {
        this.location = location;
        this.keywords = keywords;
    }

    public  void setPage(String page) {
        this.page = "pageNum"+  page;
    }

    public  void setPosition(String position) {
        this.position = "position="+ position;
    }

    public  void setStart(String start) {
        this.start = "start="+ start;
    }
    public void setLocation(String location) {
        this.location = "geoId="+ location;
    }

    public void setKeywords(String keywords) {
        this.keywords = "keywords=" + keywords;
    }

    public void buildUrl() {
        this.url = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.linkedin.com")
                .path(this.BASE_URL)
                .query(this.TIME_PERIOD)
                .query(this.WORK_TYPE)
                .query(this.ORIGIN)
                .query(this.SORT_BY)
                .query(this.location)
                .query(this.keywords)
                .query(this.position)
                .query(this.page)
                .query(this.start)
                .toUriString();

        System.out.println(this.url);
    }
}
