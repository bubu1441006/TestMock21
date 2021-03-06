// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.PID.*;

public class TurnController extends SubsystemBase {
  /** Creates a new TurnController. */

  private PIDController turnController;

  public TurnController() {
    turnController = new PIDController(kP, kI, kD);
  }

  private static TurnController tController = null;
  private static TurnController getInstance() {
    if (tController == null) {
      tController = new TurnController();
    }
    return tController;
  }

  public void setSetPoint(double x) {
    turnController.setSetpoint(x); 
    // set setPoint for PID controller
  }

  public void reset() {
    turnController.reset();
  }

  /*
    Thay vì sử dụng phạm vi đầu vào tối đa và tối thiểu làm các ràng buộc,
    nó coi chúng là cùng một điểm và tự động tính toán tuyến đường ngắn nhất
    đến điểm đặt.
  */
  public void enableContinuousInput(double a, double b) {
    turnController.enableContinuousInput(a, b);

  }

  /*
    Đặt giá trị nhỏ nhất và lớn nhất cho bộ tích hợp
    Khi đặt đến giới hạn, giá trị bộ tích phân được thêm vào đầu ra của bộ điều khiển
    thay vì giá trị bộ tích phân nhân với độ lợi tích phân
  */
  public void setIntegratorRange(double m, double n) {
    turnController.setIntegratorRange(m, n); 
  }

  /*
    Đặt lỗi được coi là có thể chấp nhận được để sử dụng tại Setpoint ().
  */
  public void setTolerance() {
    turnController.setTolerance(kToleranceDegrees, kToleranceAngularVelocity);
  }

  /*
    Trả về đầu ra tiếp theo của bộ điều khiển PID.
  */
  public double calculate(double c) {
    return turnController.calculate(c);
  }
  
  public boolean atSetpoint() {
    return turnController.atSetpoint();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
