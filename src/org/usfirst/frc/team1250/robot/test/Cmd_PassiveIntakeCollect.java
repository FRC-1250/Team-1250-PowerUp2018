package org.usfirst.frc.team1250.robot.test;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;

public class Cmd_PassiveIntakeCollect extends Command {
	
	  public Cmd_PassiveIntakeCollect() {
	        requires(Robot.s_intake);
	    }

	protected void initialize() {
	if (!Robot.s_intake.isSeenLeft() || !Robot.s_intake.isSeenRight()){
		Robot.s_intake.leftCollect();
		Robot.s_intake.rightCollect();
	}
		else Robot.s_intake.stopleftCollect();
			Robot.s_intake.stoprightCollect();
//	if (!Robot.s_claw.isSeenRight()){
//		Robot.s_claw.rightCollect();
//	}
//		else Robot.s_claw.stoprightCollect();
	if (!Robot.s_intake.isSeenRight() & !Robot.s_intake.isSeenLeft()){
		Robot.s_intake.collect(-1);
		Robot.s_intake.pinch();
	}
	if (Robot.s_intake.isIn()){
		Robot.s_intake.stop();
		Robot.s_intake.unpinch();
	}
//		else 
//		Robot.s_claw.stop();
//		Robot.s_claw.unpinch();
	if (Robot.s_intake.isIn()) {
		Robot.s_elevator.soloLiftPinch();		
	}
}

    protected void execute() {
}
    

protected boolean isFinished() {
	if (Robot.s_intake.isIn())
		return true;
	return false;

}

protected void end() {
}

protected void interrupted() {
}
}
