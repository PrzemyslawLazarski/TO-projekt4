package lazarski.filesystem;

import java.util.HashSet;
import java.util.Set;

public class Directory extends BaseComponent implements Cloneable {
    private HashSet<BaseComponent> children;

    public Directory() {
        this.children = new HashSet<>();
    }

    public void addChild(BaseComponent element) {
        if (this.children.contains(element))
            throw new RuntimeException("Element " + element.getName() + " już istnieje w " + this.getPath());
        element.setParent(this);
        this.children.add(element);
    }

    public void removeChild(BaseComponent element) {
        if (!this.children.contains(element))
            throw new RuntimeException("Element " + element.getName() + " nie istnieje w " + this.getPath());
        this.children.remove(element);
    }



    private boolean hasComponent(FileSystemComponent element) {
        return children.contains(element);
    }

    public boolean hasChildWithName(String name){
        for (BaseComponent child : children) {
            if(child.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public BaseComponent getChildByName(String name){
        for (BaseComponent child : children) {
            if(child.getName().equals(name)){
                return child;
            }
        }
        return null;
    }

    public Set<BaseComponent> getChildren() {
        return children;
    }


    @Override
    public Directory clone() {
        Directory clone = (Directory) super.clone();
        clone.children = new HashSet<>();
        for (BaseComponent child : children) {
            BaseComponent cloned = child.clone();
            cloned.setParent(clone);
            clone.getChildren().add(cloned);
        }
        return clone;
    }
}
