/**
 * 
 */
package ProducerConsumerPipLine;

import java.io.PipedOutputStream;

/**
 * @author yangs
 *
 */
public class Producer implements Runnable {

	private PipedOutputStream pipedOutputStream;

	public Producer() {
		pipedOutputStream = new PipedOutputStream();

	}

	/**
	 * @return the pipedOutputStream
	 */
	public PipedOutputStream getPipedOutputStream() {
		return pipedOutputStream;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i <= 5; i++) {
				String string = new String("This is a test, Id=" + i + "!");
				System.out.println("输入内容：" + string);
				pipedOutputStream.write(string.getBytes());
			}
			pipedOutputStream.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
