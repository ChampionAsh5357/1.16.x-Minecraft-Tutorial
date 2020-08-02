package io.github.championash5357.tutorial.common.util.rotation;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class RotationHelper {

	public static VoxelShape rotateDegrees(Axis axis, double angle, VoxelShape shape) {
		return rotateDegrees(axis, angle, 0.5, shape);
	}
	
	public static VoxelShape rotateDegrees(Axis axis, double angle, double center, VoxelShape shape) {
		return rotate(axis, angle, center, true, shape);
	}
	
	public static VoxelShape rotateRadians(Axis axis, double angle, VoxelShape shape) {
		return rotateRadians(axis, angle, 0.5, shape);
	}
	
	public static VoxelShape rotateRadians(Axis axis, double angle, double center, VoxelShape shape) {
		return rotate(axis, angle, center, false, shape);
	}
	
	public static VoxelShape rotate(Axis axis, double angle, double center, boolean isDegrees, VoxelShape shape) {
		return shape.toBoundingBoxList().stream().map(box -> rotate(axis, angle, center, isDegrees, box)).reduce(VoxelShapes.empty(), VoxelShapes::or);
	}
	
	private static VoxelShape rotate(Axis axis, double angle, double center, boolean isDegrees, AxisAlignedBB box) {
		return VoxelShapes.create(new AxisAlignedBB((new Coordinate3d(box.minX, box.minY, box.minZ)).rotate(axis, angle, center, isDegrees).getCoordinate(), (new Coordinate3d(box.maxX, box.maxY, box.maxZ)).rotate(axis, angle, center, isDegrees).getCoordinate()));
	}
	
	public static Map<Direction, VoxelShape> createYRotationMap(VoxelShape original) {
		return Util.make(new EnumMap<>(Direction.class), (map) -> {
			map.put(Direction.NORTH, original);
			map.put(Direction.EAST, rotateDegrees(Axis.Y, 90, original));
			map.put(Direction.SOUTH, rotateDegrees(Axis.Y, 180, original));
			map.put(Direction.WEST, rotateDegrees(Axis.Y, 270, original));
		});
	}
}
