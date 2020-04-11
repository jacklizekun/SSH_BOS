package crm.service;

import java.util.List;

import crm.domain.Customer;

/**
 * 客户服务接口 （给BOS远程调用）
 * 
 * @author 李泽坤
 * 
 */
public interface CustomerService {
	// 查询未关联定区的客户
	public List<Customer> findNoAssociationCustomers();

	// 查询已经关联定区的客户
	public List<Customer> findHasAssociationCustomers(String decidedZoneId);

	// 将客户关联到 定区上
	public void assignedCustomerToDecidedZone(String[] customerIds, String decidedZoneId);

	// 根据 客户地址 查询 定区编码
	public String findDecidedZoneIdByCustomerAddress(String address);
}
