package bos.service.impl.bc;

import java.util.List;

import bos.domain.bc.Region;
import bos.page.PageRequestBean;
import bos.page.PageResponseBean;
import bos.service.base.BaseService;
import bos.service.bc.RegionService;

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
