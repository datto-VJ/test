package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.ProductEntity;
import utils.HibernateUtils;

public class ProductRepository {
	public List<ProductEntity> findAll(){
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			Query query = session.createQuery("from ProductEntity");
			return query.list();
		}
	}
	
	public ProductEntity detail(int id) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			return session.get(ProductEntity.class,id);
		}
	}
	
	public int add(ProductEntity product) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			session.persist(product);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int update(ProductEntity product) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			session.merge(product);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int delete(int id) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			ProductEntity product = session.find(ProductEntity.class, id);
			session.delete(product);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
