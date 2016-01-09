/*
 * Copyright (c) 2016 Maven Protocol Buffers Plugin Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

def assertGeneratedFile(outputDirectory, fname, content) {
    genFile = new File(outputDirectory, fname)
    assert genFile.exists()
    assert genFile.isFile()
    assert genFile.text == content
}

outputDirectory = new File(basedir, 'target/generated-sources/protobuf/java')
assert outputDirectory.exists()
assert outputDirectory.isDirectory()

assertGeneratedFile(outputDirectory, 'test1.txt', 'test1.proto')
assertGeneratedFile(outputDirectory, 'prefix-test1.txt', 'test1.proto')
assertGeneratedFile(outputDirectory, 'test2.txt', 'test2.proto')
assertGeneratedFile(outputDirectory, 'prefix-test2.txt', 'test2.proto')

return true
