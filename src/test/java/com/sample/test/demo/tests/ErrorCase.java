package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.TestData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderPage;

public class ErrorCase extends TestBase {

    Logger log = Logger.getLogger(ErrorCase.class.getName());

    @Test
    /*
    This test demonstrates defect where order can be placed without pizza selection (#2 in the list)
     */
    public void demoErrorCase() throws InterruptedException {

        OrderPage orderpage = new OrderPage(driver);
        log.info("------------Entering selections without pizza -----------------");
        PizzaToppings topping = PizzaToppings.OLIVES;
        orderpage.ChooseTopping(topping.getDisplayName());
        orderpage.EnterQuantity(TestData.QUANTITY);
        String cost = orderpage.GetCost();
        orderpage.EnterName(TestData.NAME);
        orderpage.EnterPhone(TestData.PHONE);
        orderpage.SelectCredit();
        String failureMessage = orderpage.PlaceOrder();
        log.info(failureMessage);

        Assert.assertEquals(failureMessage, TestData.NO_SELECTION_ERROR);

    }

}
