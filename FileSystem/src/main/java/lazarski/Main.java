package lazarski;

import lazarski.filesystem.Context;
import lazarski.filesystem.Directory;

import java.util.Scanner;

public class Main {

    static Directory root;
    static Context context;
//    static ICommand command;
//    static IParser interpreter;

    static{
        context = new Context();

    }

    public static void main(String[] args) throws InterruptedException {
        root = Seeder.generateExampleTree();

        context.setCurrent(root);
        Commands commandCollection = Seeder.generateShell();

        AppStarter appStarter = new AppStarter(
                new Scanner(System.in), context, new Interpreter(commandCollection));
        appStarter.run();
//        cmdTree = DefShell.construct(ctx);
//        dparser = new DefParser(cmdTree);
//        dparser.doParse();
    }
}