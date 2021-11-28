// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SUBSYSTEM.*;

public class BallSucker extends SubsystemBase {

  public WPI_TalonSRX sucker = new WPI_TalonSRX(SUCKER_ID);

  /** Creates a new BallSucker. */
  public BallSucker() {}

  public void suck(double speed) {
    assert(speed < 0); // you suck so you are negative
    sucker.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
