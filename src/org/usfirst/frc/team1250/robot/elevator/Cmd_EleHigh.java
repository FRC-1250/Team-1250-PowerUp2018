package org.usfirst.frc.team1250.robot.elevator;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleHigh extends Command {

    public Cmd_EleHigh() {
    	requires(Robot.s_elevator);
    }

    protected void initialize() {
    	setTimeout(1);
    }

    protected void execute() {
    	Robot.s_elevator.setLiftPosition(Robot.s_elevator.SCALE_POS);
    }

    protected boolean isFinished() {
    	return (Robot.s_elevator.getLiftPosInTicks() == Robot.s_elevator.ELE_TICKS * Robot.s_elevator.SCALE_POS || isTimedOut());		
    }

    protected void end() {
    }
    
	protected void interrupted() {
		
	}
}
