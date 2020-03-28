import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;
import java.util.TreeSet;

public class PrintOutput2 implements Printable {
	
	public void print(TreeSet<Student> set) {
		
		Socket socket = null;
		BufferedWriter out = null;
		
		try {
			socket = new Socket(InetAddress.getLoopbackAddress(), 9000);
			System.out.println(InetAddress.getLoopbackAddress().getHostName() + "������ ����Ǿ����ϴ�.");
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 128);
			
			Iterator<Student> it = set.iterator();
			
			while(it.hasNext()) {
				
				Student temp = it.next();
				out.write("=======�л� ����=======\n");
				
				out.write("�л��� : " + temp.getName() + "\n");
				out.write("�й� : " + temp.getsID() + "\n");
				out.write("���� : " + temp.getMajor() + "\n");
				out.write("���� : " + temp.getScore() + "\n");
				
				out.flush();
			}
			out.write("DATA_OUTPUT_FINISHED");
			out.flush();
			System.out.println("��� �л� ������ ����Ʈ ������ �����߽��ϴ�.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {socket.close();} catch(Exception e) {}
		}
		
		
	}
}
