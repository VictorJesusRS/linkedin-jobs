package com.scrapping.linkedinjobs.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ScrappingService {

    /**
     * Get the whole content of an url
     * @param url
     * @return
     */
    public Document getPageData(String url) {
        Document data;
        try {
            data = Jsoup.connect(url).get();

        }catch (Exception e) {
            throw new RuntimeException("Page request failed");
        }

        return data;
    }

    /**
     * Extract a pagination data and jobs
     * @param document
     */
    public void getJobs(Document document) {

        double numberLoops = this.getNumberOfLoops(document);
//        System.out.println("numberLoops: "+numberLoops);

        Elements elements = document.select(".jobs-search__results-list li");

        this.getJobsData(elements);
    }

    public void getJobsData(Elements elements) {

        for (Element e:
                elements) {
//            System.out.println("jobs count: "+e);

            System.out.println("aaaaaaaa"+e.getElementsByAttribute("data-entity-urn"));
        }

    }

    public double getNumberOfLoops(Document document) {
        String countedJobs;
        Elements elements = document.select(".results-context-header__new-jobs");

        try {
            countedJobs = elements.first().text().replaceAll("[^\\d]", "");
//            System.out.println("countedJobs: "+countedJobs);
        }catch (Exception e) {
            throw new RuntimeException("Main has no text");
        }
        //25 it's the number of jobs per page
        return Math.ceil(Double.parseDouble(countedJobs)/25);
    }
}
