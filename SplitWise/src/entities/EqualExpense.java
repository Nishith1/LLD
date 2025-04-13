package entities;

import java.util.List;

class EqualExpense extends Expense {
    public EqualExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits, ExpenseType.EQUAL);
    }

    public boolean validate() {
        double expected = amount / splits.size();
        for (Split s : splits) {
            if (s.amount != expected) return false;
        }
        return true;
    }
}
