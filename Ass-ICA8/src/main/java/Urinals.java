import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        if( s==null || s.isEmpty()) return false;
        for(int  i = 0; i<s.length(); i++) {
            if(s.charAt(i)=='1' && i+1 < s.length() && s.charAt(i+1)=='1') return false;
        }
        return true;
    }

    public ArrayList<String> openFile(String file) throws FileNotFoundException {
        ArrayList<String> r = new ArrayList<String>();
        File _file = new File(file);
        Scanner sc = new Scanner(_file);

        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            r.add(s);
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a choice: \n1. Use keyboard\n2. Use file system");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String string = reader.readLine();
        Urinals u = new Urinals();
        if(string.trim().equalsIgnoreCase("1")){
            while(true){
                System.out.println("Enter a string:");
                string = reader.readLine();
                System.out.println(u.countUrinals(string));
            }
        } else {
            System.out.println("Enter a file name");
            string = reader.readLine();
            ArrayList<String> list = u.openFile(string);
            ArrayList<String> output = new ArrayList<String>();
            for(String str: list) {
                output.add(String.valueOf(u.countUrinals(str)));
            }
            System.out.println("Output in output.txt file");
            u.writeFile(output);
        }
    }

}

