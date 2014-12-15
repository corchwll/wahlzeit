package org.wahlzeit.model.waterdrops;

import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by fertigt on 02/12/14.
 */
public class Waterdrop extends DataObject
{
	public static final String TECHNIQUE = "technique";
	public static final String FORM = "form";
	public static final String INFLUENCE = "influence";

	protected WaterdropTechniqueEnum technique = WaterdropTechniqueEnum.WATER;
	protected WaterdropFormEnum form = WaterdropFormEnum.NONE;
	protected Influence influence = Influence.none;
	protected WaterdropType type;

	protected WaterdropId id = null;

	/**
	 * @methodtype constructor
	 */
	public Waterdrop()
	{}

	/**
	 * @methodtype constructor
	 */
	public Waterdrop(WaterdropTechniqueEnum technique, WaterdropFormEnum form, Influence influence)
	{
		this.technique = technique;
		this.form = form;
		this.influence = influence;
	}

	/**
	 * @methodtype constructor
	 */
	public Waterdrop(WaterdropTechniqueEnum technique, WaterdropFormEnum form, Influence influence, WaterdropType type)
	{
		this.technique = technique;
		this.form = form;
		this.influence = influence;
		this.type = type;
	}

	/**
	 * @methodtype constructor
	 */
	public Waterdrop(ResultSet rset) throws SQLException
	{
		readFrom(rset);
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

	/**
	 *
	 * @methodtype get method
	 */
	public WaterdropType getType()
	{
		return type;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setType(WaterdropType type)
	{
		this.type = type;
	}

	@Override
	public String getIdAsString()
	{
		return String.valueOf(id.asInt());
	}

	@Override
	public void readFrom(ResultSet rset) throws SQLException
	{

	}

	@Override
	public void writeOn(ResultSet rset) throws SQLException
	{

	}

	@Override
	public void writeId(PreparedStatement stmt, int pos) throws SQLException
	{

	}
}
