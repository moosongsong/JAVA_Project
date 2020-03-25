
public class AfterService extends Service{
	public final static String NAME = "AfterService";
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
		return "After Service";
	}

}
