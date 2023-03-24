package com.jihoon.board.service.implementation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jihoon.board.service.MainService;

@Service
public class MainServiceImplements implements MainService {
    
    //? 스케쥴 작업이 끝나는 시간 기준으로 실행
    // @Scheduled(fixedDelay=1000)
    // public void scheduleFixedDelay() {
    //     System.out.println("고정 딜레이 작업 : " + System.currentTimeMillis() / 1000);
    // }

    //? 스케쥴 작업이 시작하는 시간 기준으로 실행
    // @Scheduled(fixedRate=1000)
    // public void scheduleFixedRate() {
    //     System.out.println("시작 고정 딜레이 작업 : " + System.currentTimeMillis() / 1000);
    // }

    // @Scheduled(cron="2 * * * * ?")
    // public void scheduleCronJob() {
    //     try {
    //         crawlling();
    //     } catch (Exception exception) {
    //         exception.printStackTrace();
    //     }
    // }

    public void crawlling() throws Exception {

        Document document = Jsoup.connect("https://naver.com").get();

        Elements elements = document.select("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li > a");
        System.out.println(elements.size());

        for (Element element: elements) {
            System.out.println(element.absUrl("href"));
        }

    }

}
