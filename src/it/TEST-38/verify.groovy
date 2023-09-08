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

outputDirectory = new File(basedir, 'target/generated-sources/protobuf/java');
assert outputDirectory.exists();
assert outputDirectory.isDirectory();

generatedJavaFile1 = new File(outputDirectory, 'it/project1/messages/TestProtos1.java');
assert generatedJavaFile1.exists();
assert generatedJavaFile1.isFile();

generatedJavaFile2 = new File(outputDirectory, 'it/project1/subproject1/messages/TestProtos11.java');
assert generatedJavaFile2.exists();
assert generatedJavaFile2.isFile();

generatedJavaFile3 = new File(outputDirectory, 'it/project1/subproject2/messages/TestProtos12.java');
assert generatedJavaFile3.exists();
assert generatedJavaFile3.isFile();

generatedJavaFile4 = new File(outputDirectory, 'it/project2/messages/TestProtos2.java');
assert generatedJavaFile4.exists();
assert generatedJavaFile4.isFile();

buildLogFile = new File(basedir, 'build.log');
assert buildLogFile.exists();
assert buildLogFile.isFile();

/*
 * Now test the order in which the .proto files were given to the compiler.
 * The listed order below is the expected order with sortProtoFiles enabled.
 * First, process all of "project1", starting with the highest-level files,
 * then going into subdirectories in alphabetic order.
 * Finally process project2.
 *
 * Without sortProtoFiles, the order is non-deterministic (depends on file
 * system) and it was tested to be different (at least on macOS, probably
 * also on Linux).
 */
content = buildLogFile.text;
pos1 = content.indexOf("src/main/proto/it/project1/test1.proto");
pos2 = content.indexOf("src/main/proto/it/project1/subproject1/test1_1.proto");
pos3 = content.indexOf("src/main/proto/it/project1/subproject2/test1_2.proto");
pos4 = content.indexOf("src/main/proto/it/project2/test2.proto");
assert pos1 < pos2;
assert pos2 < pos3;
assert pos3 < pos4;

return true;
