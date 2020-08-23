import java.util.Timer;
import java.util.TimerTask;

public class DropTimer {

	private static int DROP_TIME = 1500;

	private Timer dropTimer;
	private TimerTask task;
	private TetrisBrain tetrisBrain;

	public DropTimer(TetrisBrain tetrisBrain) {
		setTetrisBrain(tetrisBrain);
		initiateTask();
		dropTimer = new Timer();
	}

	private void initiateTask() {
		task = new TimerTask() {
			@Override
			public void run() {
				tetrisBrain.movePiece(TetrisDirectionsEnum.DOWN);
			}
		};
	}

	public void startTimer() {
		dropTimer.schedule(task, 0, DROP_TIME);
	}

	// GETTERS AND SETTERS

	public void setTetrisBrain(TetrisBrain tetrisBrain) {
		this.tetrisBrain = tetrisBrain;
	}

}
