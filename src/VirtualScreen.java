import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class VirtualScreen implements Display{
	private Wheels wheels;
	private JTextArea outputFeild;
	private JTextArea[] wheelVels = {new JTextArea("0"), new JTextArea("0"), new JTextArea("0"), new JTextArea("0")};
	private JTextArea[] wheelStates = {new JTextArea("OK"), new JTextArea("OK"), new JTextArea("OK"), new JTextArea("OK")};
	private JScrollPane scroll;
	private JScrollBar vert;
	
	//TODO consider moving to config file
	private final static String[] statesList = {"OK", "ErrTempHi", "WarnTempHi", "ErrCurrHi", "WarnCurrHi"};
	
	public VirtualScreen(Wheels wheels){
		this.wheels = wheels;
		initialiseDisp();
	}
	
	private void initialiseDisp(){
		JPanel output = new JPanel();
		output.setLayout(new BorderLayout());
			outputFeild = new JTextArea();
			scroll = new JScrollPane(outputFeild, 
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setPreferredSize(new Dimension(500, 500));
			vert = scroll.getVerticalScrollBar();
		output.add(new JLabel("Output:"), BorderLayout.NORTH);
		output.add(scroll, BorderLayout.CENTER);
		
		JPanel wheelDisp = new JPanel();
		wheelDisp.setLayout(new GridLayout(2, 2, 2, 2));
			JPanel[] wheel = {new JPanel(), new JPanel(), new JPanel(), new JPanel()};
			String[] wheelNames = {"Left Front", "Right Front", "Left Rear", "Right Rear"};
			JButton[] resets = {new JButton("Reset"), new JButton("Reset"), new JButton("Reset"), new JButton("Reset")};
				resets[0].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						wheels.resetMotor(0);
					}
				});
				resets[1].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						wheels.resetMotor(1);
					}
				});
				resets[2].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						wheels.resetMotor(2);
					}
				});
				resets[3].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						wheels.resetMotor(3);
					}
				});
		for (int i = 0; i < 4; i++){
			wheel[i].setLayout(new GridLayout(3,2));
			wheel[i].add(new JTextArea(wheelNames[i]));
			wheel[i].add(resets[i]);
			wheel[i].add(new JTextArea("Velocity"));
			wheel[i].add(new JTextArea("Status"));
			wheel[i].add(wheelVels[i]);
			wheel[i].add(wheelStates[i]);
			wheelDisp.add(wheel[i]);
		}
		
		
		JFrame display = new JFrame();
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0.3;
		c.gridy = 0;
		display.add(wheelDisp, c);
		c.weighty = 1;
		c.gridy = 1;
		display.add(output, c);
		display.pack();
		display.setVisible(true);
	}

	@Override
	public void print(String s) {
		outputFeild.append(s);
		vert.setValue(vert.getMaximum());
	}

	@Override
	public void printLine(String s) {
		outputFeild.append("\n");
		outputFeild.append(s);
		vert.setValue(vert.getMaximum());
	}

	@Override
	public void updateWheelData(double[] vel, int[] status) {
		for(int i = 0; i < 4; i++){
			wheelVels[i].setText(String.format("%.2f" , vel[i]));
			wheelStates[i].setText(statesList[(status[i])]);
		}
		
	}

}
