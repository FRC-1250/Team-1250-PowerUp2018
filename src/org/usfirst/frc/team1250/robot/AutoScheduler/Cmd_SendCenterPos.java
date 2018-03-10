package org.usfirst.frc.team1250.robot.AutoScheduler;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Cmd_SendCenterPos extends InstantCommand {

    public Cmd_SendCenterPos() {
        super();
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.StartPos = "Center";
    }

}
