/**
 * 
 */
package ProducerConsumerBlockingQueue2;

/**
 * @author yangs
 *
 */
public class Goods {
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
	 * @param sequence the sequence to set
	 */
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Goods(int index, String produceNameString) {
		this.index = index;
		this.produceNameString = produceNameString;
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
