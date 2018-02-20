	package org.usfirst.frc.team1250.robot.commandGroups;

import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_EleDownSensor;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.commands.Cmd_TimedEleDown;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHome;
import org.usfirst.frc.team1250.robot.test.Cmd_IntakeTest;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_StriaghtScale extends CommandGroup {

    public CmdG_StriaghtScale(int dir) {
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_EleHigh());
    	 addSequential(new Cmd_AutoDrive(250, 1 , .3));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new CmdG_Droper());
    	 addParallel(new Cmd_EleDownSensor());
    	 addSequential(new Cmd_AutoDrive(-24, .8 , .3));
    	 //addParallel(new Cmd_EleHome());
//    	 addParallel(new Cmd_EleDownSensor());
    	 addSequential(new Cmd_AutoTurn(140*dir , 1 , .8));
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_IntakeTest());
    	 addSequential(new Cmd_AutoDrive(48, .8 , .3));  	
    	 addSequential(new Cmd_AutoDrive(18, .8 , .3));
    	 addSequential(new CmdG_FullCollect());
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_EleHigh());
    	 addSequential(new Cmd_AutoTurn(200*dir , 1 , .8));
    	 addSequential(new Cmd_AutoDrive(70, .8 , .3));
    	 addSequential(new CmdG_Droper());

    }
}
