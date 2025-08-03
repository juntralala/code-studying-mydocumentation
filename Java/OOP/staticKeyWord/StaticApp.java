package staticKeyWord;

import staticKeyWord.staticField.Constant;
import staticKeyWord.staticMethod.MathUtil;
import staticKeyWord.staticInnerClass.County;
import staticKeyWord.staticBlock.Aplication;

public class StaticApp {
    public static void main(String[] args) {

        System.out.println(Constant.APLICATION);
        System.out.println(Constant.VERSION);

        System.out.println(MathUtil.sum(2,2,2,2));

        var martapura = new County.City();
        martapura.setName("Martapura");
        System.out.println(martapura.getName());

        System.out.println(Aplication.PROCESSORS);

    }
}
