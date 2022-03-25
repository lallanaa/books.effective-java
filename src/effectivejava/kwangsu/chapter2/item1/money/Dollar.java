package effectivejava.kwangsu.chapter2.item1.money;

public class Dollar implements Money{

    long amount;

    public Dollar(long amount) {
        this.amount = amount;
    }

    @Override
    public long getAmount() {
        return 0;
    }
}
