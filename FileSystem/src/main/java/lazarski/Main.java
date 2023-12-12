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
        root = ExampleDelivery.generateExampleTree();

        context.setCurrent(root);
        CommandCollection commandCollection = ExampleDelivery.generateShell();

        ConsoleRunner consoleRunner = new ConsoleRunner(
                new Scanner(System.in), context, new Interpreter(commandCollection));
        consoleRunner.run();
//        cmdTree = DefShell.construct(ctx);
//        dparser = new DefParser(cmdTree);
//        dparser.doParse();
    }
}