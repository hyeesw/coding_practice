import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1978 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int RANGE = 1000;

	public static void main(String[] args) throws IOException {
		int[] arr = new int[RANGE + 1];
		Arrays.fill(arr, 1);
		arr[1] = 0; //1 not 소수처리

		//소수만 남긴 배열 만들기.
		int i = 2;
		while (i <= RANGE) {
			if (arr[i] == 1) {
				int quotient = RANGE / i;
				for (int j = 2; j <= quotient; j++) {
					arr[i * j] = 0;
				}
			}
			i++;
		}
		// 입력값이 소수인지 판별
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		while (n > 0) {
			int num = Integer.parseInt(st.nextToken());
			if (arr[num] == 1) {
				res++;
			}
			n--;
		}
		bw.write(String.valueOf(res));
		bw.close();
	}
}
