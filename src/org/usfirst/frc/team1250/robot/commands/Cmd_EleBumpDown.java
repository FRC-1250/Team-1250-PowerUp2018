package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleBumpDown extends Command {

    public Cmd_EleBumpDown() {
    	requires(Robot.s_elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_elevator.bumpUp();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
