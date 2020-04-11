package service.impl.bc;

import java.util.List;

import domain.bc.Staff;
import page.PageRequestBean;
import page.PageResponseBean;
import service.base.BaseService;
import service.bc.StaffService;

public class StaffServiceImpl extends BaseService implements StaffService {

	@Override
	public void saveOrUpdate(Staff staff) {
		staffDAO.saveOrUpdate(staff);
	}
	//分页查询
	@Override
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, staffDAO);
	}
	//删除取派员
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
