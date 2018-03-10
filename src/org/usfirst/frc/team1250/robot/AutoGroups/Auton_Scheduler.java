package org.usfirst.frc.team1250.robot.AutoGroups;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.commands.Cmd_Popper;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auton_Scheduler extends CommandGroup {

    public Auton_Scheduler(String Pos) {
    	
    	
    	
    	
    	SmartDashboard.putString("Auton Position Message", Pos);
    	
    	if (Robot.StartPos.equals("Center")) {
    		addSequential(new Cmd_Popper(0.5));	
    		addSequential(new Auto_CenterPos());
    		
    	}else if (Robot.StartPos.equals("Left")) {
    		addSequential(new Cmd_Popper(0.5));
    		addSequential(new Auto_LeftPos());
    		
    	} else if((Robot.StartPos.equals("Right"))){
    		addSequential(new Cmd_Popper(0.5));
    		addSequential(new Auto_RightPos());
    	} else {
    		addSequential(new Cmd_Popper(0.5));
    		SmartDashboard.putString("Robot Position Message", "fALLBACK");
    		addSequential(new Auto_Fallback());
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