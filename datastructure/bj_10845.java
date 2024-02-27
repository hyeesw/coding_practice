package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); // 명령 개수
		int[] queue = new int[n];
		// cursor 설정
		int fc = 0;
		int bc = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "push" -> {
					int num = Integer.parseInt(st.nextToken());
					queue[bc] = num;
					bc++;
				}
				case "pop" -> {
					if (fc == bc) {
						bw.write("-1\n");
					} else {
						bw.write(queue[fc] + "\n");
						fc++;
					}
				}
				case "size" -> bw.write(bc - fc + "\n");
				case "empty" -> {
					if (fc == bc) {
						bw.write("1\n");
					} else {
						bw.write("0\n");
					}
				}
				case "front" -> {
					if (fc == bc) {
						bw.write("-1\n");
					} else {
						bw.write(queue[fc] + "\n");
					}
				}
				case "back" -> {
					if (fc == bc) {
						bw.write("-1\n");
					} else {
						bw.write(queue[bc - 1] + "\n");
					}
				}
			}
		}
		bw.close();
	}
}
