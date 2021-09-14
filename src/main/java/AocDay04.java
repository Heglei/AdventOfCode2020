import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AocDay04 {

    public static void main(String[] args) {

        ArrayList<String> passports = input();
        int validPassports = 0;
        for (final String passport : passports) {
            final String[] entries = passport.split(" ");

            boolean isValid = true;

            for (final String entry : entries) {
                final String[] entryPair = entry.split(":");
                final String key = entryPair[0];
                final String value = entryPair[1];

                if (key.equals("cid")) {
                    continue;
                }
                final String regex = switch (key) {
                    case "byr" -> "19[2-9][0-9]|200[0-2]";
                    case "iyr" -> "201[0-9]|2020";
                    case "eyr" -> "202[0-9]|2030";
                    case "hgt" -> "1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in";
                    case "hcl" -> "#[0-9a-f]{6}";
                    case "ecl" -> "amb|blu|brn|gry|grn|hzl|oth";
                    case "pid" -> "\\d{9}";
                    default -> null;
                };

                if (regex == null) {
                    isValid = false;
                    break;
                }

                final Pattern pattern = Pattern.compile(regex);
                final Matcher matcher = pattern.matcher(value);

                if (!matcher.find()) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                validPassports++;
            }
        }

        System.out.println("Number of valid passports: " + validPassports);
        System.out.println("Number of passports with all required fields: " + input().size());

    }

    private static ArrayList<String> input() {
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> passports = new ArrayList<>();
        ArrayList<String> validPassports = new ArrayList<>();


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\AOC2020\\Day4.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
            bufferedReader.close();
            int lines = 0;
            while (lines < data.size()) {
                StringBuilder passportPaired = new StringBuilder();
                while (lines < data.size() && !data.get(lines).isEmpty()) {
                    passportPaired.append(data.get(lines)).append(" ");
                    lines++;
                }
                passports.add(passportPaired.toString());
                lines++;
            }
            for (String pass : passports) {
                Scanner scanner1 = new Scanner(pass);
                ArrayList<String> fields = new ArrayList<>();
                while (scanner1.hasNext()) {
                    fields.add(scanner1.next());
                }
                if (fields.size() == 7 || fields.size() == 8) {
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
                        validPassports.add(pass);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return validPassports;
    }

}