import java.util.HashSet;
import java.util.Iterator;

public class Bakery {
	private HashSet<String> breadWarmmer;
	
	public Bakery() {
		breadWarmmer = new HashSet<String>();
	}
	
	public void add(String breadName) {
		synchronized (this) {
			breadWarmmer.add(breadName);
		}
	}
	
//	public synchronized String getBread() {
	public String getBread() {
		String bread = null;
		
		synchronized (this) {//���⼭ ����ȭ �ϴ� ���� �����̴�.
			if(breadWarmmer.size()>0) {
				try {
					Iterator<String> it= breadWarmmer.iterator();
					if(it.hasNext()) {
						bread=it.next();
						breadWarmmer.remove(bread);
					}
				} catch (Exception e) {
					System.out.println("���� �� �ִ� ���� �����ϴ�.");
				}
			}
		}
		return bread;
	}
}
