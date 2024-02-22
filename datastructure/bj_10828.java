package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // 명령 개수
		int[] stack = new int[n];

		int cursor = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄만 받아와서 공백을 기준으로 문자열 분리

			String command = st.nextToken();
			if (command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack[cursor] = num;
				cursor++;
			} else if (command.equals("pop")) {
				if (cursor == 0) {
					bw.write("-1\n");
				} else {
					bw.write(stack[cursor - 1] + "\n");
					cursor--;
				}
			} else if (command.equals("size")) {
				bw.write(cursor + "\n");
			} else if (command.equals("empty")) {
				if (cursor == 0) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (command.equals("top")) {
				if (cursor == 0) {
					bw.write("-1\n");
				} else {
					bw.write(stack[cursor - 1] + "\n");
				}
			}
		}
		bw.close();
	}
}
