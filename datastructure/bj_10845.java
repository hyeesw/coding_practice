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

		int fc = 0;
		int bc = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue[bc] = num;
				bc++;
			} else if (command.equals("pop")) {
				if (fc == bc) {
					bw.write("-1\n");
				} else {
					bw.write(queue[fc] + "\n");
					fc++;
				}
			} else if (command.equals("size")) {
				bw.write(bc - fc + "\n");
			} else if (command.equals("empty")) {
				if (fc == bc) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (command.equals("front")) {
				if (fc == bc) {
					bw.write("-1\n");
				} else {
					bw.write(queue[fc] + "\n");
				}
			} else if (command.equals("back")) {
				if (fc == bc) {
					bw.write("-1\n");
				} else {
					bw.write(queue[bc - 1] + "\n");
				}
			}
		}
		bw.close();
	}
}
