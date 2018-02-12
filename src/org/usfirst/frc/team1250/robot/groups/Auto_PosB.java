package org.usfirst.frc.team1250.robot.groups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleErectTower;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_PosB extends CommandGroup {

    public Auto_PosB() {    	
 		addSequential(new Cmd_EleErectTower());
    	
    	String autoMessage = Robot.getAutoMessage();
    	    	
     	if(autoMessage == "LR" || autoMessage =="LL")
    	{
    		//Right Switch case
     		addSequential(new Cmd_AutoDrive(60));
     		//addSequential(new Cmd_AutoTurn(30));
     		//addSequential(new Cmd_AutoDrive(45));
    	}
    	else if(autoMessage == "RL" || autoMessage == "RR")
    	{
    		//Left Switch case
    		addSequential(new Cmd_AutoDrive(60));
     		//addSequential(new Cmd_AutoTurn(-30));
     		//addSequential(new Cmd_AutoDrive(45));
    	}
    	else
    	{
    		//Do nothing else
    	}
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
