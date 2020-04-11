package bos.service.bc;

import java.util.List;

import bos.domain.bc.Region;
import bos.page.PageQuery;

/**
 * 区域管理 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface RegionService extends PageQuery {

	// 添加区域
	public void saveRegion(Region region);

	// 查询所有区域
	public List<Region> findAllRegions();

}
