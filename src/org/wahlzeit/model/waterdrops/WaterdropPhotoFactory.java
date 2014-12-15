package org.wahlzeit.model.waterdrops;

import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fertigt on 06/12/14.
 */
public class WaterdropPhotoFactory extends PhotoFactory
{
	/**
	 * @methodtype constructor
	 */
	public WaterdropPhotoFactory()
	{

	}

	/**
	 * @methodtype factory
	 */
	@Override
	public WaterdropPhoto createPhoto()
	{
		return new WaterdropPhoto();
	}

	/**
	 * @methodtype factory
	 */
	@Override
	public WaterdropPhoto createPhoto(PhotoId id)
	{
		return new WaterdropPhoto(id);
	}

	/**
	 * @methodtype factory
	 */
	@Override
	public WaterdropPhoto createPhoto(ResultSet rs) throws SQLException
	{
		return new WaterdropPhoto(rs);
	}
}
