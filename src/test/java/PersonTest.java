import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.testng.Assert.assertEquals;

public class PersonTest {

    {
    }

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Test Start");
        currentTime();
    }

    @AfterClass()
    void afterClass() {
        System.out.println("Test End");
        currentTime();
    }

    @DataProvider(name = "AgeTest")
    Object[][] AgeTest() {
        return new Object[][] {
                {-1, false},
                {0, false},
                {12, false},
                {13,true},
                {15,true},
                {18,true},
                {19,false},
                {20,false}
        };
    }

    @Test(dataProvider = "AgeTest")
    void testPersonIsTeenager(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        System.out.println("For age " + age + ": " + "Actual result: " + result + " / " + "Expected result: " + expected);
        assertEquals(result, expected);
    }
}
