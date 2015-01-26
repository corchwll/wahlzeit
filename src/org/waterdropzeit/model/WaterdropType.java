package org.waterdropzeit.model;

/**
 * Created by fertigt on 15/12/14.
 */
public class WaterdropType
{
	public static final String NAME = "typename";
	public static final String SIZE = "size";
	public static final String TOOL = "tool";

	private String name;
	private double waterdropSize;
	private String tool;

	/**
	 * @methodtype constructor
	 */
	public WaterdropType(String name, double waterdropSize, String tool)
	{
		this.name = name;
		this.waterdropSize = waterdropSize;
		this.tool = tool;
	}

	/**
	 *
	 * @methodtype get method
	 */
	public String getName()
	{
		return name;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setName(String name)
	{
		assert name != null;
		this.name = name;
	}

	/**
	 *
	 * @methodtype get method
	 */
	public double getWaterdropSize()
	{
		return waterdropSize;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setWaterdropSize(double waterdropSize)
	{
		try
		{
			assert waterdropSize > 0.0;
			this.waterdropSize = waterdropSize;
		} catch(Exception e)
		{
			throw new RuntimeException("Waterdrop size has to be positive");
		}
	}

	/**
	 *
	 * @methodtype get method
	 */
	public String getTool()
	{
		return tool;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setTool(String tool)
	{
		assert tool != null;
		this.tool = tool;
	}
}
