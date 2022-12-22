package exercise1_2;

public class TestMyTime {
    public static void main(String[] args) {
        MyTime time1 = new MyTime(9, 27, 5);
        System.out.println(time1);
        time1.setTime(24, -10, -5);

        MyTime time2 = new MyTime(19,59,59);
        System.out.println(time2);
        time2.nextSecond();
        System.out.println(time2);
        time2.nextMinute();
        System.out.println(time2);
        time2.nextHour();
        System.out.println(time2);

        MyTime time3 = new MyTime(15,0,0);
        System.out.println(time3);
        time3.previousSecond();
        System.out.println(time3);
        time3.previousMinute();
        System.out.println(time3);
        time3.previousHour();
        System.out.println(time3);
    }

}
