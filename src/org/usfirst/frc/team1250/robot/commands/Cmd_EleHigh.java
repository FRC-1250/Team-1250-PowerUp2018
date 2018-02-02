package org.usfirst.frc.team1250.robot.commands;

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
    }

    protected void execute() {
    	Robot.s_elevator.setLiftPosition(Robot.s_elevator.SCALE_POS);

    }
    

    protected boolean isFinished() {
    	if (Robot.s_elevator.getLiftPosTicks() == Robot.s_elevator.ELE_TICKS * Robot.s_elevator.SCALE_POS )
    		return true;
    	else
    		return false;
    		
    }

    protected void end() {
    
    }
    

    protected void interrupted() {
    }
}
