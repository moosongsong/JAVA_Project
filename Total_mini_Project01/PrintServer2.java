import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class PrintServer2 {

	public static void main(String[] args) {

		ServerSocket printServerSocket = null;
		BufferedReader socketIn = null;

		try {
			printServerSocket = new ServerSocket(9000);
			System.out.println("프린트 서버가 9000번 포트로 대기중입니다...");

			while (true) {

				Socket clientSocket = printServerSocket.accept();
				System.out.println(clientSocket.getInetAddress().getHostName() + "가 접속했습니다.");

				socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()), 128);

				while (true) {

					String str = socketIn.readLine();
					if (str.trim().toUpperCase().equals("DATA_OUTPUT_FINISHED")) {
						System.out.println("모든 학생들의 정보 출력이 끝났습니다.");
						break;
					}
					System.out.println(str);
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {printServerSocket.close();} catch(Exception e) {}
		}
	}
}
