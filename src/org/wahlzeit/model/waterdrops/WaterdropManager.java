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
		try
		{
			assert techniqueAsString != null && formAsString != null && influenceAsString != null;
		} catch(Exception e)
		{
			throw new RuntimeException("The parameters have to be not null!");
		}

		Waterdrop waterdrop = new Waterdrop();

		waterdrop.setTechnique(WaterdropTechniqueEnum.valueOf(techniqueAsString));
		waterdrop.setForm(WaterdropFormEnum.valueOf(formAsString));
		waterdrop.setInfluence(Influence.valueOf(influenceAsString));

		try
		{
			assert waterdrop.getTechnique() != null && waterdrop.getForm() != null && waterdrop.influence != null;
		} catch(Exception e)
		{
			throw new RuntimeException("Something went wrong with waterdrop initialization.");
		}
		return waterdrop;
	}

	/**
	 * @collaboration manager, Waterdrop
	 * @methodtype factory
	 */
	public Waterdrop createWaterdrop(String techniqueAsString, String formAsString, String influenceAsString, String
			typeName, double size, String tool)
	{
		try
		{
			assert techniqueAsString != null && formAsString != null && influenceAsString != null && typeName != null &&
					size > 0.0 && tool != null;
		} catch(Exception e)
		{
			throw new RuntimeException("The parameters have to be not null!");
		}

		WaterdropType type = new WaterdropType(typeName, size, tool);
		Waterdrop waterdrop = new Waterdrop();

		waterdrop.setTechnique(WaterdropTechniqueEnum.valueOf(techniqueAsString));
		waterdrop.setForm(WaterdropFormEnum.valueOf(formAsString));
		waterdrop.setInfluence(Influence.valueOf(influenceAsString));
		waterdrop.setType(type);

		try
		{
			assert waterdrop.getTechnique() != null && waterdrop.getForm() != null && waterdrop.influence != null &&
					waterdrop.getType() != null;
		} catch(Exception e)
		{
			throw new RuntimeException("Something went wrong with waterdrop initialization");
		}
		return waterdrop;
	}

	/**
	 * @collaboration serializer, Waterdrop
	 * @methodtype command method
	 */
	public void saveWaterdrop(ResultSet rset, Waterdrop waterdrop) throws SQLException
	{
		try
		{
			assert !rset.isClosed() && waterdrop != null;
		} catch(Exception e)
		{
			throw new RuntimeException("ResultSet has to be open! Waterdrop should not be null!");
		}
		rset.updateString(WaterdropPhoto.TECHNIQUE, waterdrop.getTechnique().name());
		rset.updateString(WaterdropPhoto.FORM, waterdrop.getForm().name());
		rset.updateString(WaterdropPhoto.INFLUENCE, waterdrop.getInfluence().name());
		rset.updateString(WaterdropType.NAME, waterdrop.getType().getName());
		rset.updateDouble(WaterdropType.SIZE, waterdrop.getType().getWaterdropSize());
		rset.updateString(WaterdropType.TOOL, waterdrop.getType().getTool());
		try
		{
			assert !rset.isClosed();
		} catch(Exception e)
		{
			throw new RuntimeException("ResultSet has to be open!");
		}
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
