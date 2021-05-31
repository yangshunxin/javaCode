/**
 * 
 */
package ProducerConsumerBlockingQueue2;

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
			Goods goods = this.storage.getDataBlock();
			System.out.println("***consumer goods name: " + goods.getProduceName() + " sequence:" + goods.getIndex());
		}
	}

}
