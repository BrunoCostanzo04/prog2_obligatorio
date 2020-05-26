package searchBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTreeImpl<K extends Comparable<K>, T> implements MyBinarySearchTree<K,T> {

    private NodeSBT<K, T> root;

    public MyBinarySearchTreeImpl () {
        this.root=null;
    }


    @Override
    public T find(K oKey) {
        return find(oKey, root);
    }

    private T find(K oKeyToSearch, NodeSBT<K, T> oRoot) {
        T oValue = null;
        if (oRoot != null) {
            int nValue = oKeyToSearch.compareTo(oRoot.getKey());
            if (nValue == 0) {
                oValue = oRoot.getValue();
            } else if (nValue > 0) {
                oValue = find(oKeyToSearch, oRoot.getRightChild());
            } else {
                oValue = find(oKeyToSearch, oRoot.getLeftChild());
            }
        }
        return oValue;
    }

    @Override
    public void insert(K oKey, T oValue) {
        NodeSBT<K, T> oElementToAdd = new NodeSBT<K, T>(oKey, oValue);
        if (root == null) {
            root = oElementToAdd;
        } else {
            root.add(oKey, oValue);
        }
    }

    @Override
    public void delete (K oKey) {
        if (root != null) {
            root = root.remove(oKey);
        }
    }

    @Override
    public List<K> preOrder() {
        List<K> colValues = new ArrayList<K>();
        if (root != null) {
            colValues.addAll(root.preOrderTraverse());
        }
        return colValues;
    }

    @Override
    public List<K> posOrder() {
        List<K> colValues = new ArrayList<K>();
        if (root != null) {
            colValues.addAll(root.postOrderTraverse());
        }
        return colValues;
    }

    @Override
    public List<K> inOrder() {
        List<K> colValues = new ArrayList<K>();
        if (root != null) {
            colValues.addAll(root.inOrderTraverse());
        }
        return colValues;
    }
}
