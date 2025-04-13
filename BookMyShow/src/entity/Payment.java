package entity;

import entity.enums.PaymentMode;
import entity.enums.PaymentStatus;

public class Payment {
    public int paymentId;
    public double amount;
    public PaymentStatus status;
    public PaymentMode mode;
}