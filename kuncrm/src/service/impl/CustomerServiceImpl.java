package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Customer;
import service.CustomerService;
import utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> findNoAssociationCustomers() {
		System.out.println("远程调用");
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "from Customer where decidedZoneId is null";
		List<Customer> customers = session.createQuery(hql).list();
		System.out.println(customers.toString()+"****");
		transaction.commit();
		session.close();
		return customers;
	}

	@Override
	public List<Customer> findHasAssociationCustomers(String decidedZoneId) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "from Customer where decidedZoneId = ?";
		List<Customer> customers = session.createQuery(hql).setParameter(0, decidedZoneId).list();

		transaction.commit();
		session.close();
		return customers;
	}

	@Override
	public void assignedCustomerToDecidedZone(String[] customerIds, String decidedZoneId) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();

		if (customerIds != null) {
			for (String customerId : customerIds) {
				Customer customer = (Customer) session.get(Customer.class, customerId);
				customer.setDecidedZoneId(decidedZoneId);
			}
		}

		transaction.commit();
		session.close();
	}

	@Override
	public String findDecidedZoneIdByCustomerAddress(String address) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "from Customer where address = ?";
		List<Customer> customers = session.createQuery(hql).setParameter(0, address).list();

		transaction.commit();
		session.close();
		if (customers.isEmpty()) {
			return null;
			
		}
		return customers.get(0).getDecidedZoneId();
	}

}
