package rushmead.PigEar.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpawner extends Item{

	public ItemSpawner(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
        itemIcon = ir.registerIcon("pigear:pig");
    }
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if(!par2World.isRemote){
			EntityPig creeper = new EntityPig(par2World);

			creeper.setLocationAndAngles(par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 0, 0);

			par2World.spawnEntityInWorld(creeper);
			par1ItemStack.stackSize = par1ItemStack.stackSize - 1;
			return par1ItemStack;
			}
			else{
				
				return par1ItemStack;
			}
	}
	
}
