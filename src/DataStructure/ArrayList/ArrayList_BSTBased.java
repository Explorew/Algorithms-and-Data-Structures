package DataStructure.ArrayList;

public class ArrayList_BSTBased<E> {
    private Node root;

    public E get(int index){
        if(root == null || index > root.size-1 || index < 0)
            throw new IllegalArgumentException("index is out of boundary");
        return (E)root.get(index);
    }

    public void add(int index, E value){
        if(index > root.size-1 || index < 0)
            throw new IllegalArgumentException("index is out of boundary");
        if(root == null)
            root = new Node(value);
        else
            root.add(index, value);
    }

    public void add(E value){
        if(root == null)
            root = new Node(value);
        else
            root.add(root.size, value);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        traverse(root, str);
        str.append("]");

        return str.toString();
    }

    private void traverse(Node node, StringBuilder str){
        if (node == null){
            return;
        }

        if (node.left != null) {
            traverse(node.left, str);
            str.append(", ");
        }

        str.append(node.value);

        if (node.right != null) {
            str.append(", ");
            traverse(node.right, str);
        }
    }



    public class Node<E>{
        private Node left;
        private Node right;
        private int size;
        private int height;
        private E value;

        public Node(Node left, Node right, int size, int height, E value) {
            this.left = left;
            this.right = right;
            this.size = size;
            this.height = height;
            this.value = value;
        }

        public Node(E value){
            this.size = 1;
            this.height = 0;
            this.value = value;
        }

        public void add(int index, E value){
            if(index > size+1 || index < 0){
                throw new IllegalArgumentException("index is out of boundary");
            }
            root = add(index, value, root);
        }

        public Node add(int index, E value, Node node){
            //System.out.println(index);
            if(node == null){
                return new Node(null,null,1, 0, value);
            }
            if (node.left == null && node.right == null) {
                if(index < 1) node.left = new Node(null,null,1, 0, value);
                else node.right = new Node(null,null,1, 0, value);
                update(node);
                return balance(node);
            }
            if(node.left == null && node.right != null){
                node.right = add(index-1, value, node.right);
                update(node);
                return balance(node);
            }
            if(node.left != null){
                int cmp = index>node.left.size? +1 : index<node.left.size?-1 : 0;
                if(cmp <= 0) {
                    node.left = add(index, value, node.left);
                }
                if(cmp > 0) {
                    node.right = add(index-node.left.size, value, node.right);
                }
                update(node);
                return balance(node);
            }
             return null;
        }

        private void update(Node node) {
            node.size = 1 + size(node.left) + size(node.right);
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }

        public E get(int index){
            if(index > this.size || index < 0){
                return null;
            }
            return ((E) get(root, index).value);
        }

        public Node get(Node node, int index){
            if(node.left == null && index==0)
                return node;
            if(node.left == null && index!=0)
                return node.right;

            int cmp = index>node.left.size? +1 : index<node.left.size?-1 : 0;
            //when the asked node is this node
            if(cmp == 0)
                return node;
            //when the asked node is in the left subtree
            else if(cmp == -1){
                return get(node.left, index);
            }
            //when the asked node is in the right subtree
            else if(cmp == 1){
                //the new index in right subtree
                int newIndex = index - node.left.size -1;
                return get(node.right, newIndex);
            }
            //otherwise
            return null;
        }

        public Node balance(Node node){
            if(balanceFactor(node) > 1) {
                //LR inbalance
                if (balanceFactor(node.left) < 0)
                    node.left = rightRotate(node.left);
                //LL inbalance
                node = leftRotate(node);
            }
            else if(balanceFactor(node) < -1){
                //RL inbalance
                if(balanceFactor(node.right) > 0)
                    node.left = leftRotate(node.right);
                //RR inbalance
                node = rightRotate(node);
            }
            //update balance factor and size
            return node;
        }

        private Node leftRotate(Node node) {
            Node topNode = node;
            Node bottomNode = topNode.left;
            topNode.left = bottomNode.right;
            bottomNode.right = topNode;
            bottomNode.size = topNode.size;
            topNode.size = 1 + size(topNode.left) + size(topNode.right);
            bottomNode.height = 1+ Math.max(height(bottomNode.left), height(bottomNode.right));
            topNode.height = 1+ Math.max(height(topNode.left),height(topNode.right));
            //after rotation bottomNode is on the top
            return bottomNode;

        }

        private Node rightRotate(Node node) {
            Node topNode = node;
            Node bottomNode = node.right;
            topNode.right = bottomNode.left;
            bottomNode.left = topNode;
            bottomNode.size = topNode.size;
            topNode.size = 1 + size(topNode.left) + size(topNode.right);
            bottomNode.height = 1 + height(bottomNode.left) + height(bottomNode.right);
            topNode.height = 1 + height(topNode.left) + height(topNode.right);
            return bottomNode;
        }

        private int height(Node node) {
            if(node == null)
                return -1;
            return node.height;
        }

        private int size(Node node) {
            if(node == null)
                return 0;
            return node.size;
        }

        private int balanceFactor(Node node) {
            return height(node.left) - height(node.right);
        }
    }
}
