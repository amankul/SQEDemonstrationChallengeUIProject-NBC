package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.constants.TestData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderPage;

public class HappyPath extends TestBase {

    Logger log = Logger.getLogger(HappyPath.class.getName());

    @Test
    /*
    This test verifies user can order a small pizza with one topping
     */
    public void demoHappyTest() throws InterruptedException {

        OrderPage orderpage = new OrderPage(driver);
        log.info("------------Entering selections for pizza order---------------");
        PizzaTypes pizzaType = PizzaTypes.SMALL_ONETOPPINGS;
        orderpage.ChoosePizza(pizzaType.getDisplayName());
        PizzaToppings topping = PizzaToppings.OLIVES;
        orderpage.ChooseTopping(topping.getDisplayName());
        orderpage.EnterQuantity(TestData.QUANTITY);
        orderpage.EnterName(TestData.NAME);
        orderpage.EnterPhone(TestData.PHONE);
        orderpage.SelectCredit();
        String cost = orderpage.GetCost();
        String successMessage = orderpage.PlaceOrder();
        log.info(successMessage);

        // comparing double until n decimal places can get tricky, hence just worry about whole $$
        Assert.assertEquals(Double.valueOf(cost).intValue(), (int) (pizzaType.getCost() * Integer.parseInt(TestData.QUANTITY)));
        Assert.assertTrue(successMessage.contains(pizzaType.getDisplayName()));

    }

}
