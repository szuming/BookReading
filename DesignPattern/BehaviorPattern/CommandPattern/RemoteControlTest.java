package DesignPattern.BehaviorPattern.CommandPattern;


import DesignPattern.BehaviorPattern.CommandPattern.Command.*;
import DesignPattern.BehaviorPattern.CommandPattern.Control.RemoteControl;
import DesignPattern.BehaviorPattern.CommandPattern.Light.Door;
import DesignPattern.BehaviorPattern.CommandPattern.Light.Light;

public class RemoteControlTest {
    public static void main(String argv[]){
        RemoteControl remoteControl=new RemoteControl();                        //实例化遥控器
        Light light=new Light();                                                //实例化接收者
        LightOnCommand lightOnCommand=new LightOnCommand(light);                //开灯命令
        LightOffCommand lightOffCommand=new LightOffCommand(light);             //光等命令
        remoteControl.setOnCommands(0,lightOnCommand,lightOffCommand);     //遥控器设置命令

        //执行撤销
        remoteControl.onButtonWasPushed(0);                                 //遥控器执行开灯命令
        remoteControl.offButtonWasPushed(0);                                //遥控器执行关灯命令

        remoteControl.undoButtonWasPushed();                                     //遥控器执行撤销命令

        //执行宏命令
        System.out.println("执行宏命令集");
        Door door=new Door();
        DoorOpenCommand doorOpenCommand=new DoorOpenCommand(door);
        Command[] partyOn={lightOnCommand,doorOpenCommand};
        Command macroCommand=new MacroCommand(partyOn);
        remoteControl.setOnCommands(1,macroCommand,new NoCommand());
        remoteControl.onButtonWasPushed(1);
    }
}
