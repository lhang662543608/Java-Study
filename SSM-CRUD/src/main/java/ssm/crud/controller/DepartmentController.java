package ssm.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.crud.bean.Department;
import ssm.crud.bean.Msg;
import ssm.crud.service.DepartmentService;

import java.util.List;

/**
 * 处理和部门有关的请求
 *
 * @author lhang
 * @create 2020-08-06 16:54
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有的部门信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/depts")
    public Msg getDepts() {
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }
}
