/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc.team1250.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick m_joystick = new Joystick(0);
	
	public OI() {
		
		Button a = new JoystickButton(m_joystick, 1);
		Button x = new JoystickButton(m_joystick, 2);
		Button rt = new JoystickButton(m_joystick,8);

	}
	
	public boolean getButtonState(int btn) {
		return m_joystick.getRawButton(btn);
	}
	
	public Joystick getGamepad() {
		return m_joystick;
	}
}
