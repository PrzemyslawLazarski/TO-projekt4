package lazarski.filesystem;

public class File extends BaseNode implements Cloneable {
    private String content;

    public String getContent() {
        return content;
    }




    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public File clone() {
        File clone = (File) super.clone();
        clone.setContent(this.content);
        return clone;
    }
}
