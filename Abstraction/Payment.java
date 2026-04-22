interface Payment {
    void pay(double amt);

    void refund(double amt);
}

abstract class BankAccount {
    String holder;
    double balance;

    BankAccount(String h, double b) {
        holder = h;
        balance = b;

    }

    void deposit(double amt) {
        balance += amt;
    }

    abstract void show();
}

class Bkash extends BankAccount implements Payment {
    Bkash(String h, double b) {
        super(h, b);

    }

    public void pay(double amt) {
        balance -= amt;
    }

    public void refund(double amt) {
        balance += amt;
    }

    void show() {
        IO.println(" Bkash Balance :" + balance);
    }
}
