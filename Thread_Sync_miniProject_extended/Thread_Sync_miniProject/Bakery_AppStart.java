package Threadexe;

public class Bakery_AppStart {

	public static void main(String[] args) {
		Bakery bakery = new Bakery();
		bakery.add("������");
		bakery.add("ī���׶�");
		bakery.add("���û�");
		bakery.add("�ٰ�Ʈ");
		
		Thread [] students = new Thread[] {
				new Thread(new Student(bakery, "Jin")),
				new Thread(new Student(bakery, "Suga")),
				new Thread(new Student(bakery, "RM")),
				new Thread(new Student(bakery, "V")),
				new Thread(new Student(bakery, "JK"))
		};
		
		for (Thread thread : students) {
			thread.start();
		}
		
	
		while(true) {
			boolean isReadyAll = true;
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Thread thread : students) {
				if(thread.getState()!=Thread.State.WAITING) {
					isReadyAll=false;
					break;
				}
			}
			if(isReadyAll) {
				break;
			}
		}
		synchronized (bakery) {
			bakery.notify();
		}
	}

}
