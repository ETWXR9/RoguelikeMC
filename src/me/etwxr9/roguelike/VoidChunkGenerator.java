package me.etwxr9.Roguelike;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class VoidChunkGenerator extends ChunkGenerator{
    @Override
    public ChunkData generateChunkData( World world, Random random, int x, int z, BiomeGrid biome) {
        // TODO Auto-generated method stub
        return createChunkData(world);
    }
}
