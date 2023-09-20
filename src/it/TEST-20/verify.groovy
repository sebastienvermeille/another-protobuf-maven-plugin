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

outputDirectory = new File(basedir, 'target/generated-sources/protobuf/cpp');
assert outputDirectory.exists();
assert outputDirectory.isDirectory();

generatedHeaderFile = new File(outputDirectory, 'test.pb.h');
assert generatedHeaderFile.exists();
assert generatedHeaderFile.isFile();

content = generatedHeaderFile.text;
assert content.contains('class TestMessage');
assert content.contains('class TestMessage_NestedMessage');
assert content.contains('enum TestMessage_NestedEnum');

generatedClassFile = new File(outputDirectory, 'test.pb.cc');
assert generatedClassFile.exists();
assert generatedClassFile.isFile();

content = generatedClassFile.text;
assert content.contains('TestMessage::~TestMessage()');
assert content.contains('TestMessage_NestedMessage::~TestMessage_NestedMessage()');

return true;
