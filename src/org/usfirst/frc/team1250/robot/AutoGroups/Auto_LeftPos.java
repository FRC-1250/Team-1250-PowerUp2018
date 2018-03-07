package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.AutoCommands.CmdG_ScaleWhip;
import org.usfirst.frc.team1250.robot.AutoCommands.CmdG_StriaghtScale;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleErectTower;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_LeftPos extends CommandGroup {

    public Auto_LeftPos() {
    	addSequential(new Cmd_EleErectTower());
// 		addSequential(new Cmd_AutoDrive(45));
    	
    	String autoMessage = Robot.getAutoMessage();
    	
    	if(autoMessage == "RL" || autoMessage =="LL")
    	{
    		//Left Scale case
//     		addParallel(new Cmd_AutoDrive(45));
//     		addParallel(new Cmd_EleHigh());
//     		addSequential(new Cmd_AutoTurn(90));
    		addSequential(new CmdG_StriaghtScale(1));
    		
    	}
    	else if(autoMessage == "LR" || autoMessage == "RR")
    	{
    		//Left Switch case
//    		addParallel(new Cmd_AutoDrive(45));
     		addSequential(new CmdG_ScaleWhip(1));
//     		addSequential(new Cmd_AutoTurn(90));
    	}
    	else
    	{
    		//RR - Do nothing else
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
