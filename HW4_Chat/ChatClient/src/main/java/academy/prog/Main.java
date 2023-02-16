package academy.prog;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter your login: ");
			String login = scanner.nextLine();

			Thread th = new Thread(new GetThread(login));
			th.setDaemon(true);
			th.start();

			System.out.println("Enter your message: ");
			while (true) {
				String allText = scanner.nextLine();
				if (allText.isEmpty()) break;

				// users
				// @test Hello

				if (allText.equals("/users")) {
					new GetThread(login).getUsersList();
					continue;
				}

				String to = "All";
				String textMessage = "";
				if(allText.startsWith("@")) {
					char[] textFromChar = allText.toCharArray();
					for(int i = 0; i<textFromChar.length; i++) {
						if(textFromChar[i]==' '){
							to = new String (Arrays.copyOfRange(textFromChar,1,i));
							textMessage = new String (Arrays.copyOfRange(textFromChar,i+1,textFromChar.length));
							break;
						}
					}
				} else {
					textMessage = allText;
				}

				Message m = new Message(login, textMessage, to);
				int res = m.send(Utils.getURL() + "/add");

				if (res != 200) { // 200 OK
					System.out.println("HTTP error occurred: " + res);
					return;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}

