package entity;

import entity.enums.Price;
import entity.enums.SeatStatus;

import java.util.Date;
import java.util.Map;

public class Show {
    public int showId;
    public Movie movie;
    public Screen screen;
    public Date startTime;
    public Date endTime;
    public Map<Seat, SeatStatus> seatStatusMap;
    public Price price;
}