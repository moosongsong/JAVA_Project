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
			System.out.println(InetAddress.getLoopbackAddress().getHostName() + "서버에 연결되었습니다.");
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 128);
			
			Iterator<Student> it = set.iterator();
			
			while(it.hasNext()) {
				
				Student temp = it.next();
				out.write("=======학생 정보=======\n");
				
				out.write("학생명 : " + temp.getName() + "\n");
				out.write("학번 : " + temp.getsID() + "\n");
				out.write("전공 : " + temp.getMajor() + "\n");
				out.write("점수 : " + temp.getScore() + "\n");
				
				out.flush();
			}
			out.write("DATA_OUTPUT_FINISHED");
			out.flush();
			System.out.println("모든 학생 정보를 프린트 서버에 연결했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {socket.close();} catch(Exception e) {}
		}
		
		
	}
}
