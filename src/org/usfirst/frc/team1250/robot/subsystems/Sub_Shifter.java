package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1250.robot.commands.*;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team1250.robot.RobotMap;
/**
 *
 */
public class Sub_Shifter extends Subsystem {

    Solenoid solShifter = new Solenoid(RobotMap.SOL_SHIFTER);

    public void initDefaultCommand() {
        setDefaultCommand(new Cmd_PneumaticShift());
    }

    public void setHigh(){
    	solShifter.set(true);
	}
    
    public void setLow(){
    	solShifter.set(false);
	}
	
	public void setShiftState(boolean state) {
		
		if(state) 
			this.setHigh();
		else 
			this.setLow();

	}

}

