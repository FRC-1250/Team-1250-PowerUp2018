package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_Reset extends InstantCommand {

    public Cmd_Reset() {
        super();
        requires(Robot.s_drivetrain);
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.s_drivetrain.resetGyro();
    	Robot.s_drivetrain.resetSensorPos();

    }

}
