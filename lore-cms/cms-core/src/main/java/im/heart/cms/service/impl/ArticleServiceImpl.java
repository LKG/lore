package im.heart.cms.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import im.heart.cms.entity.Article;
import im.heart.cms.repository.ArticleRepository;
import im.heart.cms.service.ArticleService;
import im.heart.core.service.impl.CommonServiceImpl;

@Service(value = ArticleService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS)
public class ArticleServiceImpl extends CommonServiceImpl<Article, BigInteger> implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public List<Article> save(Iterable<Article> entities) {
		return this.articleRepository.save(entities);
	}

	@Override
	public boolean exists(BigInteger id) {
		return this.articleRepository.existsId(id);
	}

}
