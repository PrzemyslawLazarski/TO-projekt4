package lazarski.commands;

import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;
import lazarski.filesystem.BaseComponent;

import java.util.List;
import java.util.Set;

public class MKDIR implements Command {

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

        Set<BaseComponent> children = context.getCurrent().getChildren();

        Directory directory = new Directory();
        directory.setParent(context.getCurrent());
        directory.setName(name);
        children.add(directory);
    }
}
