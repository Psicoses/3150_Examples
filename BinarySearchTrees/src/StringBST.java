import org.w3c.dom.Node;

public class StringBST {
    StringBST tree;

    private static boolean rContains(Node n, String s){
        if(n == null){
            return false;
        }
        int comp = s.compareTo(n.value);
        if(comp > 0) {return rContains(n.right, s);}
        else if(comp < 0) {return rContains(n.left, s);}
        else {return true;}

    }


    public boolean insert(String s) {return false;}

    private static String rToString(Node n, StringBuilder sb){
        if(n == null){
            return;
        }

        rToString(n.left, sb);
        sb.append(n.value + ", ");
        rToString(n.right, sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
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

    }

}
