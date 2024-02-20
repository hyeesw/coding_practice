package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorArrayList {
	// vector와 ArrayList의 차이점인 Thread-safe Test 코드
	public static void main(String[] args) throws InterruptedException {
		Vector<Integer> vector = new Vector<>();
		ArrayList<Integer> arrayList = new ArrayList<>();

		threadSafe(arrayList, vector);
		/*
			Vector size : 20000
			ArrayList size : 19412
			add() 메소드를 실행하는 과정에서 context switch가 발생했기 때문에 일부 값이 add 된 후 저장되지 못한 현상을 arraylist에서 확인할 수 있다.
		*/
		System.out.println("--------------------------------");
		compareSpeed(arrayList, vector);
		/*
			ArrayList 속도 : 125m/s
			vector 속도 : 277m/s
			메소드가 동기로 동작하기 때문에 Vector가 ArrayList보다 느리다. (거의 2배..)
		 */
	}

	public static void threadSafe(ArrayList<Integer> arrayList, Vector<Integer> vector) throws InterruptedException {
		// 2개의 Thread를 Context switching해, arraylist 와 vector에 1을 증감한다.
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				vector.add(1);
				arrayList.add(1);
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				vector.add(1);
				arrayList.add(1);
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println("Vector size : " + vector.size());
		System.out.println("ArrayList size : " + arrayList.size());
	}

	public static void compareSpeed(ArrayList<Integer> arrayList, Vector<Integer> vector) {
		System.out.println("ArrayList 속도 : " + countTime(arrayList) + "m/s"); // 밀리세컨드 출력
		System.out.println("vector 속도 : " + countTime(vector) + "m/s"); // 밀리세컨드 출력
	}

	public static long countTime(List<Integer> list) {
		long startTime = System.currentTimeMillis(); // 코드 시작 시간
		for (int i = 0; i < 10000000; i++) {
			list.add(1);
		}
		long endTime = System.currentTimeMillis(); // 코드 끝난 시간
		return endTime - startTime;
	}
}
