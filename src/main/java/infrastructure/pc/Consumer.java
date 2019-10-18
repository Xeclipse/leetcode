package infrastructure.pc;

import static java.lang.Thread.sleep;

/**
 * @Author: Alex.Z
 * @DATE: 2019/10/14
 * @Description:
 */
public class Consumer extends Thread {

	Storage<Integer> storage;

	public void setStorage(Storage<Integer> storage) {
		this.storage = storage;
	}


	public Consumer(Storage<Integer> storage) {
		this.storage = storage;
	}

	public Integer consume() throws InterruptedException {
		Integer ret=0;
		for (int i = 0; i < 75; i++){
			ret = storage.get();
			sleep(1000);
		}
		return ret;

	}

	@Override
	public void run() {
		try {
			this.consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
