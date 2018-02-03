package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleSwitch extends Command {

    public Cmd_EleSwitch() {
    	requires(Robot.s_elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.s_elevator.setLiftPosition(Robot.s_elevator.SWITCH_POS);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Robot.s_elevator.getLiftPosInTicks() == Robot.s_elevator.ELE_TICKS * Robot.s_elevator.SWITCH_POS) || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
