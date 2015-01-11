package org.wahlzeit.model.waterdrops;

/**
 * Created by fertigt on 24/11/14.
 */
public enum WaterdropTechniqueEnum
{
	WATER_SOLID_SMOKE_SOAPFILM(true, Liquid.water, true, true),
	WATER_SMOKE_SOAPFILM(false, Liquid.water, true, true),
	WATER_SMOKE(false, Liquid.water, true, false),
	WATER_SOLID_SMOKE(true, Liquid.water, true, false),
	WATER_SOLID_SOAPFILM(true, Liquid.water, false, true),
	WATER_SOLID(true, Liquid.water, false, false),
	WATER_SOAPFILM(false, Liquid.water, false, true),
	PAINT_SMOKE(false, Liquid.paint, true, false),
	MILK_SMOKE(false, Liquid.milk, true, false),
	WATER(false, Liquid.water, false, false),
	PAINT(false, Liquid.paint, false, false),
	MILK(false, Liquid.milk, false, false);

	private boolean solidSurface;
	private Liquid liquid = Liquid.water;
	private boolean smoke;
	private boolean soapFilm;

	/**
	 * @methodtype constructor
	 */
	WaterdropTechniqueEnum(boolean solidSurface, Liquid liquid, boolean smoke, boolean soapFilm)
	{
		this.solidSurface = solidSurface;
		this.liquid = liquid;
		this.smoke = smoke;
		this.soapFilm = soapFilm;
	}

	/**
	 * @methodtype boolean query method
	 */
	public boolean isSolidSurface()
	{
		return solidSurface;
	}

	/**
	 * @methodtype get method
	 */
	public Liquid getLiquid()
	{
		return liquid;
	}

	/**
	 * @methodtype boolean query method
	 */
	public boolean isSmoke()
	{
		return smoke;
	}

	/**
	 * @methodtype boolean query method
	 */
	public boolean isSoapFilm()
	{
		return soapFilm;
	}

	/**
	 * @methodtype conversion method
	 */
	public String asString()
	{
		String technique = "";
		if(isSolidSurface())
			technique += "Solid surface;";
		technique += "Liquid=" + getLiquid().name() + ";";
		if(isSmoke())
			technique += "Smoke;";
		if(isSoapFilm())
			technique += "Soap film;";

		return technique;
	}
}
