import java.io.*;

public class FileWriterDo{
	public static void main(String [] args) {
		String what1 = new String("�ȳ��ϽŰ���?\r\n");
		String what2 = new String("�ڹ� ��Ʈ��ũ ���α׷����� Ǯ�� �ֽ��ϴ�.");
		
		try {
			FileWriter fw = new FileWriter("./bin/data/software_write.txt", true);
			fw.write(what1);
			fw.write(what2);
			fw.close();
			System.out.println("Done : check software.txt");
		}
		catch(IOException ie) {
			System.out.println("���ܳ�? �̰Ͷ���:"+ie);
		}
				
	}
}