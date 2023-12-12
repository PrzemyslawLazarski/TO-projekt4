package lazarski.commands;

import lazarski.filesystem.BaseNode;
import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;
import lazarski.PathMapper;

import java.util.List;

public class CpCommand implements Command {
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

        BaseNode toCopy = PathMapper.resolvePath(firstParam, context);
        BaseNode destination = PathMapper.resolvePath(secondParam, context);

        BaseNode copied = toCopy.clone();


        if (destination instanceof Directory directory){
            if (directory.hasChildWithName(copied.getName())){
                throw new RuntimeException("Katalog o tej nazwie już istnieje!");
            }
            copied.setParent(directory);
            directory.getChildren().add(copied);
        }
    }
}
