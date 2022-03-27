package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.ProductEntity;
import utils.HibernateUtils;

public class ProductRepository {
	public List<ProductEntity> findAll(){
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			List products = session.createQuery("from ProductEntity").list();
			return products;
		}
	}
	
	public ProductEntity detail(int id) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			return session.get(ProductEntity.class,id);
		}
	}
	
	public int add(ProductEntity product) {
		Transaction tran = null;
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			tran = session.beginTransaction();
			session.save(product);
			tran.commit();
			return 1;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}
	
	public int update(ProductEntity product) {
		Transaction tran = null;
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			tran = session.beginTransaction();
			session.update(product);
			tran.commit();
			return 1;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}
	
	public int delete(int productId) {
		Transaction tran = null;
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			tran = session.beginTransaction();
			ProductEntity product = session.get(ProductEntity.class, productId);
			session.delete(product);
			tran.commit();
			return 1;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}
}
