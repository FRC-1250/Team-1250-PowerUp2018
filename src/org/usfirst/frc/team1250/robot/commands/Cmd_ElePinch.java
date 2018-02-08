package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_ElePinch extends Command {

    public Cmd_ElePinch() {
    	requires(Robot.s_elevator);
    }


    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_elevator.soloLiftPinch();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	if (!Robot.s_elevator.checkSoloLift())
    		Robot.s_elevator.soloLiftPinch();
    	else
    		Robot.s_elevator.soloLiftUnPinch();
    }
    


    protected void interrupted() {
    }
}
