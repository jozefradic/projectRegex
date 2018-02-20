import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("rawText.txt");
        Scanner input = new Scanner(file);
        PrintWriter printWriterSpz = new PrintWriter("spz.txt");
        PrintWriter printWriterRc = new PrintWriter("rc.txt");
        PrintWriter printWriterMac = new PrintWriter("mac.txt");
        while (input.hasNext()) {

            String word = input.next();

            Pattern spz = Pattern.compile("[A-Z]{2}[0-9]{3}[A-Z]{2}");
            Pattern rc = Pattern.compile("[0-9]{2}(([05][1-9])|([16][012]))([0][1-9]|[12][0-9]|[3][01])\\/?[0-9]{4}");
            Pattern mac = Pattern.compile("[a-fA-F0-9:]{17}|[a-fA-F0-9]{12}");

            Matcher m = spz.matcher((String) word);
            Matcher n = rc.matcher((String) word);
            Matcher o = mac.matcher((String) word);

            if (m.matches()) {
                printWriterSpz.println(word);
                System.out.println(word);
                }

            if (n.matches()) {
                printWriterRc.println(word);
                System.out.println(word);
            }

            if (o.matches()) {
                printWriterMac.println(word);
                System.out.println(word);
            }


        }
        printWriterSpz.flush();
        printWriterSpz.close();

        printWriterRc.flush();
        printWriterRc.close();

        printWriterMac.flush();
        printWriterMac.close();
    }

}
