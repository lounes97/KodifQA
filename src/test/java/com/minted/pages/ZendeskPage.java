package com.minted.pages;

import com.minted.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZendeskPage extends BasePage {

        public ZendeskPage() {
                PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//input[@id='user_email']")
        public WebElement zenDeskUserName;
        @FindBy(xpath = "//input[@id='user_password']")
        public WebElement zenDeskPassword;
        @FindBy(xpath = "//button[@id='sign-in-submit-button']")
        public WebElement zenDeskLoginBtn;

        @FindBy(xpath = "//div[@data-test-id='header-toolbar-search-button']")
        public WebElement zendeskSearchBoxOnMain;

        @FindBy(xpath = "(//div[@data-entity-id='2522'])[1]")
        public WebElement ticket;

        @FindBy(xpath = "//input[@data-garden-id='forms.media_input']")
        public WebElement zendeskSearchBox;

    }

