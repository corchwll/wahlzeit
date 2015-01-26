package org.waterdropzeit.model;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fertigt on 18/11/14.
 */
public class WaterdropPhoto extends Photo
{
	public static final String TECHNIQUE = "technique";
	public static final String FORM = "form";
	public static final String INFLUENCE = "influence";

	protected Waterdrop waterdrop;

	/**
	 *
	 * @methodtype constructor
	 */
	public WaterdropPhoto() {
		super();
	}

	/**
	 *
	 * @methodtype constructor
	 */
	public WaterdropPhoto(PhotoId myId) {
		super(myId);
	}

	/**
	 *
	 * @methodtype constructor
	 */
	public WaterdropPhoto(ResultSet rset) throws SQLException
	{
		super(rset);
	}

	/**
	 * @collaboration serializer, PhotoManager
	 * @methodtype initialization method
	 */
	@Override
	public void readFrom(ResultSet rset) throws SQLException
	{
		try
		{
			assert !rset.isClosed();
		} catch(Exception e)
		{
			throw new RuntimeException("ResultSet has to be open!");
		}
		super.readFrom(rset);

		String technique = rset.getString(TECHNIQUE);
		String form = rset.getString(FORM);
		String influence = rset.getString(INFLUENCE);
		this.waterdrop = WaterdropManager.getInstance().createWaterdrop(technique, form, influence);

		try
		{
			assert waterdrop.getTechnique() != null && waterdrop.getForm() != null && waterdrop.getInfluence() != null;
		} catch(Exception e)
		{
			throw new RuntimeException("Something went wrong with initialization.");
		}
	}

	/**
	 * @collaboration serializer, PhotoManager
	 * @methodtype command method
	 */
	@Override
	public void writeOn(ResultSet rset) throws SQLException
	{
		try
		{
			assert !rset.isClosed();
		} catch(Exception e)
		{
			throw new RuntimeException("ResultSet has to be open!");
		}
		super.writeOn(rset);

		WaterdropManager.getInstance().saveWaterdrop(rset, this.waterdrop);
		try
		{
			assert !rset.isClosed();
		} catch(Exception e)
		{
			throw new RuntimeException("ResultSet has to be open!");
		}
	}

	/**
	 * @collaboration WaterdropPhoto/Waterdrop, Waterdrop
	 * @methodtype get method
	 */
	public Waterdrop getWaterdrop()
	{
		return this.waterdrop;
	}

	/**
	 * @collaboration WaterdropPhoto/Waterdrop, Waterdrop
	 * @methodtype set method
	 */
	public void setWaterdrop(Waterdrop waterdrop)
	{
		try
		{
			assert waterdrop != null;
		} catch(Exception e)
		{
			throw new RuntimeException("Waterdrop should not be null");
		}
		this.waterdrop = waterdrop;
		incWriteCount();
	}
}
