package info.lysenko.anton.patterns.command;

public class RemoteControlTest {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        LightControlCommandOn lightOn = new LightControlCommandOn(light);
        LightControlCommandOff lightOff = new LightControlCommandOff(light);
        LightControlCommandHigh lightHigh = new LightControlCommandHigh(light);

        //Command[] partyOn = {lightOn, lightHigh};
        Command partyOnLambda = () -> { light.on(); light.high();};
        //Command[] partyOff = {lightOff};
        //MacroCommand macroCommandOn = new MacroCommand(partyOn);
//        MacroCommand macroCommandOn = new MacroCommand(new Command[]{partyOnLambda});
//        MacroCommand macroCommandOff = new MacroCommand(partyOff);

        remoteControl.setCommand(2, partyOnLambda, light::off);

        remoteControl.setCommand(0, light::on, light::off);
        remoteControl.setCommand(1, lightHigh, lightOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        System.out.println(remoteControl);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
//        System.out.println(remoteControl);
//        System.out.println();
//        remoteControl.onButtonWasPushed(2);
//        System.out.println(remoteControl);
//        remoteControl.offButtonWasPushed(2);
//        System.out.println(remoteControl);

    }
}
