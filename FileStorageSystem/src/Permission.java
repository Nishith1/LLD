public enum Permission {
    READ, WRITE, READ_WRITE, NONE;

    public boolean canRead() {
        return this == READ || this == READ_WRITE;
    }

    public boolean canWrite() {
        return this == WRITE || this == READ_WRITE;
    }
}
