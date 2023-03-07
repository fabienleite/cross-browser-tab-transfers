# Cross Browser Tab Transfer

Store and edit browser tab groups, personnaly I made it with the idea of essentially
using it to transfer tabs from a browser to an other.

## It already exists ?

Maybe, but I did't find it. Especially not in open source. I also have to admit that I
use a lot of different browser on different devices (i.e. Safari on iOS, Brave on MacOS,
Firefox on Ubuntu) so passing my tabs from my iPhone to my destop at the end of my jog
always seemed a challenge.

## Install

You thorically only need Java 17 (I use GraalVM as it is the
target platform) for the JVM and Kotlin (you can see the target
version in [build.gradle](./build.gradle.kts))

```sh
./gradlew build
```

## Technical details

This backend is built with :

- Kotlin
- Quarkus
- Following a usecase based hexagonal architecture, close to the Clean Architecture

I plan on using :

- Ory/Hydra as the authorization server
- A simple SPA frontend using Preact or Svelte

## License

GPLv3, see [LICENSE](./LICENSE.txt).

Cross Browser Tab Transfer : transfer tabs from / to multiple browsers.

Copyright (C) 2023 Fabien Leite

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
