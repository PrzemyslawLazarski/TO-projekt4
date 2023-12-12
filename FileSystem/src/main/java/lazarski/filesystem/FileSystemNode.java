package lazarski.filesystem;

public interface FileSystemNode extends Cloneable {
    void setName(String name);
    String getName();

    FileSystemNode getParent();
    void setParent(Directory param);

    String getPath();

    void print(int indent);
}