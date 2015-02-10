package sy.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sy.model.User;
import sy.service.UserServiceI;

import com.alibaba.fastjson.JSON;

//结合了spring-test之后，则需要以下两处注解（如果不采用spring-test方式，则需要手动获取spring上下文）
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * spring-test 第一步 加上@RunWith(SpringJUnit4ClassRunner.class)注解，这句话的意思是继承：extends SpringJUnit4ClassRunnser继承该类的注解
 * 等同于 public class TestMybatis extends SpringJUnit4ClassRunnser
 */

@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
//告诉当前类你当前spring上下文需要加载那些配置文件！ @ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {

	//以下是用spring-test来测试，需导入spring-test对应的jar包
	//通过配置文件去获得spring的上下文
	//private static final Logger logger = Logger.getLogger(TestAccountService.class);
	
	private static final Logger logger = Logger.getLogger(TestMybatis.class);

	private UserServiceI userService;

	/*
	@Before
	public void before()
	{
		//以前未用spring-test来测试时（未用spring的测试方法），采用这种方式来获取上下文，然后获取对应的service
		//获取spring的上下文（spring初始化的时候很慢，又耗时也耗资源）
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{ "spring.xml", "spring-mybatis.xml" });
		userService = (UserServiceI) ac.getBean("userService");//获取bean对象
	}
	*/
	
	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {//加上注解，自动注入
		this.userService = userService;
	}

	@Test
	public void test1() {
		/*
			//获取spring的上下文（spring初始化的时候很慢，又耗时也耗资源）
			ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{ "spring.xml", "spring-mybatis.xml" });
			UserServiceI userService = （UserServiceI）ac.getBean("userService");//获取bean对象
		*/
		User u = userService.getUserById("1");
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test2() {
		List<User> l = userService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test3() {
		List<User> l = userService.getAll2();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test4() {
		List<User> l = userService.getAll3();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}
}
