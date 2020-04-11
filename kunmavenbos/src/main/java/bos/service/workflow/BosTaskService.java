package bos.service.workflow;

import bos.domain.zm.InStore;
import bos.domain.zm.OutStore;
import bos.domain.zm.ReceiveGoodsInfo;
import bos.domain.zm.TransferInfo;

/**
 * 建立 任务办理 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface BosTaskService {

	//办理 中转环节的任务
	public void completeTransferInfoTask(TransferInfo transferInfo, String taskId);

	// 办理 入库任务
	public void completeInStoreTask(InStore inStore, String taskId);

	//办理出库任务
	public void completeOutStoreTask(OutStore outStore, String taskId);

	// 办理配送签收任务
	public void completeReceiveGoodInfoTask(ReceiveGoodsInfo receiveGoodsInfo, String taskId);

}
