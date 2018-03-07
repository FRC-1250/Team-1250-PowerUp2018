package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commandGroups.CmdG_AutonSwitch;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleErectTower;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_CenterPos extends CommandGroup {

    public Auto_CenterPos() {    	
 		addSequential(new Cmd_EleErectTower());
    	
    	String autoMessage = Robot.getAutoMessage();
    	    	
     	if(autoMessage == "LR" || autoMessage =="LL")
    	{
    		//Left Switch case
    		//addSequential(new CmdG_AutonSwitch(-1));
    		System.out.println("Left");
     		//addSequential(new Cmd_AutoTurn(30));
     		//addSequential(new Cmd_AutoDrive(45));
    	}
    	else if(autoMessage == "RL" || autoMessage == "RR")
    	{
    		//Right Switch case
   		//addSequential(new CmdG_AutonSwitch(1));
   		System.out.println("Right");
     		//addSequential(new Cmd_AutoTurn(-30));
     		//addSequential(new Cmd_AutoDrive(45));
    	}
    	else
    	{
    		//Do nothing else
    		System.out.println("******************");
    	}
    	

    }
}
