package im.heart.search.web;

import im.heart.core.CommonConst;
import im.heart.core.plugins.persistence.DynamicPageRequest;
import im.heart.core.plugins.persistence.DynamicSpecifications;
import im.heart.core.web.AbstractController;
import im.heart.search.entity.Employee;
import im.heart.search.repository.EmployeeRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

@Controller
@RequestMapping("es")
public class EmployeeController extends AbstractController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 添加
     * @return
     */
    @RequestMapping("add")
    public ModelAndView add(
            @RequestParam(value = CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
            @RequestParam(value = CommonConst.RequestResult.ACCESS_TOKEN, required = false) String token,

            HttpServletRequest request,
                            ModelMap model){
        Employee employee = new Employee();
        employee.setId(100L);
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        employeeRepository.save(employee);
        super.success(model);
        return new ModelAndView();
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("query")
    public ModelAndView query(
            @RequestParam(value = CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
            @RequestParam(value = "page", required = false, defaultValue = CommonConst.Page.DEFAULT_PAGE+"") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = CommonConst.Page.DEFAULT_SIZE+"") Integer size,
            @RequestParam(value = "sort", required = false ,defaultValue="code") String sort,
            @RequestParam(value = "order", required = false,defaultValue = CommonConst.Page.DEFAULT_ORDER) String order,
            @RequestParam(value = CommonConst.RequestResult.ACCESS_TOKEN, required = false) String token,
            HttpServletRequest request,
            ModelMap model) {
        PageRequest pageRequest= DynamicPageRequest.buildPageRequest(page,size,sort,order,Employee.class);
        QueryBuilder var1=null;
        Page<Employee> pag = this.employeeRepository.search(null,pageRequest);
        super.success(model,pag);
        return new ModelAndView();
    }

}
