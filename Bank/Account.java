public class Account {
    private double balance;
    private double deposit;
    private double withdraw;

    public Account(double balance){
        this.balance = balance;
        this.deposit = 0;
        this.withdraw = 0;
    }
    public double getBalance(){
        return balance;
    }
    public boolean deposit(double amount){
        if (amount>0){
            balance= balance + amount;
            deposit = deposit + amount;
            return true; 
        }else
            return false;
    }
    public boolean withdraw(double amount){
        if (balance>=amount){
            balance= balance - amount;
            withdraw = withdraw + amount;
            return true; 
        }else
            return false;
    }
    public double getDeposit() {
        return deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

}
