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
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	if (!Robot.s_elevator.CheckSoloLift())
    		Robot.s_elevator.soloLiftPinch();
    	else
    		Robot.s_elevator.soloLiftUnPinch();
    }
    


    protected void interrupted() {
    }
}
