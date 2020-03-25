package File_IOStream_Thread_Sync_miniProject;

import java.io.IOException;
import java.util.List;

public class User implements Runnable {
	private String name;
	private FileObject fobj;
	
	public User(FileObject fobj, String name) {
		this.fobj=fobj;
		this.name = name;
	}
	@Override
	public void run() {
		while(true) {
			try {
				List<Object> list = fobj.getObjects();
				for (Object object : list) {
					System.out.print(object+" ");
				}
				System.out.println("");
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
