package lazarski.commands;

import lazarski.filesystem.Context;
import lazarski.filesystem.BaseComponent;

import java.util.List;
import java.util.Set;

public class LS implements Command {

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
        Set<BaseComponent> children = context.getCurrent().getChildren();

        int i=0;
        for (BaseComponent child : children) {
            System.out.printf("%10s",child.getName());
            i++;
            if (i%5 ==0 ){
                System.out.println();
            }
        }
        System.out.println();
    }
}
