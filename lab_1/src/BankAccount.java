   // A BankAccount keeps track of a user's money balance and ID,
// and counts how many transactions (deposits/withdrawals) are made.
public class BankAccount {
    private String id;
    private double balance;
    private int transactions;
    private String transactionText;
    
    // Constructs a BankAccount object with the given id, and
    // 0 balance and transactions.
    public BankAccount(String id) {
        this.id = id;
		this.balance = 0;
		this.transactions = 0;
		this.transactionText = "";
     }
    
    // returns the field values
    public double getBalance() { return this.balance; }
    public String getID() { return this.id; }
    public String getTransactions() { String amount = "Amount of transactions: " + this.transactions; return amount; }
    
    // Adds the amount to the balance if it is between 0-500.
    // Also counts as 1 transaction.
    public void deposit(double amount) { 
        this.balance += amount; 
        this.transactions += 1; 
    }
    
    // Subtracts the amount from the balance if the user has enough money.
    // Also counts as 1 transaction.
    public void withdraw(double amount) { this.balance -= amount; this.transactions += 1; }

    public void transactionFee(double fee) {
        int i = 0;
        double increment = fee;
        while (i<this.transactions) {
            i++;
            this.balance -= increment;
            increment += fee;
        }
        if (this.balance <= 0.00) {
            this.balance = 0.00;
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
    
    public String toString() {
        String nameBal = this.id + ", $" + this.balance;
        if (this.balance < 0) {
            double temp = -1 * this.balance;
            nameBal = this.id + ", -$" + temp;
        }
        return nameBal;
    }


    public String transfer(BankAccount obj, double amount) {
        String comment;
        if (amount == 0) {
            // comment = "no effect; zero amount";
            comment = this.id + " $" + this.balance + ", " + obj.id + " $" + obj.balance;
            return comment;
        } else if (amount < 0) {
            // comment = "no effect; negative amount";
            comment = this.id + " $" + this.balance + ", " + obj.id + " $" + obj.balance;
            return comment;
        } else if (this.balance < 5.00) {
            // comment = "no effect; can't afford fee";
            comment = this.id + " $" + this.balance + ", " + obj.id + " $" + obj.balance;
            return comment;
        } else if (this.balance == 5.00) {
            // comment = "no effect; fee would zero out account";
            comment = this.id + " $" + this.balance + ", " + obj.id + " $" + obj.balance;
            return comment;
        } else if (this.balance < amount) {
            this.balance -= 5.00;
            obj.balance += this.balance;
            this.balance -= this.balance;
            this.transactions += 1;
            obj.transactions += 1;
            comment = this.id + " $" + this.balance + ", " + obj.id + " $" + obj.balance;
            return comment;
        } else {
            this.balance -= 5.00;
            obj.balance += amount;
            this.balance -= amount;
            this.transactions += 1;
            obj.transactions += 1;
            comment = this.id + " $" + this.balance + ", " + obj.id + " $" + obj.balance;
            return comment;
        }
    }
} 

