import static org.testng.Assert.assertEquals;


public class Person {
    public static boolean isTeenager(int age) {
        boolean result;
        if (age < 19) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    }