package app.service.impl;

import java.io.Serializable;
import java.util.List;

import app.bean.BillInfo;
import app.model.Bill;
import app.service.BillService;

public class BillServiceImpl extends BaseServiceImpl implements BillService{

	@Override
	public Bill findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill saveOrUpdate(Bill entity) {
		// TODO Auto-generated method stub
		return getBillDAO().saveOrUpdate(entity);
	}

	@Override
	public boolean delete(Bill entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BillInfo> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object []> loadAllbyTime() {
		return getBillDAO().loadAllbyTime();
	}

}
