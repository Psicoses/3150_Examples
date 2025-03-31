
public class StringBST implements StringTree{
    private Node root;
    private int size;

    public StringBST() {
        this.root = null;
        this.size = 0;
    }

    private static boolean rContains(Node n, String s){
        if(n == null){
            return false;
        }
        int comp = s.compareTo(n.value);
        if(comp > 0) {return rContains(n.right, s);}
        else if(comp < 0) {return rContains(n.left, s);}
        else {return true;}

    }

    public boolean contains(String s) {
        return rContains(this.root, s);
    }

    // never pass a null node to rinsert
    private static boolean rInsert(Node n, String s){
        int comp = s.compareTo(n.value);

        if(comp < 0){ // left
            if(n.left == null) {
                n.left = new Node(s);
                return true;
            }else{
                return rInsert(n.left, s);
            }
        } else if (comp > 0){ // right
             if(n.right == null){
                 n.right = new Node(s);
                 return true;
             }else{
                 return rInsert(n.right, s);
             }

        } else{ // contains already
            return false;
        }

    }

    // add the string (if not already there)
    // return true if added
    public boolean insert(String s) {
        if(this.root == null){
            this.root = new Node(s);
            this.size++;
            return true;
        }
    else {
        boolean b = rInsert(this.root, s);
        if(b) this.size++;
        return b;
    }}

    @Override
    public int size() {
        return size;
    }

    private static void rToString(Node n, StringBuffer sb) {
        if(n == null) {
            return;
        }
        rToString(n.left, sb);
        sb.append(n.value + ", ");
        rToString(n.right, sb);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        rToString(this.root, sb);
        String s = sb.toString();
        return "Tree(size=" + this.size + "){" + s.substring(0, s.length()-2) + "}";
    }

    public static void main(String[] args){
        StringBST tree = new StringBST();

        tree.root = new Node("D");
        tree.root.left = new Node("B");
        tree.root.right = new Node("F");
        tree.root.left.left = new Node("A");
        tree.root.left.right = new Node("C");
        tree.root.right.right = new Node("E");
        tree.root.right.left = new Node("G");

        System.out.println(tree);
    }

}
