package riespanda.twitch.tv.commandblockplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;


public class BlockClickEvent implements Listener {
    private static CommandBlockPlugin plugin;

    public BlockClickEvent(CommandBlockPlugin plugin) {
        this.plugin = plugin;

    }


    @EventHandler
    public void onRightClickBlock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        List<String> commands = (List<String>) plugin.getConfig().getStringList("command-ran-by-player");
        List<String> rightclickedblocks = (List<String>) plugin.getConfig().getStringList(("right-clicked-blocks"));
        player.getInventory().getItemInMainHand();


        if ((event.getAction()) == (Action.RIGHT_CLICK_BLOCK)) {
            if((event.getHand()) == (EquipmentSlot.HAND)) {
                if ((event.getClickedBlock()) == (null))
                    return;
                if (rightclickedblocks.contains(event.getClickedBlock().getType().name())) {
                    if (plugin.getConfig().getStringList(("worlds-allowed")).contains(player.getWorld().getName())) {
                        commands.forEach(command -> player.chat("/" + command));
                    }
                }
            }
        }
    }
}

