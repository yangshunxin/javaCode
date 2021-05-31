/**
 * 
 */
package producerConsumerWaitNotify;

/**
 * @author yangs
 *
 */
public class Producer implements Runnable {
	private Storage storage;

	int goodIndex = 0;

	public Producer() {
	}

	public Producer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);
				storage.produce(goodIndex, Thread.currentThread().getName());
				goodIndex++;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
