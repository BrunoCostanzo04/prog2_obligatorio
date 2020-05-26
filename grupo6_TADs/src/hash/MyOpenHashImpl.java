package hash;

import lista.ListaEnlazada;
import lista.MyIteratorListaEnlazada;
import lista.MyList;
import java.util.Iterator;

public class MyOpenHashImpl<K, V> implements MyHash<K, V> {

    private MyList<HashEntry<K, V>>[] entryArray;
    private int size;

    public MyOpenHashImpl(int size) {
        this.entryArray = new ListaEnlazada[size];
        this.size = 0;
    }

    @Override
    public void put(K k, V v) {

        if (((float) this.size + 1) / ((float) entryArray.length) > 0.75 ){
            this.reHashing();
        }

        int position = k.hashCode() % entryArray.length;
        MyList<HashEntry<K, V>> listForPosition = entryArray[position];

        if (listForPosition == null) {
            listForPosition = new ListaEnlazada<>();
            entryArray[position] = listForPosition;
        }

        // Busco la entrada si existe la actualizo si no creo una nueva
        Iterator<HashEntry<K, V>> iterator = listForPosition.iterator();
        HashEntry<K, V> searchElement = null;

        while (iterator.hasNext() && searchElement == null) {
            HashEntry<K, V> tempValue = iterator.next();
            if (tempValue.getKey().equals(k)) {
                searchElement = tempValue;
            }
        }

        // Si encontre el elemento actualizo la value
        if (searchElement != null) {
            searchElement.setValue(v);
        } else {
            // si no existe lo creo y lo agrego a la lista
            HashEntry<K, V> hashEntry = new HashEntry<>(k, v);
            listForPosition.add(hashEntry);
            size++;
        }
    }

    @Override
    public void remove (K key){

        int position = key.hashCode() % entryArray.length;
        MyList<HashEntry<K,V>> listForPosition = entryArray[position];

        if (listForPosition != null) {
            HashEntry<K,V> temp = new HashEntry<>(key, null);
            listForPosition.removePorValue(temp);
            this.size--;
        }

    }

    @Override
    public V get(K k) {
        int position = k.hashCode() % entryArray.length;
        V valueToReturn = null;

        MyList<HashEntry<K, V>> listForPosition = entryArray[position];

        if (listForPosition != null) {
            // Buscar si existe la entrada con clave k
            for (HashEntry<K, V> tempEntry : listForPosition) {
                if (tempEntry.getKey().equals(k)) {
                    valueToReturn = tempEntry.getValue();
                    break;
                }
            }
        }
        return valueToReturn;
    }

    @Override
    public int size() {
        return this.size;
    }


    private void reHashing(){

        int newLength = getNextPrimeNumber(this.entryArray.length * 2);
        MyList<HashEntry<K,V>>[] oldHash = this.entryArray;
        this.entryArray = new MyList[newLength];
        int updates = 0;
        for(int i = 0; i<oldHash.length;i++){
            if (oldHash[i] != null){
                for(int j = 0; j< oldHash[i].getSize();j++){
                        HashEntry<K,V> valueToRehash = oldHash[i].get(j);
                        this.put(valueToRehash.getKey(), valueToRehash.getValue());
                        updates++;
                }
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
