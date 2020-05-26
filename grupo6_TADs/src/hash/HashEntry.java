package hash;

public class HashEntry<K, V> {

    private K key;
    private V value;
    private boolean deleted;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof HashEntry) {
            isEqual = this.key.equals(((HashEntry) obj).getKey());
        }
        return isEqual;
    }

}
