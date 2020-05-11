package structural.proxy.command;

public class ListFilesCommand implements Command {

    @Override
    public boolean isAdminRequired() {
        return false;
    }

    @Override
    public String getCommand() {
        return "ls -alh";
    }

}
