//join�� �̿��� ����ȭ
public class Bakery_AppStart {

	public static void main(String[] args) {
		Bakery bakery = new Bakery();
		bakery.add("������");
		bakery.add("ī���׶�");
		bakery.add("���û�");
		bakery.add("�ٰ�Ʈ");
		
		//chain
		Thread t1 = new Thread(new Student(bakery, "Jin", Thread.currentThread()));
		Thread t2 = new Thread(new Student(bakery, "Suga", t1));
		Thread t3 = new Thread(new Student(bakery, "Hope", t2));
		Thread t4 = new Thread(new Student(bakery, "JK", t3));
		Thread t5 = new Thread(new Student(bakery, "JIMIN", t4));
		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		t5.start();//å�ӿ��� ����
		//fly weight Pattern
		
		System.out.println("main is end");
	}

}
