import java.util.Scanner;

/**
 * Created by Rachel on 2016. 9. 15..
 */
public class TreeTraversal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nodeNum = Integer.parseInt(scan.nextLine());

        String[] nodeArr = new String[nodeNum * 3];
        int index = 0;

        for(int i=0; i<nodeNum; i++) {
            String nodesStr = scan.nextLine();
            String[] nodesArr = nodesStr.split(" ");
            for(String node: nodesArr) {
                nodeArr[index++] = node;
            }
        }

        preorder(nodeArr, "A");
        System.out.println("");
        inorder(nodeArr, "A");
        System.out.println("");
        postorder(nodeArr, "A");
    }

    public static void preorder(String[] nodeArr, String root) {

        int index = 0;
        for(int i=0; i<nodeArr.length; i+=3) {
            if(nodeArr[i].equals(root)) {
                index = i;
                break;
            }
        }

        System.out.print("" + root);
        if(!nodeArr[index+1].equals("."))
            preorder(nodeArr, nodeArr[index+1]);
        if(!nodeArr[index+2].equals("."))
            preorder(nodeArr, nodeArr[index+2]);

    }

    public static void inorder(String[] nodeArr, String root) {

        int index = 0;
        for(int i=0; i<nodeArr.length; i+=3) {
            if(nodeArr[i].equals(root)) {
                index = i;
                break;
            }
        }

        if(!nodeArr[index+1].equals("."))
            inorder(nodeArr, nodeArr[index+1]);
        System.out.print("" + root);
        if(!nodeArr[index+2].equals("."))
            inorder(nodeArr, nodeArr[index+2]);

    }

    public static void postorder(String[] nodeArr, String root) {

        int index = 0;
        for(int i=0; i<nodeArr.length; i+=3) {
            if(nodeArr[i].equals(root)) {
                index = i;
                break;
            }
        }

        if(!nodeArr[index+1].equals("."))
            postorder(nodeArr, nodeArr[index+1]);
        if(!nodeArr[index+2].equals("."))
            postorder(nodeArr, nodeArr[index+2]);
        System.out.print("" + root);

    }

}
