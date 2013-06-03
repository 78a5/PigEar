package rushmead.PigEar.common;

import org.modstats.ModstatInfo;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "pigear", name = "PigEar", version = "0.1")
@ModstatInfo(prefix="pigear")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class PigEar {
    @Instance("pigear")
    public static PigEar instance;

    @SidedProxy(clientSide = "rushmead.PigEar.client.ClientProxy", serverSide = "rushmead.PigEar.common.CommonProxy")
    public static CommonProxy proxy;
    private Configuration config;
    public static ItemSpawner pig;
    public static int pigid;

    ItemStack var19 = new ItemStack(Item.porkRaw);
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	loadConfig(event);
    	int baseID = 4736;
    	pigid = getItemConfig(config, "Pig Spawner", baseID++);
         pig = new ItemSpawner(pigid);
         ItemStack var18 = new ItemStack(pig);
    	LanguageRegistry.addName(pig, "Pig Spawner");
    	loadConfig(event);
    	 GameRegistry.addRecipe(var18, new Object[]{"GG ", "GG ", "   ", Character.valueOf('G'), var19});
    }




    private void loadConfig(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        
        config.save();
        this.config = config;
    }
    
    private static int getItemConfig(Configuration config, String key, int defaultID) {
        return config.getItem(Configuration.CATEGORY_ITEM, key, defaultID).getInt(defaultID);
    }
}
