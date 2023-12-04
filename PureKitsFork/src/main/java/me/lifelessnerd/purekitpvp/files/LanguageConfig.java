package me.lifelessnerd.purekitpvp.files;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.antlr.v4.misc.OrderedHashMap;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LanguageConfig {

    private static File file;
    private static FileConfiguration customFile;

    public static HashMap<String, Component> lang;

    public static SortedMap<String, Object> defaults;

    public static void setup(){

        defaults = new TreeMap<>();
        lang = new HashMap<>();

        file = new File(Bukkit.getServer().getPluginManager().getPlugin("PureKitPvP").getDataFolder(), "lang.yml");
        if (!(file.exists())){
            try{
                file.createNewFile();
            } catch (IOException e){
                //pain
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);

        // Language defaults
        defaults.put("GENERIC_NO_PERMISSION", "&cYou do not have permission!");
        defaults.put("GENERIC_LACK_OF_ARGS", "&cNot enough arguments!");
        defaults.put("GENERIC_WRONG_ARGS", "%ARG% &cis not a valid argument!");
        defaults.put("GENERIC_WRONG_WORLD", "&cYou can only use this menu in &7%WORLD%");
        defaults.put("GENERIC_PLAYER_HELP", """
                &bPureKitPvP - Help Menu
                &a/kit &r- &eOpen up the kit menu
                &a/getkit <kit> &r- &eGet a kit directly
                &a/suicide &r- &eCommit suicide (if enabled)
                &a/stats <player> &r- &eGet PVP stats of a player
                &a/perks &r- &eSelect perks
                &bFor admin commands, see &a/pkpvp help 2&b!
                """);
        defaults.put("PERKS_ALREADY_SELECTED", "&cYou can only change perks when you have no kit selected!");
        defaults.put("PERKS_GUI_TITLE", "&6Perks Menu");
        defaults.put("PERKS_GUI_INFO_TITLE", "&cPerks Info");
        defaults.put("PERKS_GUI_INFO_LORE", """
                &aYou can equip a total of &e5 &aperks total.
                &7Click on a perk slot to choose a perk for that slot.
                &7It will replace any perk currently in that slot.
                &7Perks are abilities that are always active.
                &7Duplicate perks do not stack.
                """);
        defaults.put("PERKS_GUI_BACK_KITS", "&aBack to Kits");
        defaults.put("PERKS_GUI_SLOT_TITLE", "&cPerk Slot %SLOT%");
        defaults.put("PERKS_GUI_SLOT_LORE", "&aClick to select a perk for this slot!");
        defaults.put("PERKS_GUI_BACK", "&aGo Back");
        defaults.put("PERKS_PERK_JUGGERNAUT", """
                &rGain regeneration 1 (5s) after every kill
                """);
        defaults.put("PERKS_PERK_BULLDOZER", """
                &rGain strength 2 (3s) after every kill
                """);
        defaults.put("PERKS_PERK_KNOWLEDGE", """
                &rGain 1 XP level on kill
                """);
        defaults.put("PERKS_PERK_NOTORIETY", """
                &r15% chance of gaining a sharpness level on each kill
                &rwill be added to the item held
                """);
        defaults.put("PERKS_PERK_NOTORIETY_MAX", "&eYou have reached the maximum Notoriety!");
        defaults.put("PERKS_PERK_NOTORIETY_UPGRADE", "&eYour sharpness level has increased!");
        defaults.put("PERKS_PERK_ENDERMAGIC", """
                &r30% chance of gaining an ender pearl on kill
                """);
        defaults.put("PERKS_PERK_ENDERMAGIC_OCCUR", "&eYou gained an ender pearl!");
        defaults.put("PERKS_PERK_SPEEDSTER", """
                &rGain 10 seconds of speed 2 after every kill
                """);
        defaults.put("PERKS_PERK_ROBBERY", """
                &r30% chance of disarming someone if hit with your fist
                &rThe weapon will be swapped with a slot in the inventory
                """);
        defaults.put("PERKS_PERK_ROBBERY_DISARMED","&eYou were disarmed by %PLAYER%'s Robbery perk!");
        defaults.put("PERKS_PERK_ROBBERY_DISARMER","&eYou disarmed %PLAYER% with your Robbery perk!");

        defaults.put("PERKS_PERK_SNOWMAN", """
                &rGive slowness 1 (3s) when you hit someone with a snowball
                """);
        defaults.put("PERKS_PERK_DISRUPTOR", """
                &rGive poison 1 (5s) when you hit someone with an egg
                """);
        defaults.put("PERKS_PERK_ENDERMAN", """
                &rYou can now ride ender pearls; they do no damage
                """);
        defaults.put("PERKS_PERK_VAMPIRE", """
                &rOn critical hits, gain 50% of the damage
                &ryou dealt, as instant health
                """);
        defaults.put("PERKS_PERK_MARKSMAN", """
                &r50% chance of gaining a power level on each bow kill
                &rPower is added to the item held, if it's a bow
                """);
        defaults.put("PERKS_PERK_MARKSMAN_UPGRADE","&eYour power level has increased!");
        defaults.put("PERKS_PERK_MARKSMAN_MAX","&eYou have reached the maximum power level!");
        defaults.put("PERKS_PERK_APOLLO", """
                &rYou get each arrow you hit on a player back
                &rA kill nets one extra arrow of that type
                """);
        defaults.put("PERKS_PERK_ADRENALINE", """
                &rWhen below 6 HP (3 hearts), you get a speed boost
                """);

        defaults.put("KITS_GUI_TITLE", "Kits");
        defaults.put("KITS_GUI_PREV", "Previous Page");
        defaults.put("KITS_GUI_NEXT", "Next Page");
        defaults.put("KITS_ALREADY_SELECTED", "&cYou already have a kit!");
        defaults.put("KITS_DOES_NOT_EXIST", "&cThat kit does not exist!");
        defaults.put("KITS_PERMISSION_NOT_DEFINED", "&cThat kit does not have a permission associated. Please report this to your administrator.");
        defaults.put("KITS_KIT_GIVEN", "&aKit &6%KIT% &agiven.");
        defaults.put("KITS_NO_KITS", "&cThere are no kits... yet. Create some with /pkpvp createkit");
        defaults.put("KITS_GUI_NO_PERMISSION", "&cYou don't have permission!");
        defaults.put("KITS_GUI_PREVIEW", "&bRIGHT CLICK to preview!");
        defaults.put("KITS_GUI_WEAPONS", "&3Weapons:");
        defaults.put("KITS_GUI_ITEMS", "&3Items:");
        defaults.put("KITS_GUI_ARMOR", "&3Armor:");
        defaults.put("KITS_GUI_NO_ARMOR", "&3No Armor");
        defaults.put("KITS_GUI_OFFHAND", "&3Offhand:");
        defaults.put("KITS_GUI_KILL_ITEM", "&fItem on Kill:");
        defaults.put("KITS_GUI_NO_KILL_ITEM", "&fNo Item on Kill");
        defaults.put("KITS_GUI_RESET", "&fReset Kit");
        defaults.put("KITS_GUI_RESET_LORE", """
                &9If you do not have permission to reset your kit,
                &9this will run /suicide on your behalf.
                """);
        defaults.put("KITS_GUI_PERKS", "&rPerks menu");
        defaults.put("KITS_GUI_PERKS_LORE", """
                &9Click here to change your perks!
                """);
        defaults.put("KITS_RESET_KIT", "&aKit has been reset.");
        defaults.put("KITS_GUI_PREVIEW_TITLE", "&aKit Preview > &b%KIT%");
        defaults.put("KITS_GUI_PREVIEW_TEXT", "&aRight click to preview.");
        defaults.put("KITS_GUI_PREVIEW_STATS", "&6Global Stats");
        defaults.put("KITS_GUI_PREVIEW_SELECT", "&aSelect Kit");
        defaults.put("KITS_GUI_PREVIEW_BACK", "&aBack to Kits");
        defaults.put("LOOT_LUCKY", "&bLUCKY! &a%ITEM%had a chance of &a%CHANCE%%!");

        defaults.put("EVENTS_END", "&7The event has ended.");
        defaults.put("EVENTS_START", "&bRANDOM EVENT! &d%EVENT% &bhas been selected!");
        defaults.put("EVENTS_TELEMADNESS_DESC", "Everyone gets Ender Pearls, all the time!");
        defaults.put("EVENTS_TELEMADNESS_ITEM_LORE", """
                &7This is an event specific item, which
                &7will be removed as soon as the event ends.
                """);
        defaults.put("EVENTS_PICKUP_DESC", "Killed players drop their stuff!");
        defaults.put("EVENTS_JUGGERNAUT_DESC", "Team up to kill the Juggernaut!");

        defaults.put("SCOREBOARD_MAIN_TITLE", "&6PureKitPvP");
        defaults.put("SCOREBOARD_PERSONAL_TITLE", "&6Personal Stats");
        defaults.put("SCOREBOARD_PERSONAL_KILLSTREAK", "  &7Killstreak: &b%VALUE%");
        defaults.put("SCOREBOARD_PERSONAL_KILLS", "  &7Kills: &b%VALUE%");
        defaults.put("SCOREBOARD_PERSONAL_DEATHS", "  &7Deaths: &b%VALUE%");
        defaults.put("SCOREBOARD_PERSONAL_KD", "  &7K/D Ratio: &b%VALUE%");
        defaults.put("SCOREBOARD_PERSONAL_LEVEL", "  &7Level: &b%VALUE%");
        defaults.put("SCOREBOARD_GLOBAL_TITLE", "&6Global Stats");
        defaults.put("SCOREBOARD_GLOBAL_KILLSTREAK", "  &7Killstreak");
        defaults.put("SCOREBOARD_GLOBAL_KILLS", "  &7Kills");
        defaults.put("SCOREBOARD_GLOBAL_KD", "  &7K/D Ratio");
        defaults.put("SCOREBOARD_GLOBAL_LEVEL", "  &7Level");




        customFile.addDefaults(defaults);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            customFile.save(file);
        } catch (IOException e){
            System.out.println("Cannot save!");
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void loadLanguage(){
        // Take data out of file; store it in map
        LegacyComponentSerializer serializer = LegacyComponentSerializer.legacyAmpersand();
        for (String key : get().getKeys(false)) {
            lang.put(key, serializer.deserialize(get().getString(key)).decoration(TextDecoration.ITALIC, false));
//            System.out.println(key + ": " + get().getString(key));
        }
    }


}
