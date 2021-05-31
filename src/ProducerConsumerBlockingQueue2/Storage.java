/**
 * 
 */
package ProducerConsumerBlockingQueue2;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yangs
 *
 */
public class Storage {
	// 仓库容量
	private final int MAXSIZE = 10;
	// 仓库存储的载体
	private LinkedBlockingQueue<Goods> list = new LinkedBlockingQueue<Goods>();

	public void putDataBlock(Goods goods) {
		try {
			list.put(goods);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Goods getDataBlock() {
		Goods goods = null;

		try {
			goods = list.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}
}
