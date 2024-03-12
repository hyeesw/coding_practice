import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_2839 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int quotient = N / 5; //몫
		int res = 0; //정답

		// 5로 나눈 몫에서 1씩 줄여가며 최대 자연수 찾기 (brute force)
		for (int i = quotient; i >= 0; i--) {
			if ((N - 5 * i) % 3 == 0) {
				res = i + (N - 5 * i) / 3;
				break;
			}
		}
		bw.write(res == 0 ? "-1" : String.valueOf(res));
		bw.close();
	}
}
