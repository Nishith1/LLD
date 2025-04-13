package manager;

import entity.Seat;
import entity.Show;
import entity.User;


// 🔐 Seat Locking
//To prevent race conditions (two users booking the same seat):

public interface SeatLockManager {
    boolean lockSeat(Show show, Seat seat, User user);
    void unlockSeat(Show show, Seat seat, User user);
    boolean validateLock(Show show, Seat seat, User user);
}

//Use a distributed lock manager (like Redis) or in-memory lock (for simplicity in interviews).
