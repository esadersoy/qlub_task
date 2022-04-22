package io.qlub.pages;

import io.qlub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.get(), this);

    }

    public WebElement getSelectOptionWthText(String text) {
        return Driver.get().findElement(By.xpath("//div[text()='" + text + "']"));
    }

    @FindBy(xpath = "//div[contains(@class,'Menu_title')]")
    public WebElement menuTitle;

    @FindBy(tagName = "canvas")
    public WebElement menuAsPdf;

    @FindBy(xpath = "//div[@class='flex grow']/div[1]")
    public WebElement payMyBillButton;

    @FindBy(xpath = "//div/p[contains(@class,'InvoiceTable_title')]")
    public WebElement tableInformation;

    @FindBy(xpath = "(//td/strong)[1]")
    public WebElement yourBillLabel;

    @FindBy(xpath = "(//td/strong)[2]")
    public WebElement billAmount;

    @FindBy(xpath = "//div[contains(@class,'PayStripe_cardContainer')]//iframe")
    public WebElement cardPaymentOption;

    @FindBy(xpath = "//div[@data-field='number']/label")
    public WebElement cardNumberLabel;

    @FindBy(xpath = "//style[text()='ApplePayButton_']")
    public List<WebElement> applePayButton;

    @FindBy(xpath="//style[text()='GooglePayButton_']")
    public List<WebElement> googlePayButton;



}
