/**
 * 
 */
package producerConsumerAwaitSignal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

	// 锁---可重入锁 锁上等待时间最长的线程将获得锁的使用权
	// 可重入锁：可以反复得到相同的一把锁，它有一个与锁相关的获取计数器，如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，然后锁需要被释放两次才能获得真正释放(重入锁)
	private final Lock lock = new ReentrantLock();

	/**
	 * Condition由ReentrantLock对象创建,并且可以同时创建多个
	 * Condition接口在使用前必须先调用ReentrantLock的lock()方法获得锁
	 * 之后调用Condition接口的await()将释放锁,并且在该Condition上等待,直到有其他线程调用Condition的signal()方法唤醒线程
	 * */

	// 仓库满的条件变量
	private final Condition fullCondition = lock.newCondition();
	// 仓库空的条件变量
	private final Condition emptyCondition = lock.newCondition();

	public void produce(int index, String produceNameString) {
		// 获取锁
		lock.lock();
		while (list.size() + 1 > MAXSIZE) {
//				System.out.println("***【生产者 " + Thread.currentThread().getName() + "】 仓库已满");

			try {
				fullCondition.await();// 释放锁，并在fullCondition上等待
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();

			}
		}
		list.add(new Goods(index, Thread.currentThread().getName(), goodSequence));
		goodSequence++;
//		System.out.println(
//				"***【生产者 " + Thread.currentThread().getName() + "】生产一个产品，序号为: " + index + "现库存" + list.size());
		emptyCondition.signalAll();
		lock.unlock();

	}

	public void consumer() {
		// 获取锁
		lock.lock();
		while (list.size() == 0) {
			System.out.println("【消费者" + Thread.currentThread().getName() + "】仓库为空");
			try {
				emptyCondition.await();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Goods goods = list.remove();
		System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，序号为：" + goods.getSequence() + " 生产者为："
				+ goods.getProduceName() + " 序号为:" + goods.getIndex() + " 现库存" + list.size());
		fullCondition.signalAll();
		lock.unlock();
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
