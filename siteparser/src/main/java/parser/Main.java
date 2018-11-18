package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("qwe123");
        try {
            Document doc = Jsoup.connect("http://zakupki.gov.ru/epz/order/quicksearch/search.html").get();
            Elements elements = doc.getElementsByClass("registerBox registerBoxBank margBtm20");
            Pattern pattern;
            Matcher matcher;

//            System.out.println(elements.first().getElementsByClass("tenderTd"));

            for (Element element : elements) {

                BuyOrder order = new BuyOrder(element);
                System.out.println(order.toString());
                /*
                System.out.println(element);
//                System.out.println(element.getElementsByClass("tenderTd"));
                Elements tenderId = element.getElementsByClass("tenderTd");
                Elements descriptTenderTd = element.getElementsByClass("descriptTenderTd");
                Elements amountTenderTd = element.getElementsByClass("amountTenderTd");

                for (Element element1 : tenderId) {
//                    System.out.println(element1);

                    String tenderStatus = element1.getElementsByTag("dt").get(0).text();
                    String tmp[] = element1.getElementsByTag("dt").get(1).text().split("/");

                    String startPriceBlock = element1.getElementsByTag("dd").text();
                    pattern = Pattern.compile("Начальная цена (?<price>[\\d, ]+) (?<currency>[^<]+)");
                    matcher = pattern.matcher(startPriceBlock);

                    Double startPrice = null;
                    String currency = null;

                    while (matcher.find()) {
                        startPrice = Double.parseDouble(matcher.group("price").replace(" ", "").replace(",", "."));
                        currency = matcher.group("currency").trim();
                    }


//                    System.out.println("Статус: " + tenderStatus);
//                    System.out.println("Закупка по: " + tmp[1]);
//                    System.out.println("Этап закупки: " + tmp[0]);
//                    System.out.println("Стартовая цена: " + startPrice);
//                    System.out.println("Валюта: " + currency);
                }

                for (Element element1 : descriptTenderTd) {
//                    System.out.println(Arrays.toString(element1.wholeText().replace("  ","").split("\n")));
//                    System.out.println(element1);
                    String regNumber = element1.getElementsByTag("dt").get(0).text().replaceAll("\\D+", "");
//

                    Elements customer = element1.getElementsByClass("nameOrganization").get(0).getElementsByAttributeStarting("href");
                    String customerName = customer.text();
                    String customerUrl = customer.attr("href");
                    String description = element1.getElementsByTag("dd").get(1).text();
                    String ikz = element1.getElementsByTag("dd").get(2).text().replaceAll("\\D+", "");

                    System.out.println("№: " + regNumber);
                    System.out.println("Заказчик: " + customerName);
                    System.out.println("URL заказчика: " + customerUrl);
                    System.out.println("Описание: " + description);
                    System.out.println("ИКЗ: " + ikz);
                }
                pattern= Pattern.compile("Размещено: (?<startDate>[\\d.]+) Обновлено: (?<updateDate>[^<]+)");
                matcher = pattern.matcher(amountTenderTd.text());
                LocalDate startDate = null;
                LocalDate updateDate = null;

                DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );

                while (matcher.find()) {
                    startDate = LocalDate.parse(matcher.group("startDate"));
                    updateDate = LocalDate.parse(matcher.group("updateDate"));
                }

                System.out.println("Размещено: "+startDate);
                System.out.println("Обновлено: "+updateDate);*/
                break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
