package ch.fhnw.richards.lecture10_threads;

public class ThreadStopper extends Thread {
	private TestThread t;
	
	public static void main(String[] args) {
		new ThreadStopper();
	}
	
	private ThreadStopper() {
		t = new TestThread();
		t.start();
		this.start();
	}
	
	@Override
	public void run() {
		// first wait 50ms;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		
		// try to stop the other thread
		int attempts = 0;
		while (t.isAlive()) {
			attempts++;
			t.stop = true;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Attempts " + attempts);
	}	
	
	private static class TestThread extends Thread {
		private boolean stop = false; // may not stop unless this is "volatile"
		private int counter;
		
		@Override
		public void run() {
			while (!stop) {
				counter++;
			}
		}
	}
}
