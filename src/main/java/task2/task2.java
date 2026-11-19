import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class task2 {

    /**
     * Calculates the number of days between two dates.
     *
     * @param year_from  starting year
     * @param month_from starting month (1-12)
     * @param day_from   starting day of month (1-31)
     * @param year_to    ending year
     * @param month_to   ending month (1-12)
     * @param day_to     ending day of month (1-31)
     * @return the number of days between the two dates
     */
    public static long daysBetween(
            int year_from, int month_from, int day_from,
            int year_to, int month_to, int day_to) {

        LocalDate startDate = LocalDate.of(year_from, month_from, day_from);
        LocalDate endDate = LocalDate.of(year_to, month_to, day_to);

        return Math.abs(ChronoUnit.DAYS.between(startDate, endDate));
    }

    public static void main(String[] args) {
        long diff1 = daysBetween(2026, 1, 1, 2026, 11, 20);
        long diff2 = daysBetween(2024, 2, 15, 2024, 3, 5); // Includes Feb 29 (leap year)

        System.out.println("Days between 2026-01-01 and 2026-11-20: " + diff1);
        System.out.println("Days between 2024-02-15 and 2024-03-05: " + diff2);
    }
}