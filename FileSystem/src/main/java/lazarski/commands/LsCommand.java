package lazarski.commands;

import lazarski.filesystem.Context;
import lazarski.filesystem.BaseNode;

import java.util.List;
import java.util.Set;

public class LsCommand implements Command {

    private List<String> parameters;
    @Override
    public String getName() {
        return "ls";
    }

    @Override
    public void setParameters(List<String> list) {
        this.parameters = list;
    }

    @Override
    public void execute(Context context) {
        Set<BaseNode> children = context.getCurrent().getChildren();

        int i=0;
        for (BaseNode child : children) {
            System.out.printf("%10s",child.getName());
            i++;
            if (i%5 ==0 ){
                System.out.println();
            }
        }
        System.out.println();
    }
}
