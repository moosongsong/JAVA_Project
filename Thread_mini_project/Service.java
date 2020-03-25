
public abstract class Service implements Runnable{
	protected Customer customer=null;
	
	public void requestUser(Customer customer) {
		this.customer=customer;
	}
	public abstract String getServiceName();
	
}


