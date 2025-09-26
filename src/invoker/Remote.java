package invoker;

import interfaces.Command;

public class Remote {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public String pressButton() {
        return command.execute();
    }
}
