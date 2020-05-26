package normalTree;

import java.util.ArrayList;
import java.util.List;

public class Node <K extends Comparable<K>,T> {

    private K key;
    private T value;
    private Node<K, T> leftChild;
    private Node<K, T> rightChild;

    public Node (K key, T value) {
        this.key=key;
        this.value=value;
        this.leftChild=null;
        this.rightChild=null;
    }
    public Node (K key) {
        this.key=key;
        this.leftChild=null;
        this.rightChild=null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<K,T> delete(K key) {
        if (key.compareTo(this.getKey())==0){
            //Borro el nodo
            if (this.getRightChild()==null && this.getLeftChild()==null){
                return null;
            }
            else if (this.getRightChild()!=null && this.getLeftChild()==null){
                return rightChild;
            }
            else if (this.getRightChild()==null && this.getLeftChild()!=null){
                return leftChild;
            }
            else if (this.getRightChild()!=null && this.getLeftChild()!=null) {
                Node<K,T> oTemp = leftChild.findHoja();
                this.key=oTemp.getKey();
                this.value=oTemp.getValue();
                leftChild = leftChild.delete(oTemp.getKey());
            }
        }
        else {
            if (leftChild != null) {
                leftChild=leftChild.delete(key);
            }
            if (rightChild!=null) {
                rightChild=rightChild.delete(key);
            }
        }
        return this;
    }

    public Node<K, T> findHoja() {
        Node<K, T> oReturn = this;
        if (leftChild != null) {
            oReturn = leftChild.findHoja();
        }
        return oReturn;
    }

    public List<K> preOrderTraverse() {
        List<K> colList = new ArrayList<K>();
        colList.add(getKey());
        if (leftChild != null) {
            colList.addAll(leftChild.preOrderTraverse());
        }
        if (rightChild != null) {
            colList.addAll(rightChild.preOrderTraverse());
        }
        return colList;
    }

    public List<K> postOrderTraverse() {
        List<K> colList = new ArrayList<K>();
        if (leftChild != null) {
            colList.addAll(leftChild.postOrderTraverse());
        }
        if (rightChild != null) {
            colList.addAll(rightChild.postOrderTraverse());
        }
        colList.add(getKey());
        return colList;
    }

    public List<K> inOrderTraverse() {
        List<K> colList = new ArrayList<K>();
        if (leftChild != null) {
            colList.addAll(leftChild.inOrderTraverse());
        }
        colList.add(this.getKey());
        if (rightChild != null) {
            colList.addAll(rightChild.inOrderTraverse());
        }
        return colList;
    }
}
