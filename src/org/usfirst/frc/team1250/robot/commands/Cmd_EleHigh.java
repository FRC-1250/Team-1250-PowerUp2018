package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleHigh extends Command {

    public Cmd_EleHigh() {
    	requires(Robot.s_claw);

    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_claw.LiftTop();

    }
    

    protected boolean isFinished() {
    	if (Robot.s_claw.GetLiftPos() == 1157.06 * 81)
    	return true;
    	else
    	return false;
    		
    }

    protected void end() {
    
    }
    

    protected void interrupted() {
    }
}
