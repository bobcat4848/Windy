package tech.bobcat;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (!player.hasPermission("windy.*") || !player.isOp()) return false;
            if (command.getName().equalsIgnoreCase("windy")) {
                if (args.length == 0) {
                    // Display commands
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        // Start wind storms for all players in applicable biomes
                        player.playSound(player.getLocation(), Sound.BLOCK_SMOKER_SMOKE, 50, 5);
                        player.sendMessage("A wind storm has started.");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
