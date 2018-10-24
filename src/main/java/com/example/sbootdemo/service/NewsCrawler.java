package com.example.sbootdemo.service;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * Crawling news from hfut news
 *
 * @author hu
 */
public class NewsCrawler extends BreadthCrawler {

    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     * information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     * links which match regex rules from pag
     */
    public NewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
        addSeed("http://zhuanlan.sina.com.cn/");

        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        addRegex("http://finance.sina.com.cn/zl/.*shtml");
        /*do not fetch jpg|png|gif*/
        addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        /*if page is news page*/
        if (page.matchUrl("http://finance.sina.com.cn/zl/.*shtml")) {
            /*we use jsoup to parse page*/
            //Document doc = page.getDoc();

            /*extract title and content of news by css selector*/
            String title = page.select("div[class=blkContainerSblk]>h1").first().text();
            String content = page.select("div#artibody", 0).text();
            String imgUrl = page.select("div[class=img_wrapper]>img[src]").get(0).attr("abs:src");

            System.err.println("URL:\n" + url);
            System.err.println("title:\n" + title);
            System.err.println("content:\n" + content);
            System.err.println("imgUrl:\n" + imgUrl);

            /*If you want to add urls to crawl,add them to nextLink*/
            /*WebCollector automatically filters links that have been fetched before*/
        /*If autoParse is true and the link you add to nextLinks does not
          match the regex rules,the link will also been filtered.*/
            //next.add("http://xxxxxx.com");
        }
    }

}
