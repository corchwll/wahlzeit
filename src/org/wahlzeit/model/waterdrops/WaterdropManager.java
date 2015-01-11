package org.wahlzeit.model.waterdrops;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fertigt on 02/12/14.
 */
public class WaterdropManager extends ObjectManager
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
	 * @collaboration manager, Waterdrop
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
	 * @collaboration manager, Waterdrop
	 * @methodtype factory
	 */
	public Waterdrop createWaterdrop(String techniqueAsString, String formAsString, String influenceAsString, String
			typeName, double size, String tool)
	{
		assert techniqueAsString != null && formAsString != null && influenceAsString != null && typeName != null &&
				size > 0.0 && tool != null;

		WaterdropType type = new WaterdropType(typeName, size, tool);
		Waterdrop waterdrop = new Waterdrop();

		waterdrop.setTechnique(WaterdropTechniqueEnum.valueOf(techniqueAsString));
		waterdrop.setForm(WaterdropFormEnum.valueOf(formAsString));
		waterdrop.setInfluence(Influence.valueOf(influenceAsString));
		waterdrop.setType(type);

		assert waterdrop.getTechnique() != null && waterdrop.getForm() != null && waterdrop.influence != null &&
				waterdrop.getType() != null;
		return waterdrop;
	}

	/**
	 * @collaboration serializer, Waterdrop
	 * @methodtype command method
	 */
	public void saveWaterdrop(ResultSet rset, Waterdrop waterdrop) throws SQLException
	{
		assert !rset.isClosed() && waterdrop != null;
		rset.updateString(WaterdropPhoto.TECHNIQUE, waterdrop.getTechnique().name());
		rset.updateString(WaterdropPhoto.FORM, waterdrop.getForm().name());
		rset.updateString(WaterdropPhoto.INFLUENCE, waterdrop.getInfluence().name());
		rset.updateString(WaterdropType.NAME, waterdrop.getType().getName());
		rset.updateDouble(WaterdropType.SIZE, waterdrop.getType().getWaterdropSize());
		rset.updateString(WaterdropType.TOOL, waterdrop.getType().getTool());
		assert !rset.isClosed();
	}

	/**
	 * @collaboration serializer, Waterdrop
	 */
	@Override
	protected Persistent createObject(ResultSet rset) throws SQLException
	{
		return new Waterdrop(rset);
	}
}
