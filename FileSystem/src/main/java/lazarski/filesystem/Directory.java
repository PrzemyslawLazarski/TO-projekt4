package lazarski.filesystem;

import java.util.HashSet;
import java.util.Set;

public class Directory extends BaseNode implements Cloneable {
    private HashSet<BaseNode> children;

    public Directory() {
        this.children = new HashSet<>();
    }

    public void addChild(BaseNode element) {
        if (this.children.contains(element))
            throw new RuntimeException("Element " + element.getName() + " już istnieje w " + this.getPath());
        element.setParent(this);
        this.children.add(element);
    }

    public void removeChild(BaseNode element) {
        if (!this.children.contains(element))
            throw new RuntimeException("Element " + element.getName() + " nie istnieje w " + this.getPath());
        this.children.remove(element);
    }



    private boolean hasComponent(FileSystemNode element) {
        return children.contains(element);
    }

    public boolean hasChildWithName(String name){
        for (BaseNode child : children) {
            if(child.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public BaseNode getChildByName(String name){
        for (BaseNode child : children) {
            if(child.getName().equals(name)){
                return child;
            }
        }
        return null;
    }

    public Set<BaseNode> getChildren() {
        return children;
    }


    @Override
    public Directory clone() {
        Directory clone = (Directory) super.clone();
        clone.children = new HashSet<>();
        for (BaseNode child : children) {
            BaseNode cloned = child.clone();
            cloned.setParent(clone);
            clone.getChildren().add(cloned);
        }
        return clone;
    }
}
