package robot.drive;
import com.revrobotics.CANSparkBase.IdleMode;
import java.util.List;
import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robot.Ports;



public class Drive extends SubsystemBase{
    private final CANSparkMax leftLeader = new CANSparkMax(Ports.Drive.LEFT_LEADER, MotorType.kBrushless);
    private final CANSparkMax leftFollower = new CANSparkMax(Ports.Drive.LEFT_FOLLOWER, MotorType.kBrushless);
    private final CANSparkMax rightLeader = new CANSparkMax(Ports.Drive.RIGHT_LEADER, MotorType.kBrushless);
    private final CANSparkMax rightFollower = new CANSparkMax(Ports.Drive.RIGHT_FOLLOWER, MotorType.kBrushless);
// encoders
  private final RelativeEncoder leftEncoder = leftLeader.getEncoder();
  private final RelativeEncoder rightEncoder = rightLeader.getEncoder();
//i have some unused code because I went a little bit over odometry
  


  public Drive() {
    for (CANSparkMax spark : List.of(leftLeader, leftFollower, rightLeader, rightFollower)) {
	    spark.restoreFactoryDefaults();
        spark.setIdleMode(IdleMode.kBrake);



        
    }
    rightFollower.follow(rightLeader);
    leftFollower.follow(leftLeader);

    leftLeader.setInverted(true);
}

private void drive(double leftSpeed, double rightSpeed) {
    leftLeader.set(leftSpeed);
    rightLeader.set(rightSpeed);
  }
  public Command drive(DoubleSupplier vLeft, DoubleSupplier vRight){
    //NEED HELP
    return run(() -> drive(vLeft.getAsDouble(), vRight.getAsDouble()));
  }
}
