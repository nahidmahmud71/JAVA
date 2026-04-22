public class Main {
    public static void main(String[] args) {
        Car c = new Car(" Toyota", 2026);
        c.display();
        c.start();

        Square s = new Square(5);
        IO.println("Area :" + s.area());

        Bkash b = new Bkash(" Nahid Mahmud", 5000);
        b.deposit(1000);
        b.pay(500);
        b.refund(200);
        b.show();

        SmsNotifier sms = new SmsNotifier();
        sms.send(" Done!");
        sms.status();
    }
}