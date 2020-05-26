package heap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T>  {

    private T[] values;
    private int lastValuePosition;
    private boolean heapMax;
    private boolean heapMin;

    public MyHeapImpl(T[] values, boolean heapMax, boolean heapMin) {
        this.values = values;
        this.lastValuePosition = 0;
        this.heapMax = heapMax;
        this.heapMin = heapMin;
    }

    @Override
    public void insert(T value) {
        this.values[lastValuePosition] = value;
        int valuePosition = lastValuePosition;
        lastValuePosition++;
        if (heapMax==true) { // si heap max == true es un Heap Maximo
            while (valuePosition!=0 && value.compareTo(getFather(valuePosition))>0){  // actualiza mientras el elemento a insertar no este en la raiz o sea mayor que el padre
                T tempValue = getFather(valuePosition);
                this.values[getFatherPosition(valuePosition)]=value;
                this.values[valuePosition]=tempValue;
                valuePosition = getFatherPosition(valuePosition);
            }
        }
        else { // Sino un heap minimo
            while (valuePosition!=0 && value.compareTo(getFather(valuePosition))<0){ // actualiza mientras el elemento a insertar no este en la raiz o sea menor que el padre
                T tempValue = getFather(valuePosition);
                this.values[getFatherPosition(valuePosition)]=value;
                this.values[valuePosition]=tempValue;
                valuePosition = getFatherPosition(valuePosition);
            }
        }
    }

    private T getFather (int childPosition){
        return values[(childPosition-1)/2];
    }

    private int getFatherPosition (int childPosition) {
        return (childPosition-1)/2;
    }

    @Override
    public T deleteAndReturn() {
        T nodoAEliminar = values[0];
        T nodoAPonerComoRaiz = values[lastValuePosition-1];
        values[0]=nodoAPonerComoRaiz;
        int valuePosition = 0;
        lastValuePosition--;
        if(heapMax==true){
            while (getLeftChild(valuePosition)!=null && getRightChild(valuePosition)!=null){
                T leftChild = getLeftChild(valuePosition);
                int leftChildPosition = getLeftChildPosition(valuePosition);
                T rightChild = getRightChild(valuePosition);
                int rightChildPosition = getRightChildPosition(valuePosition);
                if (nodoAPonerComoRaiz.compareTo(leftChild)>0 && nodoAPonerComoRaiz.compareTo(rightChild)>0){
                    break;
                }
                else if (leftChild.compareTo(rightChild)>0) {
                    values[valuePosition]=leftChild;
                    values[leftChildPosition]=nodoAPonerComoRaiz;
                    valuePosition=leftChildPosition;
                }
                else if (leftChild.compareTo(rightChild)<0) {
                    values[valuePosition]=rightChild;
                    values[rightChildPosition]=nodoAPonerComoRaiz;
                    valuePosition=rightChildPosition;
                }
            }
        }
        else {
            while (getLeftChild(valuePosition)!=null && getRightChild(valuePosition)!=null){
                T leftChild = getLeftChild(valuePosition);
                int leftChildPosition = getLeftChildPosition(valuePosition);
                T rightChild = getRightChild(valuePosition);
                int rightChildPosition = getRightChildPosition(valuePosition);
                if (nodoAPonerComoRaiz.compareTo(leftChild)<0 && nodoAPonerComoRaiz.compareTo(rightChild)<0){
                    break;
                }
                else if (leftChild.compareTo(rightChild)<0) {
                    values[valuePosition]=leftChild;
                    values[leftChildPosition]=nodoAPonerComoRaiz;
                    valuePosition=leftChildPosition;
                }
                else if (leftChild.compareTo(rightChild)>0) {
                    values[valuePosition]=rightChild;
                    values[rightChildPosition]=nodoAPonerComoRaiz;
                    valuePosition=rightChildPosition;
                }
            }
        }

        return nodoAEliminar;
    }

    private T getLeftChild (int fatherPosition){
        return values[2*fatherPosition + 1];
    }

    private int getLeftChildPosition (int fatherPosition){
        return 2*fatherPosition + 1;
    }

    private T getRightChild (int fatherPosition){
        return values[2*fatherPosition + 2];
    }

    private int getRightChildPosition (int fatherPosition){
        return 2*fatherPosition + 2;
    }

    @Override
    public int size() {
        return lastValuePosition;   // size es la posicion donde apunta el lastValuPosition
    }

    @Override
    public String toString (){
        String salida = new String();
        for (int i=0; i<lastValuePosition;i++){
            String value = values[i].toString();
            salida = salida.concat(value+" ");
            double potencia = (Math.log10(i+2)/Math.log10(2));
            if (potencia%1==0) {    // Si hay un cambio de nivel agrego al string un cambio de linea
                salida = salida.concat("\n");
            }
        }
        return salida;
    }

}
