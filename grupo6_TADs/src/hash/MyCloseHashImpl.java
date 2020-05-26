package hash;

public class MyCloseHashImpl<K,V> implements MyHash<K,V> {

    private HashEntry<K,V>[] hashArray;
    private int size;
    private boolean linear;

    public MyCloseHashImpl(int size, boolean linear) {
        this.hashArray = (HashEntry<K, V>[]) new HashEntry[getNextPrimeNumber(size - 1)];
        this.linear = linear;
        this.size = 0;
    }

    @Override
    public void put(K k, V v) {

        if (((float) this.size + 1) / ((float) hashArray.length) > 0.5 ){
            this.reHashing();
        }

        int iterations = 0;
        int position = getPosition(k, iterations);

        while (!(hashArray[position] == null || hashArray[position].getKey().equals(k) || iterations  > hashArray.length || hashArray[position].isDeleted() ) ) {
            iterations++;
            position = getPosition(k,iterations);
        }
        if (hashArray[position] == null){
            hashArray[position] = new HashEntry<>(k, v);
            this.size++;
        } else {
            hashArray[position] = new HashEntry<>(k, v);
        }

    }

    private int getPosition(K key, int iterations){
        int position = 0;
        if (linear){
            position = (key.hashCode() % hashArray.length + iterations) % hashArray.length;
        }else{
            position = (key.hashCode() % hashArray.length + (int) Math.pow(iterations,2)) % hashArray.length;
        }
        return position;
    }

    @Override
    public void remove(K key) {

        int iterations = 0;
        int position = getPosition(key, iterations);

        while (!(hashArray[position] == null || hashArray[position].getKey().equals(key) || iterations  > hashArray.length || hashArray[position].isDeleted())) {
            iterations++;
            position = getPosition(key, iterations);
        }

        if (iterations <= hashArray.length && !(hashArray[position] == null) && !(hashArray[position].isDeleted())){
            hashArray[position].setDeleted(true);
            this.size--;
        }

    }

    @Override
    public V get(K k) {

        V valueToReturn = null;
        int iterations = 0;
        int position = getPosition(k, iterations);
        while (!(hashArray[position] == null || hashArray[position].getKey().equals(k) || iterations  > hashArray.length)) {
            iterations++;
            position = getPosition(k, iterations);
        }
        if (iterations <= hashArray.length && !(hashArray[position].isDeleted())){
            valueToReturn = hashArray[position].getValue();
        }
        return valueToReturn;

    }

    @Override
    public int size() {
        return this.size;
    }

    private void reHashing(){

        int newLength = getNextPrimeNumber(this.hashArray.length * 2);

        HashEntry<K,V>[] oldHash = hashArray;
        this.hashArray = (HashEntry<K,V>[]) new HashEntry[newLength];

        int updates = 0;

        for(int i = 0; i<oldHash.length;i++){
            if (oldHash[i] != null && !oldHash[i].isDeleted() ){
                put(oldHash[i].getKey(),oldHash[i].getValue());
                updates++;
            }
            if (updates >= size){
                break;
            }

        }
        this.size = updates;

    }

    private int getNextPrimeNumber(int number){

        int primoARetornar = number + 1;
        while(isNotPrime(primoARetornar)){
            primoARetornar++;
        }
        return primoARetornar;

    }

    private boolean isNotPrime(int number){

        boolean esPrimo = false;
        for (int i=2; i<number-1; i++){
            if (number % i == 0){
                esPrimo = true;
                break;
            }
        }
        return esPrimo;
    }
}
