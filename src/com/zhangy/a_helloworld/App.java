package com.zhangy.a_helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // ��ȡָ�����������ļ�
		sessionFactory = cfg.buildSessionFactory(); // ��������Session����
	}

	@Test
	public void testSave() throws Exception {
		User user = new User();
		user.setName("����");

		// ����
		Session session = sessionFactory.openSession(); // ��һ���µ�Session
		Transaction tx = session.beginTransaction(); // ��ʼ����

		session.save(user);

		tx.commit(); // �ύ����
		session.close(); // �ر�Session���ͷ���Դ
	}

	@Test
	public void testGet() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User user = (User) session.get(User.class, 1); // ��ȡ
		System.out.println(user);

		tx.commit();
		session.close();
	}
}