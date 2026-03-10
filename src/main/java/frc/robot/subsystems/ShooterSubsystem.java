package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem  extends SubsystemBase {
    private final SparkFlex shooterMotor1 = new SparkFlex(21, MotorType.kBrushless);
    private final SparkFlex shooterMotor2 = new SparkFlex(23, MotorType.kBrushless);
    private RelativeEncoder shooterEncoder1;
    private RelativeEncoder shooterEncoder2;
    private final double minSpeed = .95; //Minimum speed for shooters to run for isReady to return true, tolerance is within .05 of nominal shooter speed

    public ShooterSubsystem() {
        shooterEncoder1 = shooterMotor1.getEncoder();
        shooterEncoder2 = shooterMotor2.getEncoder();
    }

    public void shooterSet(double speed) {
        shooterMotor1.set(speed);
        shooterMotor2.set(speed);
    }

    // This function returns true once motors are spun up and ready to fire
    public boolean isReady() {
        double shooter1Speed = shooterEncoder1.getVelocity();
        double shooter2Speed = shooterEncoder2.getVelocity();
        if (shooter1Speed > minSpeed && shooter2Speed > minSpeed) { //If both motors are running at least at minSpeed, then isReady returns true
            return true;
        } else {
            return false;
        }
    }

}
