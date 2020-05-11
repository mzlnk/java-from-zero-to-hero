package structural.proxy.command.executor;

import structural.proxy.User;
import structural.proxy.command.Command;

public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor = new DefaultCommandExecutor();

    public CommandExecutorProxy(User user) {
        this.isAdmin = (user.getUsername().equals("admin") && user.getPassword().equals("soDifficultPassword"));
    }

    @Override
    public void onCommand(Command command) {
        if(command.isAdminRequired() && !isAdmin) {
            throw new InsufficientPermissionException();
        }
        this.executor.onCommand(command);
    }

}
