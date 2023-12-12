package lazarski.commands;

import lazarski.filesystem.BaseNode;
import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;
import lazarski.PathMapper;

import java.util.List;

public class CdCommand implements Command {

    private List<String> parameters;

    @Override
    public void setParameters(List<String> list) {
        this.parameters = list;
    }

    @Override
    public String getName() {
        return "cd";
    }

    @Override
    public void execute(Context context) {
        String path = parameters.get(0);
        Directory current = context.getCurrent();

        if (path.equals("..")) {
            if (current.getParent() == null){
                throw new RuntimeException("\n" + "Aktualny katalog to katalog główny i nie posiada katalogu poddrzędnego!");
            }
            context.setCurrent(current.getParent());
        } else if (path.equals(".")) {
            context.setCurrent(current);
        } else {
            BaseNode destination  = PathMapper.resolvePath(path, context);

            if (destination instanceof Directory directory){
                context.setCurrent(directory);
            }
            else {
                throw new RuntimeException("\n" + "Miejsce docelowe nie jest katalogiem!");
            }
        }

    }
}
