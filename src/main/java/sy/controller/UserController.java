package sy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.model.User;
import sy.service.UserServiceI;

@Controller
//只要类上加上@Controller注解，那么我就能将该类加到spring mvc上下文中，就能知道你这个类是一个控制器类
@RequestMapping("/userController")
//访问该控制地址的配置
public class UserController {

	private UserServiceI userService;//业务层

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {//自动注入
		this.userService = userService;
	}
	
	//具体访问该控制器下的某个方法（测试是畅通的）
	//http://loccalhost:8080/testmybatis/userController/showUser1.do?id=0
	//但是showUser1.do?id=0这样传参数不好看，难看！
	@RequestMapping("/showUser1")
	public String showUser1(String id,HttpServletRequest request)
	{
		User u = userService.getUserById(id);
		//将user存到request当中，存完之后，返回到showUser.jsp中
		request.setAttribute("user", u);//键值是user
		return "showUser";//showUser表示视图名称，或是一个.jsp页面的名称
	}
	
	//具体访问该控制器下的某个方法
	//http://loccalhost:8080/testmybatis/userController/showUser.do
	@RequestMapping("/{id}/showUser")
	//id是b变量，@PathVariable该注解说明id是一个变量
	public String showUser(@PathVariable String id, HttpServletRequest request) {
		User u = userService.getUserById(id);
		//将user存到request当中，存完之后，返回到showUser.jsp中
		request.setAttribute("user", u);//键值是user
		//@RequestMapping("/showAccount")
		// 访问地址 http:localhost:8080/cocool/accountController/showAccount.do
		
		// @RequestMapping("/showAccount/{id}")
		// http:localhost:8080/cocool/accountController/showAccount/1.do
		
		// 访问地址@RequestMapping("/{id}/showUser")
		// http:localhost:8080/cocool/accountController/1/showAccount.do
		return "showUser";//showUser表示视图名称，或是一个.jsp页面的名称
	}

}
