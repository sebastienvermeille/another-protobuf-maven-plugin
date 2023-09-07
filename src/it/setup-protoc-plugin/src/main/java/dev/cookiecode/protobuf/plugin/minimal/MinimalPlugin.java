package dev.cookiecode.protobuf.plugin.minimal;

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

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import java.io.IOException;

/**
 * A minimal protoc plugin that generates a file {@code foo.txt} for each protobuf file {@code foo.proto}.
 * The content of the generated file is the name of the source file. Optionally, a file name prefix can be
 * passed as an argument.
 */
public class MinimalPlugin {

    public static void main(String... args) {

        String prefix = (args.length > 0) ? args[0] : "";

        try {
            CodedInputStream in = CodedInputStream.newInstance(System.in);
            CodeGeneratorRequest pluginRequest = CodeGeneratorRequest.newBuilder().mergeFrom(in).build();
            CodeGeneratorResponse pluginResponse = generateCode(pluginRequest, prefix);
            pluginResponse.writeTo(System.out);
        } catch (Exception e) {
            CodeGeneratorResponse errorResponse = CodeGeneratorResponse.newBuilder().setError(e.getMessage()).build();
            try {
                errorResponse.writeTo(System.out);
            } catch (IOException ioe) {
                // nothing we can do here
            }
        }
    }

    private static CodeGeneratorResponse generateCode(CodeGeneratorRequest request, String prefix) {
        CodeGeneratorResponse.Builder responseBuilder = CodeGeneratorResponse.newBuilder();
        for (String sourceFileName : request.getFileToGenerateList()) {
            File.Builder fileBuilder = File.newBuilder();
            fileBuilder.setName(prefix + sourceFileName.replace(".proto", ".txt"));
            fileBuilder.setContent(sourceFileName);
            responseBuilder.addFile(fileBuilder);
        }
        return responseBuilder.build();
    }
}
