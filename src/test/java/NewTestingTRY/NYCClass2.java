package NewTestingTRY;

import org.openqa.selenium.WebDriver;

public class NYCClass2  {

    static Object sp1;

    private int i = 1;

    class InnerClass {
        private void im() {
            System.out.println(i);
        }
    }

    static class NestedClass {
        static void m() {
        }
    }

    public static void main(String[] args) {
        NYCClass2 nycClass2 = new NYCClass2();
        nycClass2.new InnerClass();
        new NYCClass2.NestedClass();
    }
}


