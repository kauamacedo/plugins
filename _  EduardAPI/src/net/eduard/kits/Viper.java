package net.eduard.kits;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import net.eduard.api.API;
import net.eduard.api.dev.Potions;
import net.eduard.api.gui.Kit;

public class Viper extends Kit {
	public double chance = 0.3;
	public Potions effect = new Potions(PotionEffectType.POISON, 0, 20 * 5);

	public Viper() {
		setIcon(Material.SPIDER_EYE, "Envene seus inimigos");
	}

	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (hasKit(p)) {
				if (e.getEntity() instanceof LivingEntity) {
					LivingEntity livingEntity = (LivingEntity) e.getEntity();
					if (API.getChance(chance)) {
						effect.create(livingEntity);
					}
				}
				
			}

		}
	}
}
