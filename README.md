# fizzbuzz

Example fizzbuzz kata in clojure

## Installation
Run with attached script:
```bash
./build.sh
```

or use maven wrapper directly (assuming *nix):
```bash
./mvnw clean install
```

or (if you have [leiningen](https://leiningen.org/#install) installed), directly from `lein`:
```bash
lein uberjar
```

## Usage

After building, see installation, run it with script file:
```bash
./run.sh 1 20
```

or directly with java:
```bash
java -jar target/uberjar/fizzbuzz-0.1.0-SNAPSHOT-standalone.jar 1 20
```

## Options

Program requires two params to run, start and end of the range (both integers).

## License

Copyright © 2019 kapware.com

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
