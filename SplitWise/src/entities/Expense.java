package entities;

import java.util.List;

public abstract class Expense {
    public double amount;
    public User paidBy;
    public List<Split> splits;
    public ExpenseType type;

    public Expense(double amount, User paidBy, List<Split> splits, ExpenseType type) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.type = type;
    }

    abstract boolean validate();
}
