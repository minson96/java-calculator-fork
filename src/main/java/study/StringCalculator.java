package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	static FastReader scan = new FastReader();

	static String string;
	static String separator;
	public static int sum;

	static void input() {
		string = scan.next();
	}

	static boolean checkException(String[] numbers) {
		for (String number : numbers) {
			if (!number.equals(",") && !number.equals(":") && !number.equals(separator)) {
				try {
					int num = Integer.parseInt(number);
					if (!(num >= 0 && num <= 9)) {
						return false;
					}
				} catch (NumberFormatException e) {
					return false;
				}
			}
		}
		return true;
	}

	static void findSeparator() {
		Pattern pattern = Pattern.compile("//(.*?)(\\n|$)");
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			separator = matcher.group(1);
			char c = separator.charAt(0);
			separator = String.valueOf(c);
			string = string.substring(5);
		} else {
			separator = ",|:";
		}
	}

	public static void main(String[] args) {
		input();
		if (string != null) {
			findSeparator();

			String[] numbers = string.split(separator);
			if (checkException(numbers)) {
				for (String number : numbers) {
					if (!number.equals(",") && !number.equals(":")) {
						int temp = Integer.parseInt(number);
						if (temp < 0) {
							throw new IllegalArgumentException("음수 타입입니다.");
						}
						sum += temp;
					}
				}
				System.out.print(sum);
			} else {
				throw new IllegalArgumentException("잘못된 타입입니다.");
			}
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
	}
}
