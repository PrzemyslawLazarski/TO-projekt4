package lazarski.commands;

import lazarski.filesystem.Context;

import java.util.List;

public interface Command {
    String getName();
    void setParameters(List<String> list);
    void execute(Context context);
}
