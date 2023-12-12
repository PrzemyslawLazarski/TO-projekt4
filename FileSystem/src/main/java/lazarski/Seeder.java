package lazarski;

import lazarski.commands.*;
import lazarski.filesystem.Directory;
import lazarski.filesystem.File;

public abstract class Seeder {
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

        File liczby = new File();
        liczby.setName("liczby.txt");
        liczby.setContent("1 2 3 4 5 6 7");

        File ala=new File();
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

    public static Commands generateShell(){
        Commands commandCollection = new Commands();

        Command ls = new LsCommand();
        Command cd = new CdCommand();
        Command mkdir = new MkdirCommand();
        Command more = new MoreCommand();
        Command tree = new TreeCommand();
        Command cp = new CpCommand();
        Command mv = new MvCommand();
        Command touch = new TouchCommand();
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
