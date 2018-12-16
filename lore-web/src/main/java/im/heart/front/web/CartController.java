/*
 * Project Name: ecp-ecom
 * File Name: CartController.java
 * Class Name: CartController
 * 
 * Copyright 2014 Hengtian Software Inc
 * 
 * Licensed under the Hengtiansoft
 * 
 * http://www.hengtiansoft.com
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package im.heart.front.web;

import im.heart.core.web.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller - 购物车
 * 
 * @author Hengtiansoft Team
 * @version 1.0_beta
 */
@Controller("shopCartController")
@RequestMapping("/cart")
public class CartController  extends AbstractController {

	/**
	 * 添加
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Long id, Long contractId, Integer quantity,
                            HttpServletRequest request,
                            ModelMap model) {
//		if (quantity == null || quantity < 1) {
//			return ERROR_MESSAGE;
//		}
//		StoreInfo storeInfo = storeService.getCurrent();
//		if (storeInfo.getStatus() != CustomerStatus.NORMAL) {
//			return Message.error("shop.cart.store.unnormal");
//		}
//		ContractProductItem contractItem = null;
//		Member member = memberService.getCurrent();
//		if (member != null) {
//			contractItem = contractProductItemService.find(contractId);
//		} else {
//			return Message.warn("shop.cart.noLogin");
//		}
//		Product product = productService.find(id);
//		if (product == null || contractItem == null) {
//			return Message.warn("shop.cart.productNotExsit");
//		}
//
//		// 是不是当前地区的合同，要是不是，则返回一个“该商品在该地区不销售！”
//		Area area = memberService.getArea();
//		Area contractArea = contractItem.getArea();
//		if (!contractArea.getId().equals(area.getId()) && !contractArea.getId().equals(BaseDaoImpl.NATIONWIDEAREAID)) {
//			return Message.warn("shop.cart.currentAreaNotSale");
//		}
//
//		// 已下架
//		if (!contractItem.getIsMarketable()) {
//			return Message.warn("shop.cart.productNotMarketable");
//		}
//
//		// 判断当前时间是不是在上架时间范围
//		if (!(new Date().after(contractItem.getProductStartDate()) && new Date().before(contractItem
//				.getProductExpireDate()))) {
//			return Message.warn("shop.cart.productNotMarketable");
//		}
//
//		if (contractItem.getLowestSaleQuantity() > quantity) {
//			return Message.warn("shop.cart.contractItemLowestSaleQuantity");
//		}
//		// 查看一下有没有资质
//		if (!productRuleService.hasAuth(member, storeInfo, product)) {
//			// 没有资质
//			return Message.warn("shop.cart.notAptitude");
//		}
//
//		// 获取到当前的购物车，有可能返回null
//		Cart cart = cartService.findByStoreId();
//		if (cart == null) {
//			cart = new Cart();
//			cart.setKey(UUID.randomUUID().toString() + DigestUtils.md5Hex(RandomStringUtils.randomAlphabetic(30)));
//			cart.setMember(member);
////			StoreInfo store = storeService.getCurrent();
//			cart.setStore(storeInfo);
//			cartService.save(cart);
//		}
//		if (cart.contains(product)) {
//			// 返回该商品的cartitem
//			CartItem cartItem = cart.getCartItem(product);
//
//			cartItem.add(quantity);
//			// 拆零费用添加
//			if (product.getPackingNumber() != null && product.getPackingNumber() > 0
//					&& (cartItem.getQuantity() % product.getPackingNumber()) != 0
//					&& product.getSeparableAccount() != null) {
//				cartItem.setSeparableAccount(product.getSeparableAccount());
//			} else {
//				cartItem.setSeparableAccount(BigDecimal.ZERO);
//			}
//			cartItemService.update(cartItem);
//		} else {
//
//			CartItem cartItem = new CartItem();
//			cartItem.setQuantity(quantity);
//			cartItem.setProduct(product);
//			cartItem.setContractItem(contractItem);
//			cartItem.setCart(cart);
//			// 拆零费用添加
//			if (product.getPackingNumber() != null && product.getPackingNumber() > 0
//					&& (cartItem.getQuantity() % product.getPackingNumber()) != 0
//					&& product.getSeparableAccount() != null) {
//				cartItem.setSeparableAccount(product.getSeparableAccount());
//			} else {
//				cartItem.setSeparableAccount(BigDecimal.ZERO);
//			}
//			cartItemService.save(cartItem);
//			cart.getCartItems().add(cartItem);
//		}
		super.success(model);
		return new ModelAndView(VIEW_SUCCESS);
//		return Message.success("shop.cart.addSuccess", cart.getQuantity(),
//				currency(getProductsTotalPrice(cart.getCartItems(),member), true, false));
	}

/*	*//**
	 * 获取到商品的小计
	 *//*
	public BigDecimal getProductsTotalPrice(Set<CartItem> cartItems,Member member){
		Setting setting = SettingUtils.get();
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<Long> ids = new ArrayList<Long>();
		for (CartItem cartItem : cartItems) {
			ids.add(cartItem.getContractItem().getId());
		}
		List<ContractProductItem> conList = contractProductItemService.findListByIds(ids);
		
		Map<Long, ContractProductItem> conMap = new HashMap<Long, ContractProductItem>();
		for (ContractProductItem c : conList) {
			conMap.put(c.getId(), c);
		}
		for (CartItem cartItem : cartItems) {
			//获取到当前购物车项的合同表
			ContractProductItem i = conMap.get(cartItem.getContractItem().getId());
			if (!member.getIsUnion()) {
				// 会员价
//				currentprice = setting.setScale(i.getSalePrice());
				//价格和购买的数量
				i.setCost(i.getSalePrice());
				i.setWeight(cartItem.getQuantity());
			} else {
				// 联采价
//				currentprice = setting.setScale(i.getLianCaiPrice());
				//价格和购买的数量
				i.setCost(i.getLianCaiPrice());
				i.setWeight(cartItem.getQuantity());
			}
			if (!(cartItem.getSeparableAccount() == BigDecimal.ZERO)) {
				if (cartItem.getQuantity() != null) {
					if (cartItem.getSeparableAccount() != null) {
						// 拆零费用加入小计
						totalPrice = totalPrice.add(i.getCost().multiply(new BigDecimal(cartItem.getQuantity())).add(cartItem.getSeparableAccount()));
					}else {
						totalPrice = totalPrice.add(i.getCost().multiply(new BigDecimal(cartItem.getQuantity())));
					}
				} else {
					totalPrice = totalPrice.add(BigDecimal.ZERO);
				}
			}else {
				totalPrice = totalPrice.add(i.getCost().multiply(new BigDecimal(cartItem.getQuantity())));
			}
		}
		return totalPrice.subtract(promotionService.getTotalSubByItemList(conList, member.getIsUnion()));
	}
	*/
	/**
	 * 判断是否包含商品
	 * 
	 * @param
	 *            商品
	 * @return 是否包含商品
	 */
/*	public boolean containsById(Product product,Long cartId) {
		List<Product> ps = productService.findByCartId(cartId);
		if(ps.contains(product)){
			return true;
		}
		return false;
	}*/
	
	
	

//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String list(ModelMap model, @ModelAttribute("error") String error) {
//		Member member = memberService.getCurrent();
//		if (member == null) {
//			return ERROR_VIEW;
//		}
//		Cart cart = cartService.findByStoreId();
//		List<Long> productIds = new ArrayList<>();
//		if (cart != null) {
//			List<Long> contractItemIds = new ArrayList<>();
//			for (CartItem item : cart.getCartItems()) {
//				contractItemIds.add(item.getContractItem().getId());
//				productIds.add(item.getProduct().getId());
//			}
//			if (!contractItemIds.isEmpty()) {
//				Map<Long, String> promotionMes = promotionService.getDetailPromotionInfo(contractItemIds,
//						member.getIsUnion());
//				model.addAttribute("promotionMes", promotionMes);
//			}
//
//		}
//		if (StringUtil.isEmpty(error)) {
//			model.addAttribute("error", error);
//		}
//		model.addAttribute("cart", cart);
//		if (cart != null) {
//			model.addAttribute("expiredNum", cart.getExpireList().size());
//		}
//		Map<Long, String> manMap = manufacturerService.findByProductIds(productIds);
//		model.addAttribute("manMap", manMap);
//		model.addAttribute("validateMessage", Message.error("shop.cart.contractDateExpire"));
//		return "/shop/cart/list";
//	}

//	/**
//	 * 异步传输列表
//	 */
//	@RequestMapping(value = "/list_cart", method = RequestMethod.GET)
//	@ResponseBody
//	public Cart list() {
//		Cart cart = cartService.findByStoreId();
//		cartService.orderCartItemsByTime(cart);
//		return cart;
//	}

