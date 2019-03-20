package im.heart.material.packs.impl;

import java.io.File;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import im.heart.material.entity.PeriodicalPackage;
import im.heart.material.packs.PackageDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import im.heart.core.utils.StringUtilsEx;

public abstract class AbstractPacker<T> implements PackageDataService {
	
	protected static final Logger logger = LoggerFactory.getLogger(AbstractPacker.class);
	/**
	 * 
	 * @功能说明：写入数据包信息
	 * @param dbpath
	 * @param materialPackage
	 * @throws SQLException
	 */
	protected void insertDataInfo(String dbpath, PeriodicalPackage materialPackage) throws SQLException{

	}
	public abstract File createDbFile(String templateFilePath,File file) throws Exception ;

}
