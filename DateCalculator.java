import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* A date calculator */
public class DateCalculator {
    final static String helpMsg = "\nOPTIONS\n1: compute the days between two given dates\n2: compute the date after the days from the given date\n0: exit the calculator";
    private static Scanner sc = null;
    private static boolean done = false;

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
        String text = today.format(formatter);
        System.out.printf("\nWelcome to Date Calculator!\nToday is %s.\n", text);
        System.out.println(helpMsg);
        sc = new Scanner(System.in);
        while(!done) {
            System.out.print("\nEnter your option: ");
            String command = sc.nextLine().trim();
            userMenu(command);
        }
    }

    private static void userMenu(String command) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");

        switch (command) {

            case "1":
                System.out.println("\nCalculate days from starting date to end date");
                System.out.print("\nEnter the starting date(mm/dd/yyyy): ");
                String str1 = sc.nextLine();
                LocalDate startDate = LocalDate.parse(str1.trim(), formatter);
                System.out.print("Enter the end date(mm/dd/yyyy): ");
                String str2 = sc.nextLine();
                LocalDate endDate = LocalDate.parse(str2.trim(), formatter);
                long days = startDate.until(endDate, ChronoUnit.DAYS);
                System.out.printf("\nThe difference is %d days\n", days);
                break;

            case "2":
                System.out.println("\nCalculate the date after given number of days from starting date");
                System.out.print("\nEnter the starting date(mm/dd/yyyy): ");
                String str3 = sc.nextLine();
                LocalDate date1 = LocalDate.parse(str3.trim(), formatter);
                System.out.print("Enter the number of days: ");
                String str4 = sc.nextLine();
                long amountToAdd = Long.parseLong(str4.trim());
                LocalDate date2 = date1.plus(amountToAdd, ChronoUnit.DAYS);
                System.out.printf("\nThe date after %d days from %s is %s\n", amountToAdd, str3, date2.format(formatter));
                break;

            case "0":
                done = true;
                System.out.println("\nExit");
        }
    }
}
