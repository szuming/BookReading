package DesignPattern.BehaviorPattern.CommandPattern;


import DesignPattern.BehaviorPattern.CommandPattern.Command.DoorOpenCommand;
import DesignPattern.BehaviorPattern.CommandPattern.Command.LightOnCommand;
import DesignPattern.BehaviorPattern.CommandPattern.Control.SimpleRemoteControl;
import DesignPattern.BehaviorPattern.CommandPattern.Light.Door;
import DesignPattern.BehaviorPattern.CommandPattern.Light.Light;

public class SimpleRemoteContrlTest {
    public static void main(String argv[]){
        SimpleRemoteControl simpleRemoteControl=new SimpleRemoteControl();      //遥控器对象
        Light light=new Light();                                                //灯对象
        LightOnCommand lightOn=new LightOnCommand(light);                       //开灯命令
        simpleRemoteControl.setCommand(lightOn);                                //遥控器设置开灯命令
        simpleRemoteControl.buttonWasPressed();                                 //按下按钮执行开灯命令

        Door door=new Door();
        DoorOpenCommand doorOpenCommand=new DoorOpenCommand(door);
        simpleRemoteControl.setCommand(doorOpenCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}
