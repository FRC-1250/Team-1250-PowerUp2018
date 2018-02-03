package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_AutoTurn extends Command {

    public Cmd_AutoTurn() {
    	requires(Robot.s_drivtrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	//Check Gyro and Encorder distance or timeout
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
