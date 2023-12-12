package lazarski;

import lazarski.commands.*;
import lazarski.filesystem.Directory;
import lazarski.filesystem.TextFile;
import lazarski.commands.*;

public abstract class ExampleDelivery {
    public static Directory generateExampleTree(){
        Directory root= new Directory();
        root.setName("root");

        Directory desktop = new Directory();
        desktop.setName("Desktop");

        Directory documents = new Directory();
        documents.setName("Documents");

        Directory downloads = new Directory();
        downloads.setName("Downloads");




        Directory przemek = new Directory();
        przemek.setName("Przemek");

        Directory files = new Directory();
        files.setName("Files");

        TextFile liczby = new TextFile();
        liczby.setName("liczby.txt");
        liczby.setContent("1 2 3 4 5 6 7");

        TextFile ala=new TextFile();
        ala.setName("ala.txt");
        ala.setContent("Ala ma kota");

        try {
            root.addChild(desktop);
            root.addChild(documents);
            root.addChild(downloads);

            desktop.addChild(files);
            files.addChild(liczby);
            files.addChild(ala);

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return root;
    }

    public static CommandCollection generateShell(){
        CommandCollection commandCollection = new CommandCollection();

        Command ls = new LS();
        Command cd = new CD();
        Command mkdir = new MKDIR();
        Command more = new MORE();
        Command tree = new TREE();
        Command cp = new CP();
        Command mv = new MV();
        Command touch = new TOUCH();
        commandCollection.addCommand(ls);
        commandCollection.addCommand(cd);
        commandCollection.addCommand(mkdir);
        commandCollection.addCommand(more);
        commandCollection.addCommand(tree);
        commandCollection.addCommand(cp);
        commandCollection.addCommand(mv);
        commandCollection.addCommand(touch);

        return commandCollection;
    }
}
