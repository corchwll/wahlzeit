package org.wahlzeit.model.waterdrops;

/**
 * Created by fertigt on 18/11/14.
 *
 * @invariant solidSurface should only be true with liquid water
 */
public class WaterdropTechnique
{
	private boolean solidSurface;
	private Liquid liquid = Liquid.water;
	private boolean smoke;
	private boolean soapFilm;

	/**
	 * @methodtype constructor
	 */
	public WaterdropTechnique()
	{}

	/**
	 *
	 * @pre solidSurface should only be true with liquid water
	 * @post no null or wrong values will be set
	 * @methodtype constructor
	 */
	public WaterdropTechnique(boolean solidSurface, Liquid liquid, boolean smoke, boolean soapFilm)
	{
		setSolidSurface(solidSurface);
		setLiquid(liquid);
		setSmoke(smoke);
		setSoapFilm(soapFilm);

		assert(this.liquid != null);
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isSolidSurface()
	{
		return solidSurface;
	}

	/**
	 *
	 * @pre solidSurface should only be true with liquid water or liquid hasn't been specified yet
	 * @post no null value will be set
	 * @methodtype set method
	 */
	public void setSolidSurface(boolean solidSurface) throws RuntimeException
	{
		if(solidSurface && !liquid.equals(Liquid.water))
			throw new RuntimeException("invariant violated");

		this.solidSurface = solidSurface;
		assert(solidSurface == this.solidSurface);
	}

	/**
	 *
	 * @methodtype get method
	 */
	public Liquid getLiquid()
	{
		return liquid;
	}

	/**
	 *
	 * @pre if solidSurface is true, only water should be set as liquid
	 * @post correct value will be set
	 * @methodtype set method
	 */
	public void setLiquid(Liquid liquid) throws RuntimeException
	{
		if(solidSurface && !liquid.equals(Liquid.water))
			throw new RuntimeException("invariant violated!");

		this.liquid = liquid;
		assert this.liquid.equals(liquid);
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isSmoke()
	{
		return smoke;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setSmoke(boolean smoke)
	{
		this.smoke = smoke;
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isSoapFilm()
	{
		return soapFilm;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setSoapFilm(boolean soapFilm)
	{
		this.soapFilm = soapFilm;
	}
}
