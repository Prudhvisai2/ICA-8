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

    @Test
    void testGoodString0(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.goodString("101101"),false);
    }

    @Test
    void testGoodString1(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.goodString("10001"),true);
    }

    @Test
    void testGoodString2(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.goodString("1010011"),false);
    }

    @Test
    void testGoodString4(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.goodString(""),false);
    }

    @Test
    void testGoodString5(){
        Urinals u = new Urinals();
        Assertions.assertEquals(u.goodString(null),false);
    }

}


