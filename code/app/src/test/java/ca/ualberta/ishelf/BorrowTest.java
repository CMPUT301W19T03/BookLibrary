package ca.ualberta.ishelf;

import org.junit.Assert;
import org.junit.Test;

public class BorrowTest {
    @Test
    public void setLendertest(){
        User user = new User();
        Borrow borrow = new Borrow();
        borrow.setLender(user);


        Assert.assertEquals(user, borrow.getLender());

    }

    @Test
    public void getLendertest(){
        User user = new User();
        Borrow borrow = new Borrow();
        borrow.setLender(user);


        Assert.assertEquals(user, borrow.getLender());

    }

    @Test
    public void setBorrowertest(){
        User user = new User();
        Borrow borrow = new Borrow();
        borrow.setBorrower(user);


        Assert.assertEquals(user, borrow.getBorrower());


    }

    @Test
    public void getBorrowertest(){
        User user = new User();
        Borrow borrow = new Borrow();
        borrow.setBorrower(user);


        Assert.assertEquals(user, borrow.getBorrower());

    }
}
