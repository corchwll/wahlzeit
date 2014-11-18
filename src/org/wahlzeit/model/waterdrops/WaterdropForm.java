package org.wahlzeit.model.waterdrops;

/**
 * Created by fertigt on 18/11/14.
 * @invariant form bubble can not be combined with doublePillar or crown
 */
public class WaterdropForm
{
	private boolean doublePillar;
	private boolean bubble;
	private boolean highPillar;
	private boolean crown;
	private boolean fontain;

	/**
	 * @methodtype constructor
	 */
	public WaterdropForm()
	{}

	/**
	 * @pre form bubble can not be combined with doublePillar or crown
	 * @post correct values will be set
	 * @methodtype constructor
	 */
	public WaterdropForm(boolean doublePillar, boolean bubble, boolean highPillar, boolean crown, boolean fontain)
	{
		setDoublePillar(doublePillar);
		setBubble(bubble);
		setHighPillar(highPillar);
		setCrown(crown);
		setFontain(fontain);
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isDoublePillar()
	{
		return doublePillar;
	}

	/**
	 * @pre doublePillar can not be combined with bubble
	 * @post correct values will be set
	 * @methodtype set method
	 */
	public void setDoublePillar(boolean doublePillar) throws RuntimeException
	{
		if(doublePillar && bubble)
			throw new RuntimeException("invariant violated");

		this.doublePillar = doublePillar;
		assert(this.doublePillar == doublePillar);
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isBubble()
	{
		return bubble;
	}

	/**
	 * @pre bubble cannot be combined with doublePillar or crown
	 * @post correct values will be set
	 * @methodtype set method
	 */
	public void setBubble(boolean bubble) throws RuntimeException
	{
		if(bubble && (doublePillar || crown))
			throw new RuntimeException("invariant violated");

		this.bubble = bubble;
		assert(this.bubble == bubble);
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isHighPillar()
	{
		return highPillar;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setHighPillar(boolean highPillar)
	{
		this.highPillar = highPillar;
		assert(this.highPillar == highPillar);
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isCrown()
	{
		return crown;
	}

	/**
	 * @pre crown can not be combined with bubble
	 * @post correct values will be set
	 * @methodtype set method
	 */
	public void setCrown(boolean crown) throws RuntimeException
	{
		if(crown && bubble)
			throw new RuntimeException("invariant violated");

		this.crown = crown;
		assert(this.crown == crown);
	}

	/**
	 *
	 * @methodtype boolean query method
	 */
	public boolean isFontain()
	{
		return fontain;
	}

	/**
	 *
	 * @methodtype set method
	 */
	public void setFontain(boolean fontain)
	{
		this.fontain = fontain;
		assert(this.fontain == fontain);
	}
}
