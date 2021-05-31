/**
 * 
 */
package producerConsumerWaitNotify;

import java.util.LinkedList;

/**
 * @author yangs
 *
 */
public class Storage {
	// 仓库容量
	private final int MAXSIZE = 10;
	// 仓库存储的载体
	private LinkedList<Goods> list = new LinkedList<Goods>();

	private int goodSequence = 0;

	public void produce(int index, String produceNameString) {
		synchronized (list) {
			while (list.size() + 1 > MAXSIZE) {
//				System.out.println("***【生产者 " + Thread.currentThread().getName() + "】 仓库已满");

				try {
					list.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();

				}
			}
			list.add(new Goods(index, Thread.currentThread().getName(), goodSequence));
			goodSequence++;
//			System.out.println(
//					"***【生产者 " + Thread.currentThread().getName() + "】生产一个产品，序号为: " + index + "现库存" + list.size());
			list.notifyAll();
		}

	}

	public void consumer() {
		synchronized (list) {
			while (list.size() == 0) {
				System.out.println("【消费者" + Thread.currentThread().getName() + "】仓库为空");
				try {
					list.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			Goods goods = list.remove();
			System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，序号为：" + goods.getSequence()
					+ " 生产者为：" + goods.getProduceName() + " 序号为:" + goods.getIndex() + " 现库存" + list.size());
			list.notifyAll();
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
