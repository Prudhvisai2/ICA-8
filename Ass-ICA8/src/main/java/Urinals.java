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

    public int countUrinals(String s) {
        if(!goodString(s)) return -1;
        int total = 0;
        int counter = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') {
                counter++;
                if(i>=1&&s.charAt(i-1)=='1') {
                    counter--;
                }
            }
            else if(s.charAt(i)=='1') {
                if(counter>=1) counter--;
                int oddCount = (counter%2);
                total += counter/2 + oddCount;
                counter = 0;
            }
            else {
                throw new NumberFormatException();
            }
        }
        int oddCount = (counter%2);
        total += counter/2 + oddCount;
        return total;
    }
    
    Boolean goodString(String s){
        if( s==null || s.isBlank()) return false;
        for(int  i = 0; i<s.length(); i++) {
            if(s.charAt(i)=='1' && i+1 < s.length() && s.charAt(i+1)=='1') return false;
        }
        return true;
    }


    //github link:
    public static void main(String[] args){
        System.out.println("dsa");
    }

}
