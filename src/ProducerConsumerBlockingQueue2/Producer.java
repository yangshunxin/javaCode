/**
 * 
 */
package ProducerConsumerBlockingQueue2;

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
		int sequence = 1;
		while (true) {
			String nameString = Thread.currentThread().getName();
			Goods goods = new Goods(sequence, nameString);
			System.out.println("put in queue name:" + nameString + " sequence:" + sequence);
			storage.putDataBlock(goods);
			sequence += 1;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
