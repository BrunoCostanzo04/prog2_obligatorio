package normalTree;

import java.util.*;

public class MyTreeImpl<K extends Comparable<K>,T> implements MyTree<K, T> {

    private Node<K,T> root;
    private int cantidad;
    private int nodosHoja;
    private int nodosCompletos;

    public MyTreeImpl() {
        this.root=null;
    }

    @Override
    public T find (K key) {
        return find(key,root);
    }

    private T find (K key, Node<K,T> oRoot){
        K oKey = null;
        T oValue=null;
        if (oRoot != null){
            int nValue = key.compareTo(oRoot.getKey());
            if (nValue==0){
                oKey=oRoot.getKey();
                oValue=oRoot.getValue();
            }
            else {
                oValue = find(key, oRoot.getRightChild());
                if (oValue!=null) {
                    return oValue;
                }
                oValue = find(key, oRoot.getLeftChild());
                if (oValue!=null) {
                    return oValue;
                }

            }
        }
        return oValue;
    }

    private Node<K,T> retornarNodo (K key) {
        return retornarNodo(key,root);
    }

    private Node<K,T> retornarNodo (K key, Node<K,T> oRoot) {
        Node<K,T> parentNode = null;
        if (oRoot !=null){
            int nValue = key.compareTo(oRoot.getKey());
            if (nValue==0){
                parentNode=oRoot;
            }
            else {
                parentNode = retornarNodo(key, oRoot.getLeftChild());
                if (parentNode == null) {
                    parentNode = retornarNodo(key, oRoot.getRightChild());
                }
            }
        }
        return parentNode;
    }

    @Override
    public void insert (K key, T data, K parentKey) {
        Node<K,T> nuevoNodo = new Node<K,T>(key,data);
        if (root==null){
            root=nuevoNodo;
            return;
        }
        Node<K,T> nodoPadre = retornarNodo(parentKey);
        if (nodoPadre==null){
            System.out.println("No existe el nodo");
        }
        else if (nodoPadre.getRightChild()==null) {
            nodoPadre.setRightChild(nuevoNodo);
        }
        else if (nodoPadre.getLeftChild()==null) {
            nodoPadre.setLeftChild(nuevoNodo);
        }
        else {
            System.out.println("Nodo lleno");
        }
    }

    @Override
    public void delete(K key) {
        if (root != null) {
            root = root.delete(key);
        }
    }

    @Override
    public int size() {
        size(root);
        return cantidad;
    }

    public void size (Node o){
        if (o!=null){
            cantidad++;
            size(o.getLeftChild());
            size(o.getRightChild());
        }
    }

    @Override
    public int countLeaf() {
        countLeaf(root);
        return nodosHoja;
    }

    public void countLeaf (Node o) {
        if (o != null) {
            if (o.getLeftChild() == null && o.getRightChild() == null) {
                nodosHoja++;
            }
            countLeaf(o.getLeftChild());
            countLeaf(o.getRightChild());
        }
    }

    @Override
    public int countCompleteElements() {
        countCompleteElements(root);
        return nodosCompletos;
    }

    public void countCompleteElements (Node o) {
        if (o != null) {
            if (o.getLeftChild() != null && o.getRightChild() != null) {
                nodosCompletos++;
            }
            countCompleteElements(o.getLeftChild());
            countCompleteElements(o.getRightChild());
        }
    }

    @Override
    public List<K> preOrder() {
        if (root != null) {
            return root.preOrderTraverse();
        }
        return new ArrayList<K>();
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

    @Override
    public List<K> porNivel() {
        if (root==null){
            return new ArrayList<K>();
        }
        Queue<Node<K,T>> elementos = new ArrayDeque<>();
        List<K> listaADevolver = new ArrayList<>();
        elementos.add(root);
        while (!elementos.isEmpty()){
            Node<K,T> removido = elementos.remove();
            listaADevolver.add(removido.getKey());
            if (removido.getLeftChild() != null){
                elementos.add(removido.getLeftChild());
            }
            if (removido.getRightChild() != null){
                elementos.add(removido.getRightChild());
            }
        }
        return listaADevolver;
    }

    @Override
    public Node<String,T> loadPostFijaExpression(String sPostFija) {
        Stack<Node<String,T>> pilaDeOperaciones = new Stack<>();
        Node<String,T> t,t1,t2;
        String limitador = "[ ]";
        String[] valor = sPostFija.split(limitador);
        for (int i=0; i<valor.length; i++) {
            if (!valor[i].equals("+") && !valor[i].equals("*") && !valor[i].equals("/") && !valor[i].equals("-")){
                Node<String,T> nuevoNodo = new Node(valor[i]);
                pilaDeOperaciones.push(nuevoNodo);
            }
            if (valor[i].equals("+") || valor[i].equals("*") || valor[i].equals("/") || valor[i].equals("-")){
                t = new Node(valor[i]);
                t1 = pilaDeOperaciones.pop();
                t2 = pilaDeOperaciones.pop();
                t.setLeftChild(t1);
                t.setRightChild(t2);
                pilaDeOperaciones.push(t);
            }
        }
        t = pilaDeOperaciones.peek();
        pilaDeOperaciones.pop();
        return t;
    }
}
