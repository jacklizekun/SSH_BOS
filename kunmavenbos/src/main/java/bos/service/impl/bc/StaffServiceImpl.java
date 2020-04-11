package bos.service.impl.bc;

import java.util.List;

import bos.domain.bc.Staff;
import bos.page.PageRequestBean;
import bos.page.PageResponseBean;
import bos.service.base.BaseService;
import bos.service.bc.StaffService;

public class StaffServiceImpl extends BaseService implements StaffService {

	@Override
	public void saveOrUpdate(Staff staff) {
		staffDAO.saveOrUpdate(staff);
	}

	@Override
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, staffDAO);
	}

	@Override
	public void delBatch(String[] ids) {
		// 修改每个id 对应 取派员 deltag 为 1
		for (String id : ids) {
			Staff staff = staffDAO.findById(id);
			staff.setDeltag("1");
		}
	}

	@Override
	public List<Staff> findAllNoDeleteStaffs() {
		// 查询条件 deltag = 0
		return staffDAO.findByNamedQuery("Staff.findNoDelete");
	}

}
