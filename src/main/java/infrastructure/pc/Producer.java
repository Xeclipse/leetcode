package infrastructure.pc;

import static java.lang.Thread.sleep;

/**
 * @Author: Alex.Z
 * @DATE: 2019/10/14
 * @Description:
 */
public class Producer extends Thread {

	Integer ID;
	Storage<Integer> storage;

	public void setStorage(Storage<Integer> storage) {
		this.storage = storage;
	}

	public Producer(Integer ID, Storage<Integer> storage) {
		this.ID = ID;
		this.storage = storage;
	}


	public void produce() throws InterruptedException {
		for (int i = 0; i < 5; i++){
			storage.put(ID);
			sleep(1000);
		}
	}

	@Override
	public void run() {
		try {
			this.produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
