package org.wahlzeit.model.waterdrops;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fertigt on 02/12/14.
 */
public class WaterdropManager
{
	protected static WaterdropManager waterdropManager = null;

	public static WaterdropManager getInstance()
	{
		if(waterdropManager == null)
		{
			waterdropManager = new WaterdropManager();
		}

		return waterdropManager;
	}

	protected WaterdropManager()
	{}

	public Waterdrop createWaterdrop(String techniqueAsString, String formAsString, String influenceAsString)
	{
		Waterdrop waterdrop = new Waterdrop();

		waterdrop.setTechnique(WaterdropTechniqueEnum.valueOf(techniqueAsString));
		waterdrop.setForm(WaterdropFormEnum.valueOf(formAsString));
		waterdrop.setInfluence(Influence.valueOf(influenceAsString));

		return waterdrop;
	}

	public void saveWaterdrop(ResultSet rset, Waterdrop waterdrop) throws SQLException
	{
		rset.updateString(WaterdropPhoto.TECHNIQUE, waterdrop.getTechnique().name());
		rset.updateString(WaterdropPhoto.FORM, waterdrop.getForm().name());
		rset.updateString(WaterdropPhoto.INFLUENCE, waterdrop.getInfluence().name());
	}
}
