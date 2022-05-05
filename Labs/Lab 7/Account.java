public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }
    public double getBalance() {
        return this.balance;
    }
    public void deposit(double valeur){
        this.balance += valeur;
        System.out.println("new balance=" + getBalance() + "$");
    }
    public void withdraw(double valeur) throws NotEnoughMoneyException {
        if (valeur > getBalance()) {
            throw new NotEnoughMoneyException(valeur, getBalance());
        } else{
            this.balance-=valeur;
            System.out.println("new balance="+getBalance()+"$");
        }
    }
}
