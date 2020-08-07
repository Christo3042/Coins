package me.christo.trees;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;
import me.christo.trees.Listeners.PlaceListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        this.getServer().getPluginManager().registerEvents(new PlaceListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadSchematic(Player p) {
        Location location = p.getLocation();
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schematic = new File(this.getDataFolder() + File.separator + "/schematics/test.schematic");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()), 1000);
        try {
            CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
            clipboard.rotate2D(90);
            clipboard.paste(session, new Vector(location.getBlockX(), location.getBlockY(), location.getBlockZ()), false);
        } catch (MaxChangedBlocksException | DataException | IOException e) {
            e.printStackTrace();
        }

    }
    public static Main getInstance() {
        return instance;
    }

}
