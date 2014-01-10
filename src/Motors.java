

public class Motors {
	private EStop eStop;
	private int SCALE_FACTOR;
	
	public Motors(int scaleFactor){
		eStop = new EStop();
		SCALE_FACTOR = scaleFactor;
	}
	
	//Note: Velocities are in the array in the order LF, RF, LR, RR
	//this assumes the front of the couch is the way the passengers are facing
	// _______________________________________
	// |LF								   RF |
	// |									  |
	// |									  |
	// |									  |
	// |LR								   RR |
	// |______________________________________|
	
	
	public int[] update(double[] vel){
		for(int i = 0; i < 4; i++){
			vel[i] *= SCALE_FACTOR;
		}
		//TODO send vels then get status from controllers
		int[] status = {0, 0, 0, 0};
		return status;
	}
	
	public void reset(int index){
		//TODO
	}
}
