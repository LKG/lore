package im.heart.core.plugins.sms;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;
import im.heart.core.utils.FreeMarkerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.Map;

/**
 * 
 * @author lkg
 * @desc :Sms发送配置管理项
 */
@Component()
public class SmsManager {
	protected static final Logger logger = LoggerFactory.getLogger(SmsManager.class);

	private String sendUrl = "http://sms-api.luosimao.com/v1/send.json";
	private String sendBatchUrl = "http://sms-api.luosimao.com/v1/send_batch.json";
	private String statusUrl = "http://sms-api.luosimao.com/v1/status.json";
	private String token = "49a4ed64374e7a699fd7b4aa2c28fb5e";
	public void sendMsg(String phone,String message) {
		logger.info("send msg post param , phone : {} , message : {}",phone,message);
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", token));
		WebResource webResource = client.resource(sendUrl);
		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		formData.add("mobile", phone);
		formData.add("message", message);
		ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).
				post(ClientResponse.class, formData);
		String jsonResult = response.getEntity(String.class);
		logger.info("send result : {}", jsonResult);
	}

	public static void main(String[] args) {
		SmsManager smsManager=new SmsManager();
		smsManager.getStatus();
	}
	public void getStatus() {
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter(
				"api","49a4ed64374e7a699fd7b4aa2c28fb5e"));
		WebResource webResource = client.resource( "http://sms-api.luosimao.com/v1/status.json" );
		MultivaluedMapImpl formData = new MultivaluedMapImpl();
		ClientResponse response =  webResource.get( ClientResponse.class );
		String jsonResult = response.getEntity(String.class);
		logger.info("status result : {}", jsonResult);
	}
}