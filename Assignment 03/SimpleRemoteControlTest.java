interface Command {
    void execute();
}

class Light {
    void on() {
        System.out.println("Light is ON");
    }
    void off() {
        System.out.println("Light is OFF");
    }
}

class LightOnCommand implements Command {
    Light light;
    LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;
    LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
}

class RemoteControl {
    Command slot;
    void setCommand(Command command) {
        slot = command;
    }
    void pressButton() {
        slot.execute();
    }
}

public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        remote.setCommand(lightOn);
        remote.pressButton();  // Light is ON

        remote.setCommand(lightOff);
        remote.pressButton();  // Light is OFF
    }
}
