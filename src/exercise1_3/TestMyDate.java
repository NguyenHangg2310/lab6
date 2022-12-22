package exercise1_3;

public class TestMyDate {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate();
        System.out.println(myDate1.isValidDate(2003,10,-23));
        System.out.println(myDate1.getDayOfWeekTest(2022,10,25));
        System.out.println(myDate1.getMonthLetter(10));
        MyDate myDate2 = new MyDate(2022,12,31);
        System.out.println(myDate2);
        System.out.println(myDate2.nextDay());
        System.out.println(myDate2.nextDay());
        System.out.println(myDate2.nextMonth());
        System.out.println(myDate2.previousDay());
        System.out.println("-----------------------");
        MyDate date1 = new MyDate(2012,2,28);
        System.out.println(date1);
        System.out.println(date1.nextDay());
        System.out.println(date1.nextDay());
        System.out.println(date1.nextMonth());
        System.out.println(date1.nextYear());
        System.out.println("-----------------------");
        System.out.println(date1.previousMonth());
        System.out.println("-----------------------");
        MyDate date2 = new MyDate(2012,1,2);
        System.out.println(date2);
        System.out.println(date2.previousDay());
        System.out.println(date2.previousDay());
        System.out.println(date2.previousMonth());
        System.out.println(date2.previousYear());

        System.out.println("-----------------------");
        MyDate date3 = new MyDate(2012,2,29);
        System.out.println(date3.previousYear());
        System.out.println("-----------------------");
        MyDate date4 = new MyDate(2099,11,31);
        System.out.println(date4.nextYear());


    }
}
