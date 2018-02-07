package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.I2C;
import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.commands.Cmd_LedThrottle;
import org.usfirst.frc.team1250.robot.commands.Cmd_PneumaticShift;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class Sub_Leds extends Subsystem {
	
	
	public static I2C i2c; 
	public static byte[] toSend = new byte[2];
	private static byte allyColor;
	

	public Sub_Leds(){
		i2c = new I2C(I2C.Port.kOnboard, RobotMap.LED_I2CPORT);
	}
		
public void disableChaser() {
	toSend[0] = 76;
	toSend[1] = 127;
	i2c.writeBulk(toSend, 2);
}

public void allyLed() {
	if(Robot.allianceColor == DriverStation.Alliance.Blue) {
		allyColor = 72;		
	}
	else {
		allyColor= 74;	
	}
	
	toSend[0]= allyColor;
	toSend[1] = 63;
	i2c.writeBulk(toSend, 2);
		
}
public void ledThrot(byte val) {
	toSend[0] = allyColor;
	toSend[1] = val;
	i2c.writeBulk(toSend, 2);
}

    public void initDefaultCommand() {
    	setDefaultCommand(new Cmd_LedThrottle());
    }
}

