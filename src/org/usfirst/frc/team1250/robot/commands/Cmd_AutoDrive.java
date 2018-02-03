package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_AutoDrive extends Command {

    public Cmd_AutoDrive() {
    	requires(Robot.s_drivtrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	//Check encoder distance or timeout
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
