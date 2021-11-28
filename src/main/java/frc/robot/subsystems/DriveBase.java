// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.SUBSYSTEM.*;
import static frc.robot.Constants.JOYSTICK.*;

public class DriveBase extends SubsystemBase {
  /** Creates a new DriveBase. */

  // 4 motors for 4 wheels
  public WPI_TalonSRX rightMaster   = new WPI_TalonSRX(RIGHTMASTER_ID);
  public WPI_TalonSRX rightFollow   = new WPI_TalonSRX(RIGHTFOLLOW_ID);
  public WPI_TalonSRX leftMaster    = new WPI_TalonSRX(LEFTMASTER_ID);
  public WPI_TalonSRX leftFollow    = new WPI_TalonSRX(LEFTFOLLOW_ID);
  
  public DriveBase() {
    // the follow wheel should follow the main wheel
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);

    // invert the left side motors so that it go in the same direction as the right
    // imagine 4 motors all on the right and then move 2 to the left
    leftMaster.setInverted(true);
    leftFollow.setInverted(true);

    // make the motor smoother
    leftFollow.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    rightMaster.setNeutralMode(NeutralMode.Brake);
  }

  public void drive(double leftDrive, double rightDrive) {
    leftMaster.set(leftDrive);
    rightMaster.set(rightDrive);
  }

  @Override
  public void periodic() {
    // go faster when press button 2 on joystick
    double boost = RobotContainer.joystick.getRawButton(BUTTON_X) ? BOOST : NORMAL;
    
    drive(RobotContainer.joystick.getRawAxis(1) + boost, 
          RobotContainer.joystick.getRawAxis(3) + boost);
  }
}
