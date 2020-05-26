package compleateBinaryTree;

public class MyCompleateBinaryTreeImpl<T> implements MyCompleateBinaryTree<T> {

    private T[] values;
    private int lastValuePosition;

    public MyCompleateBinaryTreeImpl(T[] values) {
        this.values = values;
        this.lastValuePosition = -1;
    }

    @Override
    public void insert(T value) {
        this.values[lastValuePosition+1]=value;
        lastValuePosition++;
    }

    @Override
    public void delete(T value) {
        int positionToDelete = this.find(value);
        if (positionToDelete==-1){
            return;
        }
        else {
            T lastValue = values[lastValuePosition];
            lastValuePosition--;
            values[positionToDelete]=lastValue;
        }
    }

    private int find (T value) {
        int position = -1;
        for (int i=0; i<values.length; i++){
            if (value==values[i]){
                position = i;
                break;
            }
        }
        return position;
    }

    @Override
    public String toString (){
        String salida = new String();
        for (int i=0; i<=lastValuePosition;i++){
            String value = values[i].toString();
            salida = salida.concat(value+" ");
            double potencia = (Math.log10(i+2)/Math.log10(2));
            if (potencia%1==0) {
                salida = salida.concat("\n");
            }
        }
        return salida;
    }

}
