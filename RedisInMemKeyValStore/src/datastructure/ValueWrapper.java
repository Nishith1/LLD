package datastructure;

public class ValueWrapper {
    public String value;
    public long expiryTime; // in millis; -1 if no expiry

    public ValueWrapper(String value, long ttlInMillis) {
        this.value = value;
        this.expiryTime = ttlInMillis > 0 ? System.currentTimeMillis() + ttlInMillis : -1;
    }

    public boolean isExpired() {
        return expiryTime != -1 && System.currentTimeMillis() > expiryTime;
    }
}
