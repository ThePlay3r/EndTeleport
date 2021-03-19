package me.pljr.endteleport;

import me.pljr.endteleport.commands.EndTeleportCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class EndTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new EndTeleportCommand().registerCommand(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
