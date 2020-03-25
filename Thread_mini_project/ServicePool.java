import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServicePool {
	private Map<String, Service> pool
	= new HashMap<String, Service>();
	
	public synchronized Service serviceRequest (String type) {
		Service temps=null;
		Set<String> keySet = pool.keySet();
		
		if(keySet.contains(type)) {
			return pool.get(type);
		}
		
		if(type.equals(OrderService.NAME)) {
			temps=new OrderService();
			pool.put(type, temps);
		}
		else if(type.equals(AfterService.NAME)) {
			temps=new AfterService();
			pool.put(type, temps);
		}
		else if(type.equals(DeliveryService.NAME)) {
			temps=new DeliveryService();
			pool.put(type, temps);
		}else {
			System.out.println("Wrong insert");
			return null;
		}
		return temps;
	}

	public Map<String, Service> getPool() {
		return pool;
	}

	public void setPool(Map<String, Service> pool) {
		this.pool = pool;
	}
	
	
}
