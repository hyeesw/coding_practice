package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 문제에서 요구하는 배열 size가 26으로 고정이고, 요소 추가/삽입이 없으므로 resizing이 필요 없음. => 배열이 적합
public class bj_73017575 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();
		int[] arr = new int[26];

		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			arr[idx]++;
		}

		for (int i = 0; i < 26; i++) {
			bw.write(arr[i] + " ");
		}
		bw.close();
	}
}
