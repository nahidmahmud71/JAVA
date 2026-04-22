interface Notifier {
    void send(String msg);

    void status();
}

class EmailNotifier implements Notifier {
    public void send(String m) {
        IO.println(" Email : " + m);
    }

    public void status() {
        IO.println(" Email server ok.");
    }

}

class SmsNotifier implements Notifier {
    public void send(String m) {
        IO.println(" SMS: " + m);
    }

    public void status() {
        IO.println(" SMS gateway ok.");
    }
}
