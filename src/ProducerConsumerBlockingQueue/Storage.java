/**
 * 
 */
package ProducerConsumerBlockingQueue;

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

	private Integer goodSequence = 0;

	public void produce(int index, String produceNameString) {
		Integer tmpGoodSequence = 0;
		synchronized (goodSequence) {
			goodSequence++;
			tmpGoodSequence = goodSequence;
		}
		try {
			// 容量达到最大时，自动阻塞
			list.put(new Goods(index, Thread.currentThread().getName(), tmpGoodSequence));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***【生产者 " + Thread.currentThread().getName() + "】生产一个产品，总序号为: " + tmpGoodSequence + " 线程序号："
				+ index + " 现库存" + list.size());
	}

	public void consumer() {
		try {

			// 如果为空，自动阻塞
			Goods goods = list.take();

			System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，序号为：" + goods.getSequence()
					+ " 生产者为：" + goods.getProduceName() + " 序号为:" + goods.getIndex() + " 现库存" + list.size());
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

	}

}

class Goods {
	private int index = 0; // 制造者的顺序
	private String produceNameString;
	private int sequence = 0; // 总的排序

	public Goods() {
	};

	public Goods(int index, String produceNameString, int sequence) {
		this.index = index;
		this.produceNameString = produceNameString;
		this.sequence = sequence;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	public String getProduceName() {
		return produceNameString;
	}

	/**
	 * @return the sequence
	 */
	public int getSequence() {
		return sequence;
	}

}
