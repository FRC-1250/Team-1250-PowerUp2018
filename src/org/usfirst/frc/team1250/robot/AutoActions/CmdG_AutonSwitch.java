package org.usfirst.frc.team1250.robot.AutoActions;

import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpit;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpitSlow;
import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_EleTimed;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.CmdG_Dropper;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_AutonSwitch extends CommandGroup {

	// Pass 1 for Right
	// Pass -1 for Left
		
    public CmdG_AutonSwitch(int dir) {
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_EleTimed(.8));
    	 addSequential(new Cmd_AutoDrive(38, .7 , .3));
    	 addSequential(new Cmd_DoNothing(.1));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(45 * dir, .8 , .7));  
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(81, .7 , .3));
    	 addSequential(new Cmd_DoNothing(.1));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(-45 * dir, .8 , .7)); 
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(8, .8 , .4));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_IntakeSpitSlow(1));
    	 }
}
