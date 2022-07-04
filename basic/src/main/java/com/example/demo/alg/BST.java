package com.example.demo.alg;

/**
 * @author chenlingl
 * @version 1.0
 * @description
 * @date 7/4/2022 9:50 PM
 */
public class BST {
    private Node root;

    class Node {
        private String key;
        private String val;
        private Node left,right;
        private int size;
        public Node(String key,String value,int size) {
            this.key = key;
            this.val = value;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }
    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }


    public String getVal(String key) {
        return getVal(root,key);
    }
    public String getVal(Node node,String key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return getVal(node.left,key);
        } else if (cmp > 0) {
            return getVal(node.right,key);
        } else {
            return node.val;
        }
    }

    public void put(String key,String val) {
        put(root,key,val);
    }

    public Node put(Node node,String key,String val) {
        if (node == null) {
            return new Node(key,val,1);
        }
        int cmp = key.compareTo(key);
        if (cmp < 0) {
            put(node.left,key,val);
        } else if (cmp > 0) {
            put(node.right,key,val);
        } else {
            node.val = val;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMin() {

    }
    public Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
         }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(String key) {
    }

    public Node delete(Node node,String key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left,key);
        } else if (cmp > 0) {
            node.right = delete(node.right,key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            Node tmp = node;
            node = min(tmp.right);
            node.right = deleteMin(node.right);
            node.left = tmp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public String min() {
        return min(root).key;
    }
    public Node min(Node node) {
        //最小值一定在左子树上，因此判断最终左子树是否为null
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public String max() {
        return max(root).key;
    }

    public Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public String floor(String key) {
        Node index = floor(root,key);
        if (index  == null) {
            return null;
        }
        return index.key;
    }

    public Node floor(Node node,String key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left,key);
        }
        Node tmp = floor(node.right,key);
        if (tmp != null) {
            return tmp;
        } else {
            return node;
        }
    }
}
