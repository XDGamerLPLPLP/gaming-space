/*package de.plugin.utils;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {
    int currentHeight = 50;
    private Material m;
    private void blockRandomizer(){
        Random rand = new Random();
        int i = rand.nextInt(3);
        if(i == 1){
            m = Material.BLACKSTONE_WALL;
        }else if(i == 2){
            m = Material.DIAMOND_BLOCK;
        }
    }
    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        ChunkData chunk = createChunkData(world);
        generator.setScale(0.005D);

        for (int X = 0; X < 16; X++)
            for (int Z = 0; Z < 16; Z++) {
                currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.5D, 0.5D) * 15D + 50D);
                blockRandomizer();
                for (int i = currentHeight; i > 0; i--)
                    chunk.setBlock(X, currentHeight, Z, m);
                chunk.setBlock(X, 0, Z, Material.BEDROCK);
            }
        return chunk;
    }
}*/

