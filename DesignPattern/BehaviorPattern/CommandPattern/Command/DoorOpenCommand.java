package DesignPattern.BehaviorPattern.CommandPattern.Command;


import DesignPattern.BehaviorPattern.CommandPattern.Light.Door;

public class DoorOpenCommand implements Command {
    Door door;

    public DoorOpenCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }

    @Override
    public void undo() {
        door.close();
    }
}
