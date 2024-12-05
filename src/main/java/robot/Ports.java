package robot;

public final class Ports {
  // TODO: Add and change all ports as needed.
  public static final class OI {
    public static final int OPERATOR = 0;
    public static final int DRIVER = 1;
  }
  public static final class Drive {
    public static final int RIGHT_LEADER = 2;
    public static final int RIGHT_FOLLOWER = 3;
    //Doing the other part
    public static final int LEFT_LEADER = 4;
    public static final int LEFT_FOLLOWER = 5; 
    // the number 4 means that the motor controller for the lkeft leader is connected to port 4
    // and same principle for others
    // etc
  }
}
