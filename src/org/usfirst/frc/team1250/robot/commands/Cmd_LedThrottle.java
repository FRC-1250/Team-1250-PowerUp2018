package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.OI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class Cmd_LedThrottle extends Command {
	

	double leftStick;
	double rightStick;
	static double avgThrottle;
	
    public Cmd_LedThrottle() {
    	requires(Robot.s_leds);
    }

    protected void initialize() {

    	
    }

    protected void execute() {
    	leftStick = Math.abs(Robot.m_oi.getGamepad().getY());
    	rightStick = Math.abs(Robot.m_oi.getGamepad().getThrottle());
    	
    	avgThrottle = (leftStick + rightStick) / 2;
    	Robot.s_leds.ledThrot((byte)(63 * avgThrottle)); 
    	
    }

    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }


    protected void interrupted() {
    }
}
