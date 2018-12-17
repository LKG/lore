package im.heart.cms.service;

import im.heart.core.service.CommonService;
import java.math.BigInteger;

import im.heart.cms.entity.FrameImage;
import im.heart.core.service.ServiceException;


public  interface FrameImageService extends CommonService<FrameImage, BigInteger>{
	public static final String BEAN_NAME = "frameImageService";
	
	/**
	 * 
	 * @param frameUser
	 */
	public FrameImage save(FrameImage po)  throws ServiceException;
}
