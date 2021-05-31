/**
 * 
 */
package ProducerConsumerBlockingQueue;

/**
 * @author yangs
 *
 */
public class Consumer implements Runnable {
	private Storage storage;

	public Consumer() {
	}

	public Consumer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(1000);
				storage.consumer();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

}
