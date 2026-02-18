package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax innerElevatorMotor = new SparkMax(21, MotorType.kBrushless);
    RelativeEncoder innerElevatorEncoder;

    public void encodersubSystems() {
        innerElevatorEncoder = innerElevatorMotor.getEncoder();
        // SmartDashboard.putNumber("outer Elevator Encoder",
        // outerElevatorEncoder.getPosition());
        // SmartDashboard.putNumber("inner Elevator Encoder",
        // innerElevatorEncoder.getPosition());
    }
    public void elevate(double speed){
        innerElevatorMotor.set(speed);
    }
    public ElevatorSubsystem() {

    }

    @Override
    public void periodic() {
        innerElevatorEncoder = innerElevatorMotor.getEncoder();
        SmartDashboard.putNumber("inner Elevator Encoder", innerElevatorMotor.getEncoder().getPosition());
    }
}