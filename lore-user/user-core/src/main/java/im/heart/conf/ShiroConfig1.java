package im.heart.conf;//package im.heart.conf;
//
//import com.google.common.collect.Lists;
//import im.heart.security.cache.ShiroCacheConfig;
//import im.heart.security.credentials.RetryLimitCredentialsMatcher;
//import im.heart.security.filter.*;
//import im.heart.security.realm.FrameUserRealm;
//import im.heart.security.session.*;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.cache.CacheManager;
//import org.apache.shiro.cache.ehcache.EhCacheManager;
//import org.apache.shiro.codec.Base64;
//import org.apache.shiro.session.SessionListener;
//import org.apache.shiro.session.mgt.SessionFactory;
//import org.apache.shiro.session.mgt.SessionManager;
//import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
//import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
//import org.apache.shiro.web.filter.authz.SslFilter;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.WebSecurityManager;
//import org.apache.shiro.web.servlet.Cookie;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.servlet.Filter;
//import java.util.Collection;
//import java.util.Map;
//
//@Configuration
//@PropertySource(value = "classpath:/application-shiro.yml")
//public class ShiroConfig1 {
//	protected static final Logger logger = LoggerFactory.getLogger(ShiroConfig1.class);
//
//	public static final String CACHE_MANAGER_BEAN_NAME = ShiroCacheConfig.CACHE_MANAGER_BEAN_NAME;
//
//	@Value("${shiro.login.url}")
//	private String loginUrl = "/login.jhtml";
//
//	@Value("${shiro.login.success.url}")
//	private String successUrl = "/";
//
//	@Value("${shiro.sessionManager.cookie.name}")
//	private String sessionIdName = "jsid";
//
//	@Value("${shiro.unauthorizedUrl}")
//	private String unauthorizedUrl = "/unauthorized.jhtml";
//
//	@Value("${shiro.logout.success.url}")
//	private String logoutSuccessUrl = "/login.jhtml?logout=1";
//
//	@Bean(name = CACHE_MANAGER_BEAN_NAME)
//	public CacheManager cacheManager() {
//		return new EhCacheManager();
//	}
//
//	@Bean()
//	public FrameAuthenticationFilter frameAuthenticationFilter() {
//		return new FrameAuthenticationFilter();
//	}
//	@Bean()
//	public FrameLogoutFilter frameLogoutFilter() {
//		return new FrameLogoutFilter();
//	}
//	@Bean()
//	public SslFilter sslFilter() {
//		return new SslFilter();
//	}
//
//	/**
//	 * 这里统一做鉴权，即判断哪些请求路径需要用户登录，哪些请求路径不需要用户登录。
//	 * 这里只做鉴权，不做权限控制，因为权限用注解来做。
//	 * @return
//	 */
//	@Bean
//	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//		DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
//		chain.addPathDefinition("/static/**", "anon");
//		chain.addPathDefinition("/favicon.ico", "anon");
//		chain.addPathDefinition("**.ico", "anon");
//		chain.addPathDefinition("/oauth2/**", "anon");
//		chain.addPathDefinition("/3rd/**", "anon");
//		chain.addPathDefinition("/css/**", "anon");
//		chain.addPathDefinition("/js/**", "anon");
//		chain.addPathDefinition("/imgs/**", "anon");
//		chain.addPathDefinition("/images/**", "anon");
//		chain.addPathDefinition("/app/js/**", "anon");
//		chain.addPathDefinition("/app/css/**", "anon");
//		chain.addPathDefinition("/app/imgs/**", "anon");
//		chain.addPathDefinition("/modules/**", "anon");
//		chain.addPathDefinition("/login-in**", "anon");
//		chain.addPathDefinition("/validate/**", "anon");
//		chain.addPathDefinition("/regist**", "anon");
//		chain.addPathDefinition("/regist/**", "anon");
//		chain.addPathDefinition("/findPwd/**", "anon");
//		chain.addPathDefinition("/api/**", "anon");
//		chain.addPathDefinition("/", "anon");
//		chain.addPathDefinition("/index/*", "anon");
//		chain.addPathDefinition("/admin/druid/**", "perms[druid:monitor]");
//		chain.addPathDefinition("/admin/monitor/**", "perms[monitor:monitor]");
//		chain.addPathDefinition("/logout*", "logout");
//		chain.addPathDefinition("/authenticated", "authc");
//		chain.addPathDefinition("/**", "authc");
//		return chain;
//	}
//	/**
//	 * 网络请求的权限过滤, 拦截外部请求
//	 */
//	@Bean
//	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
//		ShiroFilterFactory shiroFilterFactoryBean = new ShiroFilterFactory();
//		shiroFilterFactoryBean.setLoginUrl(loginUrl);
//		shiroFilterFactoryBean.setSuccessUrl(successUrl);
//		shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
//		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
//		/*<!-- 添加自定义过滤链 -->*/
//		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
//		filters.put("authc",frameAuthenticationFilter());
//		/*<!-- 用户注销控制过滤链 -->*/
//		filters.put("logout",frameLogoutFilter());
//		/*<!-- 添加ssl过滤链 -->*/
//		filters.put("ssl",sslFilter());
//		/*<!-- 控制并发登录人数 -->*/
//		filters.put("kickout",kickoutSessionControlFilter());
//		/*<!-- 强制退出用户 -->*/
//		filters.put("forceLogout",forceLogoutFilter());
//		ShiroFilterChainDefinition shiroFilterChainDefinition=shiroFilterChainDefinition();
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition.getFilterChainMap());
//		return shiroFilterFactoryBean;
//	}
//
//	@Bean(name = "kickout")
//	public KickoutSessionControlFilter kickoutSessionControlFilter() {
//		KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
//		kickoutSessionControlFilter.setCacheManager(cacheManager());
//		return kickoutSessionControlFilter;
//	}
//	@Bean(name = "forceLogout")
//	public ForceLogoutFilter forceLogoutFilter() {
//		ForceLogoutFilter forceLogoutFilter = new ForceLogoutFilter();
//		return forceLogoutFilter;
//	}
//
//	@Bean(name = "credentialsMatcher")
//	public RetryLimitCredentialsMatcher credentialsMatcher() {
//		RetryLimitCredentialsMatcher retryLimitCredentialsMatcher=new RetryLimitCredentialsMatcher();
//		retryLimitCredentialsMatcher.setCacheManager(cacheManager());
//		return retryLimitCredentialsMatcher;
//	}
//	@Bean(name="frameUserRealm")
//	public FrameUserRealm frameUserRealm() {
//		FrameUserRealm frameUserRealm=	new FrameUserRealm();
//		frameUserRealm.setCacheManager(cacheManager());
//		frameUserRealm.setCredentialsMatcher(credentialsMatcher());
//		return frameUserRealm;
//	}
//
//	/**
//	 * SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。
//	 * @return
//	 */
//	@Bean(name = "securityManager")
//	public WebSecurityManager defaultWebSecurityManager() {
//		ShiroWebSecurityManager wsm = new ShiroWebSecurityManager();
//		wsm.setCacheManager(cacheManager());
//		wsm.setRealm(frameUserRealm());
//		wsm.setSessionManager(sessionManager());
//		wsm.setRememberMeManager(rememberMeManager());
//		SecurityUtils.setSecurityManager(wsm);
//		return wsm;
//	}
//
//	@Bean(name = "sessionIdCookie")
//	public Cookie sessionIdCookie() {
//        Cookie cookie = new SimpleCookie(sessionIdName);
//		//more secure, protects against XSS attacks
//        cookie.setHttpOnly(true);
//		return cookie;
//	}
//	@Bean(name = "rememberMeManager")
//	public CookieRememberMeManager rememberMeManager() {
//		CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
//		//rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//		rememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
//		return rememberMeManager;
//	}
//	@Bean(name = "onlineSessionFactory")
//	public SessionFactory onlineSessionFactory() {
//		SessionFactory sessionFactory = new OnlineSessionFactory();
//		return sessionFactory;
//	}
//	@Bean
//	public SessionManager sessionManager() {
//		ShiroSessionManager sessionManager = new ShiroSessionManager();
//		sessionManager.setGlobalSessionTimeout(ShiroSessionManager.DEFAULT_GLOBAL_SESSION_TIMEOUT);
//		sessionManager.setDeleteInvalidSessions(true);
//		sessionManager.setSessionFactory(onlineSessionFactory());
//		//移除JSESSIONID小尾巴
//		sessionManager.setSessionIdUrlRewritingEnabled(false);
//		sessionManager.setSessionValidationSchedulerEnabled(true);
//		sessionManager.setSessionDAO(sessionDAO());
//		sessionManager.setSessionIdCookie(sessionIdCookie());
//		Collection<SessionListener> listeners=Lists.newArrayList();
//		////设置SESSION 监听器
//		listeners.add(shiroSessionListener());
//		sessionManager.setSessionListeners(listeners);
//		return sessionManager;
//	}
//	/**
//	 * 自定义sessionListener
//	 * @return
//	 */
//	@Bean(name="sessionListener")
//	public SessionListener shiroSessionListener(){
//		ShiroSessionListener shiroSessionListener=new ShiroSessionListener();
//		return shiroSessionListener;
//	}
//	/**
//	 * 自定义sessionDAO
//	 * @return
//	 */
//	@Bean()
//	public CachingSessionDAO sessionDAO() {
//		ShiroSessionDAO sessionDAO=new ShiroSessionDAO();
//		return sessionDAO;
//	}
//
//	/**
//     * 在方法中 注入 securityManager,进行代理控制
//     */
//    @Bean
//    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
//        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
//        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
//        bean.setArguments(new Object[]{defaultWebSecurityManager()});
//        return bean;
//    }
//
//	/**
//	 * 	LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
//	 * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
//	 * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
//	 * 协助shiro初始化, 负责调用shiro的init与destory
//	 */
//	@Bean
//	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
//		return new LifecycleBeanPostProcessor();
//	}
//	/**
//	 *
//    * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
//	 * @return
//	 */
//	@Bean()
//   public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//       DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//		/**
//		 * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
//		 * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
//		 * 加入这项配置能解决这个bug
//		 */
//	   daap.setUsePrefix(true);
//       daap.setProxyTargetClass(true);
//       return daap;
//   }
//   @Bean()
//   public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
//	 AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//	 return sourceAdvisor;
//   }
//
//}
