package ui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import model.Flag;
import thread.FlagThread;

public class FlagGUI {
	
	public final static String ESC   = "\u001b[";
	public final static int YELLOW = 43;
	public final static int BLUE = 44;
	public final static int RED = 41;
	
	FlagThread yellowLine;
	FlagThread blueLine;
	FlagThread redLine;
	
	Flag f;
	BufferedWriter bw;
	
	public FlagGUI() throws IOException {
		f = new Flag();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		yellowLine = new FlagThread(f, YELLOW, 5, 14, 0, this);
		blueLine = new FlagThread(f, BLUE, 15, 7, 14, this);
		redLine = new FlagThread(f, RED, 20, 7, 21, this);
		//Clear interface
		bw.write(ESC + "2J"); 
		bw.flush();
	}
	
	public void startProgram() {
		yellowLine.start();
		blueLine.start();
		redLine.start();
	}
	
	public synchronized void updateGUI(String msg, int x, int y) throws IOException {
		bw.write(ESC + x + "G" + ESC + y + "d");
		bw.write(msg);
		bw.flush();
	}
	
	public void positionCursor(int x, int y) throws IOException {
		bw.write(ESC + x + "G" + ESC + y + "d");
	}
	
}
