package lazarski.commands;

import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;

import java.util.List;

public class TREE implements Command {

    private List<String> parameters;
    @Override
    public String getName() {
        return "tree";
    }

    @Override
    public void setParameters(List<String> list) {
        this.parameters = list;
    }

    @Override
    public void execute(Context context) {
        Directory current = context.getCurrent();
        current.print(1);
    }
}
