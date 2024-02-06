import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_1406 {남
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// arr = string 입력받기
		LinkedList<Character> charList = new LinkedList<>();
		String str = st.nextToken();
		for(int i=0; i<str.length(); i++) {
			charList.add(str.charAt(i));
		}
		// 커서 위치 = string.length
		int cursor = str.length();
		// 명령 개수 입력받기
		int order_num = Integer.parseInt(br.readLine());

		for(int i=0; i<order_num; i++) {
			String order = br.readLine(); // 명령어 입력받기
			char keyword = order.charAt(0); // keyword = 명령어[0]
			if(keyword == 'L') {if(cursor >= 0) cursor--;}
			else if(keyword == 'D') {if(cursor <= str.length()) cursor++;}
			else if(keyword == 'B') {if(cursor >= 0) charList.remove(cursor-1);}
			else {
				char x = order.charAt(2);
				charList.add(cursor, x);
				cursor++;
			}
		}
		for(char ele: charList){
			bw.write(ele);
		}
		bw.close();
	}
}
