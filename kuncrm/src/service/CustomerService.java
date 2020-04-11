package service;

import java.util.List;

import domain.Customer;

/**
 * 客户业务层接口（远程调用）
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
	
	public String findDecidedZoneIdByCustomerAddress(String address);
}
