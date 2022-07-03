# Carpet Sky Additions (Previously SkyBlock)

[![GitHub downloads](https://img.shields.io/github/downloads/jsorrell/CarpetSkyAdditions/total?label=Github%20downloads&logo=github)](https://github.com/jsorrell/CarpetSkyAdditions/releases)
[![CurseForge downloads](http://cf.way2muchnoise.eu/full_633402_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/carpet-sky-additions)
[![Modrinth downloads](https://img.shields.io/modrinth/dt/3oX3JnAP?label=Modrinth%20Downloads)](https://modrinth.com/mod/carpet-sky-additions)

## About this Fork
This fork of [jsorrel/CarpetSkyAdditions](https://github.com/jsorrell/CarpetSkyAdditions) adds the new world preset "EndBlock" (working title). This was inspired by [Jokeypokey](https://www.youtube.com/user/gugglewuggle) on YouTube and their OneBlock Survival series. Other than in the original video series you don't start with any blocks in your inventory, so you will have to do the dragon fight with your bare hands (and with ender pearls).

The difference to SkyBlock is that the end dimension generates in the regular way (with islands, cities, etc.) and you start on an activated end portal instead of an island with a tree. For this reason I gave endermen a 1% chance to spawn with a grass block in the overworld, making grass available.

## Warning
This challange might not be doable on every seed. Before playing I highly recommend to check that your seed fulfills the followin:
- The obsidian platform in the end should not be mid-air, you should be able to reach the main end island without blocks. In theory you could lure an enderman onto your platform, kill it and enderpearl over to the main island but I really don't recommend playing on such a seed.
- There should be an end city with a pickaxe as loot or with a ship reachable with *only* enderpearls (no blocks) from the end gateway that generates after the dragon fight. Otherwise you will not be able to proceed after you defeated the dragon.

**English** | [中文](docs/zh_cn/README.md)

Carpet Sky Additions is a module for [fabric-carpet](https://github.com/gnembon/fabric-carpet)
originally based on [skyrising/skyblock](https://github.com/skyrising/skyblock).

This mod aims to provide an expert-level SkyBlock style gameplay that depends on players' knowledge of Minecraft
mechanics.
In some cases, outside tools such as [Chunkbase](https://www.chunkbase.com/)
or [MiniHUD](https://www.curseforge.com/minecraft/mc-mods/minihud) will be helpful.
Usage of these is encouraged.
Sometimes extended grinding or AFKing will be required for progression.
Unless SkyBlock world generation is chosen or features are specifically enabled, the mod will do nothing.
This means SkyBlock and Non-SkyBlock worlds can be switched between easily without restarting the
client.

## Installation

[![Vanilla Sky: Everything from Nothing](http://cf.way2muchnoise.eu/title/624853.svg)](https://www.curseforge.com/minecraft/modpacks/vanilla-sky)

The easiest way to use this mod is to install the modpack called ***Vanilla Sky: Everything from Nothing*** which is
available on CurseForge.

To create a new SkyBlock world, choose `World Type: SkyBlock` and enable the datapack `"carpetskyadditions/skyblock"`.

For custom or server installations, follow the [Detailed Installation Instructions](docs/en_us/installation.md)

## Features

### SkyBlock Generation

A SkyBlock world generates exactly like a Default generation world, but with every block removed. Biomes and Structure
Bounding Boxes are kept in place. This means Husks will still spawn in Deserts and Blazes will spawn in Nether
Fortresses, for example. Even with almost every block removed, you have access to most things in the game.

[More Generation Details](docs/en_us/generation.md)

### Gameplay Changes ###

SkyBlock generation does, however, leave a few unobtainable resources.
In addition to adding SkyBlock generation, this mod also fills in
the gaps, making as minimal and Minecrafty changes as possible.

The biggest progress-blocker is Lava, which is unobtainable by default.
This prevents going to the Nether or End or getting Cobblestone.
This mod fixes that problem by providing a way to get Lava.

Sand is also very limited in a default SkyBlock world, but the mod allows for more to be created.

Most other resources provided by this mod are cosmetic and don't make major changes to progression, such as Dead Bushes
and Ender Dragon Heads.

When possible, changes were added to a datapack instead of being programmed into the mod for ease of user customization.
The datapack is built into the mod.

SkyBlock advancements were also added to guide progression and document the mod's changes to vanilla.

*When installed with default settings, all blocks, items, mobs, and advancements obtainable in Default generation are
obtainable in SkyBlock generation.*

[List of Mod Features](docs/en_us/features.md)

[List of Datapack Features](docs/en_us/datapack.md)

### Progression Walkthrough

If you get stuck, a general progression walkthrough is available [here](docs/en_us/progression.md).

## Acknowledgements

- [@skyrising](https://github.com/skyrising/skyblock) for the initial mod idea

- [@DeadlyMC](https://github.com/DeadlyMC/Skyblock-datapack) for the initial ideas for the datapack

- [@gnembon](https://github.com/gnembon/fabric-carpet) for `fabric-carpet`

- @YipKei for Chinese (Simplified) translations

## License

This project is licensed under the terms of the MIT license.
