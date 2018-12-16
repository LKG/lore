package im.heart.material.parser;

import im.heart.material.entity.MaterialPeriodical;

import java.io.InputStream;

/**
 * 
 *
 * @作者 ：LKG
 */
public interface MaterialPeriodicalParser {
	public void parser(MaterialPeriodical periodical, InputStream is);
	public void addParserTask(MaterialPeriodical periodical, InputStream is) ;
}
