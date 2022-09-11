package TreeOfSpaceThreadSafe;

public enum TreeState {
    Idle,
    Locking,
    Unlocking,
    Upgrading
}
