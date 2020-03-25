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
		//��� ��Ʈ���� �����ϴ� ���
		//�Է� ��Ʈ���� �����ϴ� ���
		//��� ��Ʈ���� �ݴ� ���
		//�Է� ��Ʈ���� �ݴ� ���
	public synchronized void saveObjects(Object obj) throws IOException {
		//�Է� ��Ʈ�� �ݱ� (����:�Է½�Ʈ���� ������ ���)
		//��½�Ʈ�� ��� (���� : ��� ��ũ���� �������� ���� ���)
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
