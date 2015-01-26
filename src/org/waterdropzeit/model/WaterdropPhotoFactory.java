package org.waterdropzeit.model;

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
	 * @collaboration factory, WaterdropPhoto
	 * @methodtype factory
	 */
	@Override
	public WaterdropPhoto createPhoto()
	{
		return new WaterdropPhoto();
	}

	/**
	 * @collaboration factory, WaterdropPhoto
	 * @methodtype factory
	 */
	@Override
	public WaterdropPhoto createPhoto(PhotoId id)
	{
		return new WaterdropPhoto(id);
	}

	/**
	 * @collaboration factory, WaterdropPhoto
	 * @methodtype factory
	 */
	@Override
	public WaterdropPhoto createPhoto(ResultSet rs) throws SQLException
	{
		return new WaterdropPhoto(rs);
	}
}
