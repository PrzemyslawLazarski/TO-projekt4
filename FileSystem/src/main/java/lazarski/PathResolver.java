package lazarski;

import lazarski.filesystem.BaseComponent;
import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;
import lazarski.filesystem.TextFile;

public abstract class PathResolver {

    public static BaseComponent resolvePath(String path, Context context) {
        Directory current;
        if (path.equals(".")){
            return context.getCurrent();
        }
        if (path.charAt(0) == '/') {
            current = context.getCurrent();
            while(current.getParent() != null){
                current = current.getParent();
            }
            if (path.length() == 1){
                return current;
            }
        } else if (path.charAt(0) == '.' && path.charAt(1) == '/'){
            current = context.getCurrent();
        }
        else {
            current = context.getCurrent();
            String[] split = path.split("/");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("..")) {
                    current = current.getParent();
                    if(current == null){
                        throw new RuntimeException("Niepoprawna ścieżka!");
                    }
                } else {
                    if (current.hasChildWithName(split[i])) {
                        BaseComponent next = current.getChildByName(split[i]);
                        if (next instanceof Directory) {
                            current = (Directory) next;
                        } else if (next instanceof TextFile && i == (split.length - 1)) {
                            return next;
                        }
                        else {
                            throw new RuntimeException("Niepoprawna ścieżka!");
                        }
                    }
                    else {
                        throw new RuntimeException("Niepoprawna ścieżka!");
                    }
                }
            }
            return current;
        }
        String[] split = path.split("/");
        for (int i = 1; i < split.length; i++) {
            if (split[i].equals("..")) {
                current = current.getParent();
                if(current == null){
                    throw new RuntimeException("Niepoprawna ścieżka!");
                }
            } else {
                if (current.hasChildWithName(split[i])) {
                    BaseComponent next = current.getChildByName(split[i]);
                    if (next instanceof Directory) {
                        current = (Directory) next;
                    } else if (next instanceof TextFile && i == (split.length - 1)) {
                        return next;
                    }
                    else {
                        throw new RuntimeException("Niepoprawna ścieżka!");
                    }
                }
                else {
                    throw new RuntimeException("Niepoprawna ścieżka!");
                }
            }
        }
        return current;
    }

}
