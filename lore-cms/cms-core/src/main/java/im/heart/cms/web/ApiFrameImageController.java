package im.heart.cms.web;

import im.heart.cms.entity.FrameImage;
import im.heart.cms.service.FrameImageService;
import im.heart.core.CommonConst;
import im.heart.core.plugins.persistence.DynamicPageRequest;
import im.heart.core.plugins.persistence.DynamicSpecifications;
import im.heart.core.web.AbstractController;
import java.math.BigInteger;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ApiFrameImageController extends AbstractController {
	
	protected static final String apiVer = "/api/v1/image";
	
	protected static final String VIEW_LIST="frameImage/list";
	protected static final String VIEW_UPDATE="frameImage/update";
	protected static final String VIEW_DETAILS="frameImage/details";
	protected static final String VIEW_SUCCESS = "frameImage/success";
	@Autowired
	private FrameImageService frameImageService;
	
	/**
	 * @功能说明：分页查询
	 * @param jsoncallback
	 * @param page
	 * @param size
	 * @param sort
	 * @param order
	 * @param token
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= apiVer+"s" ,method = RequestMethod.GET)
	protected ModelAndView lists(
			@RequestParam(value = CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
			@RequestParam(value = "page", required = false, defaultValue = CommonConst.Page.DEFAULT_PAGE+"") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = CommonConst.Page.DEFAULT_SIZE+"") Integer size,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "order", required = false,defaultValue = CommonConst.Page.DEFAULT_ORDER) String order,
			@RequestParam(value = "access_token", required = false) String token,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		Specification<FrameImage> spec=DynamicSpecifications.bySearchFilter(request, FrameImage.class);
		PageRequest pageRequest=DynamicPageRequest.buildPageRequest(page,size,sort,order,FrameImage.class);
		Page<FrameImage> pag = this.frameImageService.findAll(spec, pageRequest);
		super.success(model, pag);
		return new ModelAndView(VIEW_LIST);
	}
	/**
	 * @功能说明：根据Id查询信息
	 * @param jsoncallback
	 * @param id
	 * @param token
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value=apiVer+"/{id}" ,method = RequestMethod.GET)
	protected ModelAndView findByKey(
			@RequestParam(value = CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
			@PathVariable BigInteger id,
			@RequestParam(value = "access_token", required = false) String token,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		FrameImage po = this.frameImageService.findById(id);
		super.success(model, po);
		return new ModelAndView(VIEW_DETAILS);
	}
	/**
	 * @功能说明：统计记录数
	 * @param jsoncallback
	 * @param request
	 * @param token
	 * @param model
	 * @return
	 */
	@RequestMapping(value = apiVer+"/count",method = RequestMethod.GET)
	protected ModelAndView counts(
			@RequestParam(value = CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
			HttpServletRequest request,
			@RequestParam(value = "access_token", required = false) String token,
			ModelMap model) {
		Specification<FrameImage> spec=DynamicSpecifications.bySearchFilter(request, FrameImage.class);
		Long count = this.frameImageService.count(spec);
		super.success(model,count);
		return new ModelAndView(RESULT_PAGE);
	}
}
