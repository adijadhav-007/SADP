class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    
    private int speed;
    private String location;
    
    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }
    
    public void high() {
        speed = HIGH;
        System.out.println(location + " ceiling fan is on HIGH");
    }
    
    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " ceiling fan is on MEDIUM");
    }
    
    public void low() {
        speed = LOW;
        System.out.println(location + " ceiling fan is on LOW");
    }
    
    public void off() {
        speed = OFF;
        System.out.println(location + " ceiling fan is OFF");
    }
    
    public int getSpeed() {
        return speed;
    }
}

interface Command {
    void execute();
    void undo();
}

class CeilingFanHighCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else {
            ceilingFan.off();
        }
    }
}

class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else {
            ceilingFan.off();
        }
    }
}

class RemoteControlWithUndo {
    private Command slot;
    private Command undoCommand;

    public RemoteControlWithUndo() {
        undoCommand = new NoCommand();
    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void pressButton() {
        slot.execute();
        undoCommand = slot;
    }

    public void pressUndo() {
        undoCommand.undo();
    }
}

class NoCommand implements Command {
    public void execute() {}
    public void undo() {}
}

public class CeilingFanTest {
    public static void main(String[] args) {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanHighCommand fanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand fanOff = new CeilingFanOffCommand(ceilingFan);

        remote.setCommand(fanHigh);
        remote.pressButton();

        remote.setCommand(fanOff);
        remote.pressButton();

        System.out.println("Undoing...");
        remote.pressUndo();

        System.out.println("Undoing again...");
        remote.pressUndo();
    }
}
