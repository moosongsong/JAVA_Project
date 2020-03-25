
public class DeliveryService extends Service{
	public final static String NAME = "DeliveryService";
	@Override
	public void run() {
		
		for (int i = 0; i < 4; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
			System.out.println(getServiceName()+","+customer.getName());
		}
		
		
	}

	@Override
	public String getServiceName() {
		return "Delivery Service";
	}

}
