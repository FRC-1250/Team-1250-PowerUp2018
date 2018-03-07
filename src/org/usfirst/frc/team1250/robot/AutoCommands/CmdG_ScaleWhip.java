package org.usfirst.frc.team1250.robot.AutoCommands;

import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_ScaleWhip extends CommandGroup {

    public CmdG_ScaleWhip(int dir) {
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_EleHigh());
    	 addSequential(new Cmd_AutoDrive(220, 1 , .3));
    	 addSequential(new Cmd_DoNothing(.1));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(80 , 1 , .8));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(209, 1 , .3));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(-90 , 1 , .8));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(56, 1 , .3));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new CmdG_Droper());
    }
}
