package org.usfirst.frc.team1250.robot.elevator;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleHigh extends Command {
	static int previousTickCount; 

    public Cmd_EleHigh() {
    	requires(Robot.s_elevator);
    }

    protected void initialize() {
    	setTimeout(5);
    }

    protected void execute() {
    	int currentTickCount = Robot.s_elevator.getLiftPosInTicks();
    	//if(Robot.s_elevator.getErrorCode() == ErrorCode.CAN_MSG_STALE)
    	Robot.s_elevator.setLiftPosition(Robot.s_elevator.SCALE_POS);
    	
//    	if(Math.abs(currentTickCount - previousTickCount) > 2000)
//    	{
//    		Robot.s_elevator.setTickSensorTickPos(previousTickCount);
//    	}
    	previousTickCount = currentTickCount;
    }

    protected boolean isFinished() {
    	return (Robot.s_elevator.getLiftPosInTicks() == Robot.s_elevator.ELE_TICKS * Robot.s_elevator.SCALE_POS || isTimedOut());		
    }

    protected void end() {
    }
    
	protected void interrupted() {
		
	}
}
