/**
 * 
 */
package ProducerConsumerPipLine;

import java.io.IOException;

/**
 * @author yangs
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);

		try {
			producer.getPipedOutputStream().connect(consumer.getPipedInputStream());
			t2.start();
			t1.start();

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
