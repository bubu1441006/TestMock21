// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Gyro;
import static frc.robot.Constants.PID.*;

public class RotateToAngle extends CommandBase {
  /** Creates a new RotateToAngle. */

  private final DriveBase m_DriveBase;
  private final Gyro m_gyro;
  PIDController turnController;

  public RotateToAngle(DriveBase driveBase, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveBase = driveBase;
    m_gyro = Gyro.getInstance();
    turnController = new PIDController(kP, kI, kD);
    turnController.setSetpoint(angle);
    turnController.enableContinuousInput(-180, 180);
    turnController.setTolerance(kToleranceDegrees, kToleranceAngularVelocity);

    addRequirements(m_DriveBase);
    addRequirements(m_gyro);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turnController.reset();
    m_gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("start", true);
    SmartDashboard.putNumber("angle", m_gyro.getYaw());
    double speed = turnController.calculate(m_gyro.getYaw());
    speed += Math.signum(speed) * 0.1; // signum -> trả về 1, 0, -1 tương ứng với dấu của speed
    speed = Math.min(0.6, Math.max(-0.6, speed)); // speed phải trong khoảng [-0.6, 0.6]
    m_DriveBase.drive(-speed, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveBase.drive(0, 0);
    SmartDashboard.putBoolean("Start", false); // khi bot dừng lại -> gắn giá trị trên dashboard thành false
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turnController.atSetpoint();
  }
}

/*
⇒ Công dụng cả file: 
đưa vào góc quay, 
ước lượng liên tục tốc độ quay, 
khi nào sai số nhỏ hơn phạm vi kTolerance thì hàm isFinished trả về True → bot dừng
*/
