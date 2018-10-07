package cn.scut.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.scut.dao.StudentDao;
import cn.scut.domain.Student;

public class Testclass {

	@Test
	public void testfindStudentById() throws Exception {
		Student student = null;

		String resource = "SqlMapConfig.xml";
		// 得到配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		StudentDao studentDao = new StudentDao(sqlSessionFactory);
		// student = studentMapper.findStudentById(2);
		// List<Student> list = studentMapper.findStudentByName("stu_%5");
		// System.out.println(student);
		// for(Student s:list){
		// System.out.println(s);
		// }
		//
		Student s1 = new Student();
		s1.setAge(21);
		s1.setGender("男");
		s1.setName("lisi");
		s1.setId(1001);
		// studentMapper.addStudent(s1);
		// studentMapper.deleteStudent(1003);
		studentDao.updateStudent(s1);

	}
}
