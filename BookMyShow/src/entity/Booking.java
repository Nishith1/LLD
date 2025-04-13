package entity;

import entity.enums.BookingStatus;

import java.util.List;

public class Booking {
    public int bookingId;
    public Show show;
    public List<Seat> seats;
    public BookingStatus status;
    public Payment payment;
}
