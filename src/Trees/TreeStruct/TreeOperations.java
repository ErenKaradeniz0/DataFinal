package Trees.TreeStruct;

public class TreeOperations {
    TreeNode root;

    public TreeOperations() {
        root = null;
    }

    public void listAll(TreeNode eleman, int depth) {

        for (int i = 0; i < depth; i++) System.out.print("\t");

        System.out.println(eleman.directory_name);
        if (eleman.firstChild != null) {
            eleman = eleman.firstChild;
            while (eleman != null) {
                listAll(eleman, depth + 1);
                eleman = eleman.nextSibling;
            }
        }
    }

    int total_size = 0;

    public int listAllSizes(TreeNode eleman) {
        int size = eleman.directory_size;
        total_size = total_size + size;
        System.out.println(eleman.directory_name + ":" + size);
        if (eleman.firstChild != null) {
            TreeNode temp = eleman.firstChild;

            while (temp != null) {
                listAllSizes(temp);
                temp = temp.nextSibling;
            }
        }
        return total_size;
    }

}
