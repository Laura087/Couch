
public class AnalogID {
	
	//Axes
	public int LX; //left stick x axis
	public int LY;
	public int RX;
	public int RY;
	public int Z;
	
	//other
	public int HAT;
	
	public AnalogID(int[] anIDs){
		LX = anIDs[0];
		LY = anIDs[1];
		RX = anIDs[2];
		RY = anIDs[3];
		Z = anIDs[4];
		HAT = anIDs[5];
	}

}
