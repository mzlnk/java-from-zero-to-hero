package structural.proxy.command;

public class RebootCommand implements Command {

    @Override
    public boolean isAdminRequired() {
        return true;
    }

    @Override
    public String getCommand() {
        return "reboot";
    }

}
