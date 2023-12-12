package lazarski.commands;

import lazarski.filesystem.BaseNode;
import lazarski.filesystem.Context;
import lazarski.filesystem.FileSystemNode;
import lazarski.filesystem.File;

import java.util.List;
import java.util.Set;

public class MoreCommand implements Command {

    private List<String> parameters;
    @Override
    public String getName() {
        return "more";
    }

    @Override
    public void setParameters(List<String> list) {
        this.parameters = list;
    }

    @Override
    public void execute(Context context) {
        String fileName = parameters.get(0);

        Set<BaseNode> children = context.getCurrent().getChildren();

        for (FileSystemNode child : children) {
            if (child instanceof File && ((File) child).getName().equals(fileName)){
                System.out.println(((File) child).getContent());
            }

        }

    }
}
