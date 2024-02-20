package dataStructure;

import java.util.ArrayList;
import java.util.Vector;

public class Vector_ArrayList {
	// vector와 ArrayList의 차이점인 Thread-safe Test 코드
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		ArrayList<Integer> arrayList = new ArrayList<>();

		// 2개의 Thread를 Context switching해, arraylist 와 vector에 1을 증감한다.
		new Thread(()->{
			for(int i=0; i<10000; i++) {
				vector.add(1);
				arrayList.add(1);
			}
		}).start();
		new Thread(()->{
			for(int i=0; i<10000; i++) {
				vector.add(1);
				arrayList.add(1);
			}
		}).start();

		new Thread(()->{
			try {
				// 2초 동안 3번 Thread는 스케쥴링이 되지 않고, 1,2번 Thread만 신명나게 돌아감.
				Thread.sleep(2000);
				System.out.println("Vector size : " + vector.size());
				System.out.println("ArrayList size : " + arrayList.size());
			} catch (InterruptedException ignored) {}
		}).start();
	}
	/*
	실행결과:
	Vector size : 20000
	ArrayList size : 19412
	add() 메소드를 실행하는 과정에서 context switch가 발생했기 때문에 일부 값이 add 된 후 저장되지 못한 현상을 arraylist에서 확인할 수 있다.
	 */
}
