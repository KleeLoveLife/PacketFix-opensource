package org.tuidang.packetfiz.packets

import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.util.BlockPos;

public class C08PacketPlayerBlockPlacement implements Packet<INetHandlerPlayServer>
{
    private static final BlockPos field_179726_a = new BlockPos(-1, -1, -1);
    private BlockPos position;
    private int placedBlockDirection;
    private ItemStack stack;
    private float facingX;
    private float facingY;
    private float facingZ;

    public native C08PacketPlayerBlockPlacement();
    public native C08PacketPlayerBlockPlacement(ItemStack stackIn);
    public native C08PacketPlayerBlockPlacement(BlockPos positionIn, int placedBlockDirectionIn, ItemStack stackIn, float facingXIn, float facingYIn, float facingZIn);
    public native void readPacketData(PacketBuffer buf) throws IOException;
    public native void writePacketData(PacketBuffer buf) throws IOException;
    public native void processPacket(INetHandlerPlayServer handler);
    public native BlockPos getPosition();
    public native int getPlacedBlockDirection();
    public native ItemStack getStack();
    public native float getPlacedBlockOffsetX();
    public native float getPlacedBlockOffsetY();
    public native float getPlacedBlockOffsetZ();
}
