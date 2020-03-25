package File_IOStream_Thread_Sync_miniProject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class FileObject {
	private File file;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public FileObject(String fileName) throws FileNotFoundException, IOException {
		this.file = new File(fileName);
//		this.in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		this.out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
	}
		//출력 스트림을 생성하는 기능
		//입력 스트림을 생성하는 기능
		//출력 스트림을 닫는 기능
		//입력 스트림을 닫는 기능
	public synchronized void saveObjects(Object obj) throws IOException {
		//입력 스트림 닫기 (조건:입력스트림이 생성된 경우)
		//출력스트림 취득 (조건 : 출력 스크림이 존재하지 않을 경우)
		out.writeObject(obj);
		out.flush();
	}
	
	public List<Object> getObjects() throws ClassNotFoundException, IOException {
		LinkedList<Object>list = new LinkedList<>();
		synchronized (this) {
			while(true) {
				try {
					Object o = in.readObject();
					list.add(o);
				}catch (EOFException e){
					break;
				}
			}
		}
		return list;
	}
	
	public synchronized void close() {
		try {
			in.close();
		} catch (IOException e) {
			;
		}
		try {
			out.close();
		} catch (IOException e) {
			;
		}
	}
	
	
}
