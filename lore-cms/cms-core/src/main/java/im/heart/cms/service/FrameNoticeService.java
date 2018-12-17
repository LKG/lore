package im.heart.cms.service;

import im.heart.core.service.CommonService;

import java.math.BigInteger;

import im.heart.cms.entity.FrameNotice;
import im.heart.core.service.ServiceException;


public  interface FrameNoticeService extends CommonService<FrameNotice, BigInteger>{
	public static final String BEAN_NAME = "frameNoticeService";
	
	/**
	 * 
	 * @param frameUser
	 */
	public FrameNotice save(FrameNotice po)  throws ServiceException;
}
