package im.heart.cms.web;

import im.heart.cms.entity.FrameImage;
import im.heart.cms.entity.FrameNotice;
import im.heart.cms.service.FrameNoticeService;
import im.heart.core.CommonConst;
import im.heart.core.plugins.persistence.DynamicPageRequest;
import im.heart.core.plugins.persistence.DynamicSpecifications;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import im.heart.core.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ApiFrameNoticeController extends AbstractController {
	protected static final String apiVer = "/api/v1/notice";
	@Autowired
	private FrameNoticeService frameNoticeService;
	protected static final String VIEW_LIST="admin/frameNotice/list";
	protected static final String VIEW_CREATE="admin/frameNotice/create";
	protected static final String VIEW_UPDATE="admin/frameNotice/update";
	protected static final String VIEW_DETAILS="admin/frameNotice/details";
	protected static final String VIEW_SUCCESS = "admin/frameNotice/success";
	
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
	@RequestMapping(value=apiVer+"s" ,method = RequestMethod.GET)
	protected ModelAndView lists(
			@RequestParam(value = CommonConst.RequestResult.JSON_CALLBACK, required = false) String jsoncallback,
			@RequestParam(value = "page", required = false, defaultValue = CommonConst.Page.DEFAULT_PAGE+"") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = CommonConst.Page.DEFAULT_SIZE+"") Integer size,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "order", required = false,defaultValue = CommonConst.Page.DEFAULT_ORDER) String order,
			@RequestParam(value = "access_token", required = false) String token,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		Specification<FrameNotice> spec=DynamicSpecifications.bySearchFilter(request, FrameNotice.class);
		PageRequest pageRequest=DynamicPageRequest.buildPageRequest(page,size,sort,order,FrameNotice.class);
		Page<FrameNotice> pag = this.frameNoticeService.findAll(spec, pageRequest);
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
		FrameNotice po = this.frameNoticeService.findById(id);
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
		Specification<FrameNotice> spec=DynamicSpecifications.bySearchFilter(request, FrameNotice.class);
		Long count = this.frameNoticeService.count(spec);
		super.success(model,count);
		return new ModelAndView(RESULT_PAGE);
	}
	@RequestMapping(value=apiVer+"/create", method=RequestMethod.GET)
	protected ModelAndView preCreate(@ModelAttribute(CommonConst.RequestResult.RESULT) FrameNotice frameNotice, ModelMap model) {
		super.success(model, frameNotice);
		return new ModelAndView(VIEW_CREATE);
	}
	@RequestMapping(value=apiVer+"/create", method=RequestMethod.POST)
	public ModelAndView  create(@Valid FrameNotice frameNotice) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22");
		return new ModelAndView(VIEW_CREATE);
	}
}
