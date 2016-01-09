package plugin;

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
import google.protobuf.compiler.Plugin;

import java.io.IOException;
import java.lang.String;

/**
 * A minimal protoc plugin that generates a file {@code foo.txt} for each protobuf file {@code foo.proto}.
 * The content of the generated file is the name of the source file. Optionally, a file name prefix can be
 * passed as an argument.
 */
public class MinimalPlugin {

    public static void main(String[] args) {

        String prefix = (args.length > 0) ? args[0] : "";

        try {
            CodedInputStream in = CodedInputStream.newInstance(System.in);
            Plugin.CodeGeneratorRequest pluginRequest = Plugin.CodeGeneratorRequest.newBuilder().mergeFrom(in).build();
            Plugin.CodeGeneratorResponse pluginResponse = generateCode(pluginRequest, prefix);
            pluginResponse.writeTo(System.out);
        } catch (Exception e) {
            Plugin.CodeGeneratorResponse errorResponse = Plugin.CodeGeneratorResponse.newBuilder()
                    .setError(e.getMessage()).build();
            try {
                errorResponse.writeTo(System.out);
            } catch (IOException ioe) {
                // nothing we can do here
            }
        }
    }

    private static Plugin.CodeGeneratorResponse generateCode(Plugin.CodeGeneratorRequest request, String prefix) {
        Plugin.CodeGeneratorResponse.Builder responseBuilder = Plugin.CodeGeneratorResponse.newBuilder();
        for (String sourceFileName : request.getFileToGenerateList()) {
            Plugin.CodeGeneratorResponse.File.Builder fileBuilder = Plugin.CodeGeneratorResponse.File.newBuilder();
            fileBuilder.setName(prefix + sourceFileName.replace(".proto", ".txt"));
            fileBuilder.setContent(sourceFileName);
            responseBuilder.addFile(fileBuilder);
        }
        return responseBuilder.build();
    }
}
