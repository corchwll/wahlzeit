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

	protected WaterdropTechniqueEnum technique = WaterdropTechniqueEnum.WATER;
	protected WaterdropFormEnum form = WaterdropFormEnum.NONE;
	protected Influence influence = Influence.none;

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
		super.readFrom(rset);

		this.technique = WaterdropTechniqueEnum.valueOf(rset.getString(TECHNIQUE));
		this.form = WaterdropFormEnum.valueOf(rset.getString(FORM));
		this.influence = Influence.valueOf(rset.getString(INFLUENCE));
	}

	/**
	 *
	 * @methodtype command method
	 */
	@Override
	public void writeOn(ResultSet rset) throws SQLException
	{
		super.writeOn(rset);

		rset.updateString(TECHNIQUE, technique.name());
		rset.updateString(FORM, form.name());
		rset.updateString(INFLUENCE, influence.name());
	}

	/**
	 *
	 * @methodtype get method
	 */
	public WaterdropTechniqueEnum getTechnique()
	{
		return technique;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setTechnique(WaterdropTechniqueEnum technique)
	{
		this.technique = technique;
	}

	/**
	 *
	 * @methodtype get method
	 */
	public WaterdropFormEnum getForm()
	{
		return form;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setForm(WaterdropFormEnum form)
	{
		this.form = form;
	}

	/**
	 *
	 * @methodtype get method
	 */
	public Influence getInfluence()
	{
		return influence;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setInfluence(Influence influence)
	{
		this.influence = influence;
	}
}
