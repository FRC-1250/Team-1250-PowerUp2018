package org.usfirst.frc.team1250.robot.AutoScheduler;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.AutoActions.CmdG_ScaleWhip;
import org.usfirst.frc.team1250.robot.AutoActions.CmdG_StriaghtScale;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_LeftPos extends CommandGroup {

    public Auto_LeftPos() {
    	//addSequential(new Cmd_Popper(1));

    	
    	String autoMessage = Robot.getAutoMessage();
    	
    	
    	if(autoMessage.equals("RL") || autoMessage.equals("LL"))
    	{
    		//Left Scale case
//     		addParallel(new Cmd_AutoDrive(45));
//     		addParallel(new Cmd_EleHigh());
//     		addSequential(new Cmd_AutoTurn(90));
    		addSequential(new CmdG_StriaghtScale(1));
    		
    	}
    	else if(autoMessage.equals("LR")|| autoMessage.equals("RR"))
    	{
    		//Left Switch case
//    		if (getCross) 
    			addSequential(new CmdG_ScaleWhip(1));
//    		else 
//    			addSequential(new Auto_Fallback() );
    	}
    	else
    	{
    		//RR - Do nothing else
    	}

    }
}