	/**
	 * 编辑
	 */
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> edit(Long id, Integer quantity) {
//		Map<String, Object> data = new HashMap<String, Object>();
//		if (quantity == null || quantity < 1) {
//			data.put("message", ERROR_MESSAGE);
//			return data;
//		}
//		Cart cart = cartService.findByStoreId();
//		if (cart == null || cart.isEmpty()) {
//			data.put("message", Message.error("shop.cart.notEmpty"));
//			return data;
//		}
//		CartItem cartItem = cartItemService.find(id);
//		Set<CartItem> cartItems = cart.getCartItems();
//		if (cartItem == null || cartItems == null || !cartItems.contains(cartItem)) {
//			data.put("message", Message.error("shop.cart.cartItemNotExsit"));
//			return data;
//		}
//
//		Product product = cartItem.getProduct();
//		ContractProductItem contractProductItem = cartItem.getContractItem();
//		// 已下架
//		if (!contractProductItem.getIsMarketable()) {
//			data.put("message", Message.warn("shop.cart.productNotMarketable"));
//			return data;
//		}
//
//		// 判断当前时间是不是在上架时间范围
//		if (!(new Date().after(contractProductItem.getProductStartDate()) && new Date().before(contractProductItem
//				.getProductExpireDate()))) {
//			data.put("message", Message.warn("shop.cart.productNotMarketable"));
//			return data;
//		}
//		// 判断数量框数量正确性
//		if (contractProductItem.getLowestSaleQuantity() > quantity) {
//			data.put("message", Message.warn("shop.cart.contractItemLowestSaleQuantity"));
//			return data;
//		}
//		cartItem.setQuantity(quantity);
//		// 拆零费用添加
//		if (product.getPackingNumber() != null && product.getPackingNumber() > 0
//				&& (cartItem.getQuantity() % product.getPackingNumber()) != 0 && product.getSeparableAccount() != null) {
//			cartItem.setSeparableAccount(product.getSeparableAccount());
//		} else {
//			cartItem.setSeparableAccount(BigDecimal.ZERO);
//		}
//		cartItemService.update(cartItem);
//
//		String promotionType = promotionService.getDetailPromotionInfo(contractProductItem.getId(), cart.getMember()
//				.getIsUnion());
//
//		data.put("message", SUCCESS_MESSAGE);
//		data.put("separableAccount", cartItem.getSeparableAccount()); //单个cartItem的拆零费用
//		data.put("subtotal", cartItem.getSubtotal()); //单个cartitem的总价格(包括拆零费用)
//		data.put("quantity", cart.getQuantity()); //cart当前的总数量
//		data.put("effectivePoint", cart.getEffectivePoint()); //cart当前的有效积分 目前没用
//		data.put("effectivePrice", cart.getEffectivePrice()); //cart当前的实际价格
//		data.put("promotionPirce", cartItem.getPromotionPrice()); //cartItem促销优惠金额
//		data.put("promotionType", promotionType); //促销具体信息
//		return data;
//	}

	/**
	 * 删除
	 */
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> delete(Long id) {
//		Map<String, Object> data = new HashMap<String, Object>();
//		Cart cart = cartService.findByStoreId();
//		if (cart == null || cart.isEmpty()) {
//			data.put("message", Message.error("shop.cart.notEmpty"));
//			return data;
//		}
//		CartItem cartItem = cartItemService.find(id);
//		Set<CartItem> cartItems = cart.getCartItems();
//		if (cartItem == null || cartItems == null || !cartItems.contains(cartItem)) {
//			data.put("message", Message.error("shop.cart.cartItemNotExsit"));
//			return data;
//		}
//		cartItems.remove(cartItem);
//		cartItemService.delete(cartItem);
//
//		data.put("message", SUCCESS_MESSAGE);
//		data.put("quantity", cart.getQuantity());
//		data.put("productAmmount", cart.getCartItems().size());
//		return data;
//	}

	/**
	 * 清空
	 */
//	@RequestMapping(value = "/clear", method = RequestMethod.POST)
//	public ModelAndView clear( HttpServletRequest request,
//							   ModelMap model) {
////		Cart cart = cartService.findByStoreId();
////		cartService.delete(cart);
//		super.success(model,true);
//		return new ModelAndView(VIEW_SUCCESS);
//	}

	/**
	 * 清空失效商品
	 */
	@RequestMapping(value = "/clearExpire", method = RequestMethod.POST)
	public ModelAndView clearExpire(HttpServletRequest request,
                                    ModelMap model) {
//		Cart cart = cartService.findByStoreId();
//		for (CartItem item : cart.getExpireList()) {
//			cartItemService.delete(item);
//		}
		super.success(model,true);
		return new ModelAndView(VIEW_SUCCESS);

	}
}
