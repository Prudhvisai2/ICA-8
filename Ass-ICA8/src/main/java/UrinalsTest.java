import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UrinalsTest {


    @Test
    void testWriteFile(){
        ArrayList<String> s = new ArrayList<String>();
        s.add("hello");
        Urinals u = new Urinals();
        u.writeFile(s);
    }
}
