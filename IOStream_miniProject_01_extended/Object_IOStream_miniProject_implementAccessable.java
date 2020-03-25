package 입출력연습;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class Object_IOStream_miniProject_implementAccessable implements Object_IOStream_miniProject_Accessable{

	@Override
	public void saveSchool(School school, String fileName) throws Exception {
		BufferedOutputStream bos =null;
		ObjectOutputStream oos = null;
		Iterator<Person_ob>it = school.getSchool().iterator();
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream(fileName), 2048);
			oos = new ObjectOutputStream(bos);
			while(it.hasNext()) {
				Person_ob temp = it.next();
				oos.writeObject(temp);
			}
			oos.flush();
			System.out.println("파일에 저장");
		} catch (IOException e) {
			System.out.println("Fail");
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				System.out.println("close Fail");
			}
		}
	}

	@Override
	public void restoreSchool(School school, String fileName) throws Exception {
		File file = new File(fileName);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis, 2048);
			ois = new ObjectInputStream(bis);

			while(true) {
				try {
					Person_ob person = (Person_ob) ois.readObject();
					if(person != null) {
						school.getSchool().add(person);
					}
				} catch (EOFException e) {
					System.out.println("모든 데이터를 읽어들임.");
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("input Fail");
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				System.out.println("close Fail");
			}
		}
	}

}
