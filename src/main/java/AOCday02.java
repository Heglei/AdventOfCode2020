import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AOCday02 {
//    public static void main(String[] args) {
//        Scanner scanner;
//        int valid = 0;
//        try {
//            scanner = new Scanner(new File ("C:\\AOC2020\\Day2.txt"));
//            while (scanner.hasNextLine()) {
//                String[] parts = scanner.nextLine().split(" ");
//                String[] policy = parts[0].split("-");
//                char letter = parts[1].charAt(0);
//                int validCount = 0;
//
//                for (int i = 0; i < parts[2].length(); i++) {
//                    if (parts[2].charAt(i) == letter) {
//                        validCount++;
//                    }
//                }
//                if (validCount >= Integer.parseInt(policy[0])
//                        && validCount <= Integer.parseInt(policy[1])) {
//                    valid++;
//                }
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Die angegebene Datei konnte nicht gefunden werden");
//        }
//        System.out.println(valid);
//    }

    public static void main(String[] args) {
        Scanner scanner;
        int valid = 0;
        try {
            scanner = new Scanner(new File("C:\\AOC2020\\Day2.txt"));
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                String[] policy = parts[0].split("-");
                char letter = parts[1].charAt(0);
                int validCount = 0;

                if (parts[2].charAt(Integer.valueOf(policy[0]) - 1) == letter) {
                    validCount++;
                }
                if (parts[2].charAt(Integer.valueOf(policy[1]) - 1) == letter) {
                    validCount++;
                }
                if (validCount == 1) {
                    valid++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Die angegebene Datei konnte nicht gefunden werden");
            e.printStackTrace();
        }
        System.out.println(valid);
    }
}