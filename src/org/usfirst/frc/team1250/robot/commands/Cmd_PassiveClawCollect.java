package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;

public class Cmd_PassiveClawCollect extends Command {
	
	  public Cmd_PassiveClawCollect() {
	        requires(Robot.s_claw);
	    }

	protected void initialize() {
	if (!Robot.s_claw.isSeenLeft() || !Robot.s_claw.isSeenRight()){
		Robot.s_claw.leftCollect();
		Robot.s_claw.rightCollect();
	}
		else Robot.s_claw.stopleftCollect();
			Robot.s_claw.stoprightCollect();
//	if (!Robot.s_claw.isSeenRight()){
//		Robot.s_claw.rightCollect();
//	}
//		else Robot.s_claw.stoprightCollect();
	if (!Robot.s_claw.isSeenRight() & !Robot.s_claw.isSeenLeft()){
		Robot.s_claw.collect();
		Robot.s_claw.pinch();
	}
	if (Robot.s_claw.isIn()){
		Robot.s_claw.stop();
		Robot.s_claw.unpinch();
	}
//		else 
//		Robot.s_claw.stop();
//		Robot.s_claw.unpinch();
	if (Robot.s_claw.isIn()) {
		Robot.s_elevator.soloLiftPinch();		
	}
}

    protected void execute() {
}

protected boolean isFinished() {
	if (Robot.s_claw.isIn())
		return true;
	return false;

}

protected void end() {
}

protected void interrupted() {
}
}
