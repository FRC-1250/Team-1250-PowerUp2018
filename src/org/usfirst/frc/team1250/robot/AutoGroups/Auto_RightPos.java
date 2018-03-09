package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.AutoCommands.CmdG_ScaleWhip;
import org.usfirst.frc.team1250.robot.AutoCommands.CmdG_StriaghtScale;
import org.usfirst.frc.team1250.robot.commands.Cmd_Popper;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto_RightPos extends CommandGroup {

    public Auto_RightPos() {
    	//addSequential(new Cmd_Popper(1));
// 		addSequential(new Cmd_AutoDrive(45));
    	
    	String autoMessage = Robot.getAutoMessage();
    	
    	boolean getCross = Robot.CrossMid;
    	
    	SmartDashboard.putBoolean("Are We Crossing", getCross);
    	
    	SmartDashboard.putString("input String", autoMessage);

    	if(autoMessage.equals("LR") || autoMessage.equals("RR"))
    	{
    		SmartDashboard.putString("Auto Message", "Passed 1");
    		
    		addSequential(new CmdG_StriaghtScale(-1));
    		
    		SmartDashboard.putString("Auto Message", "Passed 2");
    		
    	}
    	else if(autoMessage.equals("RL") || autoMessage.equals("LL"))
    	{
    		//Left Switch case
//    		addParallel(new Cmd_AutoDrive(45));
     		
    		if (getCross) 
    			addSequential(new CmdG_ScaleWhip(-1));
    		else 
    			addSequential(new Auto_Fallback() ); 
    		
     		
//     		addSequential(new Cmd_AutoTurn(90));
    	}
    	else
    	{
    		//RR - Do nothing else
    	}

    }
}
