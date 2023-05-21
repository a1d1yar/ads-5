public class Main {
    public static void main(String[] args) {

        BST<Integer, String> bst = new BST<>();

        bst.put(5, "Kazy");
        bst.put(2, "Besh");
        bst.put(7, "Shyzhyk");
        bst.put(1, "baursak");
        bst.put(3, "Kozhe");
        bst.put(6, "Kokshetau");


        System.out.println("val of  key is " + bst.get(3));


        //bst.delete(2);


        System.out.println("Keys in ascending order:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }



        System.out.println("Keys and their values in ascending order:");
        for (BST.Node node : bst.entries()) {
            System.out.println("Key is " + node.key + ", Value is  " + node.val);
        }

        System.out.println("Size of tree: " + bst.size());
    }
}
