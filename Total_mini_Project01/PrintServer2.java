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
			System.out.println("����Ʈ ������ 9000�� ��Ʈ�� ������Դϴ�...");

			while (true) {

				Socket clientSocket = printServerSocket.accept();
				System.out.println(clientSocket.getInetAddress().getHostName() + "�� �����߽��ϴ�.");

				socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()), 128);

				while (true) {

					String str = socketIn.readLine();
					if (str.trim().toUpperCase().equals("DATA_OUTPUT_FINISHED")) {
						System.out.println("��� �л����� ���� ����� �������ϴ�.");
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
