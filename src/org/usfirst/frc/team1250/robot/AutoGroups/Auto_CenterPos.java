package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.AutoCommands.CmdG_AutonSwitch;
import org.usfirst.frc.team1250.robot.commands.Cmd_Popper;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto_CenterPos extends CommandGroup {

    public Auto_CenterPos() {    	
    	String autoMessage = Robot.DS_Msg;
    	
    	SmartDashboard.putString("Auto Message", autoMessage);
    	 
    	//addSequential(new Cmd_AutoDrive(48, .6 , .3));
    	
     	if(autoMessage.equals("LR") || autoMessage.equals("LL"))
    	{
    		//Left Switch case
    		addSequential(new CmdG_AutonSwitch(-1));;
     		//addSequential(new Cmd_AutoTurn(30));
    		//addSequential(new Cmd_AutoDrive(48, .6 , .3));
    	}
    	else if(autoMessage.equals("RL") || autoMessage.equals("RR"))
    	{
    		//Right Switch case
    		addSequential(new CmdG_AutonSwitch(1));
   		System.out.println("Right");
     		//addSequential(new Cmd_AutoTurn(-30));
     		//addSequential(new Cmd_AutoDrive(45));
   			//addSequential(new Cmd_AutoDrive(48, .6 , .3));
    	}
    	else
    	{
    		//Do nothing else
    		System.out.println("******************");
    	}
    	

    }
}
