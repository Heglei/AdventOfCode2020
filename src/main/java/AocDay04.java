import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AocDay04 {
    public static void main(String[] args) {
        ArrayList<String> ArrayList1 = new ArrayList<>();
        ArrayList<String> passports = new ArrayList<>();
        int validPassCount = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader("C:\\AOC2020\\Day4.txt"));
            String line;
            while ((line = input.readLine()) != null) {
                ArrayList1.add(line);
            }
            input.close();
            int lines = 0;
            while (lines < ArrayList1.size()) {
                StringBuilder PassportPaired = new StringBuilder();
                while (lines < ArrayList1.size() && !ArrayList1.get(lines).isEmpty()) {
                    PassportPaired.append(ArrayList1.get(lines)).append(" ");
                    lines++;
                }
                passports.add(PassportPaired.toString());
                lines++;
            }
            for (String pass : passports) {
                Scanner scanner1 = new Scanner(pass);
                ArrayList<String> fields = new ArrayList<>();
                while (scanner1.hasNext()) {
                    fields.add(scanner1.next());
                }
                if (fields.size() == 7) {
                    int validFieldCount = 0;
                    for (String field : fields) {
                        if (field.startsWith("ecl") || field.startsWith("pid")
                                || field.startsWith("eyr") || field.startsWith("hcl")
                                || field.startsWith("byr") || field.startsWith("iyr")
                                || field.startsWith("hgt")) {
                            validFieldCount++;
                        }
                    }
                    if (validFieldCount == 7) {
                        validPassCount++;
                    }
                } else if (fields.size() == 8) {
                    validPassCount++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(validPassCount);
    }
//
//public int partTwo() {
//    Map<String, String> requiredValidFields = new HashMap();
//
//    private validPassport() {
//        requiredValidFields.put("byr", "19[2-9][0-9]|200[0-2]");
//        requiredValidFields.put("iyr", "201[0-9]|2020");
//        requiredValidFields.put("eyr", "202[0-9]|2030");
//        requiredValidFields.put("hgt", "1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in");
//        requiredValidFields.put("hcl", "#[0-9a-f]{6}");
//        requiredValidFields.put("ecl", "amb|blu|brn|gry|grn|hzl|oth");
//        requiredValidFields.put("pid", "\\d{9}");
//    }
//}
}