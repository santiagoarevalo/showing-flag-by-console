package thread;

import java.io.IOException;

import model.Flag;
import ui.FlagGUI;

public class FlagThread extends Thread {
	
	private Flag f;
	private int color;
	private int sleep;
	private int height;
	private int max;
	private int x;
	private int y;
	
	private FlagGUI fGUI;
	
	public FlagThread(Flag f, int color, int sleep, int height, int firstY, FlagGUI fGUI) {
		this.f = f;
		this.color = color;
		this.sleep = sleep;
		this.height = height;
		max = 120;
		x = 1;
		y = firstY;
		this.fGUI = fGUI;
	}
	
	@Override
	public void run() {
		try {
			showFlag();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showFlag() throws IOException, InterruptedException {
		fGUI.positionCursor(x, y);
		int firstY = y;
		int columns = 1;
		
		while(columns < max) {
			columns++;
			for(int i = 0; i < height; i++) {
				fGUI.updateGUI(f.showLine(color), x, y);
				Thread.sleep(sleep);
				y++;
			}
			x++;
			y = firstY;
		}
	}
}
