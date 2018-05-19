package DesignPattern.BehaviorPattern.CommandPattern.Command;


import DesignPattern.BehaviorPattern.CommandPattern.Light.Door;

public class DoorCloseCommand implements Command {
    Door door;

    public DoorCloseCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.close();
    }

    @Override
    public void undo() {
        door.open();
    }
}
