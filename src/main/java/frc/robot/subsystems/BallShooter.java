// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SUBSYSTEM.*;

public class BallShooter extends SubsystemBase {
  
  public WPI_TalonSRX ballShooter = new WPI_TalonSRX(SHOOTER_ID);

  public BallShooter() {}

  public void shoot(double strength) {
    ballShooter.set(strength);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
