package structural.proxy.command.executor;

import structural.proxy.command.Command;

public class DefaultCommandExecutor implements CommandExecutor {

    @Override
    public void onCommand(Command command) {
        System.out.println("Command: " + command.getCommand() + " has been executed");
    }

}
