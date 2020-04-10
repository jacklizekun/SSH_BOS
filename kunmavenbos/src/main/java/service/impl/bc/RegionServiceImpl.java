package service.impl.bc;

import java.util.List;

import domain.bc.Region;
import page.PageRequestBean;
import page.PageResponseBean;
import service.base.BaseService;
import service.bc.RegionService;

public class RegionServiceImpl extends BaseService implements RegionService {

	@Override
	public void saveRegion(Region region) {
		regionDAO.save(region);
	}

	@Override
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, regionDAO);
	}

	@Override
	public List<Region> findAllRegions() {
		return regionDAO.findAll();
	}

}
