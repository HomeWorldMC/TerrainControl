package com.khorn.terraincontrol.bukkit.generator;


import com.khorn.terraincontrol.bukkit.BukkitWorld;
import com.khorn.terraincontrol.generator.ObjectSpawner;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R2.CraftChunk;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class TCBlockPopulator extends BlockPopulator
{
    private BukkitWorld world;
    private ObjectSpawner spawner;

    public TCBlockPopulator(BukkitWorld world)
    {
        this.world = world;
        this.spawner = new ObjectSpawner(world.getSettings(), world);
    }

    @Override
    public void populate(World world, Random random, Chunk chunk)
    {
        this.world.LoadChunk(((CraftChunk) chunk).getHandle());
        this.spawner.populate(chunk.getX(), chunk.getZ());
    }
}
