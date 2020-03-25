package File_IOStream_Thread_Sync_miniProject;

import java.io.IOException;
import java.util.Random;

public class Sender implements Runnable{
	private FileObject fobj;
	private String name;
	
	public Sender(FileObject fobj, String name) {
		this.fobj = fobj;
		this.name = name;
	}

	@Override
	public void run() {
		Random rand = new Random();
		while(true) {
			int r = rand.nextInt();
			try {
				fobj.saveObjects(r);
				System.out.println(name);
			} catch (IOException e) {
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
