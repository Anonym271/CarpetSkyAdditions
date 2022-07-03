package com.jsorrell.carpetskyadditions.gen;

import com.jsorrell.carpetskyadditions.util.SkyAdditionsIdentifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import net.minecraft.world.biome.source.TheEndBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.WorldPreset;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

import java.util.Map;

public class SkyAdditionsWorldPresets {
  public static final RegistryKey<WorldPreset> SKYBLOCK =
    RegistryKey.of(Registry.WORLD_PRESET_KEY, new SkyAdditionsIdentifier("skyblock"));
  public static final RegistryKey<WorldPreset> ENDBLOCK =
    RegistryKey.of(Registry.WORLD_PRESET_KEY, new SkyAdditionsIdentifier("endblock"));

  private static final DimensionOptions OVERWORLD_OPTIONS_SKYBLOCK = new DimensionOptions(
    BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.OVERWORLD),
    new SkyBlockChunkGenerator(BuiltinRegistries.STRUCTURE_SET, BuiltinRegistries.NOISE_PARAMETERS, MultiNoiseBiomeSource.Preset.OVERWORLD.getBiomeSource(BuiltinRegistries.BIOME), BuiltinRegistries.CHUNK_GENERATOR_SETTINGS.getOrCreateEntry(ChunkGeneratorSettings.OVERWORLD)));
  private static final DimensionOptions OVERWORLD_OPTIONS_ENDBLOCK = new DimensionOptions(
    BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.OVERWORLD),
    new EndBlockChunkGenerator(BuiltinRegistries.STRUCTURE_SET, BuiltinRegistries.NOISE_PARAMETERS, MultiNoiseBiomeSource.Preset.OVERWORLD.getBiomeSource(BuiltinRegistries.BIOME), BuiltinRegistries.CHUNK_GENERATOR_SETTINGS.getOrCreateEntry(ChunkGeneratorSettings.OVERWORLD)));
  private static final DimensionOptions NETHER_OPTIONS = new DimensionOptions(
    BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.THE_NETHER),
    new SkyBlockChunkGenerator(BuiltinRegistries.STRUCTURE_SET, BuiltinRegistries.NOISE_PARAMETERS, MultiNoiseBiomeSource.Preset.NETHER.getBiomeSource(BuiltinRegistries.BIOME), BuiltinRegistries.CHUNK_GENERATOR_SETTINGS.getOrCreateEntry(ChunkGeneratorSettings.NETHER)));
  private static final DimensionOptions END_OPTIONS = new DimensionOptions(
    BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.THE_END),
    new SkyBlockChunkGenerator(BuiltinRegistries.STRUCTURE_SET, BuiltinRegistries.NOISE_PARAMETERS, new TheEndBiomeSource(BuiltinRegistries.BIOME), BuiltinRegistries.CHUNK_GENERATOR_SETTINGS.getOrCreateEntry(ChunkGeneratorSettings.END)));
  private static final DimensionOptions DEFAULT_END_OPTIONS = new DimensionOptions(
    BuiltinRegistries.DIMENSION_TYPE.getOrCreateEntry(DimensionTypes.THE_END), new NoiseChunkGenerator(
      BuiltinRegistries.STRUCTURE_SET,
      BuiltinRegistries.NOISE_PARAMETERS,
      new TheEndBiomeSource(BuiltinRegistries.BIOME),
      BuiltinRegistries.CHUNK_GENERATOR_SETTINGS.getOrCreateEntry(ChunkGeneratorSettings.END)
  ));

  public static void registerAll() {
    BuiltinRegistries.add(BuiltinRegistries.WORLD_PRESET, SkyAdditionsWorldPresets.SKYBLOCK, new WorldPreset(
      Map.of(
        DimensionOptions.OVERWORLD, OVERWORLD_OPTIONS_SKYBLOCK,
        DimensionOptions.NETHER, NETHER_OPTIONS,
        DimensionOptions.END, END_OPTIONS
      )
    ));
    BuiltinRegistries.add(BuiltinRegistries.WORLD_PRESET, SkyAdditionsWorldPresets.ENDBLOCK, new WorldPreset(
      Map.of(
        DimensionOptions.OVERWORLD, OVERWORLD_OPTIONS_ENDBLOCK,
        DimensionOptions.NETHER, NETHER_OPTIONS,
        DimensionOptions.END, DEFAULT_END_OPTIONS
      )
    ));
  }
}
