package manager;

import entities.Expense;
import entities.Split;
import entities.User;

import java.util.HashMap;
import java.util.Map;

class ExpenseManager {
    Map<String, User> users = new HashMap<>();
    Map<String, Map<String, Double>> balanceSheet = new HashMap<>();

    public void addUser(User user) {
        users.put(user.id, user);
        balanceSheet.put(user.id, new HashMap<>());
    }

    public void addExpense(Expense expense) {
        for (Split split : expense.splits) {
            String paidBy = expense.paidBy.id;
            String owedBy = split.user.id;
            double amount = split.amount;

            balanceSheet.get(owedBy).put(paidBy, balanceSheet.get(owedBy).getOrDefault(paidBy, 0.0) + amount);
            balanceSheet.get(paidBy).put(owedBy, balanceSheet.get(paidBy).getOrDefault(owedBy, 0.0) - amount);
        }
    }

    public void showBalances() {
        for (String u1 : balanceSheet.keySet()) {
            for (String u2 : balanceSheet.get(u1).keySet()) {
                double amount = balanceSheet.get(u1).get(u2);
                if (amount > 0) {
                    System.out.println(u1 + " owes " + u2 + ": " + amount);
                }
            }
        }
    }
}
