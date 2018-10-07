package cn.scut.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.scut.domain.Student;

/***
 * 
 * 在mybatis使用原生的jdbc语句（ibatis的方式）
 * 
 * @author Lenovo
 *
 */

public class StudentDao {

	private SqlSessionFactory sqlSessionFactory;

	// 使用构造方法注入工厂对象
	public StudentDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;

	}

	public Student findStudentById(int id) throws Exception {
		// String resource = "SqlMapConfig.xml";
		// //得到配置文件
		// InputStream inputStream = Resources.getResourceAsStream(resource);
		// // 创建会话工厂类
		// SqlSessionFactory sqlSessionFactory = new
		// SqlSessionFactoryBuilder().build(inputStream);
		// 创建会话对象
		SqlSession session = sqlSessionFactory.openSession();
		// 操作数据库
		Student student = session.selectOne("test.findStudentById", id);

		session.close();
		return student;
	}

	public List<Student> findStudentByName(String name) throws Exception {
		// String resource = "SqlMapConfig.xml";
		// //得到配置文件
		// InputStream inputStream = Resources.getResourceAsStream(resource);
		// // 创建会话工厂类
		// SqlSessionFactory sqlSessionFactory = new
		// SqlSessionFactoryBuilder().build(inputStream);
		// 创建会话对象
		SqlSession session = sqlSessionFactory.openSession();
		// 操作数据库
		List<Student> list = session.selectList("test.findStudentByName", name);

		session.close();
		return list;

	}

	public void addStudent(Student s) throws Exception {
		// String resource = "SqlMapConfig.xml";
		// //得到配置文件
		// InputStream inputStream = Resources.getResourceAsStream(resource);
		// // 创建会话工厂类
		// SqlSessionFactory sqlSessionFactory = new
		// SqlSessionFactoryBuilder().build(inputStream);
		// 创建会话对象
		SqlSession session = sqlSessionFactory.openSession();
		// 操作数据库

		session.insert("test.addStudent", s);

		// 提交事务，因为mybatis没有开启自动提交
		session.commit();
		session.close();
	}

	public void deleteStudent(int id) throws Exception {
		// String resource = "SqlMapConfig.xml";
		// //得到配置文件
		// InputStream inputStream = Resources.getResourceAsStream(resource);
		// // 创建会话工厂类
		// SqlSessionFactory sqlSessionFactory = new
		// SqlSessionFactoryBuilder().build(inputStream);
		// 创建会话对象
		SqlSession session = sqlSessionFactory.openSession();
		// 操作数据库

		session.delete("test.deleteStudent", id);

		// 提交事务，因为mybatis没有开启自动提交
		session.commit();
		session.close();

	}

	public void updateStudent(Student s) throws Exception {
		String resource = "SqlMapConfig.xml";
		// 得到配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 创建会话对象
		SqlSession session = sqlSessionFactory.openSession();
		// 操作数据库

		session.update("test.updateStudent", s);

		// 提交事务，因为mybatis没有开启自动提交
		session.commit();
		session.close();
	}
}
