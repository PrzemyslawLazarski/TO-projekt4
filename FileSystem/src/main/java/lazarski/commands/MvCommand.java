package lazarski.commands;

import lazarski.filesystem.BaseNode;
import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;
import lazarski.PathMapper;

import java.util.List;

public class MvCommand implements Command {

    private List<String> parameters;

    @Override
    public String getName() {
        return "mv";
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

        BaseNode toMove = PathMapper.resolvePath(firstParam, context);

        boolean changeName = false;
        BaseNode destination;
        String newName = "";

        try {
            destination = PathMapper.resolvePath(secondParam, context);
        } catch (RuntimeException e) {
            String newPath = secondParam.substring(0, secondParam.lastIndexOf("/"));
            newName = secondParam.substring(secondParam.lastIndexOf("/") + 1);
            destination = PathMapper.resolvePath(newPath, context);
            changeName = true;
        }
        if (destination instanceof Directory directory) {
            if (changeName) {
                toMove.setName(newName);
            }
            if (directory.hasChildWithName(toMove.getName())){
                throw new RuntimeException("Katalog o tej nazwie już istnieje!");
            }
            Directory oldParent = toMove.getParent();
            oldParent.removeChild(toMove);
            directory.addChild(toMove);
            toMove.setParent(directory);

        }
    }
}
