package im.heart.api.web;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import im.heart.core.enums.FileHeader;
import im.heart.core.model.RequestBody;
import im.heart.core.model.RequestParas;
import im.heart.core.utils.*;
import im.heart.core.web.AbstractController;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
public class SysRrouteController extends AbstractController {
	protected static final Logger logger = LoggerFactory.getLogger(SysRrouteController.class);

	/**
	 * 
	 * @功能说明： 判断是否是黑名单ip
	 * @param ip
	 * @return
	 */
	private boolean isRestrict(String ip){
		
		return false;
	}
	
	
	/**
	 * 
	 * @功能说明：处理请求参数
	 * @param input
	 * @return
	 */
	private RequestParas getRequestParameter(InputStream input) {
		RequestParas requestParameters = null;
		try {
			byte[] pack = IOUtils.toByteArray(input);
			byte[] key = new byte[8]; // 密钥
			if (pack == null || pack.length <= 10) {
				return null;
			}
			byte[] body = new byte[pack.length - 10]; // 有效的数据体
			logger.info("====recv data length {{{" + pack.length + "}}}");
			// 取出密钥
			System.arraycopy(pack, 2, key, 0, key.length);
			// 取出消息体
			System.arraycopy(pack, 10, body, 0, body.length);
			logger.info("解压key：" + new String(key, "UTF-8"));
			// 转换压缩文件流为普通流
			byte[] unpack = FileUtilsEx.uncompressToStringback(body);
			String signBoby = DesUtils.parseSignback(unpack, new String(key,"UTF-8"));
			logger.info("解压signBoby ：" + signBoby);
			requestParameters = JSON.parseObject(signBoby, RequestParas.class);
		} catch (IOException e) {
			logger.error(e.getStackTrace()[0].getMethodName(), e);
		} catch (Exception e) {
			logger.error(e.getStackTrace()[0].getMethodName(), e);
		}finally{
			IOUtils.closeQuietly(input);
		}
		return requestParameters;
	}
	/**
	 * 
	 * @功能说明：提取公用参数
	 * @return 
	 */
	protected Map<String, Object> pickCommonparams(RequestParas requestParameters){
		Map<String, Object> params = Maps.newHashMap();
		String cpImei = requestParameters.getCpImei();
		String cpPhoneNum = requestParameters.getCpPhoneNum();
		String cpUid = requestParameters.getCpUid();
		String cpPrt = requestParameters.getCpPrt();
		String cpPltfm = requestParameters.getCpPltfm();
		String cpTouch = requestParameters.getCpTouch();
		String cpCityId = requestParameters.getCpCityId();
		String cpCh = requestParameters.getCpCh();
		String cpModel = requestParameters.getCpModel();
		String cpRatio = requestParameters.getCpRatio();
		String cpTpl = requestParameters.getCpTpl();
		String cpVer = requestParameters.getCpVer();
		String cpResver = requestParameters.getCpResver();
		String cpPubResPath = requestParameters.getCpPubResPath();
		String cpLon = requestParameters.getCpLon();
		String cpLat = requestParameters.getCpLat();
		params.put("cpImei", cpImei);
		params.put("cpPhoneNum", cpPhoneNum);
		params.put("cpUid", cpUid);
		params.put("cpPrt", cpPrt);
		params.put("cpPltfm", cpPltfm);
		params.put("cpTouch", cpTouch);
		params.put("cpCityId", cpCityId);
		params.put("cpCh", cpCh);
		params.put("cpModel", cpModel);
		params.put("cpRatio", cpRatio);
		params.put("cpTpl", cpTpl);
		params.put("cpVer", cpVer);
		params.put("cpResver", cpResver);
		params.put("cpPubResPath", cpPubResPath);
		params.put("cpLon", cpLon);
		params.put("cpLat", cpLat);
		return params;
	}
	
