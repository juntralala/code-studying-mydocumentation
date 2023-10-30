package muhammad.junaidi.test.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {


    @Test
    public  void listMockTest() {

        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(0)).thenReturn("Ujun");
        Mockito.when(list.get(100)).thenReturn("Muhammad Junaidi");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(100));


        Mockito.verify(list, Mockito.times(1)).get(0);
//        Mockito.verify(list, Mockito.times(2)).get(0);
    }


}
