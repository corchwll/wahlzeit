package org.wahlzeit.model.waterdrops;

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
	 *
	 * @methodtype initialization method
	 */
	@Override
	public void readFrom(ResultSet rset) throws SQLException
	{
		assert !rset.isClosed();
		super.readFrom(rset);

		String technique = rset.getString(TECHNIQUE);
		String form = rset.getString(FORM);
		String influence = rset.getString(INFLUENCE);
		this.waterdrop = WaterdropManager.getInstance().createWaterdrop(technique, form, influence);

		assert waterdrop.getTechnique() != null && waterdrop.getForm() != null && waterdrop.getInfluence() != null;
	}

	/**
	 *
	 * @methodtype command method
	 */
	@Override
	public void writeOn(ResultSet rset) throws SQLException
	{
		assert !rset.isClosed();
		super.writeOn(rset);

		WaterdropManager.getInstance().saveWaterdrop(rset, this.waterdrop);
		assert !rset.isClosed();
	}

	/**
	 *
	 * @methodtype get method
	 */
	public Waterdrop getWaterdrop()
	{
		return this.waterdrop;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setWaterdrop(Waterdrop waterdrop)
	{
		assert waterdrop != null;
		this.waterdrop = waterdrop;
		incWriteCount();
	}
}
