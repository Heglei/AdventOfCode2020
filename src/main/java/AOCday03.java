import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class AOCday03 {

    public static void main(String[] args) {

        List<String> lines = input();
        int trees = 0;
        int slope = 0;
        for (int i = 1; i < lines.size(); i++) {
            slope += 3;
            if ()
                if (lines.get(i).charAt(slope) == '#') {
                    trees++;
                }
            System.out.println(trees);
        }
    }

    private static List<String> input() {
        Scanner scanner;
        List lines = new ArrayList();
        try {
            scanner = new Scanner(new File("C:\\\\AOC2020\\\\Day3.txt"));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Die angegebene Datei konnte nicht gefunden werden");
        }
        return lines;
    }
}
