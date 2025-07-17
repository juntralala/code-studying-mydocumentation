package staticKeyWord;

import static staticKeyWord.staticBlock.Aplication.PROCESSORS;
import static staticKeyWord.staticField.Constant.*;
import static staticKeyWord.staticInnerClass.County.City;
import static staticKeyWord.staticMethod.MathUtil.sum;

public class StaticImportApp {
    public static void main(String[] args) {

        System.out.println(APLICATION);
        System.out.println(VERSION);

        System.out.println(sum(2,2,2,2));

        var martapura = new City();
        martapura.setName("Martapura");
        System.out.println(martapura.getName());

        System.out.println(PROCESSORS);

    }
}
