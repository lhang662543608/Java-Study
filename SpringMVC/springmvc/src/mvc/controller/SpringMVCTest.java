package mvc.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mvc.entities.User;

@SessionAttributes(value = { "user" }, types = { String.class })
@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {

	public static final String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "helloView";
	}
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}

	/**
	 * 1. �� @ModelAttribute ��ǵķ���, ����ÿ��Ŀ�귽��ִ��֮ǰ�� SpringMVC ����! 
	 * 2. @ModelAttribute ע��Ҳ����������Ŀ�귽�� POJO ���͵����, �� value ����ֵ�����µ�����:
	 * 1). SpringMVC ��ʹ�� value ����ֵ�� implicitModel �в��Ҷ�Ӧ�Ķ���, ���������ֱ�Ӵ��뵽Ŀ�귽���������.
	 * 2). SpringMVC ��һ value Ϊ key, POJO ���͵Ķ���Ϊ value, ���뵽 request ��. 
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id, 
			Map<String, Object> map){
		System.out.println("modelAttribute method");
		if(id != null){
			//ģ������ݿ��л�ȡ����
			User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
			System.out.println("�����ݿ��л�ȡһ������: " + user);
			
			map.put("user", user);
		}
	}
	
	/**
	 * ��������:
	 * 1. ִ�� @ModelAttribute ע�����εķ���: �����ݿ���ȡ������, �Ѷ�����뵽�� Map ��. ��Ϊ: user
	 * 2. SpringMVC �� Map ��ȡ�� User ����, ���ѱ���������������� User ����Ķ�Ӧ����.
	 * 3. SpringMVC ������������Ŀ�귽���Ĳ���. 
	 * 
	 * ע��: �� @ModelAttribute ���εķ�����, ���뵽 Map ʱ�ļ���Ҫ��Ŀ�귽��������͵ĵ�һ����ĸСд���ַ���һ��!
	 * 
	 * SpringMVC ȷ��Ŀ�귽�� POJO ������εĹ���
	 * 1. ȷ��һ�� key:
	 * 1). ��Ŀ�귽���� POJO ���͵Ĳ���ľ��ʹ�� @ModelAttribute ��Ϊ����, �� key Ϊ POJO ������һ����ĸ��Сд
	 * 2). ��ʹ����  @ModelAttribute ������, �� key Ϊ @ModelAttribute ע��� value ����ֵ. 
	 * 2. �� implicitModel �в��� key ��Ӧ�Ķ���, ������, ����Ϊ��δ���
	 * 1). ���� @ModelAttribute ��ǵķ������� Map �б����, �� key �� 1 ȷ���� key һ��, ����ȡ��. 
	 * 3. �� implicitModel �в����� key ��Ӧ�Ķ���, ���鵱ǰ�� Handler �Ƿ�ʹ�� @SessionAttributes ע������, 
	 * ��ʹ���˸�ע��, �� @SessionAttributes ע��� value ����ֵ�а����� key, ���� HttpSession ������ȡ key ��
	 * ��Ӧ�� value ֵ, ��������ֱ�Ӵ��뵽Ŀ�귽���������. �����������׳��쳣. 
	 * 4. �� Handler û�б�ʶ @SessionAttributes ע��� @SessionAttributes ע��� value ֵ�в����� key, ��
	 * ��ͨ������������ POJO ���͵Ĳ���, ����ΪĿ�귽���Ĳ���
	 * 5. SpringMVC ��� key �� POJO ���͵Ķ��󱣴浽 implicitModel ��, �����ᱣ�浽 request ��. 
	 * 
	 * Դ�������������
	 * 1. ���� @ModelAttribute ע�����εķ���. ʵ���ϰ� @ModelAttribute ������ Map �е����ݷ����� implicitModel ��.
	 * 2. ��������������Ŀ�����, ʵ���ϸ�Ŀ����������� WebDataBinder ����� target ����
	 * 1). ���� WebDataBinder ����:
	 * ��. ȷ�� objectName ����: ������� attrName ����ֵΪ "", �� objectName Ϊ������һ����ĸСд. 
	 * *ע��: attrName. ��Ŀ�귽���� POJO ����ʹ���� @ModelAttribute ������, �� attrName ֵ��Ϊ @ModelAttribute 
	 * �� value ����ֵ 
	 * 
	 * ��. ȷ�� target ����:
	 * 	> �� implicitModel �в��� attrName ��Ӧ������ֵ. ������, ok
	 * 	> *��������: ����֤��ǰ Handler �Ƿ�ʹ���� @SessionAttributes ��������, ��ʹ����, ���Դ� Session ��
	 * ��ȡ attrName ����Ӧ������ֵ. �� session ��û�ж�Ӧ������ֵ, ���׳����쳣. 
	 * 	> �� Handler û��ʹ�� @SessionAttributes ��������, �� @SessionAttributes ��û��ʹ�� value ֵָ���� key
	 * �� attrName ��ƥ��, ��ͨ�����䴴���� POJO ����
	 * 
	 * 2). SpringMVC �ѱ���������������� WebDataBinder �� target ��Ӧ������. 
	 * 3). *SpringMVC ��� WebDataBinder �� attrName �� target ���� implicitModel. 
	 * �������� request �������. 
	 * 4). �� WebDataBinder �� target ��Ϊ�������ݸ�Ŀ�귽�������. 
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("�޸�: " + user);
		return SUCCESS;
	}

	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User("Tom", "123456", "tom@163.com", 15);
		map.put("user", user);
		map.put("school", "sylu");
		return SUCCESS;
	}

	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		System.out.println(map.getClass().getName());
		map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
		return SUCCESS;
	}

	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);

		modelAndView.addObject("time", new Date());

		return modelAndView;
	}

	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)
			throws IOException {
		System.out.println("testServletAPI, " + request + ", " + response);
		out.write("hello springmvc");
		// return SUCCESS;
	}

	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo: " + user);
		return SUCCESS;
	}

	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue: sessionId: " + sessionId);
		return SUCCESS;
	}

	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
		System.out.println("testRequestHeader, Accept-Language: " + al);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username") String un,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("testRequestParam, username: " + un + ", age: " + age);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {
		System.out.println("testRest put: " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDELETE(@PathVariable("id") Integer id) {
		System.out.println("testRest delete: " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest POST ");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id) {
		System.out.println("testRest GET: " + id);
		return SUCCESS;
	}

	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("testPathVariable: " + id);
		return SUCCESS;
	}

	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath() {
		return SUCCESS;
	}

}
