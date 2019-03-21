package im.heart.cms.repository;

import im.heart.cms.entity.ArticleCategory;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gg
 * @desc 文章分类接口
 */
@Repository
public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, BigInteger> ,JpaSpecificationExecutor<ArticleCategory> {


}
