package com.niit.collaboration.DAOImpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.DAO.UploadFileDAO;
import com.niit.collaboration.model.UploadFile;

@Transactional
@Repository
public class UploadFileDAOImpl implements UploadFileDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(UploadFile uploadFile) {
		try {
			uploadFile.setId(getMaxId() + 1);
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(uploadFile);
			session.flush();
			session.close();
		} catch (Exception e) {
			uploadFile.setId(100 + 1);
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(uploadFile);
			session.flush();
			session.close();
		}

	}

	public UploadFile getFile(int event_id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UploadFile where event_id=?");
		query.setParameter(0, event_id);
		UploadFile uploadFile = (UploadFile) query.uniqueResult();
		session.close();
		return uploadFile;
	}

	private Integer getMaxId() {

		String hql = "select max(id) from UploadFile";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {

			maxID = (Integer) query.uniqueResult();
			if (maxID == null) {
				maxID = 100;
			}
		} catch (NullPointerException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}

		return maxID;

	}

}
