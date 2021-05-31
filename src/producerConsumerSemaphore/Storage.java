/**
 * 
 */
package producerConsumerSemaphore;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

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

	/**
	 * Semaphore是一种基于计数的信号量。它可以设定一个阈值，基于此，多个线程竞争获取许可信号，做完自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞。
	 * Semaphore可以用来构建一些对象池，资源池之类的，比如数据库连接池，我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示两种互斥状态。
	 * 计数为0的Semaphore是可以release的，然后就可以acquire（即一开始使线程阻塞从而完成其他执行。）
	 * 
	 * */
	// 仓库的最大容量
	final Semaphore notFullSemaphore = new Semaphore(MAXSIZE);
	// 将线程挂起，等待其它来触发
	final Semaphore notEmptySemaphore = new Semaphore(0);
	// 互斥锁
	final Semaphore mutexSemaphore = new Semaphore(1);

	public void produce(int index, String produceNameString) {
		try {
			notFullSemaphore.acquire();
			mutexSemaphore.acquire();
			list.add(new Goods(index, Thread.currentThread().getName(), goodSequence));
			goodSequence++;
//				System.out.println(
//						"***【生产者 " + Thread.currentThread().getName() + "】生产一个产品，序号为: " + index + "现库存" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mutexSemaphore.release();
			notEmptySemaphore.release();
		}
	}

	public void consumer() {
		try {
			notEmptySemaphore.acquire();
			mutexSemaphore.acquire();
			Goods goods = list.remove();
			System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，序号为：" + goods.getSequence()
					+ " 生产者为：" + goods.getProduceName() + " 序号为:" + goods.getIndex() + " 现库存" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mutexSemaphore.release();
			notFullSemaphore.release();
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
