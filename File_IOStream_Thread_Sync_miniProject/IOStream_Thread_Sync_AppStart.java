package File_IOStream_Thread_Sync_miniProject;

import java.io.IOException;

public class IOStream_Thread_Sync_AppStart {
	public static void main(String [] args) {
		try {
			FileObject fobj = new FileObject("C:\\bigdataprograming\\data.txt");
			new Thread(new Sender(fobj, "jin_제공자1")).start();
			new Thread(new Sender(fobj, "jin_제공자2")).start();
//			new Thread(new User(fobj, "Suga_사용자")).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
