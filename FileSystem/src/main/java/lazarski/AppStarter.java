package lazarski;

import lazarski.commands.Command;
import lazarski.filesystem.Context;

import java.util.Scanner;

public class AppStarter {
    private final Scanner scanner;
    private final Context context;

    private final Interpreter interpreter;


    public AppStarter(Scanner scanner, Context context, Interpreter interpreter) {
        this.scanner = scanner;
        this.context = context;
        this.interpreter = interpreter;
    }

    public void run() throws InterruptedException {

        while (true) {
            System.out.print("$ " + context.getCurrent().getPath() + " ");
            String line = scanner.nextLine();
            Command command;
            try {
                command = interpreter.resolveCommand(line);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                Thread.sleep(1000);
                continue;
            }
            try {
                command.execute(context);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                Thread.sleep(1000);
            }
        }


    }

}
