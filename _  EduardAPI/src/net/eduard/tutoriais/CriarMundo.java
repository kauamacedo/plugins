package net.eduard.tutoriais;

import org.bukkit.WorldCreator;

public class CriarMundo {
	public CriarMundo(String nome) {
		WorldCreator m = new WorldCreator(nome);
		m.createWorld();
	}
}
