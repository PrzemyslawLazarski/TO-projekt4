package lazarski.commands;

import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;
import lazarski.filesystem.BaseNode;

import java.util.List;
import java.util.Set;

public class MkdirCommand implements Command {

    private List<String> parameters;

    @Override
    public String getName() {
        return "mkdir";
    }

    @Override
    public void setParameters(List<String> list) {
        this.parameters = list;
    }

    @Override
    public void execute(Context context) {

        String name = this.parameters.get(0);

        Set<BaseNode> children = context.getCurrent().getChildren();

        Directory directory = new Directory();
        directory.setParent(context.getCurrent());
        directory.setName(name);
        children.add(directory);
    }
}
