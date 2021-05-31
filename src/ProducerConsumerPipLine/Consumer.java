/**
 * 
 */
package ProducerConsumerPipLine;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author yangs
 *
 */
public class Consumer implements Runnable {

	private PipedInputStream pipedInputStream;

	public Consumer() {
		pipedInputStream = new PipedInputStream();
	}

	/**
	 * @return the pipedInputStream
	 */
	public PipedInputStream getPipedInputStream() {
		return pipedInputStream;
	}

	@Override
	public void run() {
		int len = -1;
		byte[] buffer = new byte[1024];
		try {
			Thread.sleep(1000);
			// 一次性把 pipLine中的数据都读取过来了，，，
			while ((len = pipedInputStream.read(buffer)) != -1) {
				String string = new String(buffer, 0, len);
				System.out.println("***输出内容：" + string);
			}
			pipedInputStream.close();
		} catch (IOException | InterruptedException e) {
			// TODO: handle exception
			System.out.println("Consumer error");
			e.printStackTrace();
		}

	}

}
