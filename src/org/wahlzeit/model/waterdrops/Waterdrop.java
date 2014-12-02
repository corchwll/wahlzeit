package org.wahlzeit.model.waterdrops;

/**
 * Created by fertigt on 02/12/14.
 */
public class Waterdrop
{
	protected WaterdropTechniqueEnum technique = WaterdropTechniqueEnum.WATER;
	protected WaterdropFormEnum form = WaterdropFormEnum.NONE;
	protected Influence influence = Influence.none;

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
