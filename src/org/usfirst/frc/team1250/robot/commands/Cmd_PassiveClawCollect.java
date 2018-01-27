package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;

public class Cmd_PassiveClawCollect extends Command {
	
	  public Cmd_PassiveClawCollect() {
	        // Use requires() here to declare subsystem dependencies
	        requires(Robot.s_claw);
	    }

	protected void initialize() {
	if (!Robot.s_claw.isSeenLeft()){
		Robot.s_claw.leftCollect();
	}
		else Robot.s_claw.stopleftCollect();
	if (!Robot.s_claw.isSeenRight()){
		Robot.s_claw.rightCollect();
	}
		else Robot.s_claw.stoprightCollect();
	if (!Robot.s_claw.isSeenRight() & !Robot.s_claw.isSeenLeft()){
		Robot.s_claw.collect();
		Robot.s_claw.pinch();
	}
		else 
		Robot.s_claw.stop();
		Robot.s_claw.unpinch();
	if (!Robot.s_claw.isIn()) {
		Robot.s_claw.soloLiftPinch();		
	}
}

    protected void execute() {
}

protected boolean isFinished() {
    return false;
}

protected void end() {
}

protected void interrupted() {
}
}
