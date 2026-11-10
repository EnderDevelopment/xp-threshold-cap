# Minecraft NeoForge XP Threshold Cap Plugin

XP Threshold Cap is a Minecraft NeoForge plugin that caps experience progression in integrated singleplayer worlds when the experience required for the next level exceeds 128 XP. It allows players to reach level 32, then prevents further experience progression by resetting excess progress to the level 32 threshold.

## Install

1. Use Minecraft 1.21.1 with NeoForge 21.1.172 or a compatible NeoForge 21.1 release.
2. Ensure Java 21 is installed.
3. Build the project with Gradle:

```bash
./gradlew build
```

4. Copy the generated JAR from `build/libs/` into the `mods` folder of the NeoForge Minecraft installation.
5. Start Minecraft with the NeoForge profile.

## Use

1. Create or open an integrated singleplayer world.
2. Earn experience normally.
3. The plugin allows progression until level 32.
4. Once the next-level requirement is greater than 128 XP, additional experience is prevented.
5. The player remains at level 32 with zero progress toward the next level.

The cap is applied only to integrated singleplayer worlds. Dedicated multiplayer servers are not affected.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/69db68b1-d730-4ff0-b56c-6bc23648af9b?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=69db68b1-d730-4ff0-b56c-6bc23648af9b
