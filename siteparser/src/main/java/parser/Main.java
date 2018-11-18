package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static int TOTAL_PAGES = 50;
    private static int RECORDS_PER_PAGE = 100;

    public static void main(String[] args) {
        System.out.println("qwe123");
        try {
            List<BuyOrder> buyOrderList = new ArrayList<>(TOTAL_PAGES * RECORDS_PER_PAGE);

            long startTime = System.currentTimeMillis();
            for (int page = 1; page < TOTAL_PAGES; page++) {

                Document doc = Jsoup.connect(getUrl(page)).get();
                Elements elements = doc.getElementsByClass("registerBox registerBoxBank margBtm20");

                for (Element element : elements) {
                    BuyOrder order = new BuyOrder(element);
                    if (!order.getFaillMsg().equals("parseError")) {
                        buyOrderList.add(order);
                    }
                }
            }
            long endTime = System.currentTimeMillis();

            System.out.println(buyOrderList.size());
            System.out.println(buyOrderList.get(0).toString());
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getUrl(int pageNum) {
        String buildUrl = "http://zakupki.gov.ru/epz/order/quicksearch/search.html?" + "morphology=on" +
                "&pageNumber=" + pageNum +
                "&sortDirection=false" +
                "&recordsPerPage=_" + RECORDS_PER_PAGE +
                "&showLotsInfoHidden=false" +
                "&fz44=on" +
                "&fz223=on" +
                "&ppRf615=on" +
                "&fz94=on" +
                "&af=on" +
                "&ca=on" +
                "&pc=on" +
                "&pa=on" +
                "&currencyId=-1" +
                "&regionDeleted=false" +
                "&sortBy=UPDATE_DATE";
        return buildUrl;
    }
}
