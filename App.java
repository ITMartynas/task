public class App {
    public static void main(String[] args) {
        int firstYear = 2010;
        int lastYear = 2015;

        // looping through years from first to last given
        for (int year = firstYear; year <= lastYear; year++) {
            // second loop which loops through the months
            for (int month = 1; month <= 12; month++) {
                // adjusting total available days per cetrain conditions
                int totalDay;
                if (month == 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
                    totalDay = 29; // 29 days for February during leap year
                } else if (month == 2) {
                    totalDay = 28; // 28 days for regular February
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    totalDay = 30; // 30 days for April, June, September, and November
                } else {
                    totalDay = 31; // remaining months have 31 days
                }

                // looping through days of each month
                for (int day = 1; day <= totalDay; day++) {
                    // checking if date stays same after reversing
                    if (isSameDate(year, month, day)) {
                        // if true condition - print the date in YYYY-MM-DD format.
                        System.out.printf("%04d-%02d-%02d%n", year, month, day);
                    }
                }
            }
        }
    }

    // method to check if date stays same after reverse
    private static boolean isSameDate(int year, int month, int day) {
        // YYYYMMDD format by converting year month and date into string
        String dateStr = String.format("%04d%02d%02d", year, month, day);
        // reversing the string with reverse()
        StringBuilder reversedDateBuilder = new StringBuilder(dateStr).reverse();
        // reversed string is converted to a normal string again
        String reversedDateStr = reversedDateBuilder.toString();
        // check if the original date string is equal to the reversed date string.
        return dateStr.equals(reversedDateStr);
    }
}