package infrastructure.pc;

import org.junit.Test;

/**
 * @Author: Alex.Z
 * @DATE: 2019/10/14
 * @Description:
 */
public class MainTest {


	@Test
	public void test(){

		Storage<Integer> storage = new Storage<>(1);

		Thread[] producers=new Thread[15];
		for (int i = 0; i < 15; i++) {
			producers[i] = (new Producer(i,storage));
			producers[i].setName("producer"+i);
		}

		Thread[] consumers = new Thread[1];
		for (int i = 0; i < 1; i++) {
			consumers[i] = (new Consumer(storage));
			consumers[i].setName("consumer"+i);
		}

		for(Thread consumer : consumers){
			consumer.start();
		}

		for(Thread producer : producers){
		    producer.start();
		}

		for(Thread producer : producers){
			try {
				producer.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for(Thread consumer : consumers){
			try {
				consumer.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
