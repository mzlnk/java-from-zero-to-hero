package structural.proxy.command.executor;

import structural.proxy.command.Command;

public interface CommandExecutor {

    void onCommand(Command command);

}
