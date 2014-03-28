package io.github.aXSSor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
  
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Main(), this);
		System.out.println(ChatColor.GREEN + "> Fireworks plugin - Created by aXSSor - Running on " + Bukkit.getBukkitVersion());
	}
	public void onDisable(){
		System.out.println(ChatColor.RED + "> Fireworks Plugin DISABLED");
	}

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
    Player player = (Player)sender;


    if (cmd.getName().equalsIgnoreCase("fw")) {
      if (player.hasPermission("fw.user"))
    	  fireworkuser(player);
      else {
        player.sendMessage(ChatColor.RED + " You cannot access this feature! If you believe this is an error, Type /report");
      }
    }
    return false;
  }

  public void fireworkuser(Player player) {
	player.sendMessage(ChatColor.GREEN + "Fireworks!");
    Firework fw = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
    FireworkMeta fwmeta = fw.getFireworkMeta();
    FireworkEffect.Builder builder = FireworkEffect.builder();
    builder.withTrail();
    builder.withFlicker();
    builder.withColor(Color.FUCHSIA);
    builder.withColor(Color.PURPLE);
    builder.withColor(Color.WHITE);
    builder.withColor(Color.AQUA);
    builder.withColor(Color.RED);
    builder.withColor(Color.BLACK);
    builder.with(FireworkEffect.Type.BALL);
    fwmeta.addEffects(new FireworkEffect[] { builder.build() });
    fwmeta.setPower(1);
    fw.setFireworkMeta(fwmeta);
  }
}