	package org.usfirst.frc.team1250.robot.AutoActions;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpit;
import org.usfirst.frc.team1250.robot.NewIntake.Cmd_IntakeSpitSlow;
import org.usfirst.frc.team1250.robot.commands.Cmd_Reset;
import org.usfirst.frc.team1250.robot.commands.Cmd_TimedEleUp;
import org.usfirst.frc.team1250.robot.drive.Cmd_AutoDrive;
import org.usfirst.frc.team1250.robot.elevator.CmdG_Dropper;
import org.usfirst.frc.team1250.robot.elevator.Cmd_EleHigh;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CmdG_StriaghtScale extends CommandGroup {

    public CmdG_StriaghtScale(int dir) {
    	 Robot.s_drivetrain.setToBrake();
    	 addSequential(new Cmd_Reset());
    	 addParallel(new Cmd_TimedEleUp(2.3));
    	 //addSequential(new Cmd_AutoDrive(100, .8 , .3));
    	 addSequential(new Cmd_AutoDrive(100, 1 , .3));
    	 addSequential(new Cmd_Reset());
//    	 addSequential(new Cmd_IntakeSpitSlow(1));
//    	 addSequential(new Cmd_AutoDrive(-60, 1 , .3));
//    	 addSequential(new Cmd_DoNothing(1));
////    	 addParallel(new Cmd_EleDownSensor());
//    	 addSequential(new Cmd_AutoDrive(-30, .8 , .3));
//    	 addParallel(new Cmd_IntakeTest());
//    	 //addParallel(new Cmd_EleHome());
////    	 addParallel(new Cmd_EleDownSensor());
//    	 addSequential(new Cmd_AutoTurn(80*dir , 1 , .8));
//    	 addSequential(new Cmd_Reset());
//    	 addParallel(new Cmd_IntakeTest());
//    	 addSequential(new Cmd_AutoDrive(24, .6 , .3));  	
//    	 addSequential(new Cmd_AutoTurn(80*dir , 1 , .8));
//    	 addSequential(new Cmd_AutoDrive(60, .6 , .3));
//    	 addParallel(new Cmd_IntakeTest());
//    	 addSequential(new Cmd_AutoDrive(-3, .6 , .3));
//    	 //addSequential(new Cmd_AutoTurn(30*dir , 1 , .8));
//    	 addSequential(new CmdG_FullCollect());
//    	 addSequential(new Cmd_Reset());
//    	 addSequential(new Cmd_EleHigh());
//    	 addSequential(new Cmd_AutoTurn(175*dir , 1 , .8));
//    	 addSequential(new Cmd_AutoDrive(60, .8 , .3));
//    	 addSequential(new CmdG_Droper());

    }
}
