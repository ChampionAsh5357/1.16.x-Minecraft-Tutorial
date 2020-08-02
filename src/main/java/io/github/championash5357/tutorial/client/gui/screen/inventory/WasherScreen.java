package io.github.championash5357.tutorial.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.championash5357.tutorial.common.Tutorial;
import io.github.championash5357.tutorial.common.inventory.container.WasherContainer;
import io.github.championash5357.tutorial.common.util.text.TextTranslations;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class WasherScreen extends ContainerScreen<WasherContainer> {

	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Tutorial.ID, "textures/gui/container/washer.png");
	
	public WasherScreen(WasherContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}
	
	@Override
	protected void init() {
		super.init();
		this.field_238742_p_ = (this.xSize - this.font.func_238414_a_(this.title)) / 2;
	}
	
	@Override
	public void render(MatrixStack stack, int x, int y, float partialTicks) {
		this.renderBackground(stack);
		super.render(stack, x, y, partialTicks);
		this.func_230459_a_(stack, x, y);
	}
	
	@Override
	protected void func_230451_b_(MatrixStack stack, int x, int y) {
		super.func_230451_b_(stack, x, y);
		if(x >= this.guiLeft + 79 && y >= this.guiTop + 34 && x <= this.guiLeft + 96 && y <= this.guiTop + 51) {
			this.renderTooltip(stack, TextTranslations.containerWasherTime(container.getWashTime()), x - this.guiLeft, y - this.guiTop);
		}
	}
	
	@Override
	protected void func_230450_a_(MatrixStack stack, float partialTicks, int x, int y) {
		this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
		this.blit(stack, this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		if(container.getWashTime() > 0) this.blit(stack, this.guiLeft + 79, this.guiTop + 34, 176, 0, 18, 18);
	}
}
