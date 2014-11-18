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

	public boolean isDoublePillar()
	{
		return doublePillar;
	}

	/**
	 * @pre doublePillar can not be combined with bubble
	 * @post correct values will be set
	 */
	public void setDoublePillar(boolean doublePillar)
	{
		assert(doublePillar && !bubble);
		this.doublePillar = doublePillar;
		assert(this.doublePillar == doublePillar);
	}

	public boolean isBubble()
	{
		return bubble;
	}

	/**
	 * @pre bubble cannot be combined with doublePillar or crown
	 * @post correct values will be set
	 */
	public void setBubble(boolean bubble)
	{
		assert(bubble && !doublePillar && !crown);
		this.bubble = bubble;
		assert(this.bubble == bubble);
	}

	public boolean isHighPillar()
	{
		return highPillar;
	}

	public void setHighPillar(boolean highPillar)
	{
		this.highPillar = highPillar;
		assert(this.highPillar == highPillar);
	}

	public boolean isCrown()
	{
		return crown;
	}

	/**
	 * @pre crown can not be combined with bubble
	 * @post correct values will be set
	 */
	public void setCrown(boolean crown)
	{
		assert(crown && !bubble);
		this.crown = crown;
		assert(this.crown == crown);
	}

	public boolean isFontain()
	{
		return fontain;
	}

	public void setFontain(boolean fontain)
	{
		this.fontain = fontain;
		assert(this.fontain == fontain);
	}
}
