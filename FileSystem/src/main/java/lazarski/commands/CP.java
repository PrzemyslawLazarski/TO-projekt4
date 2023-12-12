package lazarski.commands;

import lazarski.filesystem.BaseComponent;
import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;
import lazarski.PathResolver;

import java.util.List;

public class CP implements Command {
    private List<String> parameters;

    @Override
    public String getName() {
        return "cp";
    }

    @Override
    public void setParameters(List<String> list) {
        this.parameters = list;
    }

    @Override
    public void execute(Context context) {

        if (parameters.size() < 2) {
            throw new RuntimeException("Niewłaściwa liczba argumentów!");
        }

        String firstParam = parameters.get(0);
        String secondParam = parameters.get(1);

        BaseComponent toCopy = PathResolver.resolvePath(firstParam, context);
        BaseComponent destination = PathResolver.resolvePath(secondParam, context);

        BaseComponent copied = toCopy.clone();


        if (destination instanceof Directory directory){
            if (directory.hasChildWithName(copied.getName())){
                throw new RuntimeException("Katalog o tej nazwie już istnieje!");
            }
            copied.setParent(directory);
            directory.getChildren().add(copied);
        }
    }
}
