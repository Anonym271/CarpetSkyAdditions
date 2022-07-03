package com.jsorrell.carpetskyadditions.gen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

public class EndBlockChunkGenerator extends AbstractSkyBlockChunkGenerator{
  public EndBlockChunkGenerator(Registry<StructureSet> structureRegistry, Registry<DoublePerlinNoiseSampler.NoiseParameters> noiseRegistry, BiomeSource biomeSource, RegistryEntry<ChunkGeneratorSettings> settings) {
    super(structureRegistry, noiseRegistry, biomeSource, settings);
  }

  public static final Codec<EndBlockChunkGenerator> CODEC =
    RecordCodecBuilder.create(
      instance ->
        NoiseChunkGenerator.createStructureSetRegistryGetter(instance).and(
            instance
              .group(
                RegistryOps.createRegistryCodec(Registry.NOISE_KEY).forGetter(generator -> generator.noiseRegistry),
                (BiomeSource.CODEC.fieldOf("biome_source")).forGetter(ChunkGenerator::getBiomeSource),
                (ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings")).forGetter(EndBlockChunkGenerator::getSettings)))
          .apply(instance, instance.stable(EndBlockChunkGenerator::new)));

  @Override
  public void prepareSpawn(ServerWorld world, BlockPos worldSpawn, boolean bonusChest) {
    new SkyBlockStructures.SpawnEndPortal(worldSpawn).generate(world, world.random);
  }
  @Override
  protected Codec<? extends ChunkGenerator> getCodec() {
    return CODEC;
  }

  static {
    // FIXME Update namespace in 1.19.1
    Registry.register(Registry.CHUNK_GENERATOR, new Identifier("skyblock", "endblock"), EndBlockChunkGenerator.CODEC);
  }
}
