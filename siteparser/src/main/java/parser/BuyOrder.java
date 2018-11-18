package parser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuyOrder {

    private String regNumber;

    private String tenderStatus;
    private Double startPrice;
    private String currency;

    private String reasonLaw;
    private String stage;

    private String customerName;
    private String customerUrl;
    private String description;
    private String buyId;
    private LocalDate startDate;

    private LocalDate updateDate;

    BuyOrder(Element element) {
        Element descriptTenderTd = element.getElementsByClass("descriptTenderTd").get(0);
        Element tenderId = element.getElementsByClass("tenderTd").get(0);

        tenderStatus = tenderId.getElementsByTag("dt").get(0).text();
        Pattern pattern = Pattern.compile("Начальная цена (?<price>[\\d, ]+) (?<currency>[^<]+)");
        Matcher matcher = pattern.matcher(tenderId.getElementsByTag("dd").text());
        while (matcher.find()) {
            startPrice = Double.parseDouble(matcher.group("price").replace(" ", "").replace(",", "."));
            currency = matcher.group("currency").trim();
        }

        String tmp[] = tenderId.getElementsByTag("dt").get(1).text().split("/");
        stage = tmp[0].trim();
        reasonLaw = tmp[1].trim();

        regNumber = descriptTenderTd.getElementsByTag("dt").get(0).text().replaceAll("\\D+", "");

        Elements customer = descriptTenderTd.getElementsByClass("nameOrganization").get(0).getElementsByAttributeStarting("href");
        customerName = customer.text();
        customerUrl = customer.attr("href");
        description = descriptTenderTd.getElementsByTag("dd").get(1).text();
        buyId = descriptTenderTd.getElementsContainingOwnText("Идентификационный код закупки(ИКЗ):").text().replaceAll("\\D+", "");

        pattern = Pattern.compile("Размещено: (?<startDate>[\\d.]+) Обновлено: (?<updateDate>[^<]+)");
        matcher = pattern.matcher(element.getElementsByClass("amountTenderTd").text());
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        while (matcher.find()) {
            startDate = LocalDate.parse(matcher.group("startDate"), f);
            updateDate = LocalDate.parse(matcher.group("updateDate"), f);
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getTenderStatus() {
        return tenderStatus;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public String getReasonLaw() {
        return reasonLaw;
    }

    public String getStage() {
        return stage;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerUrl() {
        return customerUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getBuyId() {
        return buyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    @Override
    public String toString() {
        return "BuyOrder{" +
                "regNumber='" + regNumber + '\'' +
                ", tenderStatus='" + tenderStatus + '\'' +
                ", startPrice=" + String.format("%.2f", startPrice) +
                ", currency='" + currency + '\'' +
                ", reasonLaw='" + reasonLaw + '\'' +
                ", stage='" + stage + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerUrl='" + customerUrl + '\'' +
                ", description='" + description + '\'' +
                ", buyId='" + buyId + '\'' +
                ", startDate=" + startDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
