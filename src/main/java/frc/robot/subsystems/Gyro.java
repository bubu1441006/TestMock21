// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyro extends SubsystemBase {
  /** Creates a new Gyro. */

  private AHRS ahrs;

  public Gyro() {
    ahrs = new AHRS();
  }

  private static Gyro gyro = null;
  public static Gyro getInstance() {
    if(gyro == null) {
      gyro = new Gyro();
    }
    return gyro;
  }

  public void reset() {
    ahrs.reset();
  }

  // Yaw là xoay 
  public double getYaw() {
    return ahrs.getYaw();
  }

  @Override
  public void periodic() {
    // đưa giá trị tọa độ x, y lên app SmartDashboard
    SmartDashboard.putNumber("x", ahrs.getDisplacementX());
    SmartDashboard.putNumber("y", ahrs.getDisplacementY());
  }
}
