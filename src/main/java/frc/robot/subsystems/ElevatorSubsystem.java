package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax climberElevatorMotor = new SparkMax(28, MotorType.kBrushless);
    RelativeEncoder climberElevatorEncoder;

    public void encodersubSystems() {
        climberElevatorEncoder = climberElevatorMotor.getEncoder();
        // SmartDashboard.putNumber("outer Elevator Encoder",
        // outerElevatorEncoder.getPosition());
        // SmartDashboard.putNumber("inner Elevator Encoder",
        // innerElevatorEncoder.getPosition());
    }
    public void elevate(double speed){
        climberElevatorMotor.set(speed);
    }
    public ElevatorSubsystem() {

    }

    @Override
    public void periodic() {
        climberElevatorEncoder = climberElevatorMotor.getEncoder();
        SmartDashboard.putNumber("inner Elevator Encoder", climberElevatorMotor.getEncoder().getPosition());
    }
}