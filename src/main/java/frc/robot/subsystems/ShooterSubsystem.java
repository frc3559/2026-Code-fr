package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem  extends SubsystemBase{
    private final SparkFlex shooterMotor = new SparkFlex(21, MotorType.kBrushless);

    public ShooterSubsystem(){

    }

    public void shooterSet(double speed){
    shooterMotor.set(speed);
    }

}
