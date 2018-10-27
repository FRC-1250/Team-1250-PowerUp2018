package org.usfirst.frc.team1250.robot.NewIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Cmd_IntakeSpitSlow extends TimedCommand {

    public Cmd_IntakeSpitSlow(double timeout) {
        super(timeout);
    	requires(Robot.s_newintake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.s_newintake.setIntakeSpeed(.3);
    }

    protected void end() {
    	Robot.s_newintake.stop();
    }
    
    protected void interrupted() {
    }
}
