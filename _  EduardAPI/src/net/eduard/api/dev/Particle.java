package net.eduard.api.dev;


import java.lang.reflect.Constructor;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.eduard.api.config.Section;
import net.eduard.api.manager.RexAPI;
import net.eduard.api.util.ParticleType;
import net.eduard.api.util.Save;

public class Particle implements Save{


	private Location location;

	private int amount;

	private ParticleType particle;

	private float speed;

	private float xRandom;

	private float yRandom;

	private float zRandom;

	public Particle(ParticleType type, Location location, int amount) {
		setLocation(location);
		setAmount(amount);
		setParticle(type);
	}

	public Particle(ParticleType type, Location location, int amount,
		float random, float speed) {

		this(type, location, amount);
		setxRandom(random);
		setyRandom(random);
		setzRandom(random);
		setSpeed(speed);
	}

	public Particle(ParticleType type, Location location, int amount,
		float xRandom, float yRandom, int zRandom) {

		this(type, location, amount);
		setxRandom(xRandom);
		setyRandom(yRandom);
		setzRandom(zRandom);
	}

	public Particle(ParticleType type, Location location, int amount,
		float xRandom, float yRandom, int zRandom, float speed) {

		this(type, location, amount, xRandom, yRandom, zRandom);
		setSpeed(speed);
	}

	public Particle create() {
		RexAPI.sendPackets(getPacket());
		return this;
	}

	private Object getPacket() {

		try {
			Class<?> PacketPlayOutWorldParticlesClass = RexAPI.getMine("PacketPlayOutWorldParticles");
			
			Constructor<?> constructor =
				PacketPlayOutWorldParticlesClass.getConstructor(
					String.class, float.class, float.class, float.class,
					float.class, float.class, float.class, float.class,
					int.class);
			return constructor.newInstance(particle.getParticleName(),
				(float) location.getX(), (float) location.getY(),
				(float) location.getZ(), xRandom, yRandom, zRandom, speed,
				amount);

		} catch (Exception ex) {
			try {
				RexAPI.getNew(RexAPI.getCraft("PacketPlayOutWorldParticles"), particle.getParticleName(),
						(float) location.getX(), (float) location.getY(),
						(float) location.getZ(), xRandom, yRandom, zRandom, speed,
						amount);
			} catch (Exception ex2) {
			}
		}
		return null;
	}

	public Particle create(Player p) {

		try {
			RexAPI.sendPacket(getPacket(),p);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this;
	}

	public int getAmount() {

		return amount;
	}

	public Location getLocation() {

		return location;
	}

	public ParticleType getParticle() {

		return particle;
	}

	public float getSpeed() {

		return speed;
	}

	public float getxRandom() {

		return xRandom;
	}

	public float getyRandom() {

		return yRandom;
	}

	public float getzRandom() {

		return zRandom;
	}

	public void setAmount(int amount) {

		this.amount = amount;
	}

	public void setLocation(Location location) {

		this.location = location;
	}

	public void setParticle(ParticleType particle) {

		this.particle = particle;
	}

	public void setSpeed(float speed) {

		this.speed = speed;
	}

	public void setxRandom(float xRandom) {

		this.xRandom = xRandom;
	}

	public void setyRandom(float yRandom) {

		this.yRandom = yRandom;
	}

	public void setzRandom(float zRandom) {

		this.zRandom = zRandom;
	}

	public void save(Section section, Object value) {
		
	}

	public Object get(Section section) {
		return null;
	}
}

