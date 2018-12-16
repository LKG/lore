package im.heart.frame.web;

import im.heart.core.CommonConst;
import im.heart.core.plugins.persistence.DynamicPageRequest;
import im.heart.core.plugins.persistence.DynamicSpecifications;
import im.heart.core.web.AbstractController;
import im.heart.frame.entity.FrameDict;
import im.heart.frame.service.FrameDictItemService;
import im.heart.frame.service.FrameDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author gg
 * 数据字典子表
 */
@Controller
public class TestController extends AbstractController {
	
	protected static final String apiVer = "/index";
	@Autowired
	private FrameDictService frameDictService;
	@Autowired
	private FrameDictItemService frameDictItemService;

	@RequestMapping(value = {apiVer ,"/"})
	protected ModelAndView checkCode(
			@RequestParam(value = CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
			@RequestParam(value = "page", required = false, defaultValue = CommonConst.Page.DEFAULT_PAGE+"") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = CommonConst.Page.DEFAULT_SIZE+"") Integer size,
			@RequestParam(value = "sort", required = false ,defaultValue = "createTime") String sort,
			@RequestParam(value = "order", required = false,defaultValue = CommonConst.Page.DEFAULT_ORDER) String order,
			@RequestParam(value = CommonConst.RequestResult.ACCESS_TOKEN, required = false) String token,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		System.out.println("################");
		Specification<FrameDict> spec= DynamicSpecifications.bySearchFilter(request, FrameDict.class);
		PageRequest pageRequest= DynamicPageRequest.buildPageRequest(page,size,sort,order, FrameDict.class);
		Page<FrameDict> pag = this.frameDictService.findAll(spec, pageRequest);
		super.success(model,pag);
		return new ModelAndView("index");
	}
}
