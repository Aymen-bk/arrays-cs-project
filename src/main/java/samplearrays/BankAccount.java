public class BankAccount {

    double currentBalance;
    double[] transactions = new double[1000];
    int transactionCount = 0;

    public BankAccount(String name, int startingBalance){
        this.currentBalance = startingBalance;
        if (transactionCount < transactions.length) {transactions[transactionCount++] = startingBalance;}
    }

    public void deposit(double amount){
        if (amount > 0) {
            currentBalance += amount;
            if (transactionCount < transactions.length) {transactions[transactionCount++] = amount;}
            System.out.println("Deposited: " + amount);
        }
        else {System.out.println("invalid deposit amount: " + amount);}
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= currentBalance)
        {
            currentBalance -= amount;
            if (transactionCount < transactions.length) {transactions[transactionCount++] = -amount;} //negative value

            System.out.println("Withdrawn: " + amount);
        }

        else if (amount <= 0) {System.out.println("invalid withdrawal amount: " + amount);}

        else {System.out.println("insufficient funds for withdrawal: " + amount);}
    }

    public void displayTransactions(){
        System.out.println("Transactions:");
        for (int i = 0; i < transactionCount; i++)

        {
            if (i == 0) { System.out.println("Initial Balance: " + transactions[i]);}
            else if (transactions[i] > 0) {System.out.println("Deposit: " + transactions[i]);}
            else {System.out.println("Withdrawal: " + Math.abs(transactions[i]));}
        }
    }

    public void displayBalance(){
        System.out.println("Current Balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }
}
