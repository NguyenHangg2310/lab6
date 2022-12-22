package exercise1_2;

public class TestTryCatch {
    public static void main(String[] args) {
        try {
            int data = 5 / 0;
        } catch (ArithmeticException e) {
            //In ra màn hình tên ngoại lệ
            System.out.println("invalid");
        }
        System.out.println("Phép chia cho 0");
    }
}
