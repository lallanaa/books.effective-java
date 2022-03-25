package effectivejava.kwangsu.chapter2.item1.money;

public interface Money {
    long getAmount();

    public static Money of(MoneyType type, long amount) {
        if(MoneyType.DOLLAR == type){
            return new Dollar(amount);
        }
        if(MoneyType.WON == type){
            return new Won(amount);
        }
        throw new IllegalArgumentException();
    }
}
