
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import net.java.games.input.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Couch {
	private GameController controller;
	private Wheels wheels;
	private Display screen;
	
    private JSONObject config;
    
    private boolean MODE_CHANGE_ON;
    private boolean DEBUG_ON;
	
	private static final String CONFIG_FILE_PATH = "CONFIG";

	
	public Couch() throws FileNotFoundException{
        
		Reader in = new FileReader(CONFIG_FILE_PATH);
        JSONTokener jtk = new JSONTokener(in);
        config = new JSONObject(jtk);	
        
		MODE_CHANGE_ON = (config.getInt("modeChange") != 0);
		DEBUG_ON = (config.getInt("debug") != 0);
		
 		wheels = new Wheels(config.getInt("scaleFactor"));
 		String screenType = config.getString("screenType");
 		switch(screenType){
 			case "Console":
 				screen = new Cons();
 				break;
 			case "Screen":
 				//TODO this
 				//screen = new Screen(wheels);
 				//break;
 			case "Virtual Screen":
 				screen = new VirtualScreen(wheels);
 				break;
 			default:
				screen = new VirtualScreen(wheels);
 		}
 		double[] baseData = {config.getDouble("wheelbase"), config.getDouble("track"), config.getDouble("maxForwardSpeed"), config.getDouble("maxRotationalSpeed")};
		controller = new GameController(
						wheels, 
						screen, 
						convertStringArray(config.getJSONArray("compNames")), 
						convertIntArray(config.getJSONArray("anIDs")), 
						config.getString("defaultContSys"), 
						config.getDouble("minHoldTime"),
						baseData
					);
		String controlDebug = controller.init();
		if (DEBUG_ON){
			screen.printLine(controlDebug);
		}
		screen.updateWheelData(wheels.getVels(), wheels.getStates());
	}
	
	private int[] convertIntArray(JSONArray array){
		int[] result = new int[array.length()];
		for(int i = 0; i < array.length(); i++){
			result[i] = array.getInt(i);
		}
		return result;
	}
	
	private String[] convertStringArray(JSONArray array){
		String[] result = new String[array.length()];
		for(int i = 0; i < array.length(); i++){
			result[i] = array.getString(i);
		}
		return result;
	}
	
	public void run(){
		while(controller.poll()){
			controller.scanController();
			controller.updateWheels();
			screen.updateWheelData(wheels.getVels(), wheels.getStates());
		}
		screen.printLine("Controller Disconnected");
	}
	
	public void setup(){
		//TODO
	}
}
