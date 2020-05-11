package structural.proxy;

import structural.proxy.command.Command;
import structural.proxy.command.ListFilesCommand;
import structural.proxy.command.RebootCommand;
import structural.proxy.command.executor.CommandExecutor;
import structural.proxy.command.executor.CommandExecutorProxy;

public class ProxyTest {

    public static void main(String[] args) {
        User admin = new User("admin", "soDifficultPassword");
        User user = new User("user", "justPassword");

        CommandExecutor adminExecutor = new CommandExecutorProxy(admin);
        CommandExecutor userExecutor = new CommandExecutorProxy(user);

        Command listFilesCmd = new ListFilesCommand();
        Command rebootCmd = new RebootCommand();

        adminExecutor.onCommand(listFilesCmd);
        userExecutor.onCommand(listFilesCmd);

        adminExecutor.onCommand(rebootCmd);
        userExecutor.onCommand(rebootCmd);


    }

}
