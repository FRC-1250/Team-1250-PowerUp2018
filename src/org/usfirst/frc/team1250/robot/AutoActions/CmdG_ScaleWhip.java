package org.usfirst.frc.team1250.robot.AutoActions;

import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpit;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpitSlow;
import org.usfirst.frc.team1250.robot.commands.Cmd_DoNothing;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.commands.Cmd_TimedEleUp;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoTurn;
import org.usfirst.frc.team1250.robot.elevator.CmdG_Dropper;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_ScaleWhip extends CommandGroup {

    public CmdG_ScaleWhip(int dir) {
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_AutoDrive(220, 1 , .3));
    	 addParallel(new Cmd_TimedEleUp(2.2));
    	 addSequential(new Cmd_DoNothing(.1));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(80 * dir , 1 , .8));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(175, 1 , .3));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoTurn(-90 * dir , 1 , .8));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_AutoDrive(30, 1 , .3));
    	 addSequential(new Cmd_Reset());
    	 addSequential(new Cmd_IntakeSpitSlow(1));
    }
}