	/**
	 * @功能说明：手机端统一入口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/api/v1")
	protected @ResponseBody  void  sysLoadService(HttpServletRequest request,
			HttpServletResponse response) {
		OutputStream outStream = null;
		try {
			// 用户请求ip
			String ip = BaseUtils.getIpAddr(request);
			if(isRestrict(ip)){
				//返回访问过于频繁，已限制访问
				return ;
			}
			// --------------------
			outStream = response.getOutputStream();
			InputStream input = request.getInputStream();
			logger.info("请求ip:----" + ip);
			RequestParas requestParameters = this.getRequestParameter(input);
			if (requestParameters != null) {
				long start = System.currentTimeMillis();
				Map<String, Object> params = new HashMap<String, Object>();
				params=this.pickCommonparams(requestParameters);
				params.put("cpIp", ip);
				// 共用参数 end
				List<RequestBody> actions = requestParameters.getActions();
				if (actions != null) {
					for (RequestBody body : actions) {
						String action = body.getAction();// 请求方法ID
						String requuid = body.getRequuid();// 请求uuid
						String cpImei = (String) params.get("cpImei");
						String cpPhoneNum = (String) params.get("cpPhoneNum");
						String cpPrt = (String) params.get("cpPrt");
						String cpUid = (String) params.get("cpUid");
						logger.info(">>>>>>FLOW_UP|" + requuid + "|" + cpImei
								+ "|" + cpPhoneNum+ "|" +  cpPrt + "|" + cpUid);
						StringBuffer stbuff = new StringBuffer("http://");
						// 状态为可用状态
						stbuff.append(request.getServerName());
						stbuff.append(":");
						stbuff.append(request.getServerPort());
						stbuff.append(request.getContextPath()+"/" + action);
						// 参数处理
						Map<String, String> paras = body.getParas();
						if (paras != null) {// 请求参数
							if (paras.containsKey("ps")) {
								String value = paras.get("ps");
								paras.remove("ps");
								params.put("size", StringUtilsEx.isNotBlank(value) ? value : "10");
							}
							if (paras.containsKey("pn")) {
								String value = paras.get("pn");
								paras.remove("pn");
								params.put("page", StringUtilsEx.isNotBlank(value) ? String.valueOf(Integer.valueOf(value) + 1): "1");
							}
							params.putAll(paras);
						}
						logger.info(">>>>>>|UUID:" + requuid + "|IP:" + ip
								+ "|REQ_ACTION:" + stbuff.toString()
								+ "|REDIRECT_URL:" +  cpPrt+ "|PARAMS:"
								+ JSON.toJSONString(params));
						outStream.write(requuid.getBytes());// 写入UUID
						byte[] data = OkHttpClientUtils.fetchEntity(stbuff.toString(), params);
						byte[] pack = null;
						// //处理反馈结果,判断反馈结果是否为压缩流，不是压缩流对数据进行压缩后再返回给客户端
						if (FileUtilsEx.isSpecFile(data, FileHeader.ZIP.getValue())) {
							logger.info("outStream  is zip ...");
							pack = data;
						} else {
							logger.info("outStream  is not zip  begin commpress to byte ...");
							pack = FileUtilsEx.compressToByte(data);
							logger.info("outStream  commpress to byte  end...");
						}
						outStream.write(StringUtilsEx.changebytelength(pack.length).getBytes());// 写入长度
						outStream.write(pack);// 写入数据
						long end = System.currentTimeMillis();
						long time = (end - start);
						logger.info("====FLOW_DOWN,{},{},{},{},{},{}|",requuid,cpImei,cpPhoneNum, pack.length, cpPrt,time);
						logger.info(">>>>>>请求 {} [{}]耗时[{}]ms",action,stbuff.toString(),time);
						outStream.flush();
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getStackTrace()[0].getMethodName(), e);
			//处理出现异常统一返回错误信息给客户端
			//	TODO 处理出现异常统一返回错误信息给客户端
//			throw new Exception();
		} finally {
			IOUtils.closeQuietly(outStream);
		}
		return ;
	}
	
}
