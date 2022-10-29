import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UrinalsTest {


    @Test
    void testWriteFile(){
        ArrayList<String> s = new ArrayList<String>();
        s.add("hello");
        Urinals u = new Urinals();
        u.writeFile(s);
    }

    @Test
    void testCountUrinals1(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.countUrinals("00000"),3);
    }

    @Test
    void testCountUrinals2(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.countUrinals("00001"),2);
    }

    @Test
    void testCountUrinals3(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.countUrinals("10000"),2);
    }

    @Test
    void testCountUrinals4(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.countUrinals("010010"),0);
    }

    @Test
    void testCounterUrinals5(){
        Urinals u = new Urinals();
        NumberFormatException thrown = assertThrows(
                NumberFormatException.class,
                ()->u.countUrinals("1av"),
                "is an error"
        );
    }

}


