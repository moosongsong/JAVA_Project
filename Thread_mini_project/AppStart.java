
public class AppStart {

	public static void main(String[] args) {
		ServicePool servicePool = new ServicePool();
		Customer c1 = new Customer("C1");
		Customer c2 = new Customer("C2");
		Customer c3 = new Customer("C3");
		Customer c4 = new Customer("C4");
		
		Service s = servicePool.serviceRequest("OrderService");
		s.requestUser(c1);
		Thread t1 = new Thread(s);
		System.out.println(s.customer.getName());
		
		Service s2 = servicePool.serviceRequest("AfterService");
		s2.requestUser(c2);
		Thread t2 = new Thread(s2);
		System.out.println(s2.customer.getName());
		
		Service s3 = servicePool.serviceRequest("DeliveryService");
		s3.requestUser(c3);
		Thread t3 = new Thread(s3);
		System.out.println(s3.customer.getName());
		
		Service s4 = servicePool.serviceRequest("OrderService");
		s4.requestUser(c4);
		Thread t4 = new Thread(s4);
		System.out.println(s4.customer.getName());
		
		t1.start(); 
		t2.start();
		t3.start();
		
		
		
		
		
		
//		
	}

}
