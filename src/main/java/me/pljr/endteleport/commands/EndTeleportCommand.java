package me.pljr.endteleport.commands;

import me.pljr.pljrapispigot.commands.BukkitCommand;
import me.pljr.pljrapispigot.utils.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class EndTeleportCommand extends BukkitCommand {

    public EndTeleportCommand(){
        super("endteleport", "endteleport.use");
    }

    @Override
    public void onConsoleCommand(ConsoleCommandSender sender, String[] args) {
        if (args.length > 0 && checkPlayer(sender, args[0])){
            Player player = Bukkit.getPlayer(args[0]);
            World world = Bukkit.getWorld("world_the_end");
            if (world == null){
                System.out.println("World world_the_end doesn't exist!");
                return;
            }
            Location location = new Location(world, 100.500, 49, 0.500);
            List<Location> airList = new ArrayList<>();
            airList.add(location.clone());
            airList.add(location.clone().add(0, 1, 0));
            airList.add(location.clone().add(0, 2, 0));
            airList.forEach(remove -> world.getBlockAt(remove).setType(Material.AIR));
            world.getBlockAt(location.clone().subtract(0, 1, 0)).setType(Material.BEDROCK);
            PlayerUtil.teleport(player, location);
        }
    }
}
