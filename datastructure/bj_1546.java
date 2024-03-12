package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1546 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int sum = 0;
		//st 객체는 지금 버퍼에 있는 값 대상으로 토크나이저를 하기 떄문에, 새로운 입력이 들어올 때마다 객체를 생성해야 함.
		// br.readline()으로 한 문장 가져와서 토크나이징.
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력 받으면서 계산
		for (int i = 0; i < n; i++) {
			int curNum = Integer.parseInt(st.nextToken());
			if (curNum > max)
				max = curNum; // max 갱신
			sum += curNum;
		}

		double result = sum * 100.0 / max / n;
		bw.write(String.valueOf(result));
		bw.close();
	}
}
