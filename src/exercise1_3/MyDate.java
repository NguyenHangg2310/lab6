package exercise1_3;

import javax.swing.plaf.SplitPaneUI;

public class MyDate {
    private int year;
    private int month;
    private int day;

    String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] DAY_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int[] nonLeapYearMonthNumbers = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    int[] leapYearMonthNumbers = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};


    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public boolean isValidDate(int year, int month, int day) {
        if (!(year >= 1 && year <= 9999)) {
            return false;
        }
        if (!(month >= 1 && month <= 12)) {
            return false;
        }

        int monthDays = DAY_IN_MONTHS[month - 1] + (month == 2 & isLeapYear(year) ? 1 : 0);
        if (!(day >= 1 && day <= monthDays)) {
            return false;
        }
        return true;
    }

    public int getDayOfWeek(int year, int month, int day) {
        int magicCenturyNumber = 6 - 2 * ((year / 100) % 4);
        int lastTwoDigitsOfYear = year % 100;
        int magicYearNumber = lastTwoDigitsOfYear / 4;
        int magicMonthNumber = isLeapYear(year) ? leapYearMonthNumbers[month - 1] : nonLeapYearMonthNumbers[month - 1];
        int magicDayNumber = day;
        return (magicCenturyNumber + lastTwoDigitsOfYear + magicYearNumber + magicMonthNumber + magicDayNumber) % 7;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDayOfWeekTest(int year, int month, int day) {
        for (int i = 0; i <= 6; i++) {
            if (getDayOfWeek(year, month, day) == i) {
                return DAYS[i];
            }
        }
        return null;
    }

    public MyDate() {
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonthLetter(int month) {
        for (int i = 0; i <= 11; i++) {
            if (month == i + 1) {
                return MONTHS[i];
            }
        }
        return null;
    }

    public String toString() {
        if (!isValidDate(year, month, day)) {
            return "Invalid year, month, or day!";
        }
        return getDayOfWeekTest(this.year, this.month, this.day) + " " + this.day + " " + getMonthLetter(this.month) + " " + this.year;
    }

    public MyDate nextDay() {
        int monthDays = DAY_IN_MONTHS[month - 1] + (month == 2 & isLeapYear(year) ? 1 : 0);
        if (day != monthDays) {
            setDay(day + 1);
        } else {
            setDay(1);
            if (month != 12) {
                setMonth(month + 1);
            } else {
                setMonth(1);
                setYear(year + 1);
            }
        }
        return this;
    }

    public MyDate nextMonth() {
        int monthDays = DAY_IN_MONTHS[month - 1] + (month == 2 & isLeapYear(year) ? 1 : 0);
        if (day == monthDays) {
            setDay(DAY_IN_MONTHS[month] + (month == 1 & isLeapYear(year) ? 1 : 0));
        }
        if (month != 12) {
            setMonth(month + 1);
        } else {
            setMonth(1);
            setYear(year + 1);
        }
        return this;
    }

    public MyDate nextYear() {
        if (isLeapYear(year + 1) && month == 2) {
            setDay(29);
        }else if ((!isLeapYear(year + 1)) && month == 2){
            setDay(28);
        }
        setYear(year + 1);
        return this;
    }

    public MyDate previousDay() {
        int monthDays = DAY_IN_MONTHS[month - 1] + (month == 2 & isLeapYear(year) ? 1 : 0);
        if (day != 1) {
            setDay(day - 1);
        } else if (day == monthDays) {
            setDay(DAY_IN_MONTHS[month - 2] + (month == 3 & isLeapYear(year) ? 1 : 0));
            if (month != 1) {
                setMonth(month - 1);
            } else {
                setMonth(12);
                setYear(year - 1);
            }

        } else {
            setDay(31);
            if (month != 1) {
                setMonth(month - 1);
            } else {
                setMonth(12);
                setYear(year - 1);
            }
        }
        return this;
    }

    public MyDate previousMonth() {
        int monthDays = DAY_IN_MONTHS[month - 1] + (month == 2 & isLeapYear(year) ? 1 : 0);
        if (day == monthDays) {
            setDay(DAY_IN_MONTHS[month - 2] + (month == 3 & isLeapYear(year) ? 1 : 0));
        }
        if (month != 1) {
            setMonth(month - 1);
        } else {
            setMonth(12);
            setYear(year - 1);
        }
        return this;
    }

    public MyDate previousYear() {
        if (isLeapYear(year) && month == 2) {
            setDay(28);
        }else if ((!isLeapYear(year)) && month == 2){
            setDay(29);
        }
            setYear(year - 1);
        return this;
    }
}
