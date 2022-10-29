import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Urinals {

    public void writeFile(ArrayList<String> list){
        try{
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("output.txt"));
            for(String s: list) {
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //github link:
    public static void main(String[] args){
        System.out.println("dsa");
    }

}
