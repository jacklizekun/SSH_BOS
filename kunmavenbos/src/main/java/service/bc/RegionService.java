package service.bc;

import java.util.List;

import domain.bc.Region;
import page.PageQuery;

/**
 * 区域管理持久层接口
 * @author 李泽坤
 *
 */
public interface RegionService extends PageQuery {

	//添加
	public void saveRegion(Region region);
	//查询所有
	public List<Region> findAllRegions();

}

