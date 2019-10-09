package tech.bobcat;

import com.sun.istack.internal.NotNull;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.ArrayList;
import java.util.List;

public class WindChange implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if (!Windy.config.getBoolean("Windy.enabled")) return;
        System.out.println("Windy starting wind...");

        List<Biome> enabledBiomes = getListOfBiomes(Windy.config.getList("Windy.biomes"));
        for (Player p : e.getWorld().getPlayers()) {
            Location loc = p.getLocation();
            Biome b = loc.getBlock().getBiome();
            for (Biome biome : enabledBiomes) {
                if (b == biome) {

                    // Conditional if checks to see if player is under cover, if they aren't apply wind sound/effect.
                    // Can be improved to check to see if player is within a house with blocks on all sides.
                    if (loc.getBlockY() + 1 <= loc.getWorld().getHighestBlockYAt(loc)) {
                        p.playSound(loc, Sound.ENTITY_PARROT_FLY, 50, 50);

                    }
                }
            }
        }
    }

    public List<Biome> getListOfBiomes(List<?> objectList) {
        List<Biome> biomes = new ArrayList<>();
        for (Object o : objectList) {
            if (o instanceof Biome) {
                biomes.add(Biome.valueOf(o.toString()));
            }
        }
        return biomes;
    }
}
