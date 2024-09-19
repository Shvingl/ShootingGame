package luke.y.shootingGame.commands;

import luke.y.shootingGame.ShootingGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartShooter implements CommandExecutor {
    ShootingGame plugin;

    public StartShooter(ShootingGame plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (Bukkit.getPlayer(args[0]) != null) {
                plugin.startGame(Bukkit.getPlayer(args[0]));
                sender.sendMessage("Hráč začal shooting game.");
            }
        }
        return false;
    }
}
