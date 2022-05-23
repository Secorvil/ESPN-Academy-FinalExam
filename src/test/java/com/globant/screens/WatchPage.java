package com.globant.screens;

import com.globant.util.screens.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage {

    @FindBy(css = ".BucketsContainer div:first-child .Carousel ul")
    private WebElement firstCarousel;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement closeCardButton;

    @FindBy(css = ".Carousel__Outer:nth-child(1) ul")
    private WebElement liveEventsCarousel;

    @FindBy(css = ".Carousel__Outer:nth-child(1) ul li")
    private List<WebElement> liveEventsCarouselCards;

    @FindBy(css = ".Carousel__Outer:nth-child(1) ul .WatchTile__Content")
    private WebElement carouselCardsInformation;

    /**
     * Constructor method.
     *
     * @param driver Driver instance
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get the first content carousel.
     * @return WebElement of first carousel
     */
    public WebElement getFirstCarousel() {
        return firstCarousel;
    }

    /**
     * Set a WebElement as first carousel.
     * @param firstCarousel new firstCarousel element
     */
    public void setFirstCarousel(WebElement firstCarousel) {
        this.firstCarousel = firstCarousel;
    }

    /**
     * Get the close (X) card button.
     * @return WebElement of the close card button
     */
    public WebElement getCloseCardButton() {
        return closeCardButton;
    }

    /**
     * Set a WebElement as close (x) card button.
     * @param closeCardButton new closeCardButton element
     */
    public void setCloseCardButton(WebElement closeCardButton) {
        this.closeCardButton = closeCardButton;
    }

    /**
     * Get the "Live events" carousel.
     * @return WebElement of the live events carousel
     */
    public WebElement getLiveEventsCarousel() {
        return liveEventsCarousel;
    }

    /**
     * Set a WebElement as "Live events" carousel.
     * @param liveEventsCarousel new liveEventsCarousel element
     */
    public void setLiveEventsCarousel(WebElement liveEventsCarousel) {
        this.liveEventsCarousel = liveEventsCarousel;
    }

    /**
     * Get the cards from the "Live events" carousel.
     * @return List of WebElements containing the carousel cards
     */
    public List<WebElement> getLiveEventsCarouselCards() {
        return liveEventsCarouselCards;
    }

    /**
     * Set a List of WebElements as "Live events" carousel cards.
     * @param liveEventsCarouselCards new liveEventsCarouselCards element
     */
    public void setLiveEventsCarouselCards(List<WebElement> liveEventsCarouselCards) {
        this.liveEventsCarouselCards = liveEventsCarouselCards;
    }

    /**
     * Get the title and description of carousel cards.
     * @return WebElement of the description of each carousel card
     */
    public WebElement getCarouselCardsInformation() {
        return carouselCardsInformation;
    }

    /**
     * Set the description of the carousel cards.
     * @param carouselCardsInformation new carouselCardsInformation element
     */
    public void setCarouselCardsInformation(WebElement carouselCardsInformation) {
        this.carouselCardsInformation = carouselCardsInformation;
    }

    /**
     * @author Sebastián Correa
     *
     * This method checks if the "Live events" carousel is displayed.
     *
     * @return true if the live events carousel is displayed, otherwise false
     */
    public boolean checkLiveEventsCarousel() {
        scroll(0,600);
        return isElementVisible(liveEventsCarousel);
    }

    /**
     * @author Sebastián Correa
     *
     * This method checks if each card of live events carousel is properly displayed.
     *
     * @return true if all cards are displayed, otherwise false
     */
    public boolean checkCarouselCardsAreDisplayed() {
        boolean carouselCardsAreDisplayed = true;
        try {
            for (WebElement liveEventsCarouselCard : liveEventsCarouselCards) {
                if (!isElementVisible(liveEventsCarouselCard)) {
                    carouselCardsAreDisplayed = false;
                }
            }
        } catch (Exception exception) {
            carouselCardsAreDisplayed = false;
        }
        return carouselCardsAreDisplayed;
    }

    /**
     * @author Sebastián Correa
     *
     * This method clicks a card of the first carousel.
     *
     * @param cardNumber index of the card to be clicked.
     */
    public void clickFirstCarouselSelectedCard(int cardNumber) {
        String cardSelector = ".BucketsContainer div:first-child .Carousel ul li:nth-child(" + cardNumber + ")";
        WebElement selectedCard = driver.findElement(By.cssSelector(cardSelector));
        click(selectedCard);
    }
}
