package im.heart.material.parser;

import im.heart.material.entity.Periodical;

import java.io.InputStream;

/**
 * 
 *
 * @作者 ：LKG
 */
public interface PeriodicalParser {
	public void parser(Periodical periodical, InputStream is);
	public void addParserTask(Periodical periodical, InputStream is) ;
}
