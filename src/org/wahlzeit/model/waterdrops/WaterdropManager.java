package org.wahlzeit.model.waterdrops;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fertigt on 02/12/14.
 */
public class WaterdropManager
{
	protected static WaterdropManager waterdropManager = null;

	/**
	 * @methodtype get method
	 */
	public static WaterdropManager getInstance()
	{
		if(waterdropManager == null)
		{
			waterdropManager = new WaterdropManager();
		}

		return waterdropManager;
	}

	/**
	 * @methodtype constructor
	 */
	protected WaterdropManager()
	{}

	/**
	 * @methodtype factory
	 */
	public Waterdrop createWaterdrop(String techniqueAsString, String formAsString, String influenceAsString)
	{
		assert techniqueAsString != null && formAsString != null && influenceAsString != null;

		Waterdrop waterdrop = new Waterdrop();

		waterdrop.setTechnique(WaterdropTechniqueEnum.valueOf(techniqueAsString));
		waterdrop.setForm(WaterdropFormEnum.valueOf(formAsString));
		waterdrop.setInfluence(Influence.valueOf(influenceAsString));

		assert waterdrop.getTechnique() != null && waterdrop.getForm() != null && waterdrop.influence != null;
		return waterdrop;
	}

	/**
	 *
	 * @methodtype command method
	 */
	public void saveWaterdrop(ResultSet rset, Waterdrop waterdrop) throws SQLException
	{
		assert !rset.isClosed() && waterdrop != null;
		rset.updateString(WaterdropPhoto.TECHNIQUE, waterdrop.getTechnique().name());
		rset.updateString(WaterdropPhoto.FORM, waterdrop.getForm().name());
		rset.updateString(WaterdropPhoto.INFLUENCE, waterdrop.getInfluence().name());
		assert !rset.isClosed();
	}
}
