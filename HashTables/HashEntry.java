package HashTables;

public class HashEntry {
    String key;
    int value;

    // Reference to next entry
    HashEntry next;

    // Constructor
    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
