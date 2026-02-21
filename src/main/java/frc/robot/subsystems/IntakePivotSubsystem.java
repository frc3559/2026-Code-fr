package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
//import com.revrobotics.spark.config.SparkBaseConfig; unnecessary
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SoftLimitConfig;
//import com.revrobotics.spark.config.SoftLimitConfigAccessor; unnecessary
import com.revrobotics.ResetMode;
import com.revrobotics.PersistMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakePivotSubsystem extends SubsystemBase {
    public SparkMax intakePivot;
    public static final int  kIntakePivotMotorCanId = 26;

    public IntakePivotSubsystem() {
        intakePivot = new SparkMax(kIntakePivotMotorCanId, MotorType.kBrushless);
        SoftLimitConfig pivotLimitConfig = new SoftLimitConfig(); //The soft limit code should stop the motor when it hits one of the specified values.
        pivotLimitConfig.forwardSoftLimit(100); //We do not know whether the limit value is degrees or rotations
        pivotLimitConfig.reverseSoftLimit(0); //These lines make no forward and reverse limits. tweak values based on testing.
        SparkMaxConfig pivotConfig = new SparkMaxConfig();
        pivotConfig.apply(pivotLimitConfig); //applies the pivotlimitconfig's limits to the spark max config called pivotconfig
        intakePivot.configure(pivotConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters); //Change persist and reset paramaters to no or blank based on what we want
    } //the above line configures the motor intakePivot based on pivotConfig

    public void intakePivotUp(double speed) {
        intakePivot.set(speed);
    }
    
    public void intakePivotDown(double speed) {
        intakePivot.set(speed);
    }
}
