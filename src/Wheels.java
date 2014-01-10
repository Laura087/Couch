
public class Wheels {
	
	private double[] vel = new double[4];
	private int[] status= new int[4];
	private Motors motors;
	
	public static final int LF = 0;
	public static final int RF = 1;
	public static final int LR = 2;
	public static final int RR = 3;
	//Note: this assumes the front of the couch is the way the passengers are facing
	// _______________________________________
	// |LF								   RF |
	// |									  |
	// |									  |
	// |									  |
	// |LR								   RR |
	// |______________________________________|
	
	
	public Wheels(int scaleFactor){
		motors = new Motors(scaleFactor);
		for(int i = 0; i < 4; i++){
			vel[i] = 0;
			status[i] = 0;
		}
	}
	
	public void updateMotors(){
		double[] velocities = new double[4];
		for(int i = 0; i < 4; i++){
			velocities[i] = vel[i];
		}
		status = motors.update(velocities);
	}
	
	public void resetMotor(int index){
		motors.reset(index);
		vel[index] = 0;
		status[index] = 0;
	}
	
	public double getVel(int index){
		return vel[index];
	}
	
	public void setVels(double[] velocity){
		vel = velocity;

	}
	
	public void setVel(int index, double velocity){
		vel[index] = velocity;

	}
	
	public int getStatus(int index){
		return status[index];
	}
	
	public void setStatus(int index, int state){
		status[index] = state;
	}
	
	public double[] getVels(){
		double[] vels = vel;
		return vels;
	}
	
	public int[] getStates(){
		int[] states = status;
		return states; 
	}
	
}
