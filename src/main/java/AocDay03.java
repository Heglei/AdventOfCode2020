import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class AocDay03 {

    public static void main(String[] args) {

        List<String> lines = input();
        int trees = 0;
        int position = 0;
        for (int i = 1; i < lines.size(); i++) {
            position += 3;
            if (position > lines.get(i).length() - 1) {
                position = position - lines.get(i).length();
            }

            if (lines.get(i).charAt(position) == '#') {
                trees++;
            }
        }
        System.out.println(trees);

        int trees2 = trees * slopes(lines, 1, 1);
        trees2 = trees2 * slopes(lines, 5, 1);
        trees2 = trees2 * slopes(lines, 7, 1);
        trees2 = trees2 * slopes(lines, 1, 2);
        System.out.println(trees2);
    }

    private static int slopes(List<String> lines, int right, int down) {

        int trees = 0;
        int position = 0;
        for (int i = down; i < lines.size(); i += down) {
            position += right;
            if (position > 30) {
                position = position - 31;
            }

            if (lines.get(i).charAt(position) == '#') {
                trees++;
            }
        }
        System.out.println(trees);
        return trees;
    }


    private static List<String> input() {
        Scanner scanner;
        List<String> lines = new ArrayList<>();
        try {
            scanner = new Scanner(new File("C:\\AOC2020\\Day3.txt"));
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
