package com.jsorrell.carpetskyadditions.gen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

public class SkyBlockChunkGenerator extends AbstractSkyBlockChunkGenerator {
  public SkyBlockChunkGenerator(Registry<StructureSet> structureRegistry, Registry<DoublePerlinNoiseSampler.NoiseParameters> noiseRegistry, BiomeSource biomeSource, RegistryEntry<ChunkGeneratorSettings> settings) {
    super(structureRegistry, noiseRegistry, biomeSource, settings);
  }

  public static final Codec<SkyBlockChunkGenerator> CODEC =
    RecordCodecBuilder.create(
      instance ->
        NoiseChunkGenerator.createStructureSetRegistryGetter(instance).and(
            instance
              .group(
                RegistryOps.createRegistryCodec(Registry.NOISE_KEY).forGetter(generator -> generator.noiseRegistry),
                (BiomeSource.CODEC.fieldOf("biome_source")).forGetter(ChunkGenerator::getBiomeSource),
                (ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings")).forGetter(SkyBlockChunkGenerator::getSettings)))
          .apply(instance, instance.stable(SkyBlockChunkGenerator::new)));

  @Override
  public void prepareSpawn(ServerWorld world, BlockPos worldSpawn, boolean bonusChest) {
    new SkyBlockStructures.SpawnPlatform(worldSpawn).generate(world, world.random);

    // Might as well make this an option
    if (bonusChest) {
      BlockPos bonusChestPos = worldSpawn.south();
      world.setBlockState(bonusChestPos, Blocks.CHEST.getDefaultState(), Block.NOTIFY_LISTENERS);
      LootableContainerBlockEntity.setLootTable(world, world.random, bonusChestPos, LootTables.SPAWN_BONUS_CHEST);
      BlockState torchState = Blocks.TORCH.getDefaultState();
      for (Direction direction : Direction.Type.HORIZONTAL) {
        BlockPos torchPos = bonusChestPos.offset(direction);
        world.setBlockState(torchPos, torchState, Block.NOTIFY_LISTENERS);
      }
    }
  }

  @Override
  protected Codec<? extends ChunkGenerator> getCodec() {
    return CODEC;
  }

  static {
    // FIXME Update namespace in 1.19.1
    Registry.register(Registry.CHUNK_GENERATOR, new Identifier("skyblock", "skyblock"), SkyBlockChunkGenerator.CODEC);
  }
}
