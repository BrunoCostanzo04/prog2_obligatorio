package searchBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class NodeSBT<K extends Comparable<K>,T> {

    private K key;
    private T value;
    private NodeSBT<K, T> leftChild;
    private NodeSBT<K, T> rightChild;

    public NodeSBT (K key, T value) {
        this.key=key;
        this.value=value;
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

    public NodeSBT<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeSBT<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeSBT<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeSBT<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public void add(K oKey, T oValue) {
        NodeSBT<K, T> oElementToAdd = new NodeSBT<>(oKey, oValue);
        if (oKey.compareTo(this.key) > 0) {
            if (rightChild == null) {
                rightChild = oElementToAdd;
            } else {
                rightChild.add(oKey, oValue);
            }
        } else {
            if (leftChild == null) {
                leftChild = oElementToAdd;
            } else {
                leftChild.add(oKey, oValue);
            }
        }
    }

    public NodeSBT<K, T> remove(K oKey) {

        int nValue = ((Comparable<K>) oKey).compareTo(key);
        if (nValue > 0) {
            if (rightChild != null) {
                rightChild = rightChild.remove(oKey);
            }
        } else if (nValue < 0) {
            if (leftChild != null) {
                leftChild = leftChild.remove(oKey);
            }
        } else if (leftChild != null && rightChild != null) {
            // Encontre el elemento a eliminar
            NodeSBT<K, T> oTemp = rightChild.findMin();
            this.key = oTemp.getKey();
            this.value = oTemp.getValue();
            rightChild = rightChild.remove(oTemp.getKey());
        } else {
            if (leftChild != null) {
                return leftChild;
            } else {
                return rightChild;
            }
        }
        return this;
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

    public NodeSBT<K, T> findMin() {
        NodeSBT<K, T> oReturn = this;
        if (leftChild != null) {
            oReturn = leftChild.findMin();
        }
        return oReturn;
    }
}
