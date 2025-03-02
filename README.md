<!--
Author: Arne Damvin
Copyright (c) 2023 Arne Damvin
License: GNU General Public License v3.0 (GPL-3.0)
-->

# GoldMine Plugin

A simple Minecraft plugin for Paper servers that doubles the contents of a chest when a player executes the `/goldmine` command.

## Features

- Doubles the items in a chest that a player is looking at
- Permission-based command access
- Works with normal and trapped chests

## Installation

1. Download the latest release JAR file
2. Place the JAR file in your server's `plugins` folder
3. Restart your server or use a plugin manager to load the plugin

## Usage

1. Look at a chest (you need to be within 5 blocks of it)
2. Type `/goldmine`
3. The contents of the chest will be doubled!

## Permissions

- `goldmine.use` - Allows players to use the `/goldmine` command (default: op)

## Building from source

This plugin uses Maven for dependency management and building.

### Prerequisites
- Java Development Kit (JDK) 17 or newer
- Maven installed on your system
- Git (optional, for cloning the repository)

### Building steps

1. **Get the source code**
   ```bash
   git clone https://github.com/arndam/goldmine.git
   cd goldmine
   ```

2. **Build with Maven**
   ```bash
   mvn clean package
   ```

3. **Locate the built plugin**
   - After a successful build, the compiled plugin JAR file will be in the `target` folder
   - The file will be named something like `goldmine-0.1-BETA.jar`

4. **Install the plugin**
   - Copy the JAR file to your Minecraft server's `plugins` folder
   - Restart your server or use a plugin manager to load the plugin

## License

This project is licensed under the GNU General Public License v3.0 (GPL-3.0). See the LICENSE file for more details. 