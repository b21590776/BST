import java.io.IOException;
import java.util.ArrayList;

public class Selecter {

    Tree tre = new Tree();
    public void operation(ArrayList<String> commands) throws IOException {
        for (int i = 0; i < commands.size(); i++) {
            if(commands.get(i).split(" ")[0].equals("CreateBST"))
                tre.CreateBST(commands.get(i).split(" ")[1]);
            else if(commands.get(i).split(" ")[0].equals("CreateBSTH"))
                tre.CreateBSTH(Integer.parseInt(commands.get(i).split(" ")[1]));
            else if(commands.get(i).split(" ")[0].equals("FindHeight"))
                tre.FindHeight();
            else if(commands.get(i).split(" ")[0].equals("FindWidth"))
                tre.FindWidth();
            else if(commands.get(i).split(" ")[0].equals("Preorder"))
                tre.Preorder();
            else if(commands.get(i).split(" ")[0].equals("LeavesAsc"))
                tre.LeavesAsc();
            else if(commands.get(i).split(" ")[0].equals("DelRoot"))
                tre.DelRoot();
            else if(commands.get(i).split(" ")[0].equals("DelRootRc"))
                tre.DelRootRc();
            else if(commands.get(i).split(" ")[0].equals("DelRootLc"))
                tre.DelRootLc();
        }
    }
}
