package io.github.championash5357.tutorial.common.block;

import java.util.Map;

import io.github.championash5357.tutorial.common.tileentity.WasherTileEntity;
import io.github.championash5357.tutorial.common.util.text.rotation.RotationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class WasherBlock extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final Map<Direction, VoxelShape> FACING_TO_SHAPE_MAP = RotationHelper.createYRotationMap(VoxelShapes.or(Block.makeCuboidShape(0, 0, 1, 16, 16, 16),
			Block.makeCuboidShape(6, 13, 0, 10, 14, 1),
			Block.makeCuboidShape(6, 2, 0, 10, 3, 1),
			Block.makeCuboidShape(13, 6, 0, 14, 10, 1),
			Block.makeCuboidShape(2, 6, 0, 3, 10, 1),
			Block.makeCuboidShape(3, 10, 0, 4, 12, 1),
			Block.makeCuboidShape(3, 4, 0, 4, 6, 1),
			Block.makeCuboidShape(12, 4, 0, 13, 6, 1),
			Block.makeCuboidShape(12, 10, 0, 13, 12, 1),
			Block.makeCuboidShape(10, 12, 0, 12, 13, 1),
			Block.makeCuboidShape(4, 12, 0, 6, 13, 1),
			Block.makeCuboidShape(10, 3, 0, 12, 4, 1),
			Block.makeCuboidShape(4, 3, 0, 6, 4, 1),
			Block.makeCuboidShape(3, 6, 0.25, 13, 10, 0.75),
			Block.makeCuboidShape(4, 10, 0.25, 12, 12, 0.75),
			Block.makeCuboidShape(4, 4, 0.25, 12, 6, 0.75),
			Block.makeCuboidShape(6, 3, 0.25, 10, 4, 0.75),
			Block.makeCuboidShape(6, 12, 0.25, 10, 13, 0.75),
			Block.makeCuboidShape(3, 14, 0.5, 4, 15, 1),
			Block.makeCuboidShape(1, 14, 0.5, 2, 15, 1)));
	
	public WasherBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return FACING_TO_SHAPE_MAP.get(state.get(FACING));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
		return rotate(state, direction);
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return rotate(state, mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new WasherTileEntity();
	}
}
