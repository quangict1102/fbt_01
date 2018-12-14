package app.service;

import java.util.List;

import app.bean.BillInfo;
import app.model.Bill;

public interface BillService extends BaseService<Integer, Bill>{
	List<BillInfo> loadAll();
	
	List<Object []> loadAllbyTime();
}
