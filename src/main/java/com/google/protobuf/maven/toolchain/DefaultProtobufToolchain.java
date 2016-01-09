package com.google.protobuf.maven.toolchain;

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

import org.apache.maven.toolchain.DefaultToolchain;
import org.apache.maven.toolchain.model.ToolchainModel;
import org.codehaus.plexus.logging.Logger;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;

/**
 * Based on {@code org.apache.maven.toolchain.java.DefaultJavaToolChain}.
 *
 * @since 0.2.0
 */
public class DefaultProtobufToolchain extends DefaultToolchain implements ProtobufToolchain {

    public static final String KEY_PROTOC_EXECUTABLE = "protocExecutable";

    protected DefaultProtobufToolchain(ToolchainModel model, Logger logger) {
        super(model, "protobuf", logger);
    }

    private String protocExecutable;

    @Override
    public String findTool(String toolName) {
        if ("protoc".equals(toolName)) {
            File protoc = new File(FileUtils.normalize(getProtocExecutable()));
            if (protoc.exists()) {
                return protoc.getAbsolutePath();
            }
        }
        return null;
    }

    @Override
    public String getProtocExecutable() {
        return this.protocExecutable;
    }

    @Override
    public void setProtocExecutable(String protocExecutable) {
        this.protocExecutable = protocExecutable;
    }

    @Override
    public String toString() {
        return "PROTOC[" + getProtocExecutable() + "]";
    }
}
